<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.util.StringUtility"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>
 
<%
int tabIndex = 1;

	SessionBean 	sb 			= 	(SessionBean) session.getAttribute("SessionBean");	
	VINRegisterBean dealerBean 	= 	(VINRegisterBean)sb.getObjVinRegisterBean();	
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
 
<form name="dealerPage1" method="post" action="dealerRegisterAction.do">
<input type="hidden" name="actionType" id="actionType" value="pageOne" />
<input type="hidden" name="ownershipProofList" id="ownershipProofList" value="" />

<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td width="50%"><bean:message key="dealerPage.label.information"/></td>
 				<td width="50%" align="right">Page 1 of 2</td>
			</tr>
		 </table>
      </div>
       <div class="ui-widget-header-lavender section-header">
       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
       			<tr>
    				<td width="100%"><p class="vinInfoText"><b>VIN : <%=sb.getVin()%></b> &nbsp;&nbsp;
						(Please ensure that this is the correct VIN, if needed click the back button and make corrections)</p> </td>
    			</tr>
				
			</table>
       </div>
       
      <div class="ui-widget-content" style="min-height: 300px">   <br>
      	<table border="0" cellpadding="0" cellspacing="0" width="100%">
      			<tr>
  					<td colspan="3"  style="padding-left : 30px;"><h4><bean:message key="dealerpage1.subheader.label"/></h4></td>  					
				</tr>
			 <tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.make.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<select 
					id="<bean:message key="dealerpage1.vehicle.make.id" />" 
					name="<bean:message key="dealerpage1.vehicle.make.name" />" 
					value="<%= dealerBean.getVehicleMake() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						<bean:message key="dealerpage1.vehicle.make.option" />
					</select>
				</td>
			</tr>	
			 <tr>
			    <td width="18%" align="right"><bean:message key="dealerpage1.vehicle.year.label" /></td>
			    <td width="4%" align="center"><b>:</b></td>
			    <td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.year.type" />" 
					id="<bean:message key="dealerpage1.vehicle.year.id" />" 
					name="<bean:message key="dealerpage1.vehicle.year.name" />" 
					size="<bean:message key="dealerpage1.vehicle.year.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.year.maxLength" />" 
					value="<%= dealerBean.getVehicleYear() %>"
					tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />"
					onkeyup="javascript : checkNumericInput(this)"
					>
			    </td>
			  </tr>
			  
			<tr>
				<td  align="right"><bean:message key="dealerpage1.vehicle.model.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.model.type" />" 
					id="<bean:message key="dealerpage1.vehicle.model.id" />" 
					name="<bean:message key="dealerpage1.vehicle.model.name" />" 
					size="<bean:message key="dealerpage1.vehicle.model.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.model.maxLength" />" 
					value="<%= dealerBean.getVehicleModel() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			<!--<tr>
				<td  align="right"><bean:message key="dealerpage1.vehicle.color.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.color.type" />" 
					id="<bean:message key="dealerpage1.vehicle.color.id" />" 
					name="<bean:message key="dealerpage1.vehicle.color.name" />" 
					size="<bean:message key="dealerpage1.vehicle.color.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.color.maxLength" />" 
					value="<%= dealerBean.getVehiclecolor() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="dealerpage1.vehicle.plateno.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.plateno.type" />" 
					id="<bean:message key="dealerpage1.vehicle.plateno.id" />" 
					name="<bean:message key="dealerpage1.vehicle.plateno.name" />" 
					size="<bean:message key="dealerpage1.vehicle.plateno.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.plateno.maxLength" />" 
					value="<%= dealerBean.getVehiclePlateNo() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="dealerpage1.vehicle.state.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.state.type" />" 
					id="<bean:message key="dealerpage1.vehicle.state.id" />" 
					name="<bean:message key="dealerpage1.vehicle.state.name" />" 
					size="<bean:message key="dealerpage1.vehicle.state.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.state.maxLength" />" 
					value="<%= dealerBean.getVehicleState() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="dealerpage1.vehicle.odometer.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage1.vehicle.odometer.type" />" 
					id="<bean:message key="dealerpage1.vehicle.odometer.id" />" 
					name="<bean:message key="dealerpage1.vehicle.odometer.name" />" 
					size="<bean:message key="dealerpage1.vehicle.odometer.size" />" 
					MaxLength="<bean:message key="dealerpage1.vehicle.odometer.maxLength" />" 
					value="<%= dealerBean.getVehicleOdometer() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" 
					onkeyup="javascript : checkNumericInput(this)">
				</td>
			</tr>-->
			<tr>					
					<td colspan="3" style="padding-left:68px;"> &nbsp; </td>
			</tr>
			<tr>					
					<td colspan="3" style="padding-left:53px;"> <hr color="#99FFFF" width="100%"/></td>
				</tr>
			<tr>
			    <td colspan="3" style="padding-left : 60px;font-size:10pt"><b><bean:message key="dealerpage2.proof.header.label"/></b></td>
			</tr>
			<!--<tr>
			    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.titledOwnership.label"/>&nbsp;			    	
					<input 
						type="<bean:message key="dealerpage2.proof.titledOwnership.type" />" 
						value="<bean:message key="dealerpage2.proof.titledOwnership.value" />" 
						name="<bean:message key="dealerpage2.proof.titledOwnership.name" />"
						id="<bean:message key="dealerpage2.proof.titledOwnership.id" />">
			    </td>
			</tr>-->
			<tr>
			    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.ownershipPossession.label"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			    	
					<input 
						type="<bean:message key="dealerpage2.proof.ownershipPossession.type" />" 
						value="<bean:message key="dealerpage2.proof.ownershipPossession.value" />" 
						name="<bean:message key="dealerpage2.proof.ownershipPossession.name" />"
						id="<bean:message key="dealerpage2.proof.ownershipPossession.id" />">
			    </td>
			</tr>
			<tr>
			    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.agreement.label"/>&nbsp;			    	
					<input 
						type="<bean:message key="dealerpage2.proof.agreement.type" />" 
						value="<bean:message key="dealerpage2.proof.agreement.value" />" 
						name="<bean:message key="dealerpage2.proof.agreement.name" />"
						id="<bean:message key="dealerpage2.proof.agreement.id" />">
			    </td>
			</tr>
			<tr>					
					<td colspan="3" style="padding-left:68px;"> &nbsp; </td>
			</tr>
		</table>        
       </div>
    </div>
    
	    <table border="0" cellpadding="0" cellspacing="0" width="100%">
	  		<tr>
			    <td width="50%" align="center">
			      <p align="center"><div class="buttons ui-widget">
			        <!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form) "><bean:message key="back.to.fmcdealer.com"/></button> -->
			        <input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form) " value="<bean:message key="back.to.fmcdealer.com"/>" />
			      </div>
			    </td>
			    <td width="50%" align="center">
			      <p align="center"><div class="buttons ui-widget">
			      <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
			      <!-- <button id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript: return nextFunction(this.form)"><bean:message key="showHomePage.label.next.button"/></button></div></td> -->
			      <input type="button" id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript: return nextFunction(this.form)" value="<bean:message key="showHomePage.label.next.button"/>" />
			      </div>
			    </td>
	  		</tr>
		</table>               
	</div>
	
