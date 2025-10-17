<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.common.ConfigurationServlet"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<%
	int tabIndex = 1;
	
SessionBean sb 				= 	(SessionBean) session.getAttribute("SessionBean");
String env 				= 	System.getProperty ( "ENV" );
String urlParam			=	"?pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl()+"&vehtype=N";
String urlToGoKeyCode 	= 	(String)ConfigurationServlet.getApplicationProperty ( env + "_NEWVEHICLE_KEYCODE_ACCESS_URL" )+urlParam;
%>

<script>
function continueFunction()
{
	document.VehicleForm.submit();
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}
function goToKeyCodeLogin()
{
	//document.VehicleForm.action='<%=urlToGoKeyCode%>';
	//document.VehicleForm.submit();
	
	window.location.href = '<%=urlToGoKeyCode%>';
}


</script>

<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
	<div class="ui-widget-content" style="min-height: 300px">
		<br>
		<form name="VehicleForm" action="newVehicle.do">
			<table width="100%" cellpadding="2" cellspacing="2">
				<tr>
					<td align="center"><font size="5"><b>SECURE KEY CODE ACCESS</b></font></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>			
					<td align="center"><p align="center">Your dealership has reached the limit of <%=com.archway.estore.common.ConfigurationServlet.getApplicationProperty("MAX_REG_PER_MONTH_IN_WORDS")%> (<%=com.archway.estore.common.ConfigurationServlet.getApplicationProperty("MAX_REG_PER_MONTH")%>) new vehicle key code requests per month for the current month.
<br>  
					No additional new vehicle key code requests can be made through the remainder of this month.
<br><br>
<!-- Questions/additional assistance  -  please contact Jerry Flemming (<a href="mailto:jflemmin@ford.com">jflemmin@ford.com</a>) -->
</td>
				</tr>
				<tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>
				
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<!-- <td width="50%" align="center">
			     	 	<p align="center">
			     	 		<div class="buttons ui-widget">
			     	 			<input type="button" id="continue" class="JQueryButton" onclick="javascript:continueFunction(this.form)" value="Continue" />
			     	 		</div>
			     	 	</p>
			     	 </td>-->
			     	   <tr>
			  
			  <tr>
			    <td width="100%" colspan="2">&nbsp;</td>
			  </tr>
			  </table>
			   <table border="0" cellpadding="0" cellspacing="0" width="100%">
	  		<tr>
			    <td align="center" >
			      <p colspan="2" ><div class="buttons ui-widget">

						<!-- <button id="ownership" class="JQueryButton" onclick="javaScript:caor();">Create Another Ownership Record</button>	-->
						<input type="button" id="keycodeLogin" class="JQueryButton" onclick="javaScript:goToKeyCodeLogin();" value="Go To Keycode Access Log In "/> &nbsp;
						<input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />
					</div></td>
			   
	  		</tr>
			
		</table>          
		</form>
	</div>	
</div>