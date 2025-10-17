<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility, com.archway.estore.formbean.EditRegistrationVINBean"%>


<%
	EditRegistrationVINBean eRVINBean = (EditRegistrationVINBean)request.getSession().getAttribute("EditRegistrationVINBean");
%>


<form name="vehicleInfoForm" action="editRegistration.do" method="post">
<input type="hidden" name="mode" value="">
<input type="hidden" name="pa_code" id="pa_code" value="<%= eRVINBean.getPa_code() %>"> 
<input type="hidden" name="vin" id="vin" value="<%= eRVINBean.getVin() %>"> 
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="editRegistration.label.header1"/></div>
    	<div class="ui-widget-content" style="min-height: 300px"> 
			<table align="center" width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="center"><b><%= (String)request.getSession().getAttribute("VIN_PACODE_DEALERNAME") %></b></td>
				</tr>
				<tr>
					<td>
						<div class="ui-widget-header-lavender">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td width="100%"><p class="vinInfoText" align="center"><b>Vehicle Information</b></td>
								</tr>											
							</table>
					   </div>
					</td>
				</tr>

				<tr>
					<td>
						<div class="ui-widget">								
							<table align="center" width="90%" cellpadding="2" cellspacing="2" border="0">				
								<%
									if(request.getAttribute("updateRecordMsg")!=null)
									{
								%>
								<div id="dialogUpdateRecordMsg" title="My Dialog Title">
									<center><font color="red"><%= (String)request.getAttribute("updateRecordMsg") %></font><center>
								</div>
								<%										
									}
								%>
								
																
								<tr>
									<td>
										<table align="center" width="100%" border="0">											
											<tr>
												<td width="" align="right">Make</td>
												<td  align="center"><b>:</b></td>
												<td width="">												
													<select id="vehicle_make"	name="vehicle_make"	style="<bean:message key="upperCaseStyle" />" >
														<option value="FORD" <%=eRVINBean.getVehicle_make().equalsIgnoreCase("FORD")?"selected":"" %>>FORD</option>
														<option value="LINCOLN" <%=eRVINBean.getVehicle_make().equalsIgnoreCase("LINCOLN")?"selected":"" %>>LINCOLN</option>
														<option value="MERCURY" <%=eRVINBean.getVehicle_make().equalsIgnoreCase("MERCURY")?"selected":"" %>>MERCURY</option>
													</select>
												</td>									
											</tr>
											<tr>
												<td width="46%" align="right">Year</td>
												<td width="8%"  align="center"><b>:</b></td>
												<td width="">
													<input type="text" name="vehicle_year" id="vehicle_year" value="<%=eRVINBean.getVehicle_year() %>" maxlength="4" style="<bean:message key="upperCaseStyle" />"
													onkeyup="javascript : checkNumericInput(this)" />
												</td>									
											</tr>
											<tr>
												<td width="" align="right">Model</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="vehicle_model" id="vehicle_model" value="<%=eRVINBean.getVehicle_model() %>" maxlength="30"  size="30" style="<bean:message key="upperCaseStyle" />"/></td>									
											</tr>
											<tr>
												<td width="" align="right">Color</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="vehicle_color" id="vehicle_color" maxlength="30"  size="30" value="<%=eRVINBean.getVehicle_color() %>" style="<bean:message key="upperCaseStyle" />"/></td>									
											</tr>
											<tr>
												<td width="" align="right">License Plate Number</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="license_plate_number" id="license_plate_number" size="20" maxlength="10" value="<%=eRVINBean.getLicense_plate_number() %>" style="<bean:message key="upperCaseStyle" />"/></td>									
											</tr>
											<tr>
												<td width="" align="right">State&nbsp;of&nbsp;Vehicle&nbsp;Registration</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="state_vehicle_reg" id="state_vehicle_reg" value="<%=eRVINBean.getState_vehicle_reg() %>" maxlength="2" style="<bean:message key="upperCaseStyle" />"/></td>									
											</tr>
											<tr>
												<td width="" align="right">Odometer Reading</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="odometer" id="odometer" value="<%=eRVINBean.getOdometer() %>" maxlength="10"  size="10" style="<bean:message key="upperCaseStyle" />" onkeyup="javascript : checkNumericInput(this)"/></td>									
											</tr>
											<tr>					
												<td colspan="3" style="padding-left:68px;"> &nbsp; </td>
											</tr>
											<tr>					
												<td colspan="3" style="padding-left:53px; padding-right:53px;"> <hr color="#99FFFF" width="100%"/></td>
											</tr>																						
										</table>
									</td>
								</tr>
								
								
								<tr>
									<td>
										<table align="center" width="100%" border="0">											
											<tr>
												<td colspan="4" align="left" style="padding-left : 60px;font-size:10pt"><b>Choose any of the following proof of ownership documents that apply:</b></td>												
											<tr>
												<td align="right" width="40%">Vehicle is titled to dealership <b>:</b></td>
												<td width="4%"><input type="checkbox" name="dealer_titled" id="dealer_titled" size="50" value="<%=eRVINBean.getDealer_titled() %>"/></td>
												<td align="right" width="40%">Dealership is in possession of the title <b>:</b></td>
												<td><input type="checkbox" name="dealer_posess" id="dealer_posess" size="50" value="<%=eRVINBean.getDealer_posess() %>"/></td>
											</tr>
											<tr>
												<td align="right">Bus/Sell Agreement <b>:</b></td>
												<td><input type="checkbox" name="buy_sell" id="buy_sell" size="50" value="<%=eRVINBean.getBuy_sell() %>"/></td>
											</tr>
											<tr>					
												<td colspan="4" style="padding-left:53px; padding-right:53px;"> <hr color="#99FFFF" width="100%"/></td>
											</tr>
										</table>					
									</td>
								</tr>

								<tr>
									<td>
										<table align="center" width="100%" border="0">
											<tr>
												<td colspan="3" style="padding-left : 60px;font-size:10pt"><b>Vehicle Ownership Verification Submitted by :</b></td>
											</tr>
											<tr>
												<td width="30%" align="right" style="font-size:10pt"><b>Name</b></td>
												<td width="16%" align="right">First</td>
												<td width="8%"  align="center"><b>:</b></td>
												<td width=""><input type="text" name="submit_first_name" id="submit_first_name" maxlength="20" size="40" value="<%=eRVINBean.getSubmit_first_name() %>" style="<bean:message key="upperCaseStyle" />" /></td>									
											</tr>
											<tr>
												<td align="right"&nbsp;</td>
												<td width="" align="right">Last</td>
												<td  align="center"><b>:</b></td>
												<td width=""><input type="text" name="submit_last_name" id="submit_last_name" maxlength="40" size="40" value="<%=eRVINBean.getSubmit_last_name() %>" style="<bean:message key="upperCaseStyle" />"/></td>									
											</tr>																						
										</table>
									</td>
								</tr>
							</table>
							<div class="spacer"></div><div class="clear"></div>							
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="spacer"></div> <div class="clear"></div>		
			<table align="center" width="100%" border="0" cellspacing="2" cellpadding="4">								
				<tr>
					<td align="right" width="50%">														
							<input type="button" id="btnBackButton" class="JQueryButton" onClick="javaScript:backScreen();" value="Back">
					</td>
					<td align="left">	
							<input type="button" id="btnSaveButton" class="JQueryButton" onClick="javaScript: return saveRecord(this.form);" value="Save">
					</td>
					<td align="right">
						<input type="button" id="btnBackToMenu" class="JQueryButton" onClick="javaScript: return backToMenu(this.form);" value="Abort"></td>												
				</tr>			
			</table>
	</div>    
