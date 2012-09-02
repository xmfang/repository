<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
	<link rel="stylesheet" href="<s:url value='/styles/main.css'/>" />
	<title><s:text name="door.category.manage" /></title>
	
	<script type="text/javascript">
		function submitOperation() {
			if(validate() == false) {
				alert("<s:text name='name.is.not.null'/>");
				return;
			}
			$.ajax({
		        'async': false,
		        'type': 'POST',
		        'url': '${basePath}/basicinfo/doorcategory/door-category-save.action',
		        'data': $("#doorcategoryform").serialize()
		    });
			parent.closeEditPage('<s:text name="submit.success"/>');
		}
		
		function validate() {
			if ( document.getElementById("name").value.replace(/^\s+|\s+$/g,"") == "") {
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<s:form id="doorcategoryform" theme="simple">
		<table class="table">
			<tr>
				<th><s:text name="name" /></th>
				<td><s:textfield name="doorCategory.name" id="name" /></td>
			</tr>
			<tr>
				<th colspan="2"><h4><s:text name="standar.size" /></h4></th>
			</tr>
			<tr>
				<th><s:text name="width" /></th>
				<td><s:textfield id="text" name="doorCategory.standarSize.widthmm" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="height" /></th>
				<td><s:textfield name="doorCategory.standarSize.heightmm" cssClass="input-mini" /></td>
			</tr>
			<tr>
				<th><s:text name="thickness" /></th>
				<td><s:textfield name="doorCategory.standarSize.thicknessmm" cssClass="input-mini" /></td>
			</tr>
		</table>
		
		<input class="btn" type="button" value="<s:text name='submit'/>" onclick="submitOperation()" />
		<s:hidden name="doorCategory.id" />
		<s:hidden name="doorCategory.version" />
	</s:form>

</body>
</html>