<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="../skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <script type="application/javascript">
        

    </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='customer-add-show';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->

<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select id="mt" name='cid' style='width:150px'>
            <option value='0'>选择类型...</option>
          	<option value='1'>客户所在公司名称</option>
          	<option value='2'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' id="info"  name='keyword' style='width:120px' />
        </td>
        <td width='110'>
    		<select id="mtime" name='orderby' style='width:120px'>
                <option value='0'>排序...</option>
                <option value='1'>编号</option>
      	    </select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" onclick="search()" type="image" src="${pageContext.request.contextPath}skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>

<!--  内容列表   -->
<form name="form2">

<table id="infotb" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7" >
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" id="tr2">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>





<c:forEach items="${pageinfo.list}" var="customer" varStatus="sta">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="${customer.id}" class="np"></td>
	<td>${sta.count}</td>
	<td>${customer.companyperson}</td>
	<td align="center">${customer.comname}</td>

	<td><fmt:formatDate value="${customer.addtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	<td>${customer.comphone}</td>
    <td><a href="customer-edit-look?id=${customer.id}&flag=edit&currentPage=${pageinfo.pageNum}">编辑</a> | <a href="customer-edit-look?id=${customer.id}&flag=look&currentPage=${pageinfo.pageNum}">查看详情</a></td></tr>
</c:forEach>

    <tr bgcolor="#FAFAF1" align="center">
        <td height="25" colspan="12">
            &nbsp;<a href="?currentPage=${pageinfo.firstPage}">首页</a>
            &nbsp;<a href="?currentPage=${pageinfo.prePage}">上一页</a>
            【&nbsp;&nbsp;
            <c:forEach items="${pageinfo.navigatepageNums}" var="num">
                <c:choose>
                    <c:when test="${pageinfo.pageNum == num}">
                            <a style="color: red" href="?currentPage=${num}">${num}</a>&nbsp;&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="?currentPage=${num}">${num}</a>&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            】
            &nbsp;<a href="?currentPage=${pageinfo.nextPage}">下一页</a>
            &nbsp;<a href="?currentPage=${pageinfo.lastPage}">尾页</a>

        </td>
    </tr>



<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:allCheck()" class="coolbg">全选</a>
	<a href="javascript:unCheck()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchDelete()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  
<script type="text/javascript">
    //全选
    function allCheck() {
       var  cs=$("input[type='checkbox']");
       for (var i=0;i<cs.length;i++){
           var jso=cs[i];
           var jqo=$(jso);
           jqo.prop("checked",true);
       }
    }

    //反选
    function unCheck() {

        var ss=$("input[type='checkbox']");

        for (var i=0;i<ss.length;i++){

            var jso=ss[i];

            var jqo=$(jso);

           var bo= jqo.prop("checked");

           jqo.prop("checked",!bo);
        }
    }








 //批量删除
    function batchDelete() {
        var  cs =$("input[type='checkbox']:checked");
        if (cs.length != 0){
           var bo= confirm("你确定删除白？小老弟");
            if(bo){
                //把当前复选框的id值串成字符串传到控制层
                var str="";
                for (var i=0;i<cs.length;i++){
                    var jsO=cs[i];
                    var jqO=$(jsO);
                    var  s= jqO.val() +",";
                    str+=s;
                }
                //获取了串的值
                str=str.substring(0,str.length-1);
                //送到后台
                location.href="customer-delete?ids="+str;

            }else {
                alert("你不删了哦，铁汁");
            }


        }else {
            alert("滚蛋，你啥都不选我删除个茄子");
        }

    }



</script>



</body>
</html>