<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.util.StringUtility"%>

<%
int tabIndex = 1;

%>
<form name="loginForm" action="adminLogin.do">
<input type="hidden" name="mode" value="auth">    
   
<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td width="50%"><bean:message key="adminLoginPage.label.information"/></td>
 				<td width="50%" align="right">&nbsp;</td>
			</tr>
		 </table>
      </div>     
       
      <div class="ui-widget-content" style="min-height: 300px">   

	     <br>
          <%if(!StringUtility.isStringBlank((String)request.getAttribute("adminAuthError")) && ((String)request.getAttribute("adminAuthError")).equalsIgnoreCase("Y") ) {%>      
          <br>
		 <h2 class="demoHeaders">Error</h2>
			<div class="ui-widget">
				<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
					<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
					<strong><bean:message key="adminLoginPage.label.userId.errorAuthMessage"/></strong></p>
				</div>
			</div> <br>
					<%} %>

		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
				<td width="35%" align="right"><b><bean:message key="adminLoginPage.label.userId"/></b></td>
				<td width="2%" align="center"><b>:</b></td>
				<td width="63%">
					 <input type="<bean:message key="adminLoginPage.label.userId.type" />"
						id="<bean:message key="adminLoginPage.label.userId.id" />"
						name="<bean:message key="adminLoginPage.label.userId.name" />"
						size="<bean:message key="adminLoginPage.label.userId.size" />"
						MaxLength="<bean:message key="adminLoginPage.label.userId.maxLength" />"
						tabindex="<%=tabIndex++ %>">	
				
				</td>
			  </tr>
			  
			  <tr>
				  <td width="35%" align="right"><b><bean:message key="adminLoginPage.label.password"/></b></td>
				  <td width="2%" align="center"><b>:</b></td>
				  <td width="63%">
					   <input type="<bean:message key="adminLoginPage.label.password.type" />"
							id="<bean:message key="adminLoginPage.label.password.id" />"
							name="<bean:message key="adminLoginPage.label.password.name" />"
							size="<bean:message key="adminLoginPage.label.password.size" />"
							MaxLength="<bean:message key="adminLoginPage.label.password.maxLength" />"
							tabindex="<%=tabIndex++ %>">	
					  
					  </td>
			  </tr>
			  			 
			  <tr><td colspan="3">&nbsp;</td></tr>
                  
		  </table>     
       </div>

	    <table border="0" cellpadding="0" cellspacing="0" width="100%">
	  		<tr>
			    <td colspan="2" align="center">
			      <p align="center"><div class="buttons ui-widget">
			              <input type="button" id="btnSampleButton" class="JQueryButton" value="Login" onclick="javascript: submitLogin(this.form)">
			            </div></td>
			    
	  		</tr>

		</table>               
		 

    </div>
    
	   


 </form>           
            
<script language="javascript">


function submitLogin(formObj){
	if(validateFrm(formObj)){
		formObj.submit();
	}
}

function validateFrm(formObj)
{
	if(!validate(formObj.<bean:message key="adminLoginPage.label.userId.id" />, "<bean:message key="adminLoginPage.label.userId.errorMessage" />", RULE_REQUIRED)) 
	{
 		return false;
 	}
 	
 	if(!validate(formObj.<bean:message key="adminLoginPage.label.password.id" />, "<bean:message key="adminLoginPage.label.password.errorMessage" />", RULE_REQUIRED)) 
	{
	 		return false;
 	}
return true ;	
}

</script>