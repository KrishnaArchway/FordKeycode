<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>
<%@page import="com.archway.estore.wslx.ADFSCookieBean"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="com.archway.estore.util.ADFSValidation"%>
<%@page import="com.archway.estore.common.ConfigurationServlet"%>

<jsp:useBean id="collectCookieInformationBean" scope="session" class="com.archway.estore.wslx.CollectCookieInformationBean"/>
<jsp:setProperty name="collectCookieInformationBean" property="*" />

<% String token=""; %>

<script language="javascript">
 var url = window.frames.location.href;
 //console.log(url);
 var urlarr = url.split("_token=");
 //console.log(urlarr.length);
 if(urlarr.length > 1){
	  var tokArr = urlarr[1].split("&"); 
	  var token = tokArr[0];
      //console.log(token);
 }

 
 
</script>

<%
	String adfsCredential = "";
	String Issued = "";
	String Expires = "";
	String Issuer = "";
	String User = "";
	String ACI = "";
	String Site = "";
	String OrgCode = "";
	String EmpCode = "";
	String Role = "";
	String Org = "";
	String Company = "";
	String DivAbbr = "";
	String empCode = "";
	String loginID = "";
	String errorMessage = "";
	String isCookieValid = "N";
	
	
	
	
	
	
	try{
		token = (String)session.getAttribute("TOKEN");
	}catch(Exception ex){
		
	}
	
	//adfsCredential="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Im9hM295aXhiSkNxZzUxVFV2MmVhMHdqbXItVSIsImtpZCI6Im9hM295aXhiSkNxZzUxVFV2MmVhMHdqbXItVSJ9.eyJhdWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6cmVzb3VyY2U6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiaXNzIjoiaHR0cHM6Ly9jb3JwcWEuc3RzLmZvcmQuY29tL2FkZnMvc2VydmljZXMvdHJ1c3QiLCJpYXQiOjE3MzA3OTI5MDYsIm5iZiI6MTczMDc5MjkwNiwiZXhwIjoxNzMwNzk2NTA2LCJDb21tb25OYW1lIjoiZy1zaW1zMTEiLCJzdWIiOiJnLXNpbXMxMSIsInVzZXJpZCI6Imctc2ltczExIiwic2l0ZWNvZGUiOiJBUksyMyIsImNvdW50cnkiOiJVU0EiLCJBQ0lHUk9VUCI6Ik90aGVyIiwic3ViamVjdGlkIjoiZy1zaW1zMTFAZm9yZC5jb20iLCJhcHB0eXBlIjoiUHVibGljIiwiYXBwaWQiOiJ1cm46YXJjaHdheXZlaGljbGVvd25lcnNoaXA6Y2xpZW50aWQ6d2ViX3ZlaGljbGVfb3duZXJzaGlwOnFhIiwiYXV0aG1ldGhvZCI6InVybjpNRkE6dHJ1ZSIsImF1dGhfdGltZSI6IjIwMjQtMTEtMDVUMDc6NTM6MjUuMDIzWiIsInZlciI6IjEuMCJ9.qCuNCfizuI2tVvYy0JrsYovErzcD10n1Zl_oQiEUsyLZeSFTmNdvCaRxrkI-_U6BUe-VEgd-7HVybFKRuJgieJHE9iefuOWEfxae23EUXnGFBDlIYuhEg93VycLaiBIefo9oCzNOlqIDB4UCFGOBV012ymt3BdSopM7PRP5G7XGGRqhga_5jwWWZEBZadXNKw1AIedhWe-WxiA-8jZY1Tb0NxvslWitLeYNsKX5d2U2NcJNopxlxJtEYi3Q1oAmjdh7dMJ1U9b2yiQVDf8JRCAl6294BFpf_eqV69pI49N0GN3cKs5mPlJEDsJaRAiUHXTt67H_aq-snTQnM86dt-g";
	ADFSCookieBean adfsCookieData = new ADFSCookieBean();
	if(token != null && token != ""){
		
		ADFSValidation adfsTokenValidation = new ADFSValidation(token);
		adfsCookieData = adfsTokenValidation.validateAdfsToken();
		Org 	= adfsCookieData.getOrg();
		ACI 	= adfsCookieData.getAci();
		OrgCode = adfsCookieData.getOrgCode();
		User 	= adfsCookieData.getUser();
		DivAbbr = adfsCookieData.getDivAbbr();
		loginID = adfsCookieData.getUser();
		EmpCode = adfsCookieData.getEmpCode();
		Role	= adfsCookieData.getRole();
		Company = adfsCookieData.getCompany();
		errorMessage = adfsCookieData.getErrorMessage();
	}else {
		
		
				
	}
	
