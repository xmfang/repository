<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<title><s:text name="style.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			if(validate() == false) {
				alert("<s:text name='style.code.is.not.null'/>");
				return;
			}
			$.ajax({
		        'async': false,
		        'type': 'POST',
		        'url': '${basePath}/basicinfo/style/style-save.action',
		        'data': $("#styleform").serialize()
		    });
			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("styleCode").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="styleform" theme="simple">
		<table class="table">
			<tr>
				<th><s:text name="style.code" /></th>
				<td><s:textfield id="styleCode" name="style.code" /></td>
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
				<th><s:text name="description" /></th>
				<td><s:textarea name="style.description" /></td>
			</tr>
			<tr>
				<th><s:text name="craft.for.select"/></th>
				<td class="checkbox"><s:checkboxlist list="allCrafts" listValue="name" listKey="id" name="craftIds" /></td>
			</tr>
		</table>
		
		<input class="btn" type="button" value="<s:text name='submit'/>" onclick="submitOperation()" />
		<s:hidden name="style.id" />
		<s:hidden name="style.version" />
		<s:hidden name="supplierId" />
	</s:form>

</body>
</html>