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
function continueFunction()
{
	//alert('hi');
	document.VehicleForm.submit();
}

function goToFMCDealer(formObj)
{
	document.VehicleForm.action='fmcDealer.do';
	document.VehicleForm.submit();
}
</script>

<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
	<div class="ui-widget-content" style="min-height: 300px">
		<br>
		<form name="VehicleForm" action="newVehiclePage3.do">
			<table width="100%" cellpadding="2" cellspacing="2">
				<tr>
					<td align="center"><font size="5"><b>Secure Key Code Access</b></font></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td align="center">Note the Process for obtaining a New Vehicle Key Code</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr>			
					<td>Access to the Ford Key Code application through this path is restricted to only key code requests in your dealership's current New Vehicle inventory.  Key Code access for other purposes (registered vehicle owners, dealership owned used vehicles, etc.) are required to go through the General Key Code Access link on the previous webpage.  All Vehicle Key Code requests are monitored and dealerships must be in compliance with the Ford Key Code Usage Policy.</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>Ford Key Code Usage Policy requires authorized dealership users to verify and retain the appropriate documentation of the requesting vehicle owner.  The Certificate of Origin (MSO) must be retained for each New Vehicle Key Code that is requested.  The Ford Policy prohibits the selling or sharing of this information to third party sources such as lienholders, repossessors, key code brokers, etc.</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td><font size="3pt"><b><i>Vehicle Key Codes on the Key Tags</i></b></font></td>
				</tr>
				<tr>
					<td>New Vehicles ordered from Ford arrive via transport at your dealership with a set of programmed keys (2) and key tags which include the vehicle key code on them.  The vehicle key code information on the key tags is to be securely recorded by the dealership upon vehicle arrival. Establishing a process to record the vehicle key code will reduce/eliminate the need for online access to key codes in the future.</td>
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
		      			value="Continue" />
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