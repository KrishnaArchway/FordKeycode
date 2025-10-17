<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.util.StringUtility"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%> 

<%
	int tabIndex = 1;	
	SessionBean sb 				= 	(SessionBean) session.getAttribute("SessionBean");
	String 		submittedBy 	= 	(String)sb.getRegisteredVehicleToWhom();
	VINRegisterBean infoBean	=	(VINRegisterBean)sb.getObjVinRegisterBean();
%>

<form name="confirmPage" method="post" action="">
	<input type="hidden" name="actionType" id="actionType" value="pageTwo" />

	<div class="ui-widget">
        <div class="ui-widget-header-lavender section-header">
       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
       			<tr>
    				<td width="100%"><p class="vinInfoText"><b>VIN : <%=sb.getVin()%></b> &nbsp;&nbsp;
						(Please ensure that this is the correct VIN, if needed click the back button and make corrections)</p> </td>
    			</tr>
				
			</table>
       </div>
      	<div class="ui-widget-content">      	
      	<br>
      		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
     	 		<tr>
		    		<td colspan="3" align="left" style="padding-left :50px;"><b>Please confirm information below.</b></td>
		 		</tr>
			</table>
	  	</div>	
	  	<div class="ui-widget-content" style="min-height: 300px">   
	  	<table border="0" cellpadding="0" cellspacing="0" width="90%" height="15px">
				  <tr>
				    <td width="100%" align="center">		      
				      <div class="buttons ui-widget">			          
					  <b><font color="#FF0000">Please Note</font>:</b> <b> This record has NOT as yet been entered</b>.  Make sure that you select the "SUBMIT" button below to enter this information.  You will obtain a confirmation notice once the data has been recorded.
				      </div>
				    </td>			  
				  </tr>
				 
				 
				  <tr>
				    <td width="50%" align="right">		      
				      <div class="buttons ui-widget">			          
					  <input type="button" class="JQueryButton" value="Print for your records" onclick="window.print()" />
					  <br><font color="#FF0000">Record NOT submitted.<br>
					See note above.</font>
				      </div>
				    </td>			  
				  </tr>
		</table>
	  	<br>   
	  	
	  	<%
	  		if(submittedBy.equalsIgnoreCase("OWNER"))
	  		{
	  	%>	     
		      
		      	<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">		      	
		     	 <tr>
				    <td colspan="3" align="left" style="padding-left :0px;"><b>
				    	<%
				    		if(infoBean.getOwnedBy().equalsIgnoreCase("BUSINESSFLEET"))
				    		{
				    	%>
				    			<bean:message key="ownerPage.lable.businessfleet" />
				    	<%
				    		}
				    		else
				    		{
				    	%>
				    			<bean:message key="ownerPage.label.individual" />
				    	<%		
				    		}
				    	%>		
				    </b>
				    </td>
				 </tr>
				 <tr>
					<td>&nbsp;</td>
				 </tr>
				 <tr>
				    <td colspan="3" align="center" style="padding-left :0px;"><b><bean:message key="ownerPage.label.dataHeader"/></b></td>			    
				 </tr>
				 <tr>
					<td>&nbsp;</td>
				 </tr>
				 
				 <tr>
				    <td width="50%" align="right">P &amp; A Code</td>
				    <td width="4%" align="center"><b>:</b></td>
				    <td  align="left"><%= sb.getPacode()%></td>			    
				</tr>
				 
				 <tr>
				    <td width="50%" align="right"><bean:message key="ownerPage.lable.first" /></td>
				    <td width="4%" align="center"><b>:</b></td>
				    <td  align="left"><%= infoBean.getFirstName()%></td>			    
				</tr>
				<tr>
					<td  align="right"><bean:message key="ownerPage.lable.last" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getLastName()%></td>
				</tr>
				<%
		    		if(infoBean.getOwnedBy().equalsIgnoreCase("BUSINESSFLEET"))
		    		{
		    	%>
			    	<tr>
						<td width="50%" align="right"><bean:message key="ownerPage.lable.businessName" /></td>
						<td width="4%" align="center"><b>:</b></td>
						<td  align="left"><%= infoBean.getBusinessOrFleetName()%></td>
					</tr>
		    	<%
		    		}
		    	%>					
				<tr>
					<td width="50%" align="right"><bean:message key="ownerPage.lable.address" /></td>
					<td width="4%" align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getAddress()%></td>
				</tr>			
				<tr>
					<td  align="right"><bean:message key="ownerPage.lable.city" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getCity()%></td>
				</tr>
				<tr>
					<td  align="right"><bean:message key="ownerPage.lable.state" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getState()%></td>
				</tr>
				<tr>
					<td  align="right"><bean:message key="ownerPage.lable.zip" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getZipcode()%></td>
				</tr>
				<!--<tr>
					<td  align="right"><bean:message key="ownerPage.lable.phone" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%= infoBean.getPhoneNo()%></td>
				</tr>-->
				
			</table>  
			<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center"> 
				<tr>					
					<td colspan="3"> <hr color="gray" width="90%"/></td>
				</tr>     
			</table>	
			
			
			
				
				<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
				  <tr>
		  				<td colspan="3"  align="center" style="padding-left : 0px;"><h3>Personal ID Information</h3></td>
		  		  </tr>
				  <tr>
				    <td width="50%" align="right" style="font-size:10pt" nowrap><bean:message key="ownerPage2.label.dataHeader"/></td>
				    <td width="4%" align="center"><b>:</b></td>
				    <td  align="left"><%= infoBean.getLicenseNo() %></td>
				  </tr>
				 <!--  <tr>
				    <td  align="right" nowrap><bean:message key="ownerPage2.license.lable.number" /></td>
				    <td  align="center"><b>:</b></td>
				    <td  align="left"><%= infoBean.getLicenseNo() %></td>
				  </tr>-->
				  <tr>
					<td  align="right" nowrap><bean:message key="ownerPage2.license.lable.state" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%=infoBean.getLicenseState()%>	</td>
				</tr>
				<tr>
					<td  align="right" nowrap><bean:message key="ownerPage2.license.lable.expiry" /></td>
					<td  align="center"><b>:</b></td>
					<td  align="left"><%=infoBean.getLicenseExpiryDate() %>	</td>
				</tr>
				<tr>					
					<td colspan="3" style="padding-left:0px;"> &nbsp;</td>
				</tr>
				<!-- <tr>					
					<td colspan="3" style="padding-left:0px;"> <hr color="#99FFFF" width="90%"/></td>
				</tr>-->
				<!-- <tr>
				    <td colspan="3" style="padding-left : 0px;;font-size:10pt"><b><bean:message key="ownerPage2.label.additional.header"/></b></td>
				</tr>-->
				<tr>
				    <td width="18%" align="right" valign="top"><b><bean:message key="ownerPage2.label.additional.header"/>&nbsp;<bean:message key="ownerPage2.label.choose"/></b></td>
				    <td width="4%" align="center" valign="top"> <b>:</b> </td>
				    <td align="left" valign="top">
				    
				    	<% 
				    		if(infoBean.getAdditionalIdentity().equalsIgnoreCase("title"))
				    		{
				    	%>
				    			<bean:message key="ownerPage2.choose.title.label"/>
				    	<% 
				    		}
				    		else if(infoBean.getAdditionalIdentity().equalsIgnoreCase("registration"))
				    		{
				    			
				    	%>
				    			<bean:message key="ownerPage2.choose.register.label"/>
				    	<%
				    		}
				    		else if(infoBean.getAdditionalIdentity().equalsIgnoreCase("insurance"))
				    		{			    		
				    					    	
				    	%>
				    			<bean:message key="ownerPage2.choose.certofinsu.label"/>
				    	<%
				    		}
				    		else
				    		{			    		
				    		
				    	%>
				    			<%= infoBean.getOtherExplain() %>
				    	<%
				    		}
				    	%>
				    	
				    </td>
				</tr>
				<% 
				   if(infoBean.getNoAdditionalIdentity().equalsIgnoreCase("true"))
				   {
				%>
				<tr>
				<td colspan="3">&nbsp;</td>
				</tr>
						<!-- <tr>
						    <td colspan="3" style="padding-left : 0px;"><b><bean:message key="ownerPage2.noaddinfo.label"/></b>&nbsp;True </td>
						</tr>-->
						
						<tr>
							<td  align="right" valign="top"><b><bean:message key="ownerPage2.noaddinfo.label"/><bean:message key="ownerPage2.noaddinfo.labelexcep"/></b></td>
							<td  align="center" valign="top"><b>:</b></td>
							<td  align="left" valign="top"><b><font color="#FF0000">True</font></b></td>
						</tr>	
						
						<tr>
				<td colspan="3">&nbsp;</td>
				</tr><tr>
							<td  align="right" valign="top"><b><bean:message key="ownerPage2.cirsumstances.describe.label" /></b></td>
							<td  align="center" valign="top"><b>:</b></td>
							<td  align="left" valign="top"><%=infoBean.getDescribeCircumstances() %></td>
						</tr>
						
				<%
				   }		   
				%>
				
				</table>
		 		
		 		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center"> 
					<tr>					
						<td colspan="3"> <hr color="gray" width="90%"/></td>
					</tr>     
				</table>
		 	
 			<% 
	  			}
 			%>
 		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
			<tr>
				<td colspan="3" width="100%"  align="center" style="padding-left : 0px;"><h4>Vehicle Information</h4></td>
			</tr>
			<tr>
			  <td width="50%" align="right"><bean:message key="ownerPage3.vehicle.year.label" /></td>
			  <td width="4%" align="center"><b>:</b></td>
			  <td  align="left"><%=infoBean.getVehicleYear() %></td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.make.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%=infoBean.getVehicleMake() %></td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.model.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%=infoBean.getVehicleModel() %></td>
			</tr>
			<!--<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.color.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%= infoBean.getVehiclecolor() %></td>
			</tr>-->
			<%
	  		if(submittedBy.equalsIgnoreCase("OWNER"))
	  		{
	     	%>
			<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.plateno.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%=infoBean.getVehiclePlateNo() %></td>
			</tr>
			<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.state.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%= infoBean.getVehicleState() %></td>
			</tr>
			<%
	  		}
	     	%>
			<!--<tr>
				<td  align="right"><bean:message key="ownerPage3.vehicle.odometer.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%= infoBean.getVehicleOdometer() %></td>
			</tr>-->		
			<%
		  		if(submittedBy.equalsIgnoreCase("DEALER"))
		  		{
	  		%>
					<tr>					
						<td colspan="3" style="padding-left:53px;"> <hr color="#99FFFF" width="90%"/></td>
					</tr>
					<tr>
					    <td colspan="3" style="padding-left : 60px;font-size:10pt"><b><bean:message key="dealerpage2.proof.header.label"/></b></td>
					</tr>
					<!--<tr>
					    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.titledOwnership.label"/>
					    &nbsp;<%= ((infoBean.getDealerTitled()).equalsIgnoreCase("Y"))?"Yes":"No" %>
						
					    </td>
					</tr>-->
					<tr>
					    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.ownershipPossession.label"/>&nbsp;			    	
							<%= ((infoBean.getDealerPosses()).equalsIgnoreCase("Y"))?"Yes":"No" %>
					    </td>
					</tr>
					<tr>
					    <td colspan="3" style="padding-left : 80px;"><bean:message key="dealerpage2.proof.agreement.label"/>&nbsp;			    	
							<%= ((infoBean.getDealerSell()).equalsIgnoreCase("Y"))?"Yes":"No" %>
					    </td>
					</tr>
					<tr>					
							<td colspan="3" style="padding-left:68px;"> &nbsp; </td>
					</tr>	
			<% 
	  			}
			%>		
		</table>
			
	  		
		<%
	  	if(submittedBy.equalsIgnoreCase("OWNER"))
	  	{
	  	%>	 
		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center"> 
			<tr>					
				<td colspan="3"> <hr color="gray" width="90%"/></td>
			</tr>     
		</table>
	
		
		
		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
      		<tr>
  				<td colspan="3"   align="center" style="padding-left : 0px;"><h4><bean:message key="dealerpage2.subheader.label1"/></h4></td>  					
			</tr>
			 <tr>
			    <td width="50%" align="right">Name : &nbsp;	<bean:message key="dealerpage2.verified.first.label" /></td>
			    <td width="4%" align="center"><b>:</b></td>
			    <td  align="left"><%= infoBean.getSubmitFirstName() %></td>
			  </tr>
			  <tr>
				<td  align="right"><bean:message key="dealerpage2.verified.last.label" /></td>
				<td  align="center"><b>:</b></td>
				<td  align="left"><%= infoBean.getSubmitLastName()%></td>
			</tr>
					
		</table>  
		<%}%>		
		<table border="0" cellpadding="0" cellspacing="0" width="90%" align="center"> 
			<tr>					
				<td colspan="3"> <hr color="gray" width="90%"/></td>
			</tr>     
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
		      	<input type="button" id="<bean:message key="confirmPage.label.next.button"/>" class="JQueryButton" onclick="javascript:return nextFunction()" value="<bean:message key="confirmPage.label.next.button"/>">
		      </div>
		    </td>
		  </tr>
		</table>
    
    
    
    
    </div>
	
</form>
	
<script language="javascript">
var submittedBy = "<%=submittedBy%>";



function goBack()
{
	window.history.go(-1);
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}

function nextFunction()
{
	
	if(submittedBy == "OWNER")
	{
		document.confirmPage.action = "registerAction.do" ;
		//document.getElementById('Next').disabled=true;
		document.getElementById('actionType').value = "completeRegistration" ;
	}
	else
	{
		document.confirmPage.action = "dealerRegisterAction.do" ;
		//document.getElementById('Next').disabled=true;
		document.getElementById('actionType').value = "completeRegistration" ;
	}		
	document.confirmPage.submit();
}
</script>            