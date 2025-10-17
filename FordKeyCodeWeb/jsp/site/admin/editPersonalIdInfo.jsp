<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility, com.archway.estore.formbean.EditRegistrationVINBean"%>


<%
	EditRegistrationVINBean eRVINBean = (EditRegistrationVINBean)request.getSession().getAttribute("EditRegistrationVINBean");
%>


<form name="personalIdInfoForm" action="editRegistration.do" method="post">
<input type="hidden" name="mode" value="">
<input type="hidden" name="pa_code" id="pa_code" value="<%= eRVINBean.getPa_code() %>"> 
<input type="hidden" name="vin" id="vin" value="<%= eRVINBean.getVin() %>"> 
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="editRegistration.label.header1"/></div>
    	<div class="ui-widget-content" style="min-height: 300px">
			<table align="center" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center"><b><%= (String)request.getSession().getAttribute("VIN_PACODE_DEALERNAME") %></b></td>
				</tr>
				<tr>
					<td>
					<div class="ui-widget-header-lavender">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td width="100%"><p class="vinInfoText" align="center"><b>Personal ID Information</b></td>
							</tr>											
						</table>
				   </div>						
					
					</td>
				</tr>

				<tr>
					<td>
						<div class="ui-widget">												
							<table align="center" width="90%" cellpadding="2" cellspacing="2">
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
									<td><br><br>
										<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0">											
											<tr>
												<td width="30%" align="right">Driver's&nbsp;License&nbsp;Number</td>
												<td width="4%" align="center"><b>:</b></td>
												<td width=""><input type="text" name="vo_drivers_license" id="vo_drivers_license" maxlength="40" size="40" value="<%= eRVINBean.getVo_drivers_license() %>"  style="<bean:message key="upperCaseStyle" />"/></td>
												
											</tr>
											<tr>
												<td align="right">State</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_license_state" id="vo_license_state" maxlength="2" size="10" value="<%= eRVINBean.getVo_license_state() %>" style="<bean:message key="upperCaseStyle" />"/></td>												
											</tr>						
											<tr>
												<td align="right">Expiration Date</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_license_exp_date" id="vo_license_exp_date" maxlength="10" size="20" value="<%= eRVINBean.getVo_license_exp_date() %>" readonly="readonly" /></td>												
											</tr>						
										</table>
									</td>
								</tr>
								
								<tr>					
									<td style="padding-left:53px; padding-right:53px;"> <hr color="#99FFFF" width="100%"/></td>
								</tr>	

								<tr>
									<td>
										<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0">
											<tr>
											<%--<td colspan="8"><b>Have Additional Form of Identification Verified and Copy Retained : </b></td>--%>
												<td colspan="8" style="padding-left : 60px;font-size:10pt"><b>Indicate the proof of ownership that you have reviewed & retained a copy</b></td>
											</tr>
											<tr>
												<td colspan="2" style="padding-left :80px; padding-top:5px; font-size:10pt"><b>Choose One : </b></td>
												<td colspan="6">&nbsp;</td>
											</tr>
											<tr>
												<td width="18%" align="right">Title:</td>
												<td width="5%"><input type="radio" name="additionalIdentity" id="additionalIdentity" value="title" onClick="javascript:explainOther(this.value)"/ <%= eRVINBean.getId_title().equalsIgnoreCase("Y")?"checked":"" %>></td>
												<td width="18%" align="right">Registration:</td>
												<td width="5%"><input type="radio" name="additionalIdentity" id="additionalIdentity" value="registration" onClick="javascript:explainOther(this.value)" <%= eRVINBean.getId_registration().equalsIgnoreCase("Y")?"checked":"" %>/></td>
												<td width="18%" align="right">Cert of Insurance:</td>
												<td width="5%"><input type="radio" name="additionalIdentity" id="additionalIdentity" value="insurance" onClick="javascript:explainOther(this.value)" <%= eRVINBean.getId_insurance().equalsIgnoreCase("Y")?"checked":"" %>/></td>
												<td width="18%" align="right">Other:</td>
												<td width="13%"><input type="radio" name="additionalIdentity" id="additionalIdentity" value="other" onClick="javascript:explainOther(this.value)" <%= eRVINBean.getId_other().equalsIgnoreCase("Y")?"checked":"" %>/></td>
											</tr>
											
											<tr>
												<td colspan="8" style="padding-left:122px">
													<div id="otherExpTr" style="display : <%= eRVINBean.getId_other().equalsIgnoreCase("Y")? "block" : "none" %>">
														<table border="0" cellpadding="0" cellspacing="5" width="100%">
															<tr>
																<td  align="right">Other Explain</td>
																<td  align="center"><b>:</b></td>
																<td  align="left"><input type="text" id="other_descrip" name="other_descrip" size="50"MaxLength="200" value="<%= eRVINBean.getOther_descrip()%>" style="text-transform:uppercase" >
																</td>
															</tr>
														</table>
													</div>
												</td>												
											</tr>											
											
											<tr>
												<td colspan="8">&nbsp;</td>
											</tr>
											<tr>					
												<td colspan="8" style="padding-left:53px; padding-right:53px;"> <hr color="#99FFFF" width="100%"/></td>
											</tr>	
											

											<tr>
												<td colspan="8" style="padding-left : 60px;font-size:10pt"><b>Driver's License and/or Additional Forms   of Identification are not available</b></td>
											</tr>
											<tr>
												<td colspan="8">&nbsp;</td>
											</tr>

											<tr>
												<td colspan="8" style="padding-left : 60px;font-size:10pt"><b>Describe Circumstances : </b></td>
											</tr>
											<tr>
												<td colspan="8" style="padding-left : 60px;">
													<textarea cols="80" rows="4" name="circumstances_descrip" id="circumstances_descrip" readonly  onKeyDown="limitText(this.form.circumstances_descrip,509);" 
													onKeyUp="limitText(this.form.circumstances_descrip,509);"><%= eRVINBean.getCircumstances_descrip() %></textarea></td>
											</tr>
																
										</table>
									</td>
								</tr>
							</table>
							<div class="spacer"></div> <div class="clear"></div>							
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="spacer"></div> <div class="clear"></div>	
		<table align="center" width="100%" border="0" cellspacing="0" cellpadding="0">				
			<tr>
				<td width="20%">&nbsp;</td> 
				<td align="left" valign="top">														
						<input type="button" id="btnBackButton" class="JQueryButton" onClick="javaScript:backScreen();" value="Back">
				</td>
				<td align="center">	
						<input type="button" id="btnSaveButton" class="JQueryButton" onClick="javascript: return saveRecord(this.form);" value="Save">
				</td>
				<td align="right">	
						<input type="button" id="btnNextButton" class="JQueryButton" onClick="javaScript:nextScreen();" value="Next">
				</td>
				<td align="right" width="45%">
						<input type="button" id="btnBackToMenu" class="JQueryButton" onClick="javaScript: return backToMenu(this.form);" value="Abort"></td>												
			</tr>			
		</table>

	</div>    
