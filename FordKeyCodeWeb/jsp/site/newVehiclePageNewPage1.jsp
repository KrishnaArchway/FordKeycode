<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.common.ConfigurationServlet"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<%
	int tabIndex = 1;
	
	SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
	
	String env 				= 	System.getProperty ( "ENV" );
	//String urlParam			=	"?pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl()+"&vehtype=N";
	//String urlToGoKeyCode 	= 	(String)ConfigurationServlet.getApplicationProperty ( env + "_NEWVEHICLE_KEYCODE_ACCESS_URL" )+urlParam;
	
	
	String urlParam			=	"&pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl();
	String urlToGoKeyCode 	= 	"https://fordpro.com/en-us/tools/sales/resources/dealer-key-code/";


%>

<script>
function continueFunction()
{
	//alert('hi');
	document.VehicleForm.submit();
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
					<td align="center"><p align="center">Please explain the circumstances for this request (Required to obtain a key code)</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center"><p align="center">Have you already established an online New Vehicle record providing a reason for making this key code request?</td>
				</tr>
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
			  <table width="100%" cellpadding="2" cellspacing="2">
			  <tr>
			    <td width="50%" align="center">NO - <a href="javascript:continueFunction(this.form)">Create a New Vehicle Request record</a></td>
			    <td width="50%" align="center">YES - <a href="<%=urlToGoKeyCode %>">Go to Key Code Access Login</a></td>
			  </tr>
			     	 
				</tr>
			</table>
		</form>
	</div>	
</div>