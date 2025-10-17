<%@ page import = "java.io.*,java.util.*" %>
<html>
   <head>
      <title>Page Redirection</title>
   </head>
   <body>
      <center>
         <h1>Page Redirection</h1>
      </center>
      <%
         // New location to be redirected
         String site = new String("https://corpqa.sts.ford.com/adfs/oauth2/authorize?response_type=code&client_id=urn:archwayvehicleownership:clientid:web_vehicle_ownership:qa&resource=urn:archwayvehicleownership:resource:web_vehicle_ownership:qa&redirect_uri=https://wwwqa.ownerverification.dealerconnection.com/");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site);
      %>
   </body>
</html>