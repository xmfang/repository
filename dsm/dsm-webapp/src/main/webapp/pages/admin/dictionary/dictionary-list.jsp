<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   		<script src="<s:url value='/js/jquery.js'/>"></script>
		<script src="<s:url value='/js/artdialog/popup.edit.window.js'/>"></script>
		<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
		<link rel="stylesheet" href="<s:url value='/styles/artdialog/default.css'/>" />
		<title><s:text name="dictionary.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="dictionary.manage"/>';
				var content = "<iframe src='${basePath}/admin/dictionary/dictionary-edit.action?dictionary.id=" + id
							+ "&dictionary.category=" + "<s:property value='category'/>"
							+ "' style='width: 300px; height: 300px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/admin/dictionary/dictionary-remove.action?dictionary.id=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="dictionaries" requestURI="/admin/dictionary/dictionary-list.action" uid="dictionary" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="sortOrder" titleKey="dictionary.sortOrder" />
			<display:column property="serialNumber" titleKey="dictionary.serialNumber" />
			<display:column property="text" titleKey="dictionary.text" />
			<%-- <display:column property="category" titleKey="dictionary.category" decorator="com.nafu.dsm.webapp.decorator.EnumColumnDecorator" /> --%>
			<display:column property="remark" titleKey="dictionary.remark" />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${dictionary.id})" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(${dictionary.id})" />
			</display:column>
		</display:table>
		<br/>
		<input type="button" class="btn" value="<s:text name='add'/><s:property value='getText(category)'/>" onclick="openwin('')" />
		<br />
		
	</body>
</html>

