<%@page import="com.archway.estore.wslx.ADFSCookieBean"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="com.archway.estore.util.ADFSValidationTest"%>
<!-- 
/*
**************Start ADFS Cookie Information Information per User*************************
Issued					--> 
Expires					--> 
Issuer					--> 
User						--> hvictory
IP						--> 
ACI						--> Employee
Site						--> 
OrgCode					--> USA
EmpCode					--> F
Role						--> N
Org						--> 5036
Company 					--> Ford Motor Company of US
DivAbbr 					--> null
**************End ADFS Cookie Information Information per User*************************
*/
-->
<%
	String adfsCredential = "";
	String Issued = "";
	String Expires = "";
	String Issuer = "";
	String User = "hvictory";
	String ACI = "Employee";
	String Site = "";
	String OrgCode = "USA";
	String EmpCode = "F";
	String Role = "N";
	String Org = "5036";
	String Company = "Ford Motor Company of US";
	String DivAbbr = "";
	String empCode = "";
	String loginID = "";
	String errorMessage = "";
	
	
	adfsCredential = "";
	
	ADFSValidationTest adfsTokenValidation = new ADFSValidationTest(adfsCredential);
	ADFSCookieBean adfsCookieData = new ADFSCookieBean();
	adfsCookieData = adfsTokenValidation.validateAdfsToken();
	
/*	Cookie[] cookies = request.getCookies();
	
	for (Cookie aCookie : cookies) {
		String name = aCookie.getName();
	 
		if (name.equals("ADFS-credential")) {
			adfsCredential = aCookie.getValue();
			break;
		}
	}
	
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
		out.println("ADFS-Credential Cookie Expired/Not Present. Please login again");
	} */
%>

<FORM name="login" METHOD="get" ACTION="https://www.ownerverification.dealerconnection.com/keycode/index.jsp">

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