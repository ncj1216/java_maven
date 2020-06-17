<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加项目信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="niu">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="pname"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="com" name="newcomname"  onchange="addCustomerPerson(this.value)">
			<option>选择公司</option>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="cp" name="comper"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="emp"  name="empFk">
			<option>选择技术负责人</option>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="empcount"/>人</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="starttime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="buildtime"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="cost"/>万</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select  name="level"><option value=1>紧急</option><option value=2>一般</option><option value=3>暂缓</option></select></td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="endtime"/></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130 name="remark"></textarea><span id="number"></span>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	<A class="coolbg" href="javascript:commit()" >保存</A>
	<a href="project-base.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>
</form>



<script type="text/javascript">

	$(function () {

		//显示客户公司·信息
		showCustomer();


		//项目经理
		showEmployee();
	})


	function showCustomer() {

		$.ajax({

			url:"customer/project-add-customer-show",
			dataType:"json",
			statusCode:{
				200:function (obj) {
						//console.log(obj);
				$("#com").empty();//清空
				$("#com").append("<option value='-1'>选择公司</option>");
					$.each(obj,function (i,customer) {
							$("<option></option>").val(customer.id).text(customer.comname).appendTo("#com")
					});
				}
			}

		});

	}


	//项目经理显示
	function showEmployee() {
		$.ajax({
			url:"employee/project-add-employee-show",
			dataType:"json",
			statusCode:{
				200:function (obj) {
					// console.log(obj);
					$("#emp").empty();
					$("#emp").append("<option value='-1'>选择技术负责人</option>");
					$.each(obj,function (i, employee) {
						$("<option></option>").val(employee.eid).text(employee.ename).appendTo($("#emp"));
					});
				},
				404:function () {
					alert("请求有误");
				},
				500:function () {
					alert("请求失败");
				}
			}
		});
	}



	//联动效果，显示客户联系人
	function addCustomerPerson(id) {
		$.ajax({
			url:"customer/project-add-customer-person-show",
			data:"id="+id,
			dataType:"json",
			statusCode:{
				200:function (obj) {
					// console.log(obj);
					$("#cp").val(obj.companyperson);
				},
				404:function () {
					alert("请求有误");
				},
				500:function () {
					alert("请求不当")
				}
			}
		});
	}



	//保存功能的实现
	function commit() {
		//用异步实现保存操作
		$.ajax({
			url:"project/project-saveInfo",
			type:"post",
			data:$("#niu").serialize(),
			dataType:"json",
			statusCode:{
				200:function () {
					location.href = "project-base.jsp";
				},
				404:function () {
					alert("请求有误")
				},
				500:function () {
					alert("请求失败")
				}
			}
		});
	}
</script>


</body>
</html>