<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>


<%
int tabIndex = 1;
SessionBean sb = (SessionBean) session.getAttribute("SessionBean");
String strVin = sb.getVin() ;

%>

<form name="vinExistFrm" method="post" action="#">

	<div class="ui-widget">
                <div class="ui-widget-header section-header">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  				<tr>
    			<td width="50%"><bean:message key="ownerPage.label.information"/></td>
    			<td width="50%" align="right">&nbsp;</td>
  				</tr>
 				</table>
                </div>
                                                
                <div class="ui-widget-content" style="min-height: 300px">
                <br>
                <br>
                
                
			  <table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
			    <td align="center" colspan="3"><b> VIN : <%= strVin %> </b></td>			    
			  </tr>
			  <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
			  <tr>
			    <td  align="center"><b>A record of ownership verification is already established for this VIN</b></td>			    
			  </tr>
			  <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
			</table>
              
            </div>
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr>
		    <td width="50%" align="center">
		    	<div class="buttons ui-widget">
		        <input type="button" class="JQueryButton" value="Back" onClick="javascript : goBack()"/>		        
		      </td>
		    </td>
		    <td width="50%" align="center">
		      <p align="center">
		      <div class="buttons ui-widget">		       
		        <input type="button" class="JQueryButton" value="Continue" onClick="javascript : showLogin()"/>
		      </td>
		  </tr>
		   <tr>
		    <td  align="center">
		    	To check the VIN you entered
		    </td>
		    <td  align="center">		      
		        To KeyCode Access Login 
		    </td>
		  </tr>
		</table>
            
               
            </div>
            
            </form>
<script language="javascript">
	var vinNum = "<%= strVin %>" ;
	
	function goBack(){
		document.location.href='vinExist.do?actionType=back&vin='+vinNum ;
	}
	
	function showLogin(){
		document.location.href= "http://www.fmcdealer.dealerconnection.com/sites/ford_lm/parts_service/pdt/Pages/keycode2.aspx" ;
	}

</script>            