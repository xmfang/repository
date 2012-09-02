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
		<title><s:text name="model.manage" /></title>
		<script language = "javascript">
			function openwin(id) {
				var title = '<s:text name="model.manage"/>';
				var content = "<iframe src='${basePath}/basicinfo/model/model-edit.action?modelId=" + id
							+ "&supplierId=" + "<s:property value='supplierId'/>"
							+ "' style='width: 350px; height: 300px;' frameborder='0'></iframe>";
				popupWin(title, content);
			}
			
			function remove(id) {
				if (confirm("<s:text name='confirm.delete'/>")) {
					location.href = "${basePath}/basicinfo/model/model-remove.action?modelId=" + id;
				}
			}
		</script>
	</head>
	<body>
	
		<display:table name="models" requestURI="/basicinfo/model/model-list.action" uid="model" pagesize="20" class="table table-striped table-bordered table-condensed">
			<display:column property="name" titleKey="model.name" />
			<display:column property="priceCent" titleKey="price" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="costCent" titleKey="cost" decorator="com.nafu.dsm.webapp.decorator.PriceColumnDecorator" />
			<display:column property="unit" titleKey="unit"  />
			<display:column titleKey="edit">
				<input type="button" class="btn" value="<s:text name='edit'/>" onclick="openwin(${model.id})" />
			</display:column>
			<display:column titleKey="remove">
				<input type="button" class="btn" value="<s:text name='remove'/>" onclick="remove(${model.id})" />
			</display:column>
		</display:table>
		<br/>
		<input type="button" class="btn" value="<s:text name='add'/><s:text name='model'/>" onclick="openwin('0')" />
		<br />
		
	</body>
</html>

