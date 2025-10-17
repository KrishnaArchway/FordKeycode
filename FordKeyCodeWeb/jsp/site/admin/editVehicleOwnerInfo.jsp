<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility, com.archway.estore.formbean.EditRegistrationVINBean"%>


<%
	EditRegistrationVINBean eRVINBean = (EditRegistrationVINBean)request.getSession().getAttribute("EditRegistrationVINBean");
%>


<form name="editVehicleOwnerInfoForm" action="editRegistration.do" method="post">
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
								<td width="100%"><p class="vinInfoText" align="center"><b>Vehicle Owner Information</b></td>
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
								<BR><BR>
								<tr>
									<td>
										<table align="center" width="100%" border="0">											
											<tr>
												<td width="38%" align="right"><b>This Vehicle is owned by individual</b></td>
												<td width="4%" align="center" ><b>:</b></td>
												<td><input type="radio" name="individualBusinessFleet" id="individualBusinessFleet" value="INDIVIDUAL" <%= eRVINBean.getVo_business_name().trim().length() > 0 ? "" : "checked" %> onClick="javascript:showDiv()"/></td>
											</tr>
											<tr>
												<td align="right"><b>This&nbsp;Vehicle&nbsp;is&nbsp;owned&nbsp;by&nbsp;business/fleet</b></td>
												<td width="" align="center" ><b>:</b></td>
												<td><input type="radio" name="individualBusinessFleet" id="individualBusinessFleet" value="BUSINESSFLEET" <%= eRVINBean.getVo_business_name().trim().length() > 0 ?"checked" : "" %> onClick="javascript:showAllDiv()"/></td>
											</tr>						
										</table>
									</td>
								</tr>
							
								<tr>
									<td width="100%">
										<div id="individual1"  style="display: none">
										<BR><BR>
										<table align="center" width="100%" border="0">
											<tr>												
												<td colspan="3"><b>Vehicle Owner / Representative Name</b></td>
											</tr>
											<tr>
												<td width="20%" align="right">First</td>
												<td width="4%" align="center"><b>:</b></td>
												<td><input type="text" name="vo_first_name" id="vo_first_name" size="30" maxlength="20" value="<%= eRVINBean.getVo_first_name() %>" style="<bean:message key="upperCaseStyle" />"/></td>
											<tr>
												<td align="right">Last</td>
												<td width="" align="center"><b>:</b></td>
												<td><input type="text" name="vo_last_name" id="vo_last_name" size="30" maxlength="40" value="<%= eRVINBean.getVo_last_name() %>" style="<bean:message key="upperCaseStyle" />"/></td>
											</tr>
										</table>
										</div>
										<div id="business" style="display: none">
											<table align="center" width="100%" border="0">
												<tr>
													<td width="20%" align="right">Business/Fleet Name</td>
													<td width="4%" align="center"><b>:</b></td>
													<td><input type="text" name="vo_business_name" id="vo_business_name" size="50" maxlength="50"  value="<%= eRVINBean.getVo_business_name() %>" style="<bean:message key="upperCaseStyle" />"/></td>
												</tr>
											</table>
										</div>
										<div id="individual2"  style="display: none">
										<table align="center" width="100%" border="0">
											<tr>
												<td width="20%" align="right">Address</td>
												<td width="4%" align="center"><b>:</b></td>
												<td><input type="text" name="vo_address" id="vo_address" size="50" maxlength="40" value="<%= eRVINBean.getVo_address() %>" style="<bean:message key="upperCaseStyle" />"/></td>
											</tr>
											<tr>
												<td align="right">City</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_city" id="vo_city" size="40" maxlength="30"  value="<%= eRVINBean.getVo_city() %>" style="<bean:message key="upperCaseStyle" />"/></td>
											</tr>
											<tr>
												<td align="right">State</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_state" id="vo_state" size="5" maxlength="2" value="<%= eRVINBean.getVo_state() %>"  style="<bean:message key="upperCaseStyle" />"/></td>
											</tr>
											<tr>
												<td align="right">Zip</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_zip" id="vo_zip" size="20" maxlength="10" value="<%= eRVINBean.getVo_zip() %>" style="<bean:message key="upperCaseStyle" />" onkeyup="javascript : checkZipInput(this) " /></td>
											</tr>
											<tr>
												<td align="right">Telephone</td>
												<td align="center"><b>:</b></td>
												<td><input type="text" name="vo_phone" id="vo_phone" size="20" maxlength="12" value="<%= eRVINBean.getVo_phone() %>" onkeyup="javascript : checkInput(this)" /></td>
											</tr>
										</table>
										</div>
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
	var ownedBy = "<%= StringUtility.isStringBlank(eRVINBean.getVo_business_name())? "INDIVIDUAL" : "BUSINESSFLEET" %>" ;
	//alert('ownedBy:' + ownedBy);
	setValue(ownedBy);

	function setValue(ownedBy)
	{
		var valueArr = document.getElementsByName("individualBusinessFleet");
		for(i=0;i<valueArr.length;i++)
		{
			if(valueArr[i].value == ownedBy)
			{
				valueArr[i].checked = true ;
	
				if(ownedBy == "INDIVIDUAL")
				{
					//alert('a');					
					showDiv();
				}
				else
				{
					//alert('b1');
					showAllDiv();
				}
				break ;
			}
		}		
	}
	
	function getVehicleOwnerInfo(selectedVin)
	{
		document.editVehicleOwnerInfoForm.mode.value="VehicleOwnerInfo";
		document.editVehicleOwnerInfoForm.selectedVin.value=selectedVin;
		document.editVehicleOwnerInfoForm.submit();
	}
	
	function saveRecord(formObj)
	{
		
		if(validateFrm(formObj)==true)
		{
			document.editVehicleOwnerInfoForm.mode.value="saveVehicleOwnerInfo";
			document.editVehicleOwnerInfoForm.submit();	
		}
		else
		{
			return false ;
		}		
	}
	
	function backScreen()
	{
		document.editVehicleOwnerInfoForm.mode.value="backToEditRegistration";
		document.editVehicleOwnerInfoForm.submit();		
	}

	function backToMenu()
	{
		document.editVehicleOwnerInfoForm.mode.value="backToMenuScreen";
		document.editVehicleOwnerInfoForm.submit();		
	}
	
	function nextScreen()
	{
		document.editVehicleOwnerInfoForm.mode.value="personalIdInformation";
		document.editVehicleOwnerInfoForm.submit();
	}
	
	function validateFrm(formObj)
	{
		if(!validate(formObj.vo_first_name, "First Name", RULE_REQUIRED)) 
		{
			return false;
		}
		
		if(!validate(formObj.vo_last_name, "Last Name", RULE_REQUIRED)) 
		{
			return false;
		}
		
		if(!validate(formObj.vo_address, "Address", RULE_REQUIRED)) 
		{
			return false;
		}
		
		if(!validate(formObj.vo_city, "City", RULE_REQUIRED)) 
		{
			return false;
		}
		
		if(!validate(formObj.vo_state, "State", RULE_REQUIRED)) 
		{
			return false;
		}
		
		if(!validate(formObj.vo_zip, "Zip", RULE_REQUIRED)) 
		{
			return false;
		}
		
		var val = GetSelectedItem(formObj) ;
		if(val=='BUSINESSFLEET')
		{
			if(!validate(formObj.vo_business_name, "Business Name", RULE_REQUIRED)) 
			{
				return false;
			}
		}
		else
		{
			document.editVehicleOwnerInfoForm.vo_business_name.value='';
		}
		return true ;		
	}	
	
	function GetSelectedItem(formObj) 
	{
		var result ="";
		len = formObj.individualBusinessFleet.length;
		//alert(len);
		for (i = 0; i <len; i++) 
		{
			if (formObj.individualBusinessFleet[i].checked==true) 
			{
				result = formObj.individualBusinessFleet[i].value;
			}
		}
		return result;			
	}
	
	function showDiv()
	{		
		//alert('1');
		document.getElementById("individual1").style.display = "block";
		document.getElementById("individual2").style.display = "block";	
		document.getElementById("business").style.display = "none";
	}
	function showAllDiv()
	{		
		//alert('2');
		document.getElementById("individual1").style.display = "block";
		document.getElementById("individual2").style.display = "block";	
		document.getElementById("business").style.display = "block";

	}
	
	function checkInput(ob) 
	{
		var invalidChars = /[^-0-9]/gi
		if(invalidChars.test(ob.value)) 
		{
		      ob.value = ob.value.replace(invalidChars,"");
		}
	}
	
	function checkZipInput(ob) 
	{
		var invalidChars = /[^0-9]/gi
		if(invalidChars.test(ob.value)) 
		{
			ob.value = ob.value.replace(invalidChars,"");
		}
	}
	
</script>
            