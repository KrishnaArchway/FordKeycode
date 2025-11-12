<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.session.SessionBean"%>
<%@ page import="com.archway.estore.formbean.VINRegisterBean"%>
<%@ page import="com.archway.estore.common.ConfigurationServlet"%>


<%
	String env 			= 	System.getProperty ( "ENV" );
	String urlToGoFmc 	= 	"https://fordpro.com/en-us/tools/sales/resources/dealer-key-code/";

%>

<form name="dealerPage2" method="post" action="fmcDealer.do">
<div class="ui-widget">
      
       <div class="ui-widget-header section-header">
       		<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
  					<td colspan="2">&nbsp;</td>  					
				</tr>
			</table>
       </div>
       
       <div class="ui-widget-content" style="min-height: 300px">   <br>
		  <table border="0" cellpadding="0" cellspacing="0" width="100%">
		  	<tr>
			    <td align="center" colspan="3"><b> Do you want to Cancel and return </b></td>			    
			  </tr>
			  <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
			  <tr>
			    <td  align="center"><b>to Key Code?</b></td>			    
			 </tr>
			 <tr>
			    <td align="center" colspan="3">&nbsp;	</td>			    
			  </tr>
		  </table>
		 
       </div>
    </div>
    
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  	
		<tr>
		    <td align="center">
		      <p colspan="2"><div class="buttons ui-widget">

		              <!-- <button id="btnBack" class="JQueryButton" onclick="javascript:fnBack(this.form)">Back</button>&nbsp;&nbsp;
		              <button id="btnFMCdealer" class="JQueryButton" onclick="javascript:goToFMCDealer()" >Yes - Go to FMCDealer.com</button>            
		              -->
		              <input type="button" id="btnBack" class="JQueryButton" onclick="javascript:fnBack(this.form)" value="Back" />&nbsp;&nbsp;
		              <input type="button" id="btnFMCdealer" class="JQueryButton" onclick="javascript:goToFMCDealer()" value="Yes - Go to Key Code "/>            
				      
				</div></td>
		   
  		</tr>
	</table>               
	</div>
	
</form>
	
<script language="javascript">


function fnBack(frmObj)
{
	window.history.go(-1);	
}

function goToFMCDealer()
{
	document.dealerPage2.action='<%=urlToGoFmc%>' ;
	document.dealerPage2.method="GET";
	document.dealerPage2.submit();
}
</script>            