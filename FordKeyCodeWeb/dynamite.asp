<%
'-----------------------------------------------------------------------------
'
' Web Single Login Validate COM Object v4.0 - Sample ASP Script
' http://www.cns.ford.com/wsl

' October 28, 2005
'
' Copyright (c) 2005 Ford Motor Company. All rights reserved.
'
'-----------------------------------------------------------------------------

' Require all variables to be declared
Option Explicit

' Declare variables
Dim strWslCookie, strValues, strCookie, blnValid, intReason, intCount
Dim strName, intTime, dtTime, strIssuer, strIssuers, strAttrNames, strValue
Dim h1, h2 , Issued , Expires, Issuer , User , IP, ACI , Site , OrgCode , EmpCode , Role , Org , Company ,  DivAbbr

' Reference to the Validate COM object
Dim objValidate





' Create instance of the COM object
Set objValidate = Server.CreateObject("FordWSL.Validate")

' Set the Public Key.  You can either pass this a single filename or if you
' need to accept cookies signed with more than one key, pass in an array of
' filenames.  For example:
'    Dim strPubKeys(1)
'    strPubKeys(0) = "c:\inetpub\wsl4\wsl-internal.pem"
'    strPubKeys(1) = "c:\inetpub\wsl4\wsl-b2b.pem"
'    objValidate.PublicKeys = strPubKeys
objValidate.PublicKeys = "D:\Tomcat7.0\wslx\wslx-dlrconn.pem"

' Set the Remote IP address.  This is to perform IP address validation
' against the cookie.  If you do not set this, IP checking is not performed,
' which weakens the security of the cookie.
objValidate.RemoteIP = Request.ServerVariables("REMOTE_ADDR")

' Get the Ford-WSL cookie from the HTTP_COOKIE server variable. Do not use
' Request.Cookies("WSL-credential") as it might return' the cookie in URL
' encoded format.
For Each strCookie In Split(Request.ServerVariables("HTTP_COOKIE"), ";")
	strValues = Split(strCookie, "=", 2)
	If Trim(strValues(0)) = "WSLX-credential" Then strWslCookie = Trim(strValues(1))
Next

' Set the cookie property.  If a cookie wasn't found, we'll catch that in the
' next step.
objValidate.Cookie = strWslCookie

' Now validate the cookie
blnValid = objValidate.ValidateCookie

' Was the cookie valid?
if blnValid Then

	'
	' Yes, we have a valid cookie!  Let's display the contents
	'

	'Response.Write("<b>Cookie is valid!</b><br>")

	' Retrieve and display the issue time and expire time
	intTime = objValidate.IssueTime      ' seconds past EPOCH (Unix Time)
	dtTime = objValidate.IssueDateTime   ' DATETIME variant

	'Response.Write("issuetime = " & dtTime & " (" & intTime & ")<br>")

	intTime = objValidate.ExpireTime     ' seconds past EPOCH (Unix Time)
	dtTime = objValidate.ExpireDateTime  ' DATETIME variant

	'Response.Write("expiretime = " & dtTime & " (" & intTime & ")<br>")

	' Display the issuers
	strIssuers = objValidate.Issuers     ' Returns array of issuers
	For intCount = 0 to UBound(strIssuers)

		'Response.Write("issuer" & intCount & " = " & strIssuers(intCount) & "<br>")
	Next

	' Retrieve all the attribute names in the cookie
	strAttrNames = objValidate.AttributeNames   ' Returns arry of attribute names

	' Display each of the attribute names and values
	For Each strName in StrAttrNames
		' Get the value for this attribute name
		strValue = objValidate.Attribute(strName)
		' Display it
		'Response.Write(strName & " = " & strValue & "<br>")


						if strName = "issuetime" then
							Issued = strValue
						 end if

						 if strName = "expiretime" then
							Expires = strValue
						 end if

						 if strName = "Issuer" then
							Issuer = strValue
						 end if

						 if strName = "userid" then
							User = strValue
						 end if

						 if strName = "ipaddr" then
							IP = strValue
						 end if

						 if strName = "acigroup" then
							ACI = strValue
						 end if



						 if strName = "orgcode" then
							OrgCode = strValue
						 end if

						 if strName = "empcode" then
							EmpCode = strValue
						 end if

						 if strName = "mrrole" then
							Role = strValue
						 end if

						 if strName = "org" then
							Org = strValue
						 end if

						 if strName = "company" then
							Company = strValue
						 end if

						 if strName = "divabbr" then
							DivAbbr = strValue
						end if

						if strName = "empcode" then
						h1 = strValue
						end if

						if strName = "org" then
							h2 = strValue
				end if






	Next


Else

	' No...  Now, you can optionally find out WHY the cookie was invalid. These
	' reasons correspond with the WSL_VALIDTY_STATUS codes found in wsl4.h.
	' These values are duplicated below for your convenience:
	'    #define WSL_COOKIE_NONE            0
	'    #define WSL_COOKIE_INVALID         1
	'    #define WSL_COOKIE_EXPIRED         2
	'    #define WSL_COOKIE_SIG_INVALID     3
	'    #define WSL_COOKIE_WRONG_IP        4
	'    #define WSL_COOKIE_VALID           5
	intReason = objValidate.Validity

	' Display appropriate error message.
	Select Case intReason
		Case 0
			'Response.Write("<b><font color='red'>No cookie!</font></b><br>")
		Case 1
			'Response.Write("<b><font color='red'>Cookie is invalid!</font></b><br>")
		Case 2
			'Response.Write("<b><font color='red'>Cookie has expired!</font></b><br>")
		Case 3
			'Response.Write("<b><font color='red'>Cookie has invalid signature!</font></b><br>")
		Case 4
			'Response.Write("<b><font color='red'>Cookie has wrong IP address!!</font></b><br>")
	End Select

End If

%>
<FORM name="login" METHOD="get" ACTION="https://wwwqa.ownerverification.dealerconnection.com/keycode/index.jsp">

<input type=hidden name ="issued" value="<%=Issued%>">
<input type=hidden name ="expires" value="<%=Expires%>">
<input type=hidden name ="issuer" value="<%=Issuer%>">
<input type=hidden name ="user" value="<%=User%>">
<input type=hidden name ="ip" value="<%=IP%>">
<input type=hidden name ="aci" value="<%=ACI%>">
<input type=hidden name ="site" value="<%=Site%>">
<input type=hidden name ="orgCode" value="<%=OrgCode%>">
<input type=hidden name ="empCode" value="<%=EmpCode%>">
<input type=hidden name ="role" value="<%=Role%>">
<input type=hidden name ="org" value="<%=Org%>">
<input type=hidden name ="company" value="<%=Company%>">
<input type=hidden name ="divAbbr" value="<%=DivAbbr%>">
<input type=hidden name ="empCode" value="<%=h1%>">
<input type=hidden name ="loginID" value="<%=h2%>">

<script language="javascript">
  document.login.submit();
</script>


</FORM>
