<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>

<%

String vinNum = (String)request.getAttribute("vinNum");
String dealerVehicleYear = (String)request.getAttribute("dealerVehicleYear");
String dealerVehicleMake = (String)request.getAttribute("dealerVehicleMake");
String dealerVehicleModel = (String)request.getAttribute("dealerVehicleModel");
String dealerVehicleInfo = (String)request.getAttribute("dealerVehicleInfo");
String agreementCheck = (String)request.getAttribute("agreementCheck");
String submittedFirstName = (String)request.getAttribute("submittedFirstName");
String submittedLastName = (String)request.getAttribute("submittedLastName");

SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
%>
<form name="confirmPage" id="confirmPage" method="post" action="newVehicleSubmit.do">
<input type="hidden" name="vinNum"  id="vinNum" value="<%=vinNum %>">
<input type="hidden" name="dealerVehicleYear"  id="dealerVehicleYear" value="<%=dealerVehicleYear %>">
<input type="hidden" name="dealerVehicleMake"  id="dealerVehicleMake" value="<%=dealerVehicleMake %>">
<input type="hidden" name="dealerVehicleModel"  id="dealerVehicleModel" value="<%=dealerVehicleModel %>">
<input type="hidden" name="dealerVehicleInfo"  id="dealerVehicleInfo" value="<%=dealerVehicleInfo %>">
<input type="hidden" name="agreementCheck"  id="agreementCheck" value="<%=agreementCheck %>">
<input type="hidden" name="submittedFirstName"  id="submittedFirstName" value="<%=submittedFirstName %>">
<input type="hidden" name="submittedLastName"  id="submittedLastName" value="<%=submittedLastName %>">


<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
	<div class="ui-widget-content" style="min-height: 300px">
		<br>
		<table width="80%" align="center" cellpadding="2" cellspacing="2">
			<tr><td colspan="3" align="center"><b>Please Confirm information below </b></td></tr>
			<tr><td colspan="3">&nbsp;</td></tr>
		</table>	
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width="90%" height="15px">
			<tr>
			    <td width="50%" align="right">		      
			      <div class="buttons ui-widget">			          
					  <input type="button" class="JQueryButton" value="Print for your records" onclick="window.print()" />
			      </div>
			    </td>			  
			</tr>
		</table>
	  	<br>	
		<table border="0" cellpadding="0" cellspacing="0" width="90%" height="15px">
			<tr>
				<td align="right" width="40%"><b>P &amp; A Code</b></td>
				<td width="2%" align="center"><b>:</b></td>
				<td><%= sb.getPacode()%></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right" width="40%"><b>User ID</b></td>
				<td width="2%" align="center"><b>:</b></td>
				<td><%= sb.getWsl()%></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right" width="40%"><b>Vin Number</b></td>
				<td width="2%" align="center"><b>:</b></td>
				<td><%= vinNum %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Dealer Vehicle Year</b></td>
				<td align="center"><b>:</b></td>
				<td><%= dealerVehicleYear %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Dealer Vehicle Make</b></td>
				<td align="center"><b>:</b></td>
				<td><%= dealerVehicleMake %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Dealer Vehicle Model</b></td>
				<td align="center"><b>:</b></td>
				<td><%= dealerVehicleModel %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Dealer Vehicle Info</b></td>
				<td align="center"><b>:</b></td>
				<td><%= dealerVehicleInfo %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Agreement Check</b></td>
				<td align="center"><b>:</b></td>
				<td><%= agreementCheck %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Submitted By First Name</b></td>
				<td align="center"><b>:</b></td>
				<td><%= submittedFirstName %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right"><b>Submitted By Last Name</b></td>
				<td align="center"><b>:</b></td>
				<td><%= submittedLastName %></td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
		</table>
	</div>
	
	<table border="0" cellpadding="0" cellspacing="0" width="90%">
		  <tr>
		    <td width="50%" align="center">
		      <p align="center">
		      <div class="buttons ui-widget">
		          <!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form)"><bean:message key="back.to.fmcdealer.com"/></button> -->
		          <input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />
		      </div>
		    </td>
		    <td width="50%" align="center">
		      <p align="center">
		      <div class="buttons ui-widget">
		        <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
		      	<input type="button" id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:return nextFunction()" value="<bean:message key="showHomePage.label.next.button"/>">
		      </div>
		    </td>
		  </tr>
		</table>
</div>

</form>


<script langauge="javascript">

function goBack()
{
	window.history.go(-1);
}
function nextFunction()
{
	document.confirmPage.submit();
}
</script>
		