</div>
</form>

<script>

	var dealerSell = "<%= eRVINBean.getBuy_sell() %>" ; ;
	var dealerTitled = "<%= eRVINBean.getDealer_titled() %>" ; ;
	var dealerPossess = "<%= eRVINBean.getDealer_posess() %>" ; ;
	
	setSessionValues();

	function setSessionValues()
	{
		if(dealerSell != null && dealerSell == "Y"){
			document.getElementById('buy_sell').checked = true ;
		}
		if(dealerTitled != null && dealerTitled == "Y"){
			document.getElementById('dealer_titled').checked = true ;
		}
		if(dealerPossess != null && dealerPossess == "Y"){
			document.getElementById('dealer_posess').checked = true ;
		}	
	}

	function saveRecord(formObj)
	{		
		if(validateFrm(formObj)==true)
		{
			document.vehicleInfoForm.mode.value="saveVehicleInfo";
			document.vehicleInfoForm.submit();
		}
		else
		{
			return false ;
		}		
	}
	
	function backScreen()
	{
		document.vehicleInfoForm.mode.value="backToPersonalIdInfo";
		document.vehicleInfoForm.submit();		
	}

	function backToMenu()
	{
		document.vehicleInfoForm.mode.value="backToMenuScreen";
		document.vehicleInfoForm.submit();		
	}
	
	
	function validateFrm(formObj)
	{	
		if(!validate(formObj.vehicle_year, "Year", RULE_REQUIRED)) 
		{
			return false;
		}
			
		if(!validate(formObj.vehicle_make, "Make", RULE_REQUIRED)) 
		{
			return false;
		}
			
		if(!validate(formObj.vehicle_model, "Model", RULE_REQUIRED)) 
		{
			return false;
		}
		
		/*if(!validate(formObj.vehicle_color, "Color", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.license_plate_number, "License Plate Number", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.state_vehicle_reg, "State of Vehicle Registration", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.odometer, "Odometer Reading", RULE_REQUIRED)) 
		{
			return false;
		}
		*/
		
		if(!validate(formObj.submit_first_name, "Submit By First Name", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.submit_last_name, "Submit By Last Name", RULE_REQUIRED)) 
		{
			return false;
		}
		
		return true ;		
	}
	
	function checkNumericInput(ob) 
	{
		var invalidChars = /[^0-9]/gi
		if(invalidChars.test(ob.value)) 
		{
			ob.value = ob.value.replace(invalidChars,"");
		}
	}
</script>
            