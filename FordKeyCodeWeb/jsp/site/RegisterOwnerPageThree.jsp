<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.util.StringUtility"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>

 
<%
	int tabIndex = 1;
	SessionBean sb = (SessionBean) session.getAttribute("SessionBean");	
	VINRegisterBean ownerBean = (VINRegisterBean)sb.getObjVinRegisterBean();
	System.out.println("===================== : "+sb.getVin());
%>
<div id="dialog" title="VIN Information">	
  	<table border="0" cellpadding="0" cellspacing="0" width="100%" >
	  <tr>
	    <td width="100%">
	    	<b>VIN : <%=sb.getVin()%></b><br>Please ensure that this is the correct VIN, if needed click the back button and make corrections
	      </td>
	  </tr>
	</table>
</div>

<form name="ownerPage1" method="post" action="registerAction.do">
<input type="hidden" name="actionType" id="actionType" value="pageThree" />

<div class="ui-widget">
                <div class="ui-widget-header section-header">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  				<tr>
    			<td width="50%"><bean:message key="ownerPage.label.information"/></td>
    			<td width="50%" align="right">Page 3 of 4</td>
  				</tr>
 				</table>
                </div>
                   <div class="ui-widget-header-lavender section-header">
			       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			       			<tr>
			    				<td width="100%"><p class="vinInfoText"><b>VIN : <%= sb.getVin()%></b> &nbsp;&nbsp;
									(Please ensure that this is the correct VIN, if needed click the back button and make corrections)</p> </td>
			    			</tr>
							
						</table>
			       </div>
                                 
                <div class="ui-widget-content" style="min-height: 300px">
                <br>
                             
              <div id="individual1"  style="border-color:red; display: block">
			  
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
					  <tr>
		    				<td colspan="3" width="100%" style="padding-left : 30px;"><h4>Vehicle Information</h4></td>
		    		  </tr>
		    		  <tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.make.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<select 
							id="<bean:message key="ownerPage3.vehicle.make.id" />" 
							name="<bean:message key="ownerPage3.vehicle.make.name" />" 
							value="<%= ownerBean.getVehicleMake() %>"
							tabindex="<%=tabIndex++ %>"   style="<bean:message key="upperCaseStyle" />" >
								<bean:message key="ownerPage3.vehicle.make.option" />
							</select>
						</td>
					</tr>
					  <tr>
					    <td width="25%" align="right"><bean:message key="ownerPage3.vehicle.year.label" /></td>
					    <td width="4%" align="center"><b>:</b></td>
					    <td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.year.type" />" 
							id="<bean:message key="ownerPage3.vehicle.year.id" />" 
							name="<bean:message key="ownerPage3.vehicle.year.name" />" 
							size="<bean:message key="ownerPage3.vehicle.year.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.year.maxLength" />" 
							value="<%= ownerBean.getVehicleYear() %>"
							tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />"
							onkeyup="javascript : checkNumericInput(this)"
							>
					    </td>
					  </tr>
					  
					<tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.model.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.model.type" />" 
							id="<bean:message key="ownerPage3.vehicle.model.id" />" 
							name="<bean:message key="ownerPage3.vehicle.model.name" />" 
							size="<bean:message key="ownerPage3.vehicle.model.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.model.maxLength" />" 
							value="<%= ownerBean.getVehicleModel() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						</td>
					</tr>
					<!--<tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.color.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.color.type" />" 
							id="<bean:message key="ownerPage3.vehicle.color.id" />" 
							name="<bean:message key="ownerPage3.vehicle.color.name" />" 
							size="<bean:message key="ownerPage3.vehicle.color.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.color.maxLength" />" 
							value="<%= ownerBean.getVehiclecolor() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						</td>
					</tr>-->
					<tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.plateno.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.plateno.type" />" 
							id="<bean:message key="ownerPage3.vehicle.plateno.id" />" 
							name="<bean:message key="ownerPage3.vehicle.plateno.name" />" 
							size="<bean:message key="ownerPage3.vehicle.plateno.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.plateno.maxLength" />" 
							value="<%= ownerBean.getVehiclePlateNo() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						</td>
					</tr>
					<tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.state.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.state.type" />" 
							id="<bean:message key="ownerPage3.vehicle.state.id" />" 
							name="<bean:message key="ownerPage3.vehicle.state.name" />" 
							size="<bean:message key="ownerPage3.vehicle.state.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.state.maxLength" />" 
							value="<%= ownerBean.getVehicleState() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						</td>
					</tr>
				<!--	<tr>
						<td  align="right"><bean:message key="ownerPage3.vehicle.odometer.label" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage3.vehicle.odometer.type" />" 
							id="<bean:message key="ownerPage3.vehicle.odometer.id" />" 
							name="<bean:message key="ownerPage3.vehicle.odometer.name" />" 
							size="<bean:message key="ownerPage3.vehicle.odometer.size" />" 
							MaxLength="<bean:message key="ownerPage3.vehicle.odometer.maxLength" />" 
							value="<%= ownerBean.getVehicleOdometer() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" 
							onkeyup="javascript : checkNumericInput(this)">
						</td>
					</tr> -->
					<tr>					
							<td colspan="3" style="padding-left:122px;"> &nbsp; </td>
					</tr>
				</table>
			 </div> 
	</div>
            	
			
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr>
		    <td width="50%" align="center">
		      <p align="center"><div class="buttons ui-widget">
		          <!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form)"><bean:message key="back.to.fmcdealer.com"/></button> -->
		          <input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />       
		        </div></td>
		   	 <td width="50%" align="center">
		      <p align="center">
		      <div class="buttons ui-widget">
		      <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
		      <!-- <button id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript: return nextFunction(this.form)"><bean:message key="showHomePage.label.next.button"/></button> -->
		      <input type="button" id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:nextFunction(this.form);" value="<bean:message key="showHomePage.label.next.button"/>" />
		      </div>
		      </td>
		  </tr>
	</table>
            
               
 </form>
 
 
<script language="javascript">




function validateFrm(formObj)
{
	if(!validate(formObj.<bean:message key="ownerPage3.vehicle.year.id" />, "<bean:message key="ownerPage3.vehicle.year.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage3.vehicle.make.id" />, "<bean:message key="ownerPage3.vehicle.make.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage3.vehicle.model.id" />, "<bean:message key="ownerPage3.vehicle.model.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	

	return true ;
}

function checkValidYear(fldObj){
	var year = fldObj.value ;
	
	if(year != null){
		if(year.length < 4){
			alert('Invalid Year, Please Enter Valid Year');
			document.getElementById(fldObj.id).focus();
			document.getElementById(fldObj.id).select();
		}	
	}
}

function nextFunction(formObj)
{
	if(validateFrm(formObj)==true)
	{
		formObj.submit();

	}else{
		return false ;
	}
	
}

function checkNumericInput(ob) {
  var invalidChars = /[^0-9]/gi
  if(invalidChars.test(ob.value)) {
            ob.value = ob.value.replace(invalidChars,"");
      }
}

function goBack()
{
	window.history.go(-1);
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}
</script>            