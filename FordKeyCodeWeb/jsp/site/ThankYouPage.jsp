<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>

<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>
<%@ page import="com.archway.estore.common.ConfigurationServlet"%> 

<%
	int tabIndex = 1;
	
	SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
	String submittedBy 		= (String)request.getAttribute("SUBMITTED_BY") ;
	String exceptionFlag 	= (String)session.getAttribute("ExceptionFalg") ;
	String duplicateInsert	= (String)session.getAttribute("DuplicateInsert") ;
	
	String env 				= 	System.getProperty ( "ENV" );
	//String urlParam			=	"?pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl();
	//String urlToGoKeyCode 	= 	(String)ConfigurationServlet.getApplicationProperty ( env + "_KEYCODE_ACCESS_URL" )+urlParam;
	
	String urlParam			=	"&pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl();
	String urlToGoKeyCode 	= 	"https://fordpro.com/en-us/tools/sales/resources/dealer-key-code/";

%>

<form name="dealerPage2" method="post" action="dealerRegisterAction.do">

<div class="ui-widget">
	<div class="ui-widget-header section-header">
    	<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
  				<td colspan="2">&nbsp;</td>  					
			</tr>
		</table>
	</div>
       
    <div class="ui-widget-content" style="min-height: 300px">   <br>
		<table border="0" cellpadding="0" cellspacing="0" width="80%" align="center">
			<tr>
				<td align="center" colspan="3"><b>Thank You</b></td>			    
			</tr>
			<tr>
				<td align="center" colspan="3">&nbsp;	</td>			    
			</tr>
			<tr>			  
				<td  align="center">
<%
	if(duplicateInsert!=null && duplicateInsert.trim().length()>0)
	{
%>
					<%= duplicateInsert %>
<%			    		
	}
	else
	{
		if(exceptionFlag.equalsIgnoreCase(""))
		{
%>
					<bean:message key="thankyou.msg" />
		
		
		<br><br>
			    	<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td width="100%" colspan="2"><b>One Week Record Retention</b> - An Ownership Record will exist in database for seven days before expiring.  Should a key code request be made on a VIN where an Ownership record was added more than seven days prior, a new ownership record will be required for the VIN.</td>
						</tr>
						<tr>
							<td width="100%" colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td width="100%" colspan="2"><b>One Time Use</b> - An individual ownership record can only be used one time to make a key code request.  A new ownership record will be required each time there are additional key code requests for the same VIN. </td>
						</tr
						<tr>
							<td width="100%" colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td width="100%" colspan="2"><b>Key Code Dealer Audits </b>
							-  <a href="/pdf/Dealership_Keycode_complaince_PDF.pdf" target="_blank">Compliance and Audits PDF</a> </td>
						</tr>
					</table>
<%

			}										
		else
		{
%>	
					<!--<bean:message key="thankyou.exception.msg" /><br><br>-->
			    	<table border="0" cellpadding="0" cellspacing="0" width="100%">
					    <tr>
							<td width="100%" colspan="2"><li><bean:message key="thankyou.exception.msg" /></li></td>
						</tr>
						<tr>
							<td width="100%" colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td width="100%" colspan="2"><li>Please remember that complete Vehicle Owner Verification must be obtained and held in case of an audit and that non-compliance may result in your access to key codes being restricted or revoked.</li></td>
						</tr>
						<tr>
							<td width="100%" colspan="2">&nbsp;</td>
						</tr>
						<!--<tr>
							<td width="3%"><p align="center">A)</td>
							<td width="97%"><p align="left">Via a scanned email that includes a complete Vehicle Ownership Verification Form</td>
						</tr>
						<tr>
    						<td width="3%"><p align="center">B)</td>
    						<td width="97%"><p align="left">Via a fax of the completed Vehicle Ownership Verification Form</td>
						</tr>
  						<tr>
    						<td width="3%"><p align="center">C)</td>
    						<td width="97%"><p align="left">Via direct online entry through the Vehicle Ownership Form available on the Key Code page on FMCDealer.com</td>
  						</tr>
  						<tr>
    						<td width="100%" colspan="2">&nbsp;</td>
  						</tr>-->
  						<tr>
    						<td width="100%" colspan="2">
      							<li>Click here to open the <a href="/pdf/Vehicle_Ownership_Verification_Form.pdf" target="_blank">Vehicle Ownership Verification Form</a></li>
      						</td>
  						</tr>
  						<tr>
    						<td width="100%" colspan="2">&nbsp;</td>
  						</tr>
  						<!--<tr>
    						<td width="100%" colspan="2">Print this form and submit the complete vehicle ownership information within
      							<font color="#FF0000"><b> 3 business days</b> </font> of making the key code request
      						</td>
  						</tr>-->
					</table>
			    		
<%
		}
	}
%>
				</td>			    
			</tr>
			<tr>
				<td align="center" colspan="3">&nbsp;	</td>			    
			</tr>
		</table>
	</div>
</div>
<div>	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td align="center" >
				<p colspan="2" >
				<div class="buttons ui-widget">
	
					<!-- <button id="ownership" class="JQueryButton" onclick="javaScript:caor();">Create Another Ownership Record</button>	-->
						
					<input type="button" id="keycodeLogin" class="JQueryButton" onclick="javaScript:goToKeyCodeLogin();" value="Go To Keycode Access Log In "/>
				</div>
			</td>
				   
		</tr>
		<tr>
		    <td align="center">
		      <p colspan="2">
		      	<div class="buttons ui-widget">
				    
					<!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer()"><bean:message key="back.to.fmcdealer.com"/></button>			              
					<button id="keycodeLogin" class="JQueryButton" onclick="javaScript:goToKeyCodeLogin();">Go To Keycode Access Log In</button>
						      -->
					<input type="button" id="ownership" class="JQueryButton" onclick="javaScript:caor();" value="Create Another Ownership Record" />	
					<input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />
				</div>
			</td>
		</tr>
	</table>               
</div>
	
</form>
	
<script language="javascript">
function goToKeyCodeLogin()
{
	document.dealerPage2.action='<%=urlToGoKeyCode%>';
	document.dealerPage2.method="GET";
	document.dealerPage2.submit();
}
function caor()
{
	/////alert("in here");
	document.dealerPage2.action='show.do?pacode=<%=sb.getPacode()%>&acl=<%=sb.getAcl()%>&wsl=<%=sb.getWsl()%>&t=<%=Math.random()%>';
	document.dealerPage2.method="POST";
	document.dealerPage2.submit();
	//window.location.href = 'show.do?pacode=<%=sb.getPacode()%>&acl=<%=sb.getAcl()%>&wsl=<%=sb.getWsl()%>&t=<%=Math.random()%>';
}

function nextFunction()
{
	//window.location.href = 'vin.do';
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}
</script>            