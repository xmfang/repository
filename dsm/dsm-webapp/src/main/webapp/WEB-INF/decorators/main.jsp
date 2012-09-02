<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><s:text name="nafu.door.store.management"/></title>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/jquery.js'/>"></script>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/js/bootstrap-dropdown.js'/>"></script>
    <decorator:head/>
</head>
<body id="page-home">
    <div id="page" class="container">
		<div class="navbar">
	  		<div class="navbar-inner">
	    		<div class="container">
	    			<a class="brand" href="#"><s:text name="nafu.door.store.management"/></a>
	      			<ul class="nav">
  						<li class="dropdown">
    						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <s:text name="basic.info.manage"/> <b class="caret"></b></a>
    						<ul class="dropdown-menu">
      							<li><a href="<s:url value='/basicinfo/doorcategory/door-category-list.action'/>"><s:text name="door.category.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/color/color-manage.action'/>"><s:text name="color.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/supplier/supplier-list.action'/>"><s:text name="supplier.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/model/model-manage.action'/>"><s:text name="model.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/style/style-manage.action'/>"><s:text name="style.manage"/></a></li>
      							<li><a href="<s:url value='/admin/dictionary/dictionary-manage.action'/>"><s:text name="dictionary.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/craft/craft-manage.action'/>"><s:text name="craft.manage"/></a></li>
      							<li><a href="<s:url value='/basicinfo/parts/parts-manage.action'/>"><s:text name="parts.manage"/></a></li>
    						</ul>
  						</li>
  						<li class="dropdown">
    						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <s:text name="order.manage"/> <b class="caret"></b></a>
    						<ul class="dropdown-menu">
      							<li><a href="<s:url value='/order/customer-order-base-info-edit.action'/>"><s:text name="customer.order"/></a></li>
      							<li><a href="<s:url value='/order/customer-order-list.action'/>"><s:text name="active.customer.order"/></a></li>
    						</ul>
  						</li>
					</ul>
	    		</div>
	  		</div>
		</div>
        
        <div id="content">
            <div id="main">
            	<decorator:body/>
                <hr />
            </div>            
        </div>
        
        <div id="footer">
            <p class="pull-left">&copy; Copyright <a href="#"><s:text name="copyright" /></a>.</p>
        </div>
        
    </div>
    
    <div id="extra1">&nbsp;</div>
    <div id="extra2">&nbsp;</div>
</body>
</html>
