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
	Integer exceptionCount = request.getAttribute("EXCEPTIONCOUNT")==null ?new Integer(0) :(Integer) (request.getAttribute("EXCEPTIONCOUNT"));
%>


<script>
	


</script>




<div id="dialog" title="VIN Information">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" >
  <tr>
    <td width="100%">
    	<b>VIN : <%=sb.getVin()%></b><br>Please ensure that this is the correct VIN, if needed click the back button and make corrections
      </td>
  </tr>
</table>
 </div>

<form name="ownerPage2" id="ownerPage2" method="post" action="registerAction.do">
<input type="hidden" name="actionType" id="actionType" value="pageTwo" />
<input type="hidden" name="noAdditionl" id="noAdditionl" value="" />
<input type="hidden" name="ownerAgreeTermFalg" id="ownerAgreeTermFalg" value="N" />
<input type="hidden" name="exceptionCount" id="exceptionCount" value="<%=exceptionCount%>" />



<div class="ui-widget">
                <div class="ui-widget-header section-header">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  				<tr>
    			<td width="50%"><bean:message key="ownerPage.label.information"/></td>
    			<td width="50%" align="right">Page 2 of 4</td>
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
                                 
                <div class="ui-widget-content" style="min-height: 300px">
                <br>
                             
              
              <div id="individual1"  style="border-color:red; display: block">
			  
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
					  <tr>
	    				<td colspan="3" style="padding-left : 30px;"><h3>Personal ID Information</h3></td>
	    			  </tr>
					 <!--  <tr>
					    <td width="18%" align="right" style="font-size:10pt"><b><bean:message key="ownerPage2.label.dataHeader"/></b></td>
					    <td width="4%" align="center"><b>:</b></td>
					    <td  align="left">&nbsp;</td>
					  </tr>-->
					  
					  <tr>
					    <td  align="right"><bean:message key="ownerPage2.label.dataHeader"/>&nbsp;<bean:message key="ownerPage2.license.lable.number" /></td>
					    <td  align="center"><b>:</b></td>
					    <td  align="left">	
							<input type="<bean:message key="ownerPage2.license.number.type" />" 
							id="<bean:message key="ownerPage2.license.number.id" />" 
							name="<bean:message key="ownerPage2.license.number.name" />" 
							size="<bean:message key="ownerPage2.license.number.size" />" 
							MaxLength="<bean:message key="ownerPage2.license.number.maxLength" />" 
							value="<%= ownerBean.getLicenseNo() %>"
							tabindex="<%=tabIndex++ %>"  style="<bean:message key="upperCaseStyle" />">
					    </td>
					  </tr>
					  <tr>
						<td  align="right"><bean:message key="ownerPage2.license.lable.state" /></td>
						<td  align="center"><b>:</b></td>
						<td  align="left">	
							<input type="<bean:message key="ownerPage2.license.state.type" />" 
							id="<bean:message key="ownerPage2.license.state.id" />" 
							name="<bean:message key="ownerPage2.license.state.name" />" 
							size="<bean:message key="ownerPage2.license.state.size" />" 
							MaxLength="<bean:message key="ownerPage2.license.state.maxLength" />" 
							value="<%= ownerBean.getLicenseState() %>"
							tabindex="<%=tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
						</td>
					</tr>
					<tr>
						<td  align="right"><bean:message key="ownerPage2.license.lable.expiry" /></td>
						<td  align="center"><b>:</b></td>

						<td  align="left">	
							<input type="<bean:message key="ownerPage2.license.expiry.type" />" 
							id="<bean:message key="ownerPage2.license.expiry.id" />" 
							name="<bean:message key="ownerPage2.license.expiry.name" />" 
							size="<bean:message key="ownerPage2.license.expiry.size" />" 
							MaxLength="<bean:message key="ownerPage2.license.expiry.maxLength" />" 
							value="<%= ownerBean.getLicenseExpiryDate() %>" readonly="readonly" 
							tabindex="<%=tabIndex++ %>" 
							style="<bean:message key="upperCaseStyle" />">&nbsp;
						</td>
						
						
					</tr>
					<tr>					
							<td colspan="3" style="padding-left:122px;"> &nbsp; </td>
					</tr>
				</table>
			 </div> 
			 
			 
			 <div id="div1" style="">
			
			 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			  
				<tr>					
					<td colspan="3" style="padding-left:65px;"> <hr color="#99FFFF" width="100%"/></td>
				</tr>
				<tr>
				    <td colspan="3" style="padding-left : 65px;;font-size:10pt"><b><bean:message key="ownerPage2.label.additional.header"/></b></td>
				</tr>
				
				<tr>
				    <td width="18%" align="right"><b><bean:message key="ownerPage2.label.choose"/></b></td>
				    <td width="4%" align="left"><b>:</b> </td>
				    <td align="left">&nbsp;</td>
				</tr>
				 <tr>
				 	<td  align="right">&nbsp;</td>
					<td  align="right" colspan="2">
						<table border="0" cellpadding="0" cellspacing="5" width="100%">
							<tr>
								<td align="left" width="12%"> <bean:message key="ownerPage2.choose.title.label"/> &nbsp;
									<input 
										type="<bean:message key="ownerPage2.choose.title.type" />" 
										value="<bean:message key="ownerPage2.choose.title.value" />" 
										name="<bean:message key="ownerPage2.choose.title.name" />"
										id="<bean:message key="ownerPage2.choose.title.id" />"
										 onClick="javascript:explainOther(this.value)" >
								</td>						
								<td align="left" width="20%">
									<bean:message key="ownerPage2.choose.register.label"/> &nbsp;
									<input 
										type="<bean:message key="ownerPage2.choose.register.type" />" 
										value="<bean:message key="ownerPage2.choose.register.value" />" 
										name="<bean:message key="ownerPage2.choose.register.name" />"
										id="<bean:message key="ownerPage2.choose.register.id" />"
										 onClick="javascript:explainOther(this.value)" >
								</td>
								<td align="left" width="26%">
									<bean:message key="ownerPage2.choose.certofinsu.label"/> &nbsp;
									<input 
										type="<bean:message key="ownerPage2.choose.certofinsu.type" />" 
										value="<bean:message key="ownerPage2.choose.certofinsu.value" />" 
										name="<bean:message key="ownerPage2.choose.certofinsu.name" />"
										id="<bean:message key="ownerPage2.choose.certofinsu.id" />"
										 onClick="javascript:explainOther(this.value)" >
								</td>
								<td align="left">
									<bean:message key="ownerPage2.choose.other.label"/> &nbsp;
									<input 
										type="<bean:message key="ownerPage2.choose.other.type" />" 
										value="<bean:message key="ownerPage2.choose.other.value" />" 
										name="<bean:message key="ownerPage2.choose.other.name" />"
										id="<bean:message key="ownerPage2.choose.other.id" />"
										onClick="javascript:explainOther(this.value)" >
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="3" style="padding-left:122px">
						<div id="otherExpTr" style="display : none">
							<table border="0" cellpadding="0" cellspacing="5" width="100%">
								<tr>
									<td  align="right">
									<bean:message key="ownerPage2.choose.otherExp.label" /></td>
									<td  align="center"><b>:</b></td>
									<td  align="left">	
										<input type="<bean:message key="ownerPage2.choose.otherExp.type" />" 
										id="<bean:message key="ownerPage2.choose.otherExp.id" />" 
										name="<bean:message key="ownerPage2.choose.otherExp.name" />" 
										size="<bean:message key="ownerPage2.choose.otherExp.size" />" 
										MaxLength="<bean:message key="ownerPage2.choose.otherExp.maxLength" />" 
										value="<%= ownerBean.getOtherExplain() %>"
										tabindex="<%= tabIndex++ %>"    style="<bean:message key="upperCaseStyle" />" >
									</td>
								</tr>
							</table>
						</div>
					</td>
					
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>					
						<td colspan="3" style="padding-left:63px;"> <hr color="#99FFFF" width="100%"/></td>
				</tr>
			</table>
			</div>
