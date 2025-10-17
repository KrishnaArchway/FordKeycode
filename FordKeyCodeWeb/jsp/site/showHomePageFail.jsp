<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<% 
	String reqParam	= "";

	if(request.getAttribute("ErrorMsg") != null)
		reqParam	=	(String)request.getAttribute("ErrorMsg");
%>
            
<h2 class="demoHeaders">Error</h2>
<div class="ui-widget">
	<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong><%= reqParam %></strong></p>
	</div>
</div>            