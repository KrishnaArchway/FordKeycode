<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<div class="ui-widget">
                <div class="ui-widget-header section-header"><bean:message key="preShowHomePage.label.information"/></div>
                <div class="ui-widget-content" style="min-height: 300px">
                <br>
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td width="100%">
    
    
    
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td width="100%" colspan="3">
      <p align="center"><font size="5">SECURE KEY CODE ACCESS</font></td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">
      <p align="center">Note the Process for obtaining a Vehicle Key Code</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%">&nbsp;</td>
    <td width="1%">
      <p align="right"><img border="0" src="images/arrow4Pre.gif" width="21" height="14"></td>
    <td width="116%">Key Code Access requires that a Vehicle Ownership Record is entered in the Verification database</td>
  </tr>
  <tr>
    <td width="1%">&nbsp;</td>
    <td width="1%">
      <p align="right"><img border="0" src="images/arrow4Pre.gif" width="21" height="14"></td>
    <td width="116%">New Information Required: A Vehicle Repair Order # and the open date of the Repair Order</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">A dealership <font color="#FF0000"> Repair Order # is now required</font> for every key code request made.  If the key code is used to cut a replacement/duplicate key, the RO should include the Labor Ops code: PATS (Passive Anti-Theft System) indicating that a cut key was programmed for the vehicle owner.  If the key code is being used for cylinder calibration, the RO should reflect this work</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">In the event of a dealership audit, the information on the RO (including the PATS Labor Op code "or" cylinder-related work) must match the vehicle owner's name on the vehicle title and/or registration.  Any inappropriate use of vehicle key code information contrary the Ford Key Code Usage Policy as set out in the Key Code Request Terms of Agreement may result in your dealership losing key code access.<font color="#FF0000"> You are required to retain copies</font> of proper vehicle ownership documentation:</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="14%">&nbsp;</td>
    <td width="11%">
      <p align="center">A.</td>
    <td width="75%">A completed and signed Vehicle Ownership Verification Form. <a href="pdf/Vehicle_Ownership_Verification_Form.pdf" target="_blank">PDF of Blank Vehicle Ownership Form</a></td>
  </tr>
  <tr>
    <td width="14%">&nbsp;</td>
    <td width="11%">
      <p align="center">B.</td>
    <td width="75%">At least one of the following: Vehicle Registration, Title and/or Certificate of Insurance</td>
  </tr>
  <tr>
    <td width="14%">&nbsp;</td>
    <td width="11%">
      <p align="center">C.</td>
    <td width="75%">A copy of the Vehicle Owner/Representative Driver's License</td>
  </tr>
  <tr>
    <td width="14%">&nbsp;</td>
    <td width="11%">&nbsp;</td>
    <td width="75%">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" colspan="3">&nbsp;If you do not have this information, please return to FMCDealer.com</td>
  </tr>
</table>
    

     
    </td>
  </tr>
</table>
                
                 <div class="clear"></div>
 
 <div class="spacer"></div>
                </div>
            </div>
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td width="50%" align="center">
      <p align="center"><div class="buttons ui-widget">
         <!-- <button id="btnSampleButton" class="JQueryButton" onclick="javascript : goToFMCDealer()" ><bean:message key="back.to.fmcdealer.com"/></button> -->
         <input type="button" id="btnSampleButton" class="JQueryButton" onclick="javascript:goToFMCDealer(this.form)" value="<bean:message key="back.to.fmcdealer.com"/>" />       
      </div>
    </td>
    <td width="50%" align="center">
      <p align="center"><div class="buttons ui-widget">
     		<button id="<bean:message key="preShowHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:nextFunction()"><bean:message key="showHomePage.label.next.button"/></button>
     		<input type="button" id="<bean:message key="preShowHomePage.label.next.button"/>" class="JQueryButton" onclick="javascript:nextFunction()" value="<bean:message key="showHomePage.label.next.button"/>" />
      </div>
    </td>
  </tr>
</table>
            
               
            </div>
<script language="javascript">

function goToFMCDealer(){
	window.location.href = 'fmcDealer.do?actionType=preShow&redirectTo=cancelMsg';
}

function nextFunction()
{
	window.location.href = 'show2.do';
}
</script>            