</form>

	
<script language="javascript">

var dealerSell = "<%= dealerBean.getDealerSell() %>" ; ;
var dealerTitled = "<%= dealerBean.getDealerTitled() %>" ; ;
var dealerPossess = "<%= dealerBean.getDealerPosses() %>" ; ;

setSessionValues();

function setSessionValues(){
	if(dealerSell != null && dealerSell == "Y"){
		document.getElementById('dealerSell').checked = true ;
	}
	if(dealerTitled != null && dealerTitled == "Y"){
		document.getElementById('dealerTitled').checked = true ;
	}
	if(dealerPossess != null && dealerPossess == "Y"){
		document.getElementById('dealerPosses').checked = true ;
	}
	
}


function nextFunction(formObj)
{
 	if(validateFrm(formObj)==true)
	{
	    document.getElementById('actionType').value = "pageOne" ;
		formObj.submit();

	}else{
		return false ;
	}

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

function validateFrm(formObj)
{
	if(!validate(formObj.<bean:message key="dealerpage1.vehicle.year.id" />, "<bean:message key="dealerpage1.vehicle.year.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="dealerpage1.vehicle.make.id" />, "<bean:message key="dealerpage1.vehicle.make.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="dealerpage1.vehicle.model.id" />, "<bean:message key="dealerpage1.vehicle.model.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
    if(document.getElementById("dealerSell").checked||document.getElementById("dealerPosses").checked)
	{}
	else
	{
	   alert("Please Choose atleast one of the proof of ownership documents - <bean:message key="dealerpage2.proof.ownershipPossession.label" /> or <bean:message key="dealerpage2.proof.agreement.label" />");
	   return false;
	}
		
	document.getElementById('ownershipProofList').value= "";


	return true ;
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