</div>
</form>

<script>

$(function() {
	$( "#vo_license_exp_date" ).datepicker({
	//	numberOfMonths: 3,
	//	showButtonPanel: true,
		showOtherMonths: true,
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: "../images/calendar3.gif",
		buttonImageOnly: true				
	});
});

	function getVehicleOwnerInfo(selectedVin)
	{
		document.personalIdInfoForm.mode.value="VehicleOwnerInfo";
		document.personalIdInfoForm.selectedVin.value=selectedVin;
		document.personalIdInfoForm.submit();
	}
	
	function saveRecord(formObj)
	{		
		if(validateFrm(formObj)==true)
		{
			document.personalIdInfoForm.mode.value="savePersonalIdInfo";
			document.personalIdInfoForm.submit();
		}
		else
		{
			return false ;
		}		
	}
	
	function backScreen()
	{
		document.personalIdInfoForm.mode.value="backToVehicleOwnerInfo";
		document.personalIdInfoForm.submit();		
	}

	function backToMenu()
	{
		document.personalIdInfoForm.mode.value="backToMenuScreen";
		document.personalIdInfoForm.submit();	
	}
	
	function nextScreen()
	{
		document.personalIdInfoForm.mode.value="vehicleInformation";
		document.personalIdInfoForm.submit();
	}
	
	function validateFrm(formObj)
	{	
		if(!validate(formObj.vo_drivers_license, "Drivers License", RULE_REQUIRED)) 
		{
			return false;
		}
			
		if(!validate(formObj.vo_license_state, "License State", RULE_REQUIRED)) 
		{
			return false;
		}
			
		if(!validate(formObj.vo_license_exp_date, "License Expiration Date", RULE_REQUIRED)) 
		{
			return false;
		}				
		return true ;		
	}
	
	
	
	
	
	function explainOther(value)
	{
		if(value == 'other')
		{
			document.getElementById("otherExpTr").style.display = "block";
		}
		else
		{
			document.getElementById("otherExpTr").style.display = "none";
		}
	}
	
	/*Shrinivas start*/
	
	function showNoIdDiv(fldId)
	{
		if(document.getElementById(fldId).checked == true)
		{
			
			document.getElementById("individual2").style.display = "block";
			document.getElementById('noAdditionl').value = "true" ;
			
		}
		else
		{
			document.getElementById("individual2").style.display = "none";
			document.getElementById('noAdditionl').value = "" ;		
		}	
	}
	
	
	function limitText(limitField, limitNum) 
	{
		if (limitField.value.length > limitNum) 
		{
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
	
		
</script>
            