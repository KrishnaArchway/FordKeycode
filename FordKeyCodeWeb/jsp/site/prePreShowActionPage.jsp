<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.common.ConfigurationServlet"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<%
	int tabIndex = 1;
	
	SessionBean sb 			= (SessionBean) session.getAttribute("SessionBean");
	
	String env 				= 	System.getProperty ( "ENV" );
	String urlParam			=	"&pacode="+sb.getPacode()+"&acl="+sb.getAcl()+"&wsl="+sb.getWsl();
	String urlToGoKeyCode 	= 	"https://fordpro.com/en-us/tools/sales/resources/dealer-key-code/";

%>
<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
		<div class="ui-widget-content" style="min-height: 300px">
			<br>
           	
           	
           	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr>
		    <td width="100%" colspan="3">
		      <p align="center"><font size="5">SECURE KEY CODE ACCESS</font></td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3">&nbsp;</td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3" align="center">
		      <p align="center">A Vehicle Ownership Record is required to obtain a Key Code</td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
  		    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
  		    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  
           <tr>
  		    <td width="100%" colspan="3">
           	
			
			
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
			    <td width="100%" colspan="2" align="center"><p align="center"><font size="4">Have you already established an online Vehicle Ownership record?</font></p></td>
			  </tr>
			  <tr>
			    <td width="100%" colspan="2">&nbsp;</td>
			  </tr>
			  <tr>
			    <td width="50%" align="center"><b>NO</b> - <a href="show1.do">Create an Vehicle Ownership record</a></td>
			    <td width="50%" align="center"><b>Yes</b> - <a href="<%=urlToGoKeyCode %>">Go to Key Code Access Login</a></td>
			  </tr>
			</table>
			
			
			
			</td>
  </tr>	
			</table>

               
             <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <!-- <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>-->
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div>
         </div>
	</div>
   
</div>

