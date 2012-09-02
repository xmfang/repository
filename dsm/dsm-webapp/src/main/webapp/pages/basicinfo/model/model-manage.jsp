<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
	<head> 
		<link rel="stylesheet" href="<s:url value='/styles/tabs/tabs.css'/>" type="text/css" media="all" />
	    <script type="text/javascript" src="<s:url value='/js/tabs/tabs-iframe.js'/>"></script>
		<title><s:text name="model.manage"/></title> 
	</head> 
	<body> 
		<h3><s:text name="model.manage"/></h3>
		<ul class="tabs">
			<s:iterator id="supplier" value="suppliers">
				<li>
					<s:a action="model-list.action"><s:param name="supplierId" value="#supplier.id"/>
						<s:property value="#supplier.name"/>
					</s:a>
				</li>
			</s:iterator>
		</ul>
		
		<div class="tab_container">
			<div id="tab" class="tab_content">
				<iframe src="" style="width: 100%;" onload="Javascript:setIframeHeight(this)" frameborder="0"></iframe>
			</div>
		</div>
	</body> 
</html> 