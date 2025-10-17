<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>

<jsp:useBean id="collectCookieInformationBean" scope="session" class="com.archway.estore.wslx.CollectCookieInformationBean"/>
<jsp:setProperty name="collectCookieInformationBean" property="*" />

<%
collectCookieInformationBean.toString(); 
collectCookieInformationBean.LogCookieInformationToLogFile(request); 
session.setAttribute("WSLXBEAN",collectCookieInformationBean );
//response.sendRedirect("newVehicle.do?pacode="+collectCookieInformationBean.getOrg ()+"&acl=FORD&wsl="+collectCookieInformationBean.getUser());
%>

    

<form name="newVeh" method="post" action="newVehiclePage1.do?pacode=<%=collectCookieInformationBean.getOrg ()%>&acl=FORD&wsl=<%=collectCookieInformationBean.getUser()%>">

</form>

<script language="javascript">
  document.newVeh.submit();
</script>