%>

<%
String reqParam	= "";
collectCookieInformationBean.toString(); 
collectCookieInformationBean.LogCookieInformationToLogFile(request); 
session.setAttribute("WSLXBEAN",collectCookieInformationBean );

String currPage = (String)session.getAttribute("currPage");

if(session.getAttribute("TOKEN") != null){
	token = session.getAttribute("TOKEN").toString();
	response.sendRedirect("show.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
}

try{
	if(request.getParameter("errorMessage").equals("Success! Redirected") && currPage.equals(null)){
		response.sendRedirect("show.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
		//out.println("currPage 109 " + currPage);
	}else if(request.getParameter("errorMessage").equals("Success! Redirected") && !currPage.equals(null)){
		if(currPage.equalsIgnoreCase("main.jsp?keyCodeV=old")){
			response.sendRedirect("show.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
			//response.sendRedirect("adfs.jsp");
		}else{
			response.sendRedirect("adfsNewVehicle.jsp"); //main.jsp?keyCodeV=old
		}
	}
	else{
		reqParam=request.getParameter("errorMessage");
	}
}catch(Exception el){
	
	reqParam=request.getParameter("errorMessage");
	//response.sendRedirect("https://corpqa.sts.ford.com/adfs/oauth2/authorize?response_type=code&client_id=urn:archwayvehicleownership:clientid:web_vehicle_ownership:qa&resource=urn:archwayvehicleownership:resource:web_vehicle_ownership:qa&redirect_uri=https://wwwqa.ownerverification.dealerconnection.com/");
	//window.location.href = "https://corpqa.sts.ford.com/adfs/oauth2/authorize?response_type=code&client_id=urn:archwayvehicleownership:clientid:web_vehicle_ownership:qa&resource=urn:archwayvehicleownership:resource:web_vehicle_ownership:qa&redirect_uri=https://wwwqa.ownerverification.dealerconnection.com/";
}
%>
<FORM name="login" METHOD="post" ACTION="newAdfs.jsp">

<input type="hidden" name ="grant_type" id="grant_type" value="authorization_code"/>
<input type="hidden" name ="code" id="code" value=""/>
<input type="hidden" name ="client_id" id="client_id" value="urn:archwayvehicleownership:clientid:web_vehicle_ownership:qa"/>
<input type="hidden" name ="resource_id" id="resource_id"  value="urn:archwayvehicleownership:resource:web_vehicle_ownership:qa"/>
<input type="hidden" name ="redirect_uri" id="redirect_uri" value="https://www.ownerverification.dealerconnection.com/keycode/adfs.jsp"/>
<input type="hidden" name ="auth_url" id="auth_url" value="https://corp.sts.ford.com/adfs/oauth2/authorize"/>
<input type="hidden" name ="response_type" id="response_type" value="token"/>

<input type="button" onclick="window.location.href = redirectUrl">

<script>
	
	if(token == null){
		
		window.location.href =  "https://corp.sts.ford.com/adfs/oauth2/authorize?response_type=token&client_id=urn:archwayvehicleownership:clientid:web_vehicle_ownership:prod&resource=urn:archwayvehicleownership:resource:web_vehicle_ownership:prod&redirect_uri=https://www.ownerverification.dealerconnection.com/" ;
		
		/*//var redirectUrl = <% ConfigurationServlet.getApplicationProperty("adfs_url");%>;
									//+"?response_type="+ <%ConfigurationServlet.getApplicationProperty("response_type");%>
									//+"&client_id="+ <%ConfigurationServlet.getApplicationProperty("client_id");%>
									//+"&resource="+ <%ConfigurationServlet.getApplicationProperty("audience.id");%>
									//+"&redirect_uri="+ <%ConfigurationServlet.getApplicationProperty("HOME_URL");%> ;
									
									
		var redirectUrl = 	document.getElementById("auth_url").value + "?response_type=" + document.getElementById("response_type").value
							+"&client_id="+document.getElementById("client_id").value
							+"&resource="+document.getElementById("resource_id").value
							+"&redirect_uri="+document.getElementById("redirect_uri").value;
		console.log(redirectUrl);
		
		//window.location.href = redirectUrl;*/
	}else{
		document.getElementById("code").value = token;
		document.login.submit();
	}
	
</script>

</FORM>
