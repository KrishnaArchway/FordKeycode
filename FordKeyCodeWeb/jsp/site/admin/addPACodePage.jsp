<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility,com.archway.estore.formbean.BlockedPACodeBean"%>
<html lang="us">

<head>
	<title><bean:message key="loginPageTemplate.label.title"/></title>
	
	<link href="../css/redmond/jquery-ui-1.10.2.custom.css" rel="stylesheet">
	<link href="../css/displayTag.css" rel="stylesheet">
	
    <script src="../js/jquery-1.9.1.js"></script>
    <script src="../js/jquery-ui-1.10.2.custom.js"></script>
    <script type="text/javascript" src="../js/f_default.js"></script>    
    <script type="text/javascript" src="../js/util.js"></script>
    <script type="text/javascript" src="../js/global.js"></script>
    <script type="text/javascript" src="../js/window.js"></script>    
    <script type="text/javascript" src="../js/fSimpleValidation.js"></script>
    <script type="text/javascript" src="../js/validation.js"></script>
	
	
	<meta http-equiv="content-type" content="application/xhtml+xml; charset=utf-8" />
	<meta name="authors" content="Amar Bhatt">
	
</head>
<body>
<form name="addUpdatePACodeForm">
<input type="hidden" name="mode" value="">
<br>
<br>
<br>
	<table width="25%">				
   		<tr>
			<td align="right">	
				<b><bean:message key="adminHomePage.label.table.col1"/></b>
			</td>
			<td align="left">	
				<input type="text" name="paCode" id="paCode" value="">
			</td>
		</tr>
		<tr>			
			<td align="center" colspan="2">
				<table border="0" cellpadding="0" cellspacing="0" width="25%">
			  		<tr>
			    		<td width="25%" align="center">
			      			<p align="center">
			      			<div class="buttons ui-widget">
							  <input type="button" id="btnAddButton" class="JQueryButton" onclick="javaScript:savePaCode()" value="<bean:message key="adminHomePage.label.table.saveButton"/>">
							</div>	
			            </td>
					</tr>
				</table>							
			</td>
		</tr>			
	</table>        	
</form>
</body>
</html>
<script>
	function savePaCode()
	{
		
		if(document.getElementById("paCode").value == '')
		{
			alert('Please enter PA Code');
			return false;
		}
		else
		{
//			var url="adminLogin.do?mode=savePACode&paCode="+document.getElementById("paCode").value;
			var url=document.getElementById("paCode").value;
			window.returnValue=url;
			window.close();
		}
		
	}	
</script>
            