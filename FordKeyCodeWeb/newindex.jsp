<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>

<jsp:useBean id="collectCookieInformationBean" scope="session" class="com.archway.estore.wslx.CollectCookieInformationBean"/>
<jsp:setProperty name="collectCookieInformationBean" property="*" />

<%
String reqParam	= "";
collectCookieInformationBean.toString(); 
collectCookieInformationBean.LogCookieInformationToLogFile(request);

session.setAttribute("WSLXBEAN",collectCookieInformationBean );
String currPage = (String)session.getAttribute("currPage");

out.println(request.getParameter("errorMessage") +"  currPage :: " + currPage);

try{
	if(request.getParameter("errorMessage").equals("Success! Redirected")  && currPage.equals(null)){
		response.sendRedirect("show.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
	}else if(request.getParameter("errorMessage").equals("Success! Redirected") && !currPage.equals(null)){
		if(currPage.equalsIgnoreCase("main.jsp?keyCodeV=old")){
			response.sendRedirect("show.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
			//response.sendRedirect("adfs.jsp");
		}else{
			response.sendRedirect("adfsNewVehicle.jsp"); //main.jsp?keyCodeV=old
		}
	}else{
			reqParam=request.getParameter("errorMessage");
	}

}catch(Exception ex){
	response.sendRedirect("index.jsp");
}

%>

<h2 class="demoHeaders">Loading... Please wait!</h2>
<div class="ui-widget">
	<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		<strong><%= reqParam %></strong></p>
	</div>
</div>