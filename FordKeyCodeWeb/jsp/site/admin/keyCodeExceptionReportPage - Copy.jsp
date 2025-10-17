<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility"%>
<html lang="us">
<%
int tabIndex = 1;
%>
<head>
	<title><bean:message key="loginPageTemplate.label.title"/></title>
	
	<link href="../../css/redmond/jquery-ui-1.10.2.custom.css" rel="stylesheet">
	<link href="../../css/displayTag.css" rel="stylesheet">
	
    <script src="../../js/jquery-1.9.1.js"></script>
    <script src="../../js/jquery-ui-1.10.2.custom.js"></script>
    <script type="text/javascript" src="../../js/f_default.js"></script>    
    <script type="text/javascript" src="../../js/util.js"></script>
    <script type="text/javascript" src="../../js/global.js"></script>
    <script type="text/javascript" src="../../js/window.js"></script>    
    <script type="text/javascript" src="../../js/fSimpleValidation.js"></script>
    <script type="text/javascript" src="../../js/validation.js"></script>
	
	
	<meta http-equiv="content-type" content="application/xhtml+xml; charset=utf-8" />
	<meta name="authors" content="Amar Bhatt">
	
</head>
<body>
<!-- Content Start -->
<form name="addUpdatePACodeForm" method="post">
<input type="hidden" name="mode" value="">
<br>
<br>
<br>
	
	<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td width="100%">Key Code Exception Report</td>
			</tr>
		 </table>
      </div>
      
       
      <div class="ui-widget-content" style="min-height: 300px">   <br>
      	<table border="0" cellpadding="0" cellspacing="0" width="100%">
      			<tr>
  					<td colspan="3"  style="padding-left : 30px;"><h4>Enter Start and End Date to Generate the report.</h4></td>  					
				</tr>
			 <tr>
				<td  align="right"><b>Start Date</b></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="test" 
					id="startDate" 
					name="startDate" 
					size="10" 
					MaxLength="10" 
					value=""
					tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />"
					> (MM/DD/YYYY)
				</td>
			</tr>	
			 <tr>
				<td  align="right"><b>End Date</b></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="test" 
					id="endDate" 
					name="endDate" 
					size="10" 
					MaxLength="10" 
					value=""
					tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />"
					>(MM/DD/YYYY)
				</td>
			</tr>	
			<tr>
  					<td colspan="3"  style="padding-left : 30px;">
  						<input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:generateReport(this.form)" value="Generate Report" />
						<input type="button" id="btnBackToMenu" class="JQueryButton" onClick="javaScript: return backToMenu(this.form);" value="Abort">
  						
						<span id="downloadReportText"></span>
  					</td>  					
				</tr>
		    </table>
		    </div>
		    </div>
	
</form>

<script langauage="javascript">
	
	function backToMenu()
	{
		document.addUpdatePACodeForm.action="adminLogin.do";
		document.addUpdatePACodeForm.mode.value="menuPage";
		document.addUpdatePACodeForm.submit();		
	}

	function generateReport(formObj)
	{
		if(!validate(formObj.startDate, "Start Date", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.endDate, "End Date", RULE_REQUIRED)) 
		{
			return false;
		}
		
		var url = "adminAjax.do?actionType=generateReport&startDate="+formObj.startDate.value+"&endDate="+formObj.endDate.value ;
		//alert(url);
		
		if (window.ActiveXObject) 
				    {  
				        httpRequest = new ActiveXObject("Microsoft.XMLHTTP"); 
				    }  
				    else if (window.XMLHttpRequest) 
				    {  
				        httpRequest = new XMLHttpRequest(); 
				    }  
				    httpRequest.open("POST", url, true); 
				    httpRequest.onreadystatechange = function() {generateReportResult(); } ; 
				    httpRequest.send(null);
		
		
	}
	
function generateReportResult()
{
 	if (httpRequest.readyState == 4) 
	{ 
    	if(httpRequest.status == 200) 
        { 
             //var mySplitResult = httpRequest.responseText ;
            //alert(httpRequest.responseText);
             document.getElementById("downloadReportText").innerHTML=httpRequest.responseText;
             }
             
	}
 }  
</script>


<!-- Content End -->
</body>
</html>
    