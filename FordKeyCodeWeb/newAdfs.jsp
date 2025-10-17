<%@page import="com.archway.estore.wslx.ADFSCookieBean"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="com.archway.estore.util.ADFSValidation"%>

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
	
	
	
	adfsCredential = request.getParameter("code");
	session.setAttribute("TOKEN",adfsCredential );
	
	
	
	ADFSCookieBean adfsCookieData = new ADFSCookieBean();
	
	if(!adfsCredential.isEmpty()){
		
		ADFSValidation adfsTokenValidation = new ADFSValidation(adfsCredential);
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
		//out.println("ADFS-Credential Cookie Expired/Not Present. Please login again" );
		out.println("Please wait while we load the page. ");
	} 
%>

<FORM name="login" METHOD="get" ACTION="newindex.jsp">

<input type=hidden name ="issued" value="<%=Issued%>">
<input type=hidden name ="expires" value="<%=Expires%>">
<input type=hidden name ="issuer" value="<%=Issuer%>">
<input type=hidden name ="user" value="<%=User%>">
<input type=hidden name ="aci" value="<%=ACI%>">
<input type=hidden name ="site" value="<%=Site%>">
<input type=hidden name ="orgCode" value="<%=OrgCode%>">
<input type=hidden name ="empCode" value="<%=EmpCode%>">
<input type=hidden name ="role" value="<%=Role%>">
<input type=hidden name ="org" value="<%=Org%>">
<input type=hidden name ="company" value="<%=Company%>">
<input type=hidden name ="divAbbr" value="<%=DivAbbr%>">
<input type=hidden name ="empCode" value="<%=empCode%>">
<input type=hidden name ="loginID" value="<%=loginID%>">
<input type=hidden name ="errorMessage" value="<%=errorMessage%>">



<script language="javascript">
  document.login.submit();
</script>

</FORM>