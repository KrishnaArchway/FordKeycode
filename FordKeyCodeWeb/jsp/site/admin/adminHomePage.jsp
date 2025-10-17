<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.common.ConfigurationServlet"%>
        
<%
String env 				= 	System.getProperty ( "ENV" );
%>


<form name="homepage" method="post" action="adminLogin.do">
<input type="hidden" name="mode" value=""> 
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="adminHomePage.label.information"/></div>
    	<div class="ui-widget-content" style="min-height: 300px">
    		<div class="buttons ui-widget">
    			<a href="#" onclick="javaScript:getBlockedPACode();"><bean:message key="adminHomePage.label.menu1"/></a>
    		</div>	
        	<br>
        	<div class="buttons ui-widget">
    			<a href="#" onclick="javaScript:KeyCodeExceptionReport();">Key Code Exception Report</a>
    		</div>	
    		<br>
        	<div class="buttons ui-widget">
    			<a href="#" onclick="javaScript:editRegistration();">Edit Registrations</a>
    		</div>	
    		
            	<div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div>
		</div>
	</div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr>
    		<td width="100%" align="center">
      			<p align="center">
      			<div class="buttons ui-widget">
                	<!-- <button id="btnSampleButton" class="JQueryButton" ><bean:message key="adminHomePage.label.logout.button"/></button> -->
					<input type="button" class="JQueryButton" id="homePageButton" name="homePageButton" value="Home" onclick="javascript: return homePageScreen(this.form)">

                </div>	
            </td>
		</tr>
	</table>
</div>
</form>


<script>



	function homePageScreen()
	{
		document.homepage.action="<%=(String)ConfigurationServlet.getApplicationProperty ( env + "_HOME_URL" )%>"
		document.homepage.submit();
	}


	function getBlockedPACode()
	{
		document.homepage.mode.value="get_blocked_pa_codes";
		document.homepage.submit();
	}
	function KeyCodeExceptionReport()
	{
		document.homepage.action="keyCodeExceptionReport.do";
		document.homepage.submit();
	}
	function editRegistration()
	{
		document.homepage.action="editRegistration.do";
		document.homepage.mode.value='';
		document.homepage.submit();
	}
	
	
</script>
            