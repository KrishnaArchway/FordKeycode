<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<form name="homePageForm" method="post" action="">
<div class="ui-widget">
	<div class="ui-widget-header section-header"><bean:message key="showHomePage.label.information"/></div>
		<div class="ui-widget-content" style="min-height: 300px">
			<br>
           	<table border="0" cellpadding="0" cellspacing="0" width="100%">
 					<tr>
	   					<td width="100%" style="padding-left:2em;padding-right:5em;">
	   						<bean:message key="showHomePage.label.information.message1"/>
	   					</td>
 					</tr>
 					<tr>
	   					<td width="100%">&nbsp;</td>
 					</tr>
 					<tr>
	   					<td width="100%" style="padding-left:3em;padding-right:5em;">
	   						<ul>
								  <li style="color:#1d5987;height:1.5em;">
								  	<a href="#link1" style="color: #1d5987;">
								  		<bean:message key="showHomePage.label.information.link1"/>							  		
								  	</a>
								  	<div id="link1" class="ui-helper-hidden" title="<bean:message key="showHomePage.label.information.link1"/>">
										<p><bean:message key="showHomePage.label.information.link1.msg"/></p>
									</div>
								  </li>
								  <br>
								  <li style="color:#1d5987;height:1.5em;">
								  	<a href="#link2" style="color: #1d5987;">
								  		<bean:message key="showHomePage.label.information.link2"/>
								  	</a>
								  	<div id="link2" class="ui-helper-hidden" title="<bean:message key="showHomePage.label.information.link2"/>">
										<p><bean:message key="showHomePage.label.information.link2.msg"/></p>
									</div>
								  </li><br>
								  <li style="color:#1d5987;height:1.5em;">
								  	<a href="#link3" style="color: #1d5987;">
								  		<bean:message key="showHomePage.label.information.link3"/>
								  	</a>
								  	<div id="link3" class="ui-helper-hidden" title="<bean:message key="showHomePage.label.information.link3"/>">
										<p><bean:message key="showHomePage.label.information.link3.msg"/></p>
									</div>
								  </li><br>
								  <li style="color:#1d5987;height:1.5em;">
								  	<a href="#link4" style="color: #1d5987;">
								  		<bean:message key="showHomePage.label.information.link4"/>
								  	</a>
								  	<div id="link4" class="ui-helper-hidden" title="<bean:message key="showHomePage.label.information.link4"/>">
										<p><bean:message key="showHomePage.label.information.link4.msg"/></p>
									</div>
								  </li><br>
								  <li style="color:#1d5987;height:1.5em;">
								  	<a href="#link5" style="color: #1d5987;">
								  		<bean:message key="showHomePage.label.information.link5"/>
								  	</a>
								  	<div id="link5" class="ui-helper-hidden" title="<bean:message key="showHomePage.label.information.link5"/>">
										<p><bean:message key="showHomePage.label.information.link5.msg"/></p>
									</div>
								  </li><br>
							</ul>
	   					</td>
 					</tr>
 					<tr><td width="100%">&nbsp;</td></tr>
 					<!-- <tr><td width="100%">&nbsp;</td></tr>
 					<tr><td width="100%">&nbsp;</td></tr>
 					<tr><td width="100%">&nbsp;</td></tr>
 					<tr><td width="100%">&nbsp;</td></tr>
 					<tr><td width="100%">&nbsp;</td></tr>-->
 					<tr>
	   					<td width="100%" style="padding-left:2em;padding-right:5em;"><bean:message key="showHomePage.label.information.message2"/></td>
 					</tr>
			</table>
               
             <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <!-- <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div> <div class="clear"></div>-->
			 <div class="spacer"></div> <div class="clear"></div>
			 <div class="spacer"></div>
         </div>
	</div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  		<tr>
    		<td width="50%" align="center">
      			<p align="center">
      				<div class="buttons ui-widget">
                		<!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer(this.form)"><bean:message key="back.to.fmcdealer.com"/></button> -->
                		<input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />
                		
                	</div>
            </td>
    		<td width="50%" align="center">
     	 		<p align="center">
     	 			<div class="buttons ui-widget">
     	 				<!-- <button id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:nextFunction(this.form)"><bean:message key="showHomePage.label.next.button"/></button> -->
     	 				<input type="button" id="<bean:message key="showHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:nextFunction(this.form)" value="<bean:message key="showHomePage.label.next.button"/>" />
     	 			</div>
     	 	</td>
  		</tr>
	</table>
</div>
</form>


<script language="javascript">

	function nextFunction(formObj)
	{
		$(".ui-dialog-content").dialog("close");		
		formObj.action='vin.do';
		formObj.submit();
	}
	
	function goToFMCDealer(formObj)
	{
		formObj.action='fmcDealer.do';
		formObj.submit();
	}
	

	$(function() {
          $( 'a' ).on( 'click', function( e ) {
          		$(".ui-dialog-content").dialog("close");
          		var dialogId = $(this).attr('href');
                e.preventDefault();
               	$(dialogId).dialog({ maxWidth:500,
								     maxHeight: 'auto',
								     width: 500,
								     height: 'auto'});
          });		  
    });
</script>            