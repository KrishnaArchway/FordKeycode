<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/display" prefix="display" %>

<%@ page import="com.archway.estore.util.StringUtility,com.archway.estore.formbean.BlockedPACodeBean"%>
<%
	String saveMsg[]	=	null;
	if(session.getAttribute("SAVE_MSG")!=null)
		saveMsg = ((String)session.getAttribute("SAVE_MSG")).split("\\|");
	
%>
<form name="addUpdatePACodeForm" action="adminLogin.do">
<input type="hidden" name="mode" value="">
<input type="hidden" name="paId" value="">
<input type="hidden" name="paCode" value="">
        
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="adminHomePage.label.header1"/></div>
    	<div class="ui-widget-content" style="min-height: 300px">    		
        	<br>
        	<div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
			<%
				if(saveMsg != null)
				{
			%>
				<table  align="center" width="80%">
					<tr>
						<td>
							<%
								if(saveMsg[0].equalsIgnoreCase("0"))
								{
							%>
									<font color="green"><%= saveMsg[1] %></font>
							<%
								}
								else
								{
							%>
									<font color="red"><%= saveMsg[1] %></font>
							<%		
								}
							%>	
						</td>
					</tr>
				</table>
			<%
				}
			%>	
			
        	<table align="center" width="80%">	
        		<tr>
        			<td>
        				<div class="ui-widget-content">
	        				<table width="100%">
								<tr>
									<td align="right">
										<b><bean:message key="adminHomePage.label.table.col1"/></b>
										<input type="text" name="searchPa" id="searchPa" value="">
										<input type="button" class="JQueryButton" id="searchBtn" name="searchBtn" value="<bean:message key="adminHomePage.label.search.button"/>" onclick="searchPaCode()">
										<input type="button" class="JQueryButton" id="showAllBtn" name="showAllBtn" value="<bean:message key="adminHomePage.label.showAll.button"/>" onclick="showAllPaCode()">
									</td>
								</tr>
							</table>
						</div>
        			</td>			
        		</tr>
        		<tr>
        			<td></td>
        		</tr>
				<tr>
					<td>	
						<display:table requestURI="" id="blockedCodeId" name="blockedPACodeList" width="80%" export="false" pagesize="10" cellpadding="1" class="displayMainTable" cellspacing="0" sort="list" scope="session">
							
							<display:column title="PA Code" align="left"  sortable="true">
								<%=((BlockedPACodeBean)blockedCodeId).getPaCode()%>
							</display:column>
							
							<display:column title="Dealership Name" align="left"  sortable=""  >
								<%=((BlockedPACodeBean)blockedCodeId).getDealerShipName()%>
							</display:column>
		
							<display:column title="Blocked Status" align="center" sortable="" >
								<%=((BlockedPACodeBean)blockedCodeId).getBlockedFalg()%>
							</display:column>	
							
							<display:column title="Action" align="left"  >
								<a href="#" onclick="javaScript:updateBlockedPACode('<%=((BlockedPACodeBean)blockedCodeId).getBlockedPaId()%>','<%=((BlockedPACodeBean)blockedCodeId).getPaCode()%>')"><bean:message key="adminHomePage.label.table.col4.actionlink"/></a>
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
			</table>
        	<div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
			<div class="spacer"></div> <div class="clear"></div>
        	<table align="center" width="80%">				
				<tr>
					<td align="left">	
						<p align="center">
		      			<div class="buttons ui-widget">
		                	<input type="button" id="btnAddButton" class="JQueryButton" onClick="javaScript:backToMenuPage();" value="<bean:message key="adminHomePage.label.backTo.Menu"/>">
		                </div>			
					</td>
					<td align="right">	
						<p align="center">
		      			<div class="buttons ui-widget">
		                	<input type="button" id="btnAddButton" class="JQueryButton" onClick="javaScript:addPACode();" value="<bean:message key="adminHomePage.label.table.addButton"/>">
		                </div>			
					</td>
				</tr>			
			</table>
        	      	
        	
            	<div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div> <div class="clear"></div>
				<div class="spacer"></div>
		</div>
	</div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr>
    		<td width="100%" align="center">
      			<p align="center">
      			<div class="buttons ui-widget">
                	<!-- <button id="btnSampleButton" class="JQueryButton" ><bean:message key="adminHomePage.label.logout.button"/></button> -->
                	<!-- <input type="button" id="btnSampleButton" class="JQueryButton" value="<bean:message key="adminHomePage.label.logout.button"/>" /> -->
                </div>	
            </td>
		</tr>
	</table>
</div>
</form>

<script>
	
	function showAllPaCode()
	{
		document.addUpdatePACodeForm.mode.value="showAllPaCode";
		document.addUpdatePACodeForm.submit();
	}
	
	function backToMenuPage()
	{
		document.addUpdatePACodeForm.mode.value="menuPage";
		document.addUpdatePACodeForm.submit();
	}
	
	function updateBlockedPACode(strPaId,strPaCode)
	{
		if(confirm("Do you really want to Unblock a P&A Code "+strPaCode))
		{
			document.addUpdatePACodeForm.mode.value="updatePACode";
			document.addUpdatePACodeForm.paId.value=strPaId;
			document.addUpdatePACodeForm.submit();
		}
		
	}
	
	function addPACode()
	{		
		var retval = window.showModalDialog("adminLogin.do?mode=addPaCode","","dialogHeight:150px; dialogwidth:20px;resizable:yes;titlebar=no;");	
		if(retval == undefined)
		{
			/*document.addUpdatePACodeForm.mode="get_blocked_pa_codes";
			document.addUpdatePACodeForm.submit();			
			*/
			return false;
		}	
		else
		{
			document.addUpdatePACodeForm.mode.value="savePACode";
			document.addUpdatePACodeForm.paCode.value=retval;
			document.addUpdatePACodeForm.submit();
		}
	}
	function searchPaCode()
	{
		if(document.addUpdatePACodeForm.searchPa.value != '')
		{
			document.addUpdatePACodeForm.mode.value="searchPaCode";
			document.addUpdatePACodeForm.paCode.value=document.addUpdatePACodeForm.searchPa.value;
			document.addUpdatePACodeForm.submit();
		}
		else
		{
			alert('Please enter a P&A Code for Search.');
		}
	}
	
</script>
            