<!-- Shrinivas Start -->	

			<div id="exceptionLimit">
				<table border="0" cellpadding="0" cellspacing="5" width="100%">
					
					<tr>
					    <td width="33%" style="padding-left : 65px;">
						<b><bean:message key="ownerPage2.exceptionRequests1.label"/>
						</td>
						<td style="color:red">
						<b> <%=exceptionCount%>
						<b><bean:message key="ownerPage2.exceptionRequests2.label"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">  &nbsp;</td>
					</tr>
				</table>			
			</div>	
			
			<div id="exceptionLimitReached" style="color:red";>
				<table border="0" cellpadding="0" cellspacing="5" width="100%">
					<tr>
					    <td colspan="3" style="padding-left : 65px;">
						<b><bean:message key="ownerPage2.exceptionRequestslimit.label"/>
						</td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>			
			</div>	

				
			<div id="div2">
				<table border="0" cellpadding="0" cellspacing="5" width="100%">
					
					<tr>
					    <td colspan="3" style="padding-left : 65px;"><b><bean:message key="ownerPage2.noaddinfo.label"/><a href="#" id="exceptionlink"><bean:message key="ownerPage2.noaddinfo.labelexcep"/></b></a>&nbsp;
					    	
								<input 
									type="<bean:message key="ownerPage2.noaddinfo.check.type" />" 
									value="<bean:message key="ownerPage2.noaddinfo.check.value" />" 
									name="<bean:message key="ownerPage2.noaddinfo.check.name" />"
									id="<bean:message key="ownerPage2.noaddinfo.check.id" />" >
					    </td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>			
			</div>
			
			
