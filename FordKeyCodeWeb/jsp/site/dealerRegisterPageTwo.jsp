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
	String submittedBy = (String)sb.getRegisteredVehicleToWhom();
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

<form name="dealerPage2" method="post" action="">
<input type="hidden" name="actionType" id="actionType" value="pageTwo" />

<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td width="50%"><bean:message key="dealerPage.label.information"/></td>
 				<td width="50%" align="right">
 					<% if(submittedBy.equalsIgnoreCase("OWNER")){ %>
 						Page 4 of 4
 					<%}else { %>
 						Page 2 of 2
 					<%} %>
 				</td>
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
  					<td colspan="3"  style="padding-left : 30px;"><h4><bean:message key="dealerpage2.subheader.label"/></h4></td>  					
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
					value="<%= ownerBean.getSubmitFirstName() %>"
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
					value="<%= ownerBean.getSubmitLastName() %>"
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
var submittedBy = "<%= submittedBy %>";


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
	
	if(validateFrm(formObj)==true)
	{
		if(submittedBy == "OWNER"){
			formObj.action = "registerAction.do" ;
			document.getElementById('actionType').value = "pageFour" ;
		}else{
			formObj.action = "dealerRegisterAction.do" ;
			document.getElementById('actionType').value = "pageTwo" ;
		}
		
		formObj.submit();

	}else{
		return false ;
	}

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