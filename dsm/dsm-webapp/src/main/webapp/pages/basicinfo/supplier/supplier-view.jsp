<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="supplier.manage" /></title>
	
	<script type="text/javascript">	
	</script>
	
</head>
<body>
	<h3><s:property value="supplier.name" /></h3>
	<table class="table table-striped table-bordered table-condensed">
		<tr>
			<th><s:text name="tel" /></th>
			<td><s:property value="supplier.tel" /></td>
		</tr>
		<tr>
			<th><s:text name="fax" /></th>
			<td><s:property value="supplier.fax" /></td>
		</tr>
		<tr>
			<th><s:text name="address" /></th>
			<td><s:property value="supplier.address" /></td>
		</tr>
		<tr>
			<th><s:text name="website" /></th>
			<td><s:property value="supplier.website" /></td>
		</tr>
	</table>
	<br/>
	<h4><s:text name="contacter.info"/></h4>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><s:text name="contacter" /></th>
				<th><s:text name="tel" /></th>
				<th><s:text name="title" /></th>
				<th><s:text name="email" /></th>
				<th>QQ</th>
				<th><s:text name="remark" /></th>
			</tr>
		</thead>
		<tbody id="contacterinfos">
			<s:iterator id="contactInfo" value="supplier.contactInfos">
				<tr>
					<td><s:property value="#contactInfo.contacter" /></td>
					<td><s:property value="#contactInfo.tel" /></td>
					<td><s:property value="#contactInfo.title" /></td>
					<td><s:property value="#contactInfo.email" /></td>
					<td><s:property value="#contactInfo.QQ" /></td>
					<td><s:property value="#contactInfo.remark" /></td>
				</tr>
			</s:iterator>			
		</tbody>
	</table>

</body>
</html>