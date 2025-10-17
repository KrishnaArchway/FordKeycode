<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>

<%
	int tabIndex = 1;
	
	SessionBean sb = (SessionBean) session.getAttribute("SessionBean");	
	VINRegisterBean ownerBean = (VINRegisterBean)sb.getObjVinRegisterBean();
	
%>

<div id="dialog" title="VIN Information">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" >
  <tr>
    <td width="100%">
    	<b>VIN : <%= sb.getVin()%></b><br>Please ensure that this is the correct VIN, if needed click the back button and make corrections
      </td>
  </tr>
</table>
 </div>

<form name="ownerPage1" method="post" action="registerAction.do">
<input type="hidden" name="actionType" id="actionType" value="pageOne" />

<div class="ui-widget">
                <div class="ui-widget-header section-header">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  				<tr>
    			<td width="50%"><bean:message key="ownerPage.label.information"/></td>
    			<td width="50%" align="right">Page 1 of 4</td>
  				</tr>
 				</table>
                </div>
                <div class="ui-widget-header-lavender section-header">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  				<tr>
    			<td width="100%"><p class="vinInfoText"><b>VIN : <%=sb.getVin()%></b> &nbsp;&nbsp;
						(Please ensure that this is the correct VIN, if needed click the back button and make corrections)</p></td>
    			</tr>
 				</table>
                </div>
                                 
                <div class="ui-widget-content" style="min-height: 300px">
                <br>
                <br>
                
                
			  <table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
			    <td width="33%" align="right" ><b><bean:message key="ownerPage.label.individual"/></b></td>
			    <td width="4%" align="center" ><b>:</b></td>
			    <td width="63%" align="left">
			    	<input 
						type="<bean:message key="ownerPage.lable.individualBusinessFleet.type" />" 
						value="<bean:message key="ownerPage.lable.individual.value" />" 
						name="<bean:message key="ownerPage.lable.individualBusinessFleet.name" />"
						id="<bean:message key="ownerPage.lable.individualBusinessFleet.id" />" onClick="javascript:showDiv()" >
				</td>
			  </tr>
			   <tr>
			    <td width="33%" align="right"><b><bean:message key="ownerPage.lable.businessfleet"/></b></td>
			    <td width="4%" align="center" ><b>:</b></td>
			    <td width="63%" align="left">
			    	<input 
						type="<bean:message key="ownerPage.lable.individualBusinessFleet.type"/>" 
						value="<bean:message key="ownerPage.lable.businessfleet.value"/>" 
						name="<bean:message key="ownerPage.lable.individualBusinessFleet.name"/>"
						id="<bean:message key="ownerPage.lable.individualBusinessFleet.id"/>"  onClick="javascript:showAllDiv()">
				</td>
			  </tr>
			</table>
                
              
              <div id="individual1"  style="display: none">
			  <br><br>
			  <table border="0" cellpadding="0" cellspacing="0" width="100%">
			    <tr>
			    <td colspan="3" align="left" style="padding-left :50px;"><b><bean:message key="ownerPage.label.dataHeader"/></b></td>
			    
			  </tr>
			  
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			  <tr>
			    <td width="15%" align="right"><bean:message key="ownerPage.lable.first" /></td>
			    <td width="4%" align="center"><b>:</b></td>
			    <td  align="left">	
					<input type="<bean:message key="ownerPage.lable.first.type" />" 
					id="<bean:message key="ownerPage.lable.first.id" />" 
					name="<bean:message key="ownerPage.lable.first.name" />" 
					size="<bean:message key="ownerPage.lable.first.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.first.maxLength" />" 
					value="<%= ownerBean.getFirstName() %>"
					tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />">
			    </td>
			  </tr>
			  <tr>
				<td  align="right"><bean:message key="ownerPage.lable.last" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.last.type" />" 
					id="<bean:message key="ownerPage.lable.last.id" />" 
					name="<bean:message key="ownerPage.lable.last.name" />" 
					size="<bean:message key="ownerPage.lable.last.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.last.maxLength" />" 
					value="<%= ownerBean.getLastName() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			</table>
			  
			  <div id="business">
			  <table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
				<td width="15%" align="right"><bean:message key="ownerPage.lable.businessName" /></td>
				<td width="4%" align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.businessName.type" />" 
					id="<bean:message key="ownerPage.lable.businessName.id" />" 
					name="<bean:message key="ownerPage.lable.businessName.name" />" 
					size="<bean:message key="ownerPage.lable.businessName.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.businessName.maxLength" />" 
					value="<%= ownerBean.getBusinessOrFleetName() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			</table>
			  </div>
			   <div id="individual2">
			    <table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
				<td width="15%" align="right"><bean:message key="ownerPage.lable.address" /></td>
				<td width="4%" align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.address.type" />" 
					id="<bean:message key="ownerPage.lable.address.id" />" 
					name="<bean:message key="ownerPage.lable.address.name" />" 
					size="<bean:message key="ownerPage.lable.address.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.address.maxLength" />" 
					value="<%= ownerBean.getAddress() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			
			<tr>
				<td  align="right"><bean:message key="ownerPage.lable.city" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.city.type" />" 
					id="<bean:message key="ownerPage.lable.city.id" />" 
					name="<bean:message key="ownerPage.lable.city.name" />" 
					size="<bean:message key="ownerPage.lable.city.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.city.maxLength" />" 
					value="<%= ownerBean.getCity() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>	
			
			<tr>
				<td  align="right"><bean:message key="ownerPage.lable.state" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.state.type" />" 
					id="<bean:message key="ownerPage.lable.state.id" />" 
					name="<bean:message key="ownerPage.lable.state.name" />" 
					size="<bean:message key="ownerPage.lable.state.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.state.maxLength" />" 
					value="<%= ownerBean.getState() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
				</td>
			</tr>
			
			<tr>
				<td  align="right"><bean:message key="ownerPage.lable.zip" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.zip.type" />" 
					id="<bean:message key="ownerPage.lable.zip.id" />" 
					name="<bean:message key="ownerPage.lable.zip.name" />" 
					size="<bean:message key="ownerPage.lable.zip.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.zip.maxLength" />" 
					value="<%= ownerBean.getZipcode() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" 
					onkeyup="javascript : checkZipInput(this) ">
				</td>
			</tr>	
			
			<!--tr>
				<td  align="right"><bean:message key="ownerPage.lable.phone" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left">	
					<input type="<bean:message key="ownerPage.lable.phone.type" />" 
					id="<bean:message key="ownerPage.lable.phone.id" />" 
					name="<bean:message key="ownerPage.lable.phone.name" />" 
					size="<bean:message key="ownerPage.lable.phone.size" />" 
					MaxLength="<bean:message key="ownerPage.lable.phone.maxLength" />" 
					value="<%= ownerBean.getPhoneNo() %>"
					tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />"
					onkeyup="javascript : checkInput(this) " >
				</td>
			</tr-->	
            <input type="hidden" 
			name="<bean:message key="ownerPage.lable.phone.name" />" 
			id="<bean:message key="ownerPage.lable.phone.id" />"  
			value="<%= ownerBean.getPhoneNo() %>" />		
			  
			</table>
              
              </div>
              <br><br>
                 
                 
                 
                </div>
            </div>
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr>
		    <td width="50%" align="center">
		      <p align="center">
		      	<div class="buttons ui-widget">
		         	<!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form)"><bean:message key="back.to.fmcdealer.com"/></button>-->
		         	<input 	type="button" 
		         			id="btnFMCDealerButton" 
		         			class="JQueryButton" 
		         			onclick="javascript : goToFMCDealer(this.form)"
		         			value="<bean:message key="back.to.fmcdealer.com"/>" />
		         </div>
		    </td>
		    <td width="50%" align="center">
		      <p align="center">
		      <div class="buttons ui-widget">
		        <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
		      	<!-- <button id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:return nextFunction(this.form)"><bean:message key="showHomePage.label.next.button"/></button>-->
		      	<input 	type="button" 
		      			id="<bean:message key="showHomePage.label.next.button"/>" 
		      			class="JQueryButton" 
		      			onclick="javascript:return nextFunction(this.form)"
		      			value="<bean:message key="showHomePage.label.next.button"/>" />
		      	</div> 
		      </td>
		  </tr>
		</table>
            
               
            </div>
            
            </form>