<!-- Shrinivas Ends -->			
			
			
			<div id="individual2"   style="border-color:red; display: none">
			    <table border="0" cellpadding="0" cellspacing="5" width="100%">
				   <!--  <tr>
					    <td colspan="3" style="padding-left : 150px;"><b> << Ford Client Provided Message will appear here >> </b></td>
					</tr>-->
					<tr>
					    <td colspan="3" >&nbsp;</td>
					</tr>
					<!-- <tr>
						<td colspan="3" style="padding-left:63px;"><b><bean:message key="ownerPage2.cirsumstances.header"/></b></td>
					</tr>
					<tr>
					    <td colspan="3" style="padding-left:63px;"><b><bean:message key="ownerPage2.label.choose"/></b></td>
					</tr>										
			  		<tr>
						<td  align="right">&nbsp;</td>
						<td  align="right" colspan="2">
							<table border="0" cellpadding="0" cellspacing="5" width="100%">
								<tr>
									<td > <bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>						
									<td >
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td >
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td>
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td>
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td>
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td>
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
									<td>
										<bean:message key="ownerPage2.cirsumstances.tbd.label"/> &nbsp;
										<input 
											type="<bean:message key="ownerPage2.cirsumstances.tbd.type" />" 
											value="<bean:message key="ownerPage2.cirsumstances.tbd.value" />" 
											name="<bean:message key="ownerPage2.cirsumstances.tbd.name" />"
											id="<bean:message key="ownerPage2.cirsumstances.tbd.id" />"
											 onClick="" >
									</td>
								</tr>
							</table>
						</td>
					</tr>	-->									
					 <tr>
						<td  align="right" valign="top"><b><bean:message key="ownerPage2.cirsumstances.describe.label" /></b></td>
						<td  align="center" valign="top"><b>:</b></td>
						<td  align="left">	
							<textarea maxlength="<bean:message key="ownerPage2.cirsumstances.describe.size" />" onKeyDown="limitText(this.form.describeCircumstances,this.form.countdown,<bean:message key="ownerPage2.cirsumstances.describe.size" />);"  onKeyUp="limitText(this.form.describeCircumstances,this.form.countdown,<bean:message key="ownerPage2.cirsumstances.describe.size" />); rows="3" cols="60" class="" id="<bean:message key="ownerPage2.cirsumstances.describe.id" />" name="<bean:message key="ownerPage2.cirsumstances.describe.name" />" ><%= ownerBean.getDescribeCircumstances() %></textarea>	
							<br><font size="1">(Maximum characters: <bean:message key="ownerPage2.cirsumstances.describe.size" />)<input  type="hidden" id="countdown" name="countdown" size="3" value="<bean:message key="ownerPage2.cirsumstances.describe.size" />"> </font>
						</td>
					</tr>
<!--
				<tr>
						<td  align="right" valign="top"><b><bean:message key="ownerPage2.cirsumstances.describe.terms" /></b></td>
						<td  align="center" valign="top"><b>:</b></td>
						<td  align="left">	
							<input 
									type="<bean:message key="ownerPage2.cirsumstances.describe.terms.type" />" 
									value="" 
									name="<bean:message key="ownerPage2.cirsumstances.describe.terms.name" />"
									id="<bean:message key="ownerPage2.cirsumstances.describe.terms.id" />"  >
						</td>
					</tr>
