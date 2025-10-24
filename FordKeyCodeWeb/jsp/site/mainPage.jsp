<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>

<%
	int tab_index 	= 	1;
%>


<form name="mainForm" method="post">
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="mainPage.label.information" /></div>
	<div class="ui-widget-content" style="min-height: 300px"><br>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td width="100%" colspan="3">
							<p align="center"><font size="5">SECURE KEY CODE ACCESS</font>
							</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">
								<p align="center">Process for obtaining an Ignition Key Code
							</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="1%">
							<p align="right"><img border="0" src="images/arrow4Pre.gif"
								width="21" height="14">
							</td>
							<td width="116%">&nbsp;&nbsp;Key code access requires that a Vehicle Ownership Record is entered into the verification database</td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="1%">
							<p align="right"><img border="0" src="images/arrow4Pre.gif"
								width="21" height="14">
							</td>
							<td width="116%">&nbsp;&nbsp;You are required to retain copies of vehicle ownership documentation:</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">
							<table border="1" cellpadding="5px" cellspacing="0" >
								<thead>
									<tr>
										<td>
											<ul><font size="3"><b>Customer or Business owned Vehicle</b></font></ul>
										</td>
										<td>
											<ul><font size="3"><b>Dealer owned used Vehicle</b></font><ul>
											</td>
										</tr>
				
								</thead>
								<tbody>

									<tr>
										<td>
										<ul><li>A completed and signed Vehicle Ownership Verification Form</span></p>
										<a href="pdf/Vehicle_Ownership_Verification_Form.pdf" target="_blank">PDF of Blank Vehicle Ownership Verification Form</a></li></ul>
										</td>
										<td>
										<ul><li>A completed and signed Vehicle Ownership Verification Form</span></p>
										<a href="pdf/Vehicle_Ownership_Verification_Form.pdf" target="_blank">PDF of Blank Vehicle Ownership Verification Form</a></li></ul>
									</tr>
									<tr>
										<td>
										<ul><li>A copy of the vehicle owner or business representative's Driver's License</li></ul>
										</td>
										<td><ul><li>Title or Bill of Sale (must include VIN)</li></ul></td>
									</tr>
									<tr>
										<td><ul><li>One of the following:&nbsp; Vehicle Registration, Title, or Certificate of Insurance (must include VIN)</li></ul></td>
										<td>&nbsp;</td>
									</tr>
							</tbody>
							</table>							
							</td>
						</tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="1%">
							<p align="right"><img border="0" src="images/arrow4Pre.gif"
								width="21" height="14">
							</td>
							<td width="116%">&nbsp;&nbsp;If you do not have this information, please return to Keycode</td>
						</tr>
						<tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="100%" colspan="3">
							<b>FORD FLEET VEHICLE:</b></td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="100%" colspan="3"><i>Please see Fleet Vehicle Key Code process on Keycode</i></td>
						</tr>
						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="100%" colspan="3"><b>NEW VEHICLE INVENTORY:</b></td>
						</tr>
						<tr>
							<td width="1%">&nbsp;</td>
							<td width="100%" colspan="3"><i>Please see New Vehicle Inventory Key Code process on Keycode</i></td>
						</tr>

						<tr>
							<td width="100%" colspan="3">&nbsp;</td>
						</tr>

						
					</table>
				</td>
			</tr>
		</table>
		
		<div class="clear"></div>
		<div class="spacer"></div>
	</div>
</div>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td width="50%" align="center">
			<p align="center">
			<div class="buttons ui-widget">				
				<input 	type="button" 
						id="btnFMCDealerButton" 
						class="JQueryButton"
						onclick="javascript : goToFMCDealer(this.form)" 
						value="<bean:message key="back.to.fmcdealer.com" />"	/>
			</div>
		</td>
		<td width="50%" align="center">
			<p align="center">
			<div class="buttons ui-widget">
				<input 	type="button" 
						id="btnNextButton"
						class="JQueryButton" 
						onclick="javascript:nextFunction(this.form)" 
						value="<bean:message key="mainPage.label.next.button"/>" />
	<%
		if( ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECH") ||   ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECHA") ) 
		{ 
	%>
				&nbsp;		
				<bean:message key="adminLoginPage.label.pacode" />&nbsp;:&nbsp;
				<input  type="<bean:message key="adminLoginPage.label.pacode.type" />" 
							id="<bean:message key="adminLoginPage.label.pacode.id" />" 
							name="<bean:message key="adminLoginPage.label.pacode.name" />" 
							size="<bean:message key="adminLoginPage.label.pacode.size" />" 
							MaxLength="<bean:message key="adminLoginPage.label.pacode.maxLength" />" 
							value="<bean:message key="adminLoginPage.label.pacode.value" />"
							onkeydown="if (event.keyCode == 13) checkPACode(this.form,'checkPaCode.do');"
							tabindex="1"/>							
				<input  type="hidden" id="dealerName" name="dealerName" value="" />			
	<%
		}
	%>			
			</div>
		</td>
	</tr>
	
<%
	if( ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECH") ||   ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECHA") ) 
	{ 
%>
	<tr>
		<td width="100%" colspan="2" align="center">
			<p align="center">
			<div class="buttons ui-widget">
				<input 	type="button" 
						id="btnAdminButton" 
						class="JQueryButton"
						onClick="javascript:goToAdmin(this.form,'./admin/adminLogin.do?mode=menuPage');" 
						value="<bean:message
						key="admin.button" />" />		
			
			
			</div>
		</td>
	</tr>
<%
	} 
%>
</table>
</form>

<script language="javascript">

var xmlHttp = null;
var form_Obj = null;
function GetXmlHttpObject() 
{
	var xml_Http=null;
	try  {
	 // Firefox, Opera 8.0+, Safari
	 xml_Http=new XMLHttpRequest();
	 }
	catch (e)
	 {
	 	//Internet Explorer
	 	try {
		  xml_Http=new ActiveXObject("Msxml2.XMLHTTP");
	  	}
	 	catch (e)
	  	{
	  		xml_Http=new ActiveXObject("Microsoft.XMLHTTP");
	  	}
	 }
	return xml_Http;
}

function checkPACode(formobj,requestedURL)
{
	if(formobj.pacode.value=='' )
	{
		alert("As you are admin user please enter parts and account code to continue");
		formobj.pacode.focus();
		return false;
	} 
	else
	{
		xmlHttp = GetXmlHttpObject();	
		form_Obj = formobj;
		var url=requestedURL+"?pacode="+formobj.pacode.value;
		xmlHttp.onreadystatechange=paCodeCheck;
		xmlHttp.open("POST",url,true);
		xmlHttp.send(null);
	}
}

function paCodeCheck(formobj)
{	
	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
	 { 
		var paCodeStatus = xmlHttp.responseText;		
		var paCodeStatusList = paCodeStatus.split("~");
		if(paCodeStatusList[0] == 'XX')
		{
			alert('P&A Code is not Valid');
		}
		else
		{
			alert('P&A Code is Valid');
			form_Obj.dealerName.value=paCodeStatusList[0];
			nextFunction(form_Obj);
		}	
	 } //xmlHttp if
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}

function nextFunction(formObj)
{

	<%
	if( ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECH") ||   ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECHA") ) { %>
	
	if(formObj.pacode.value=='' )
	{
		alert("As you are admin user please enter parts and account code to continue");
		return false;
	} 
	
	<%}%>
	
	formObj.action='vin.do';
	formObj.submit();
	
}

function goToAdmin(formObj,url)
{
	//alert(url);
	formObj.action=url;
	formObj.submit();
}


</script>

