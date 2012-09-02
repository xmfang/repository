<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="supplier.manage" /></title>
	
	<script type="text/javascript">	
		function addRow() {
			var row ="<tr><td><input type='text' name='#contactInfo.contacter' class='input-small' /></td>"
				+ "<td><input type='text' name='#contactInfo.tel' class='input-small' /></td>"
				+ "<td><input type='text' name='#contactInfo.title' class='input-small' /></td>"
				+ "<td><input type='text' name='#contactInfo.email'/></td>"
				+ "<td><input type='text' name='#contactInfo.QQ' class='input-small' /></td>"
				+ "<td><input type='text' name='#contactInfo.remark' /></td>"
				+ "<td><input type='button' class='btn' value=\"<s:text name='remove'/>\" onclick='removeRow(this)'/></td></tr>";
			$("#contacterinfos").append(row);
		}
		
		function removeRow(row) {
			$(row).parent().parent().remove();
		}
		
		function dealContactInfos() {
			if (!validate()) {
				alert("<s:text name='name.is.notnull'/>");
				return false;
			}
			var index = 0;
			$("#contacterinfos tr").each(function() {
				$(this).find("input[name='#contactInfo.contacter']").attr('name','contactInfos[' + index + '].contacter');
				$(this).find("input[name='#contactInfo.tel']").attr('name','contactInfos[' + index + '].tel');
				$(this).find("input[name='#contactInfo.title']").attr('name','contactInfos[' + index + '].title');
				$(this).find("input[name='#contactInfo.email']").attr('name','contactInfos[' + index + '].email');
				$(this).find("input[name='#contactInfo.QQ']").attr('name','contactInfos[' + index + '].QQ');
				$(this).find("input[name='#contactInfo.remark']").attr('name','contactInfos[' + index + '].remark');
				index++;
			});
			return true;
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
	<h3><s:text name="add.partner.supplier"/></h3>
	<s:form id="supplierform" theme="simple" action="/basicinfo/supplier/supplier-save.action">
		<table class="table-striped">
			<tr>
				<th><s:text name="name" /></th>
				<td><s:textfield id="name" name="supplier.name" /></td>
			</tr>
			<tr>
				<th><s:text name="tel" /></th>
				<td><s:textfield name="supplier.tel" /></td>
			</tr>
			<tr>
				<th><s:text name="fax" /></th>
				<td><s:textfield name="supplier.fax" /></td>
			</tr>
			<tr>
				<th><s:text name="address" /></th>
				<td><s:textarea name="supplier.address" /></td>
			</tr>
			<tr>
				<th><s:text name="website" /></th>
				<td><s:textfield name="supplier.website" /></td>
			</tr>
		</table>
		<h4><s:text name="contacter.info"/></h4>
		<table>
			<thead>
				<tr>
					<th><s:text name="contacter" /></th>
					<th><s:text name="tel" /></th>
					<th><s:text name="title" /></th>
					<th><s:text name="email" /></th>
					<th>QQ</th>
					<th><s:text name="remark" /></th>
					<th><s:text name="remove"/></th>
				</tr>
			</thead>
			<tbody id="contacterinfos">
				<s:iterator id="contactInfo" value="supplier.contactInfos">
					<tr>
						<td><s:textfield name="#contactInfo.contacter" cssClass="input-small" /></td>
						<td><s:textfield name="#contactInfo.tel" cssClass="input-small" /></td>
						<td><s:textfield name="#contactInfo.title" cssClass="input-small" /></td>
						<td><s:textfield name="#contactInfo.email" /></td>
						<td><s:textfield name="#contactInfo.QQ" cssClass="input-small" /></td>
						<td><s:textfield name="#contactInfo.remark" /></td>
						<td><input type="button" class="btn" value="<s:text name="remove"/>" onclick='removeRow(this)'/></td>
					</tr>
				</s:iterator>
			</tbody>
 		</table>
		<input type="button" class="btn" value="<s:text name='add.contacter'/>" onclick="addRow()"/>
		<s:hidden name="supplier.id" /><br/><br/>
		<s:hidden name="supplier.version" />
		<s:submit key="submit" cssClass="btn" onclick="return dealContactInfos()" />
	</s:form>

</body>
</html>