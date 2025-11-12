<%@ page import="java.util.*" %>
<%@ page import="com.archway.estore.wslx.CollectCookieInformationBean"%>
<%@ page import="com.archway.estore.session.SessionBean"%>

<jsp:useBean id="collectCookieInformationBean" scope="session" class="com.archway.estore.wslx.CollectCookieInformationBean"/>
<jsp:setProperty name="collectCookieInformationBean" property="*" />
<%
String reqParam	= "";
String org1 = "";

reqParam = request.getParameter("keyCodeV");

session.setAttribute("currPage","main.jsp?keyCodeV="+reqParam );

try{
	SessionBean sb = (SessionBean) session.getAttribute("SessionBean");	
	 org1 = ((CollectCookieInformationBean)session.getAttribute("WSLXBEAN" )).getOrg();
}catch(Exception exx){
	//response.sendRedirect("index.jsp");
}
//out.println("org1 :: " + org1);
try{
	
	if(reqParam == null || "".equalsIgnoreCase(reqParam)   || org1.equals(null) || org1.equals("")  ){
		response.sendRedirect("index.jsp");
		
%>
<html lang="us">
<head>
	<title>Ford Motor Company (KeyCode Registration Website)</title>
	
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
	
	<meta http-equiv="content-type" content="application/xhtml+xml; charset=utf-8">
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

 <div class="header ui-widget">
 <table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr>
    <td width="12%"><img border="0" src="images/ford.jpg" width="186" height="97"></td>
    <td width="88%"><h1><font color="#000000">Vehicle Ownership Verification</font></h1></td>
  </tr>
</tbody></table>
 </div>
 <div class="clear"></div>
 <div class="spacer"></div>
<div class="content-main">
	







<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
		<div class="ui-widget-content" style="min-height: 300px">
			<br>
           	
           	
           	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tbody><tr>
		    <td width="100%" colspan="3">
		      <p align="center"><font size="5">UNAUTHORIZED ACCESSING RESOURCES SECURE KEY CODE</font></p></td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3">&nbsp;</td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3" align="center">
		      <p align="center">Check the app accessing URL</p></td>
		  </tr>
		  <tr>
		    <td width="100%" colspan="3">&nbsp;</td>
		  </tr>
		  <tr>
  		    <td width="100%" colspan="3">&nbsp;</td>
		  </tr>
		  <tr>
  		    <td width="100%" colspan="3">&nbsp;</td>
		  </tr>
           <tr>
  		    <td width="100%" colspan="3">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tbody><tr>
			    <td width="100%" colspan="2" align="center"><p align="center"><font color="red" size="4">Mandatory Parameter missing.</font></p></td>
			  </tr>
			  <tr>
			    <td width="100%" colspan="2">&nbsp;</td>
			  </tr>
			</tbody>
			</table>
			
			
			
			</td>
  </tr>	
			</tbody></table>

               
             <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div>
         </div>
	</div>
   
</div>
 <div class="clear"></div>
 <div class="spacer"></div>
 	
 <div class="footer ui-widget">
 			 
			<table width="100%" style="color:#999999">
				<tbody>
					<tr>
						<td align="center">
							Copyright &copy; 2005-<script>document.write(new Date().getFullYear())</script>
						</td>
					</tr>
				</tbody>
			</table>	
		
			
 </div>	
          
 </body></html>
 <%	
	}else{
		if (reqParam.equalsIgnoreCase("null") || reqParam.equalsIgnoreCase("")){
			response.sendRedirect("index.jsp");
		}else{
			if (reqParam.equalsIgnoreCase("old")){
				response.sendRedirect("adfs.jsp");
			}
			else {
				session.setAttribute("currPage","main.jsp?keyCodeV="+reqParam );
				response.sendRedirect("adfsNewVehicle.jsp");
			}
		}
	}
}
catch (NullPointerException e)
{
   throw e;
}
%>