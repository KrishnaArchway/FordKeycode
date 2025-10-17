<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.common.ConfigurationServlet"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<%
	int tabIndex = 1;
	
	SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
	
	String env 				= 	System.getProperty ( "ENV" );
	String urlParam			=	"?pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl()+"&vehtype=N";
	String urlToGoKeyCode 	= 	(String)ConfigurationServlet.getApplicationProperty ( env + "_NEWVEHICLE_KEYCODE_ACCESS_URL" )+urlParam;

%>

<script>
function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}
function continueFunction()
{
	document.VehicleForm.submit();
}
</script>

<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
	<div class="ui-widget-content" style="min-height: 300px">
		<br>
		<form name="VehicleForm" action="vinNewVehicle.do">
			<table width="100%" cellpadding="2" cellspacing="2">
				<tr>
					<td align="center"><font size="5"><b>Secure Key Code Access</b></font></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td align="center">Process for obtaining a New Vehicle Key Code </td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td><font size="3pt"><b><i>Unusual Circumstances</i></b></font></td>
				</tr>
				<tr>
					<td>There are rare instances (examples: a lost key - or - keys &amp; tag locked inside a vehicle, etc.) where a replacement or duplicate key is needed and the dealership has no other means by which to access a key code.</td>
				</tr>
				
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>On an EXCEPTION basis - and not to exceed three key code requests per month - Ford will permit authorized dealership users to obtain new vehicle (stock unit) key code data.  Dealership key code request activity on unsold inventory will be closely monitored.  The over use or inappropriate handling of new vehicle inventory key code request may result in a dealership's loss or restricted access to this feature.</td>
				</tr>
				
				
				
				
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
			    <td width="50%" align="center">
			    	 <div class="buttons ui-widget">
			    	<input 	type="button" 
		      			id="continue" 
		      			class="JQueryButton" 
		      			onclick="javascript:continueFunction(this.form)"
		      			value="Continue with making a New Vehicle record" />
		      	</div> 
			    
			    </td>
			    <td width="50%" align="center"><div class="buttons ui-widget">
		         	     	<input 	type="button" 
		         			id="btnFMCDealerButton" 
		         			class="JQueryButton" 
		         			onclick="javascript : goToFMCDealer(this.form)"
		         			value="<bean:message key="back.to.fmcdealer.com"/>" />
		         </div></td>
			  </tr>
			     	 
				</tr>
			</table>
		</form>
	</div>	
</div>