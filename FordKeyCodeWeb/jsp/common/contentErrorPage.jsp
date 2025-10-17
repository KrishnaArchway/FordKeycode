<%@ page  buffer="0kb"
         errorPage="error.do" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>


<link href="css/main.css" rel="stylesheet" type="text/css" />

<body>

<form name="errorPage" method="post" >

<div class="ui-widget">
      <div class="ui-widget-header section-header">
     	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
 				<td colspan="2">Error</td>
			</tr>
		 </table>
      </div>
    
       
      <div class="ui-widget-content" style="min-height: 300px">   <br>
      	<table border="0" cellpadding="0" cellspacing="0" width="100%">
      			<tr>
  					<td colspan="3"  style="padding-left : 30px;"><h4>
  						<font face="arial,verdana,helvetica"  color="red" size="2">
							   <br>Our System is experiencing difficulty, Please try later
						  		</font>				  
						<hr size="2">
  					</td>  					
				</tr>
		</table>        
       </div>
 </div>
	                  
</form>

</body>


