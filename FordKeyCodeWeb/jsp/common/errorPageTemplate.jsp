<%@ page isErrorPage="true" %>
<%@ page import="com.archway.estore.common.Logger" %>
<%@ taglib uri='/tags/struts-tiles' prefix='tiles' %>
<%@ taglib uri='/tags/struts-logic' prefix='logic' %>
<%
   Logger logger = Logger.getLogger(getClass());
   logger.entering("errorPageTemplate.jsp");
   
   try
   {
%>
<HTML>
  <HEAD>
<tiles:insert name="script" />
  <TITLE><%=com.archway.estore.common.ConfigurationServlet.getApplicationProperty("APPLICATION_NAME")%> - <tiles:getAsString name="title" /></TITLE>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link href="css/main.css" rel="stylesheet" type="text/css" />
  </HEAD>
  <BODY BGCOLOR="#FFFFFF"  marginwidth=0 marginheight=0 leftmargin=0 topmargin=0>

    <table  width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
    <tr>
     
      <td valign="top">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr valign="top">
            <td  colspan="2" valign="top">
              <tiles:insert name="content" />
            </td>
          </tr>
          <tr>
            <td colspan="2">&nbsp;</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
<tiles:insert name="footer" />
  </BODY>
</HTML>

<%-- INTENDED TEMPLATE LAYOUT
-------------------------------
|            header           |
|-----------------------------|
|   |                         |
| m |                         |
| e |       content           |
| n |                         |
| u |                         |
|   |                         |
|   |-------------------------|
|   |     footer.jsp          |
-------------------------------

script is a javascript source containing all common javascript for pages.
header contains top navigation and is part of our branding area.
menu displays in a column along the left side of the page between 
the header and footer and is part of our branding area.
content displays right of menu.
footer displays below the menu and content.  This area is also variable based on rebrandings, but doesn't include graphics or color.
--%>
<%
   }
   catch (Exception e)
   {
      logger.error("Error encountered in errorPageTemplate.jsp", e);
      throw e;
   }
   finally
   {
      logger.exiting("errorPageTemplate.jsp");
   }
%>