-->					
					<tr>
					    
						<td  align="left" valign="top" colspan="3">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input 
									type="<bean:message key="ownerPage2.cirsumstances.describe.terms.type" />" 
									value="agreeTermsFlag1" 
									name="agreeTermsFlag1" 
									id="agreeTermsFlag1"  > &nbsp;
						<b><bean:message key="ownerPage2.cirsumstances.describe.terms1" /></b></td>
						<td  align="center" valign="top">&nbsp;</td>
						
					</tr>
					
					<tr>
					    
						<td  align="left" valign="top" colspan="3">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input 
									type="<bean:message key="ownerPage2.cirsumstances.describe.terms.type" />" 
									value="agreeTermsFlag2" 
									name="agreeTermsFlag2"
									id="agreeTermsFlag2"  > &nbsp;
						<b><bean:message key="ownerPage2.cirsumstances.describe.terms2" /></b></td>
						<td  align="center" valign="top">&nbsp;</td>
						
					</tr>
					
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
          <!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form);"><bean:message key="back.to.fmcdealer.com"/></button> -->
          <input	type="button" 
          			id="btnSampleButton" 
          			class="JQueryButton" 
          			onclick="javascript : goToFMCDealer(this.form);"
          			value="<bean:message key="back.to.fmcdealer.com"/>" />
        </div>
    </td>
    <td width="50%" align="center">
      <p align="center">
      <div class="buttons ui-widget">
      	<input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>
		<!-- <button id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:  return nextFunction(this.form)"><bean:message key="showHomePage.label.next.button"/></button></div> -->
      	<input type="button" id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript: return nextFunction(this.form)" value="<bean:message key="showHomePage.label.next.button"/>" />
      </div>
      </td>
  </tr>
</table>
            
</div>            
         
<div id="mainModelDiv" >
	<div id="firstDiv" style="text-align:justify;" title="1 of 5">
		 <p class="validateTips">
		 	<bean:message key="term.label.first"/>   
		 	<a href="#" id="showInnerDiv"><bean:message key="term.label.link"/></a>
		 </p>
	</div> 
	
	<div id="SecondDiv" style="text-align:justify;" title="2 of 5">  
	 	<center><b><bean:message key="term.label.second_1"/></b></center>
	 	<br>
	 	<center><b><bean:message key="term.label.second_2"/></b></center>
		<br>
		<bean:message key="term.label.second_3"/>
		<br><br>
	 	<center><a href="#" class="JQueryButton" id="Third" ><bean:message key="term.label.button.continue"/></a></center>
	</div>
  
   <div id="ThirdDiv" style="text-align:justify;" title="3 of 5">  
  	<bean:message key="term.label.third_1"/>
  	<br><br>  
  	<bean:message key="term.label.third_2"/>
	<br><br>
	<center><a href="#" class="JQueryButton" id="Fourth" ><bean:message key="term.label.button.continue"/></a></center>
  </div>
  
  <div id="FourthDiv" style="text-align:justify;" title="4 of 5">  
  	<bean:message key="term.label.fourth"/>
  	<br><br>
	<center><a href="#" class="JQueryButton" id="Term" ><bean:message key="term.label.button.terAgreement"/></a></center>
  </div>
   <div id="TermDiv" style="text-align:justify;" title="5 of 5">  
   <p>
	  	<b>
	  		<center><bean:message key="term.label.agrement_1"/></center>
	  		<br><br>
			<bean:message key="term.label.agrement_2"/>			
			<br>
			<bean:message key="term.label.agrement_3"/>			
			<br>
		</b>
		<br><br>
		<center>
			<a href="#" class="JQueryButton" id="TermAccept" ><bean:message key="term.label.button.accept"/></a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" class="JQueryButton" id="TermDecline" ><bean:message key="term.label.button.decline"/></a>
		</center>
	</p>
  </div>
