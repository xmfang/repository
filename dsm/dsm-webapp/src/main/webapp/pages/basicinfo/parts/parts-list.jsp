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
		<title><s:text name="parts.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="parts.manage"/>';
				var content = "<iframe src='${basePath}/basicinfo/parts/parts-edit.action?partsId=" + id
							+ "&partsCategory=" + "<s:property value='partsCategory'/>"
							+ "' style='width: 350px; height: 250px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/basicinfo/parts/parts-remove.action?partsId=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="partses" requestURI="/basicinfo/parts/parts-list.action" uid="parts" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="name" titleKey="parts.name" />
			<display:column property="priceCent" titleKey="price" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="costCent" titleKey="cost" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${parts.id})" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(${parts.id})" />
			</display:column>
		</display:table>
		<br/>
		<input type="button" class="btn" value="<s:text name='add'/><s:text name='parts'/>" onclick="openwin('0')" />
		<br />
		
	</body>
</html>

