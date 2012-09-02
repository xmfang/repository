<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<s:url value='/js/artdialog/popup.edit.window.js'/>"></script>
		<link rel="stylesheet" href="<s:url value='/styles/artdialog/default.css'/>" />
		<title><s:text name="style.manage" /></title>
		<script language = "javascript">			
			function openwin(id) {
				var title = '<s:text name="door.category.manage"/>';
				var content = "<iframe src='${basePath}/order/customer-order-base-info-edit.action?orderId=" + id
							+ "' style='width: 350px; height: 350px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
		
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/order/style/style-remove.action?styleId=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="customerOrders" requestURI="/order/customer-order-list.action" uid="customerOrder" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="serialNumber" titleKey="order.serial.number" />
			<display:column property="customer" titleKey="customer.name" />
			<display:column property="orderDate" titleKey="order.date"  />
			<display:column property="customerTel" titleKey="customer.telephone" />
			<display:column property="depositCent" titleKey="deposit" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="status" titleKey="order.status" decorator="com.nafu.dsm.webapp.decorator.EnumColumnDecorator" />
			<display:column property="totalPrice" titleKey="total.price" />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='finish'/>" />
			</display:column>
		</display:table>
		<br/>
		<s:a cssClass="btn" href="%{basePath}/order/customer-order-base-info-edit.action?orderId=0"><s:text name="sign.list"/></s:a>
		<br />
		
	</body>
</html>

