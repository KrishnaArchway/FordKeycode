<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>

<%
	SessionBean sb = (SessionBean) session.getAttribute("SessionBean");	
%>

 <div class="clear"></div>
 <div class="spacer"></div>
 	
 <div class="footer ui-widget">
 	<%
		if( ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECH") ||   ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg().equalsIgnoreCase("AECHA") ) 
		{ 
	%>		 
			<table width="100%" style="color:#999999">
				<tr>
					<td align="left">
						<bean:message key="adminLoginPage.label.pacode" />&nbsp;:&nbsp; <%= sb.getPacode() %>
					</td>
					<td align="center">
						Copyright &copy; 2005-<script>document.write(new Date().getFullYear())</script>
					</td>					
					<td align="right">
						<bean:message key="adminLoginPage.label.dealerName" />&nbsp;:&nbsp; <%= sb.getDealerName() %>
					</td>
				</tr>
			</table>	
		
	<%
		}
	%>		
 </div>