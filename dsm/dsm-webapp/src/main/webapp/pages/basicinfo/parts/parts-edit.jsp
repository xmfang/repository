<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<title><s:text name="parts.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			if(validate() == false) {
				alert("<s:text name='parts.name.is.not.null'/>");
				return;
			}
			$.ajax({
		        'async': false,
		        'type': 'POST',
		        'url': '${basePath}/basicinfo/parts/parts-save.action',
		        'data': $("#partsform").serialize()
		    });
			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("partsName").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="partsform" theme="simple">
		<table class="table">
			<tr>
				<th><s:text name="parts.name" /></th>
				<td><s:textfield id="partsName" name="parts.name" /></td>
			</tr>
			<tr>
				<th><s:text name="price" /></th>
				<td><s:textfield name="price" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="cost" /></th>
				<td><s:textfield name="cost" cssClass="input-mini" /></td>
			</tr>
		</table>
		
		<input class="btn" type="button" value="<s:text name='submit'/>" onclick="submitOperation()" />
		<s:hidden name="parts.id" />
		<s:hidden name="parts.version" />
		<s:hidden name="partsCategory" />
	</s:form>

</body>
</html>