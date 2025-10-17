<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>


<%@ page import="com.archway.estore.common.ConfigurationServlet"%>

<%
SessionBean sb 				= 	(SessionBean) session.getAttribute("SessionBean");
String env 				= 	System.getProperty ( "ENV" );
//String urlParam			=	"?pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl()+"&vehtype=N";
//String urlToGoKeyCode 	= 	(String)ConfigurationServlet.getApplicationProperty ( env + "_NEWVEHICLE_KEYCODE_ACCESS_URL" )+urlParam;

String urlParam			=	"&pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl();
//String urlToGoKeyCode 	= 	"https://www.dkc.dealerconnection.com/#/keycode/agreement?KeyCodeF=NEW"+urlParam;//(String)ConfigurationServlet.getApplicationProperty ( env + "_KEYCODE_ACCESS_URL" )+urlParam;
String urlToGoKeyCode 	= 	"https://stage.fordpro.com/en-us/tools/sales/resources/dealer-key-code/keycode/";


%>

<form name="dealerPage2" method="post" action="">


<div class="ui-widget">
      
       <div class="ui-widget-header section-header">
       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
  					<td colspan="2">&nbsp;</td>  					
				</tr>
			</table>
       </div>
       
       <div class="ui-widget-content" style="min-height: 300px">   <br>
		  <table border="0" cellpadding="0" cellspacing="0" width="70%" align="center">
		  	<tr>
			    <td align="center" colspan="3"><b>Thank You</b></td>			    
			  </tr>
			  <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
			  <tr>
			    <td align="center" colspan="3">Your New Vehicle Record has been submitted.</td>			    
			  </tr>
			  
</table>
			    		
			
			    </td>			    
			 </tr>
			 <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
		  </table>
       </div>
    </div>
    
	    <table border="0" cellpadding="0" cellspacing="0" width="100%">
	  		<tr>
			    
			     <td align="left">
			      <p colspan="2"><div class="buttons ui-widget">
					      <input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />
					</div></td>
			    <td align="right" >
			      <p colspan="2" ><div class="buttons ui-widget">
						<input type="button" id="keycodeLogin" class="JQueryButton" onclick="javaScript:goToKeyCodeLogin();" value="Go To Keycode Access Log In "/>
					</div></td>
			   
	  		</tr>
		</table>               
</form>
	
<script language="javascript">
function goToKeyCodeLogin()
{
	document.dealerPage2.action='<%=urlToGoKeyCode%>';
	document.dealerPage2.submit();
}
function caor()
{
	/////alert("in here");
	document.dealerPage2.action='show.do?pacode=<%=sb.getPacode()%>&acl=<%=sb.getAcl()%>&wsl=<%=sb.getWsl()%>&t=<%=Math.random()%>';
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