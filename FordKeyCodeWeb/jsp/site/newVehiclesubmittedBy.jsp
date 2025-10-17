<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.util.StringUtility"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>

<%
int tabIndex = 1;
String vinNum = (String)request.getAttribute("vinNum");
//out.println("vinNum :"+vinNum);
String dealerVehicleYear = (String)request.getAttribute("dealerVehicleYear");
String dealerVehicleMake = (String)request.getAttribute("dealerVehicleMake");
String dealerVehicleModel = (String)request.getAttribute("dealerVehicleModel");
String dealerVehicleInfo = (String)request.getAttribute("dealerVehicleInfo");
String agreementCheck = (String)request.getAttribute("agreementCheck");
SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
	
%>
          

<form name="newVehiclesubmittedBy" method="post" action="vinNewVehicle.do">
<input type="hidden" name="vinNum"  id="vinNum" value="<%=vinNum %>">
<input type="hidden" name="dealerVehicleYear"  id="dealerVehicleYear" value="<%=dealerVehicleYear %>">
<input type="hidden" name="dealerVehicleMake"  id="dealerVehicleMake" value="<%=dealerVehicleMake %>">
<input type="hidden" name="dealerVehicleModel"  id="dealerVehicleModel" value="<%=dealerVehicleModel %>">
<input type="hidden" name="dealerVehicleInfo"  id="dealerVehicleInfo" value="<%=dealerVehicleInfo %>">
<input type="hidden" name="agreementCheck"  id="agreementCheck" value="<%=agreementCheck %>">


<input type="hidden" name="actionType"  id="actionType" value="validateData">


<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td width="50%">New Vehicle submitted by</td>
 				<td width="50%" align="right">
 					
 				</td>
			</tr>
		 </table>
      </div>
      <div class="ui-widget-header-lavender section-header">
       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
       			<tr>
    				<td width="100%"><p class="vinInfoText"><b>VIN : <%=vinNum%></b> &nbsp;&nbsp;
						(Please ensure that this is the correct VIN, if needed click the back button and make corrections)</p> </td>
    			</tr>
				
			</table>
       </div>
       
      <div class="ui-widget-content" style="min-height: 300px">   <br>
      	<table border="0" cellpadding="0" cellspacing="0" width="100%">
      			<tr>
  					<td colspan="3"  style="padding-left : 30px;"><h4>New Vehicle Record Submitted By</h4></td>  					
				</tr>
			 <tr>
			    <td width="25%" align="right">Name : &nbsp;	<bean:message key="dealerpage2.verified.first.label" /></td>
			    <td width="4%" align="center"><b>:</b></td>
			    <td  align="left">
					<input type="<bean:message key="dealerpage2.verified.first.type" />" 
					id="<bean:message key="dealerpage2.verified.first.id" />" 
					name="<bean:message key="dealerpage2.verified.first.name" />" 
					size="<bean:message key="dealerpage2.verified.first.size" />" 
					MaxLength="<bean:message key="dealerpage2.verified.first.maxLength" />" 
					value=""
					tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />">
			    </td>
			  </tr>
			  <tr>
				<td  align="right"><bean:message key="dealerpage2.verified.last.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="dealerpage2.verified.last.type" />" 
					id="<bean:message key="dealerpage2.verified.last.id" />" 
					name="<bean:message key="dealerpage2.verified.last.name" />" 
					size="<bean:message key="dealerpage2.verified.last.size" />" 
					MaxLength="<bean:message key="dealerpage2.verified.last.maxLength" />" 
					value=""
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			
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
			     </div>
			    </td>           
			    <td width="50%" align="center">
			      <p align="center"><div class="buttons ui-widget">
			      <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
			      <input type="button" id="<bean:message key="showHomePage.label.next.button"/>" 
			      		 class="JQueryButton" 
			      		 onclick="javascript: return nextFunction(this.form)" 
			      		 value="<bean:message key="showHomePage.label.next.button"/>">
			    </td>
	  		</tr>
		</table>               
	
	
</form>
	
<script language="javascript">
var submittedBy = "";


function goBack()
{
	window.history.go(-1);
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}

function nextFunction(formObj)
{
	
	formObj.submit();

}

function validateFrm(formObj)
{
	if(!validate(formObj.<bean:message key="dealerpage2.verified.first.id"/>, "<bean:message key="dealerpage2.verified.first.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="dealerpage2.verified.last.id" />, "<bean:message key="dealerpage2.verified.last.label" />", RULE_REQUIRED)) 
	{
		return false;
	}
	

	return true ;
}

</script>            