<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility, com.archway.estore.formbean.EditRegistrationVINBean"%>
<%
	String saveMsg[]	=	null;
	if(session.getAttribute("SAVE_MSG")!=null)
		saveMsg = ((String)session.getAttribute("SAVE_MSG")).split("\\|");
	
%>
<form name="editRegistrationForm" action="editRegistration.do" method="post">
<input type="hidden" name="mode" value="">
<input type="hidden" name="paId" value="">
<input type="hidden" name="paCode" value="">
<input type="hidden" name="selectedVin" value="">
        
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="editRegistration.label.header1"/></div>
    	<div class="ui-widget-content" style="min-height: 300px">    		
        	<br>
        	<div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
				
			
        	<table align="center" width="80%" border="0">	
        		<tr>
        			<td>        				
	        			<table width="100%" border="0" >
							<tr>
								<td width="20%"><b>Enter VIN : </b></td>
								<td width="40%"><input type="text" name="searchVin" id="searchVin" value="" maxlength="17" size="30"></td>
								<td align="right" width="10%"><b>Days : </b></td>
								<td><select name="daysVin" id="daysVin">
										<option value="">--Select--</option>
										<option value="10">10</option>
										<option value="20">20</option>
										<option value="40">40</option>
										<option value="80">80</option>
										<option value="100">100</option>
										<option value="150">150</option>
										<option value="200">200</option>
										<option value="300">300</option>
									</select>
								</td>
								<td><input type="button" class="JQueryButton" id="searchVinButton" name="searchVinButton" value="GO" onclick="javascript: return searchByVin(this.form)"></td>
							</tr>
							<tr>
								<td >&nbsp;&nbsp;&nbsp;&nbsp;OR</td>
								<td colspan="4"></td>
							</tr>
							
							<tr>
								<td><b>Enter P&A : </b></td>
								<td><input type="text" name="searchPa" id="searchPa" value="" maxlength="5" size="30"></td>
								<td align="right"><b>Days : </b></td>
								<td><select name="daysPa" id="daysPa">
										<option value="">--Select--</option>
										<option value="10">10</option>
										<option value="20">20</option>
										<option value="40">40</option>
										<option value="80">80</option>
										<option value="100">100</option>
										<option value="150">150</option>
										<option value="200">200</option>
										<option value="300">300</option>
									</select>
								</td>
								<td><input type="button" class="JQueryButton" id="searchPaButton" name="searchPaButton" value="GO" onclick="javascript: return searchByPa(this.form)"></td>
							</tr>
						</table>						
        			</td>			
        		</tr>
        		<tr>
        			<td></td>
        		</tr>
        		<% if(request.getAttribute("EditRegistrationVINBean")!=null)
        		{	
        		%>
        		
        		<tr>
					<td>	
						<display:table requestURI="" id="EditRegistrationVINBean" name="EditRegistrationVINBean" width="60%" export="false" pagesize="10" cellpadding="1" class="displayMainTable" cellspacing="0">
							
							<display:column title="VIN" align="left"  sortable="false">								
								<%=((EditRegistrationVINBean)EditRegistrationVINBean).getVin()%>
							</display:column>
							
							<display:column title="PA Code" align="left"  sortable="false">								
								<%=((EditRegistrationVINBean)EditRegistrationVINBean).getPa_code() %>
							</display:column>
							
							<display:column title="Dealership Name" align="left"  sortable="false">								
								<%=((EditRegistrationVINBean)EditRegistrationVINBean).getDealership_name() %>
							</display:column>
							
							<display:column title="Submit First Name" align="left"  sortable="false">								
								<%=((EditRegistrationVINBean)EditRegistrationVINBean).getSubmit_first_name() %>
							</display:column>	
							
							<display:column title="Submit Last Name" align="left"  sortable="false">								
								<%=((EditRegistrationVINBean)EditRegistrationVINBean).getSubmit_last_name() %>
							</display:column>
							
							<display:column title="" align="left"  sortable="false">								
								<a href="javaScript:getVehicleOwnerInfo('<%=((EditRegistrationVINBean)EditRegistrationVINBean).getVin()%>');" >Edit</a>
							</display:column>					
							
							
							<display:setProperty name="paging.banner.placement" value="bottom"/>
							<display:setProperty name="paging.banner.onepage" value="" />
							<display:setProperty name="paging.banner.page.separator" value=""/>
							<display:setProperty name="paging.banner.no_items_found" value=""/>
							<display:setProperty name="paging.banner.one_item_found" value=""/>
							<display:setProperty name="paging.banner.all_items_found" value=""/>
							<display:setProperty name="paging.banner.some_items_found" value=""/>							
						</display:table>								
					</td>
				</tr>
        		
        		
        		<%
        		}        		
        		%>
        		
							
			</table>
        	<div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
        	<table align="center" width="80%">				
				<tr>
										
				</tr>			
			</table>
        	      	
        	
            	
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>				
		</div>
		<div class="spacer"></div> <div class="clear"></div>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="right" style="padding-right:15px;">									
					<input type="button" id="btnAddButton" class="JQueryButton" onClick="javaScript:backToMenuPage();" value="Abort">
				</td>				
			</tr>
		</table>
	</div>    
</div>
</form>

<script>
	
	function getVehicleOwnerInfo(selectedVin)
	{
		document.editRegistrationForm.mode.value="VehicleOwnerInfo";
		document.editRegistrationForm.selectedVin.value=selectedVin;
		document.editRegistrationForm.submit();
	}
	
	function searchByVin(formObj)
	{		
		if(!validate(formObj.searchVin, "Enter VIN", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.daysVin, "Days", RULE_REQUIRED)) 
		{
			return false;
		}		
		else
		{
			document.editRegistrationForm.mode.value="searchByVin";
			document.editRegistrationForm.submit();
		}
	}
	
	function searchByPa(formObj)
	{		
		if(!validate(formObj.searchPa, "Enter P&A", RULE_REQUIRED)) 
		{
			return false;
		}
		if(!validate(formObj.daysPa, "Days", RULE_REQUIRED)) 
		{
			return false;
		}
		else
		{
			document.editRegistrationForm.mode.value="searchByPa";
			document.editRegistrationForm.submit();	
		}				
	}
	
	function backToMenuPage()
	{
		document.editRegistrationForm.mode.value="menuPage";
		document.editRegistrationForm.submit();
	}
	
</script>
            