<script language="javascript">

var ownedBy = "<%= ownerBean.getOwnedBy() %>" ;
retainDiv();
setValue(ownedBy);

function retainDiv(){
	var valueArr = document.getElementsByName("individualBusinessFleet");
	for(i=0;i<valueArr.length;i++){
		if(valueArr[i].checked){
			if(valueArr[i].value == "INDIVIDUAL"){
				showDiv();
			}else{
				showAllDiv();
			}

			break ;
		}
	}	
	
}

function setValue(ownedBy){
	var valueArr = document.getElementsByName("individualBusinessFleet");
	for(i=0;i<valueArr.length;i++){
		if(valueArr[i].value == ownedBy){
			valueArr[i].checked = true ;

			if(ownedBy == "INDIVIDUAL"){
				showDiv();
			}else{
				showAllDiv();
			}

			break ;
		}
	}	
	
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


function validateFrm(formObj)
{
	if(!validate(formObj.<bean:message key="ownerPage.lable.first.id" />, "<bean:message key="ownerPage.lable.first" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage.lable.last.id" />, "<bean:message key="ownerPage.lable.last" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage.lable.address.id" />, "<bean:message key="ownerPage.lable.address" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage.lable.city.id" />, "<bean:message key="ownerPage.lable.city" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage.lable.state.id" />, "<bean:message key="ownerPage.lable.state" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	if(!validate(formObj.<bean:message key="ownerPage.lable.zip.id" />, "<bean:message key="ownerPage.lable.zip" />", RULE_REQUIRED)) 
	{
		return false;
	}
	
	var val = GetSelectedItem(formObj) ;
	if(val=='BUSINESSFLEET')
	{
		if(!validate(formObj.<bean:message key="ownerPage.lable.businessName.id" />, "<bean:message key="ownerPage.lable.businessName" />", RULE_REQUIRED)) 
		{
			return false;
		}
	}
	
return true ;	
	
}


function showDiv()
{
	document.getElementById("individual1").style.display = "block";
	document.getElementById("individual2").style.display = "block";
	document.getElementById("business").style.display = "none";
}
function showAllDiv()
{
	document.getElementById("individual1").style.display = "block";
	document.getElementById("individual2").style.display = "block";
	document.getElementById("business").style.display = "block";
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

function checkZipInput(ob) {
  var invalidChars = /[^0-9]/gi
  if(invalidChars.test(ob.value)) {
            ob.value = ob.value.replace(invalidChars,"");
      }
}
 
 function checkInput(ob) {
  var invalidChars = /[^-0-9]/gi
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
	document.ownerPage1.action='fmcDealer.do';
	document.ownerPage1.submit();
}

</script>            