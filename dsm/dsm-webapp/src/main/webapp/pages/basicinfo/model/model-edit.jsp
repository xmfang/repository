<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<title><s:text name="model.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			if(validate() == false) {
				alert("<s:text name='model.name.is.not.null'/>");
				return;
			}
			$.ajax({
		        'async': false,
		        'type': 'POST',
		        'url': '${basePath}/basicinfo/model/model-save.action',
		        'data': $("#modelform").serialize()
		    });
			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("modelName").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="modelform" theme="simple">
		<table class="table">
			<tr>
				<th><s:text name="model.name" /></th>
				<td><s:textfield id="modelName" name="model.name" /></td>
			</tr>
			<tr>
				<th><s:text name="price" /></th>
				<td><s:textfield name="price" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="cost" /></th>
				<td><s:textfield name="cost" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="unit" /></th>
				<td><s:textfield name="model.unit" cssClass="input-mini" /></td>
			</tr>
		</table>
		
		<input class="btn" type="button" value="<s:text name='submit'/>" onclick="submitOperation()" />
		<s:hidden name="model.id" />
		<s:hidden name="model.version" />
		<s:hidden name="supplierId" />
	</s:form>

</body>
</html>