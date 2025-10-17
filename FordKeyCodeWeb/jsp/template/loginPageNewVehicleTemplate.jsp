<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ page import="com.archway.estore.session.SessionBean"%>

<!doctype html>
<html lang="us">

<head>
	<title><bean:message key="loginPageTemplate.label.title"/></title>
	
	<link href="css/redmond/jquery-ui-1.10.2.custom.css" rel="stylesheet">
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/jquery-ui-1.10.2.custom.js"></script>

    
    <script type="text/javascript" src="js/f_default.js"></script>
    
     <script type="text/javascript" src="js/util.js"></script>
      <script type="text/javascript" src="js/global.js"></script>
       <script type="text/javascript" src="js/window.js"></script>
    
    <script type="text/javascript" src="js/fSimpleValidation.js"></script>
    <script type="text/javascript" src="js/validation.js"></script>
	<script type="text/javascript" src="js/calendar.js"></script>
	
	<meta http-equiv="content-type" content="application/xhtml+xml; charset=utf-8" />
	<meta name="authors" content="Amar Bhatt">
	
	
	 <script language="javascript" type="text/javascript">
        $(function() {
            $( "#accordion" ).accordion();
            $( ".JQueryButton" ).button();
            $( "#dialog" ).dialog({
                autoOpen: false,
                width: 400,
                modal: true,
                buttons: [
                    {
                        text: "Close",
                        click: function() {
                            $( this ).dialog( "close" );
                        }
                    }/*,
                    {
                        text: "Cancel",
                        click: function() {
                            $( this ).dialog( "close" );
                        }
                    }*/
                ]
                });

            // Link to open the dialog
            $("#dialog-link").click(function (event) {
                $("#dialog").dialog("open");
                event.preventDefault();
            });
        });
    </script>
    <style type="text/css">
        body{
            width: 1100px;
            margin-left: auto;
            margin-right: auto;
            font-size: 75%;
            font-family: Verdana,Arial,sans-serif;
        }
        
        
        
        
        .header
        {
            height: 100px;
            border-top: 1px solid #dedede;
            border-bottom: 1px solid #dedede;
            text-align: left;
            color: #dedede
        }
        .footer
        {
            height: 100px;
            border-top: 1px solid #dedede;          
            text-align: center;
            color: #dedede;
        }
        .content
        {
        }
        .content-left-panel
        {
            width: 200px;
            float: left;
        }
        .content-main
        {
            width: 1100px;
            float: right;
        }
        .section-header
        {
            padding: 5px 0px 5px 5px;
        }
        .clear
        {
            clear: both;
        }
        .spacer
        {
            height: 0.75em;
        }
        .buttons
        {
            //border-top: 1px solid #cccccc;
            padding-top: 10px;
            margin-top: 10px;
        }
    </style>
	
	
</head>
<body>

<%
if(((SessionBean) session.getAttribute("SessionBean"))== null)
{
	%>
	<script language="javascript">
		window.location.href = "sessionExpired.do";
	</script>
	<%
}
%>
	
<tiles:insert name="header" />
<div class="content-main">
	<tiles:insert name="content" />
</div>
<tiles:insert name="footer" />	
</body>          
</html> 