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
		<title><s:text name="craft.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="craft.manage"/>';
				var content = "<iframe src='${basePath}/basicinfo/craft/craft-edit.action?craftId=" + id
							+ "&craftCategory=" + "<s:property value='craftCategory'/>"
							+ "' style='width: 350px; height: 250px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/basicinfo/craft/craft-remove.action?craftId=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="crafts" requestURI="/basicinfo/craft/craft-list.action" uid="craft" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="name" titleKey="craft.name" />
			<display:column property="priceCent" titleKey="price" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="costCent" titleKey="cost" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${craft.id})" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(${craft.id})" />
			</display:column>
		</display:table>
		<br/>
		<input type="button" class="btn" value="<s:text name='add'/><s:text name='craft'/>" onclick="openwin('0')" />
		<br />
		
	</body>
</html>

