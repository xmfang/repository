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
		<title><s:text name="style.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="style.manage"/>';
				var content = "<iframe src='${basePath}/basicinfo/style/style-edit.action?styleId=" + id
							+ "&supplierId=" + "<s:property value='supplierId'/>"
							+ "' style='width: 400px; height: 500px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/basicinfo/style/style-remove.action?styleId=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="styles" requestURI="/basicinfo/style/style-list.action" uid="style" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="code" titleKey="style.code" />
			<display:column property="priceCent" titleKey="price" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="costCent" titleKey="cost" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="description" titleKey="description"  />
			<display:column property="craftForSelect" titleKey="craft.for.select" />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${style.id})" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(${style.id})" />
			</display:column>
		</display:table>
		<br/>
		<input type="button" class="btn" value="<s:text name='add'/><s:text name='style'/>" onclick="openwin('0')" />
		<br />
		
	</body>
</html>

