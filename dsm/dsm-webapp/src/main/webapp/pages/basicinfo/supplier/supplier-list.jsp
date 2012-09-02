<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="supplier.manage" /></title>
	<script language = "javascript">
		function openwin(id) {
			location.href = "${basePath}/basicinfo/supplier/supplier-edit.action?supplier.id=" + id;
		}
		function remove(id) {
			if (confirm("<s:text name='confirm.no.cooperation'/>")) {
				location.href = "${basePath}/basicinfo/supplier/supplier-remove.action?supplier.id=" + id;
			}
		}
	</script>
</head>
<body>
	<h3><s:text name="supplier.list"/></h3>
	<display:table name="suppliers" requestURI="/basicinfo/supplier/supplier-list.action" uid="supplier" pagesize="20" class="table table-striped table-bordered table-condensed">
		<display:column property="name" titleKey="name" href="basicinfo/supplier/supplier-view.action" paramId="supplier.id" paramProperty="id" />
		<display:column property="tel" titleKey="tel" />
		<display:column property="fax" titleKey="fax" />
		<display:column property="website" titleKey="website" />
		<display:column property="address" titleKey="address" />
		<display:column titleKey="edit">
			<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${supplier.id})" />
		</display:column>
		<display:column titleKey="remove">
			<input type="button" class="btn" value="<s:text name='no.cooperation'/>" onclick="remove(${supplier.id})" />
		</display:column>
	</display:table>
	<br/>
	<s:a cssClass="btn" action="supplier-edit.action"><s:param name="supplier.id" /><span><s:text name='add.partner.supplier'/></span></s:a>
	<br />
	
</body>
</html>

