<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="<s:url value='/js/artdialog/popup.edit.window.js'/>"></script>
		<link rel="stylesheet" href="<s:url value='/styles/artdialog/default.css'/>" />
		<title><s:text name="door.category.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="door.category.manage"/>';
				var content = "<iframe src='${basePath}/basicinfo/doorcategory/door-category-edit.action?doorCategoryId=" + id
							+ "' style='width: 350px; height: 350px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/basicinfo/doorcategory/door-category-remove.action?doorCategoryId=" + id;
				}
			}
		</script>
	</head>
	<body>
		<h3><s:text name="door.category.list" /></h3>
		<table border="1" class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th rowspan="2"><s:text name="name"/></th>
					<th colspan="3"><s:text name="standar.size" /></th>
					<th rowspan="2"><s:text name="edit"/></th>
					<th rowspan="2"><s:text name="remove"/></th>
				</tr>
				<tr>
					<th><s:text name="width" /></th>
					<th><s:text name="height" /></th>
					<th><s:text name="thickness" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="doorCategories" id="doorCategory">
					<tr>
						<td><s:property value="#doorCategory.name" /></td>
						<td><s:property value="#doorCategory.standarSize.widthmm" /></td>
						<td><s:property value="#doorCategory.standarSize.heightmm" /></td>
						<td><s:property value="#doorCategory.standarSize.thicknessmm" /></td>
						<td><input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(<s:property value='#doorCategory.id'/>)" /></td>
						<td><input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(<s:property value='#doorCategory.id'/>)" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	
		<input type="button" class="btn" value="<s:text name='add'/><s:text name='door.category'/>" onclick="openwin('')" />
		<br />
		
	</body>
</html>