</div> 

 <div id="MainModelExceptionDiv">
	<div id="TermDivException">  
    <p>
	        <b><bean:message key="term.label.exceptionhead"/></b>
	  		<br><br>
			<bean:message key="term.label.exception1"/>			
			<br>
			<bean:message key="term.label.exception2"/>				
			<br>
			<bean:message key="term.label.exception3"/>				
			<br>
			<bean:message key="term.label.exception4"/>				
			<br>
		
		<br><br>
					<a href="#" class="JQueryButton" id="ExcepContinue" ><bean:message key="term.label.button.continue"/></a>
	</p>
   </div>  
 </div>  

 </form>
             
<script language="javascript">

	var additionalId = "<%= ownerBean.getAdditionalIdentity() %>";
	var noAdditionalId = "<%= ownerBean.getNoAdditionalIdentity() %>" ;
	var circumstances = "<%= ownerBean.getAddtionalCircumstances() %>" ;
    var ownedBy = "<%= ownerBean.getOwnedBy() %>" ;
	//alert(additionalId);
	
	setSessionValues(additionalId,noAdditionalId,circumstances);
	allowException();


	$(function() {
				$( "#licenseExpiry" ).datepicker({
				//	numberOfMonths: 3,
				//	showButtonPanel: true,
					showOtherMonths: true,
					changeMonth: true,
					changeYear: true,
					showOn: "button",
					buttonImage: "../images/calendar3.gif",
					buttonImageOnly: true				
				});
				
				 $( "#MainModelExceptionDiv" ).dialog({
					  autoOpen: false,
				      autoHeight: true,
				      width: 600,
				      modal: true,
					  closeOnEscape: false,
	   				  open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); }	
					  });
					  
				 $('#exceptionlink').click(function () {
					    $( "#MainModelExceptionDiv" ).dialog( "open" );
	    				$( "#TermDivException" ).show();
					   }); 
					   
				 $('#ExcepContinue').click(function () {
	    				$( "#MainModelExceptionDiv" ).dialog( "close" );	 	    				
        				//$( "#individual2" ).show();				
				      });  					   
				
				$('#noAdditionalID').click(function () {
					if($(this).is(':checked'))
					{
	    				/*$( "#mainModelDiv" ).dialog( "open" );
	    				$( "#firstDiv" ).show();
	    				$( "#mainModelDiv" ).dialog( "option", "title", "1 of 5");
	    				$( "#SecondDiv" ).hide();
	    				$( "#ThirdDiv" ).hide();
	    				$( "#FourthDiv" ).hide();
	    				$( "#TermDiv" ).hide();*/
	    				$( "#individual2" ).show();	
						$( "#noAdditionl" ).val('true');
	    			}
	    			else
	    			{
	    				$( "#individual2").hide();
	    				$( "#noAdditionl" ).val('');
	    			}
	    				
				});
				$('#Third').click(function () {
	    				$( "#SecondDiv" ).hide();
	    				$( "#ThirdDiv" ).show();
	    				$( "#mainModelDiv" ).dialog( "option", "title", "3 of 5");
	    				
				});
				$('#Fourth').click(function () {
	    				$( "#ThirdDiv" ).hide();
	    				$( "#FourthDiv" ).show();
	    				$( "#mainModelDiv" ).dialog( "option", "title", "4 of 5");
	    				
				});
				$('#Term').click(function () {
	    				$( "#FourthDiv" ).hide();
	    				$( "#TermDiv" ).show();
	    				$( "#mainModelDiv" ).dialog( "option", "title", "5 of 5");
	    				
				});
				$('#TermAccept').click(function () {
	    				$( "#mainModelDiv" ).dialog( "close" );
	    				$( "#individual2" ).show();
	    				$( "#noAdditionl" ).val('true');
				});
							
				$('#TermDecline').click(function () {
	    				$( "#mainModelDiv" ).dialog( "close" );	 	    				
        				$('#noAdditionalID').prop('checked', false);	    				
	    				goToFMCDealer(document.getElementById("ownerPage2")); 				
				});
				
				$('#showInnerDiv').click(function () {    				
	    				$( "#firstDiv" ).hide();
	    				$( "#SecondDiv" ).show();
	    				$( "#mainModelDiv" ).dialog( "option", "title", "2 of 5");
	    				
				});
				
				$( "#mainModelDiv" ).dialog({
					  autoOpen: false,
				      autoHeight: true,
				      width: 600,
				      modal: true,
					  closeOnEscape: false,
	   				  open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); }	
				            
	    		});   		
	    		
				
			});
	
	function allowException()
	{
		// if limit of 3 reached don't allow new exception
		//alert(document.getElementById("exceptionCount").value);
		if (document.getElementById("exceptionCount").value>=3)
		{
		   document.getElementById("div2").style.display = "none"
		   document.getElementById("exceptionLimit").style.display = "block";
		}else
		{
		  document.getElementById("div2").display = "block"
		  document.getElementById("exceptionLimitReached").style.display = "none";
		}
	}
	
	function setSessionValues(additionalId,noAdditionalId,circumstances)
	{
	    //alert(additionalId);
		if(additionalId != null && additionalId != "")
		{
			var addIds = document.getElementsByName("additionalID");
			var isAddInfo = false ;
			for(i=0;i<addIds.length;i++){
				if(additionalId.toLowerCase() == addIds[i].value){
					addIds[i].checked = true ;
					explainOther(addIds[i].value);
					break ;
				}
			}
			
		}
		
		if(noAdditionalId != null && noAdditionalId != ""){
		    document.getElementById('noAdditionalID').checked = true ;
			document.getElementById("individual2").style.display = "block";
			document.getElementById('noAdditionl').value = "true" ;
			document.getElementById('agreeTermsFlag1').checked = true ;
			document.getElementById('agreeTermsFlag2').checked = true ;
		}
		
		/*if(circumstances != null && circumstances != ""){
			var circum=document.getElementsByName("circumstances");		
			
			for(i=0;i<circum.length;i++){
				if(circum[i].value == circumstances){
					circum[i].checked = true ;
					break ;
				}
			}
		}*/
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
	
	function validateFrm(formObj)
	{
		
		/*var agreeTermCheck = document.getElementById('<bean:message key="ownerPage2.cirsumstances.describe.terms.id" />').checked;
		if(agreeTermCheck)
			document.getElementById("ownerAgreeTermFalg").value="Y";*/
	
	var agreeTermCheck1 = document.getElementById('agreeTermsFlag1').checked;
	
	var agreeTermCheck2 = document.getElementById('agreeTermsFlag2').checked;
					
		var noAddInfoCheck = document.getElementById('<bean:message key="ownerPage2.noaddinfo.check.id" />').checked;
		if(!noAddInfoCheck)
		{
			var x=document.getElementsByName("additionalID");
			var isAddInfo = false ;
			for(i=0;i<x.length;i++)
			{
				if(x[i].checked == true)
				{
					isAddInfo = true ;
					break ;
				}
			}
	
			if(!validate(formObj.<bean:message key="ownerPage2.license.number.id" />, "<bean:message key="ownerPage2.label.dataHeader" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="ownerPage2.license.state.id" />, "<bean:message key="ownerPage2.license.lable.state" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="ownerPage2.license.expiry.id" />, "<bean:message key="ownerPage2.license.lable.expiry" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="ownerPage2.choose.title.id" />, "<bean:message key="ownerPage2.label.choose" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			
			if(!isAddInfo){
				return false;
			}
				
			return true ;	
		
		}	
		else
		{
	
			/*var circum=document.getElementsByName("circumstances");
			
			var isChecked = false ;
			for(i=0;i<circum.length;i++){
				if(circum[i].checked == true){
					isChecked = true ;
					break ;
				}
			}
			
			if(!isChecked){
				alert('Choose at lease one Circumstances');
				return false;
			}
			*/
			
			if(!validate(formObj.<bean:message key="ownerPage2.cirsumstances.describe.id" />, "<bean:message key="ownerPage2.cirsumstances.describe.label" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			/*if(!agreeTermCheck)
			{
				alert('Please check <bean:message key="ownerPage2.cirsumstances.describe.terms" />');
				return false;
			}*/
			
			if(!agreeTermCheck1)
			{
				alert('Please check <bean:message key="ownerPage2.cirsumstances.describe.terms1" />');
				return false;
			}
			
			if(!agreeTermCheck2)
			{
				alert('Please check <bean:message key="ownerPage2.cirsumstances.describe.terms2" />');
				return false;
			}
	
		return true ;	
		}
	
	
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
	
	function explainOther(value){
		
		if(value == 'other'){
			document.getElementById("otherExpTr").style.display = "block";
		}else{
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
	
	
	function setDisable(){
		
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
	
	
	
	function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}

</script>            