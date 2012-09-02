<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<title><s:text name="dictionary.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			if(validate() == false) {
				alert("<s:text name='text.is.notnull'/>");
				return;
			}
			$.ajax({
		        'async': false,
		        'type': 'POST',
		        'url': '${basePath}/admin/dictionary/dictionary-save.action',
		        'data': $("#dictionaryform").serialize()
		    });
//			$.post('${basePath}/admin/dictionary/dictionary-save.action', $("#dictionaryform").serialize());
			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("text").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="dictionaryform" theme="simple" action="/admin/dictionary/dictionary-submit.action">
		<table class="table">
			<tr>
				<th><s:text name="dictionary.serialNumber" /></th>
				<td><s:textfield name="dictionary.serialNumber" cssClass="input-small" /></td>
			</tr>
			<%-- <tr>
				<td><s:text name="dictionary.category" /></td>
				<td><s:select name="dictionary.category" list="categories" listValue="getText(name())" /></td>
			</tr> --%>
			<tr>
				<th><s:text name="dictionary.text" /></th>
				<td><s:textfield id="text" name="dictionary.text" /></td>
			</tr>
			<tr>
				<th><s:text name="dictionary.sortOrder" /></th>
				<td><s:textfield name="dictionary.sortOrder" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="dictionary.remark" /></th>
				<td><s:textarea name="dictionary.remark" /></td>
			</tr>
		</table>
		
		<input class="btn" type="button" value="<s:text name='submit'/>" onclick="submitOperation()" />
		<s:hidden name="dictionary.id" />
		<s:hidden name="dictionary.version" />
		<s:hidden name="dictionary.category" />
	</s:form>

</body>
</html>