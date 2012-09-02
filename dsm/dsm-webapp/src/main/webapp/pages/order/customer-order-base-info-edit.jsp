<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<link rel="stylesheet" href="<s:url value='/styles/tabs/tabs.css'/>" type="text/css" media="all" />
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<script language="javascript" type="text/javascript" src="<s:url value='/js/datepicker/WdatePicker.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/js/tabs/tabs-normal.js'/>"></script>
	<title><s:text name="door.category.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			alert($("#customerInfoForm").serialize());
			var arrayData = $("#doorForm").serializeArray();

			$(".doorform").each(function(){
				alert("222");
				$.each(arrayData, function(i, field){
					alert(field.name + ":" + field.value);
				});
			});
			
//			alert(objectData);
//			if(validate() == false) {
//				alert("<s:text name='name.is.not.null'/>");
//				return;
//			}
//			$.ajax({
//		        'async': false,
//		        'type': 'POST',
///		        'url': '${basePath}/order/customer-order-base-info-save.action',
//		        'data': $("#doorcategoryform").serialize()
//		    });
//			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("name").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="customerInfoForm" theme="simple">
		<table class="table">
			<tr>
				<th><s:text name="order.serial.number" /></th>
				<td><s:textfield name="customerOrder.serialNumber" /></td>
				<th><s:text name="order.date" /></th>
				<td><input type="text" name="customerOrder.orderDate" class="Wdate input-small" onClick="WdatePicker()"/></td>
			</tr>
			<tr>
				<th><s:text name="customer.name" /></th>
				<td><s:textfield name="customerOrder.customer" id="customer.name" cssClass="input-small" /></td>
				<th><s:text name="customer.telephone" /></th>
				<td><s:textfield id="text" name="customerOrder.customerTel" /></td>
			</tr>
			<tr>
				<th><s:text name="deposit" /></th>
				<td><s:textfield name="customerOrder.depositCent" cssClass="input-small" /></td>
				<th><s:text name="order.status" /></th>
				<td><s:select name="customerOrder.status" list="customerOrderStatuses" listKey="name()" listValue="getText(name())" cssClass="uneditable-textarea" /></td>
			</tr>
			<tr>
				<th><s:text name="customer.address" /></th>
				<td colspan="3"><s:textarea name="customerOrder.customerAddress" /></td>
			</tr>
		</table>
	</s:form>
	
		<div>
			<input type="button" value="<s:text name='add.door'/>" class="btn" onclick="addTab('<s:text name='door'/>')"/>		
		</div>
		
		<ul class="tabs">
			<li>
				<a href="#tab1"><s:text name="door"/></a>
			</li>
		</ul>
		
		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<s:form id="doorForm" theme="simple" cssClass="doorform">
					<table class="table">
						<tr>
							<th><s:text name="name" /></th>
							<td><s:textfield name="name" onchange="reNameTab(this.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode, this.value)"/></td>
							<th><s:text name="count" /></th>
							<td><s:textfield name="count" /></td>
						</tr>
						<tr>
							<td><s:text name="door.category" /></td>
							<td>
								<s:select name="doorCategoryId" list="doorCategories" listKey="id" listValue="name" onchange="reloadColors()" />
							</td>
							<th><s:text name="color" /></th>
							<td>
								<s:select name="colorId" list="getColors(1)" listKey="id" listValue="name" />
							</td>
						</tr>
						<%-- <tr>
							<th><s:text name="door.category" /></th>
							<td><s:select list="doorCategories" listKey="id" listValue="name" name="doorCategory" /></td>
							<th><s:text name="color" /></th>
							<td><s:select list="colors" listKey="id" listValue="name" name="colorId" /></td>
						</tr> --%>
						<tr>
							<th><s:text name="style" /></th>
							<td><s:select list="styles" listKey="id" listValue="code" name="styleId" /></td>
							<th><s:text name="model" /></th>
							<td><s:select list="models" listKey="id" listValue="name" name="modelId" /></td>
						</tr>
						<tr>
							<th rowspan="4"><s:text name="craft" /></th>
							<s:iterator value="craftCategories">
								<tr>
									<th><s:text name="text" /><s:text name="craft" /></th>
									<td colspan="2" class="checkbox">
										<s:checkboxlist list="findCraftsByCategory(text)" listKey="id" listValue="name" name="craftIds" />
									</td>
								</tr>
							</s:iterator>
						</tr>
					</table>
					<input type="button" class="btn" value="<s:text name='cancel'/>" onclick="removeTab(this.parentNode.parentNode)" />
				</s:form>
			</div>
		</div>
		
		<div>
			<input type="button" class="btn" value="<s:text name='submit'/>" onclick="submitOperation()" />
		</div>

</body>
</html>