<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<%@ page import="com.archway.estore.util.StringUtility"%>
<%@ page import="com.archway.estore.session.SessionBean"%>
        
<%
	int 	tabIndex 			= 	1;
	String 	vin 				= 	null ;
	String 	registeredVehicle 	= 	null ;
	
	String isVinExist = null ;
	SessionBean	sb	=	(SessionBean)session.getAttribute("SessionBean");
	
	if(request.getAttribute("VIN_EXIST") != null ){
		isVinExist = (String) request.getAttribute("VIN_EXIST") ;
	}
	
	vin = sb.getVin() ;
	registeredVehicle = sb.getRegisteredVehicleToWhom();	

%>
<div class="ui-widget">
	<div class="ui-widget-header section-header">&nbsp;</div>
	<div class="ui-widget-content" style="min-height: 300px">
		<br>
		<form name="vinNewVehicleForm" method="post" action="newVehiclesubmittedBy.do">
			<input type="hidden" name="actionType" id="actionType" value=""/>
			<input type="hidden" name="vinNum" id="vinNum" value=""/>
			<table width="100%" align="center" cellpadding="2" cellspacing="2">
				
				<tr>
					<td align="center"><b>New Vehicle Key Code requests made this month: <font color="#FF0000"><b><%=sb.getNewVehCounter()%> of 10 (Limit)</b></font></td>
				</tr>
				
				<tr>
					<td align="left">&nbsp;</td>
				</tr>
				
				<tr>
					<td align="left">Enter the VIN of the stock unit for the key code request about to be made:</td>
				</tr>
				
				<tr>
					<td>
						<table width="50%" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<input  type="text"	id="vinNVNumber1"	name="vinNVNumber1" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber2', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber2"	name="vinNVNumber2" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber3', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber3"	name="vinNVNumber3" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber4', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber4"	name="vinNVNumber4" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber5', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber5"	name="vinNVNumber5" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber6', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber6"	name="vinNVNumber6" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber7', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber7"	name="vinNVNumber7" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber8', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber8"	name="vinNVNumber8" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber9', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber9"	name="vinNVNumber9" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber10', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber10"	name="vinNVNumber10" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber11', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber11"	name="vinNVNumber11" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber12', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber12"	name="vinNVNumber12" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber13', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber13"	name="vinNVNumber13" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber14', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber14"	name="vinNVNumber14" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber15', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber15"	name="vinNVNumber15" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber16', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber16"	name="vinNVNumber16" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'vinNVNumber17', event)">
								</td>
								
								<td>
									<input  type="text"	id="vinNVNumber17"	name="vinNVNumber17" size="2"	MaxLength="1" value=""	tabindex="<%=tabIndex++ %>"   style="WIDTH: 20px;" onkeypress="checkVal(this.id, event)" onkeyup="movetoNext(this, this.id, 'dealerVehicleMake', event)" onblur="javascript:validateKeycode(this.form)">
								</td>
								
							</tr>
						</table>
						<span id="itemLoader" />
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				
				<tr>
					<td>
						<table width="70%" align="center" cellpadding="0" cellspacing="0">				
							<tr>
								<td  align="right">Make</td>
								<td  align="center"><b>:</b></td>
								<td  align="left">	
									<select id="dealerVehicleMake"	name="dealerVehicleMake" value=""	tabindex="<%=tabIndex++ %>"   style="text-transform:uppercase" >
										<option value="FORD">FORD</option>
										<option value="LINCOLN">LINCOLN</option>
										<option value="MERCURY">MERCURY</option>
									</select>
								</td>
							</tr>			
							
							<tr>
							    <td width="18%" align="right">Year</td>
							    <td width="4%" align="center"><b>:</b></td>
							    <td  align="left">	
									<input type="text" id="dealerVehicleYear" name="dealerVehicleYear"	size="5" MaxLength="4"	value="" tabindex="<%=tabIndex++ %>"  style="text-transform:uppercase"
									onkeyup="javascript : checkNumericInput(this)">
							    </td>
							</tr>						
							
							<tr>
								<td  align="right">Model</td>
								<td  align="center"><b>:</b></td>
								<td  align="left">	
									<input type="text" id="dealerVehicleModel"	name="dealerVehicleModel" size="20"	MaxLength="20"	value="" tabindex="<%=tabIndex++ %>"  style="text-transform:uppercase" >
								</td>
							</tr>				
						</table>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>Please describe the circumstances involved as to why your dealership needs the key code data for the VIN listed above: </td>
				</tr>
				<tr>
					<td align="center">
						<textarea rows="10" cols="80" id="dealerVehicleInfo" name="dealerVehicleInfo"></textarea>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>I am proceeding into the Ford Key Code application for the purpose of obtaining the Key Code on only New Vehicle Inventory (a Stock Unit) at my dealership.</td>
				</tr>
				<tr><td align="center"><input type="checkbox" name="agreementCheck" id="agreementCheck" value="Yes"></>I Agree</td></tr>
				
				
				<tr>		
					<td width="50%" align="center">      
				     <p align="center">
				     <div class="buttons ui-widget">      
				      	<input type="button" id="btnNextButton" class="JQueryButton" value="Submit" onClick="javascript:return ConfirmFrm(this.form)"/>
				     </div></td>
				
				</tr>
				
				<tr>		
					<td width="50%" align="center">      
				     <p align="center">
				<!-- Questions/additional assistance - please contact Jerry Flemming (<a href="mailto:jflemmin@ford.com">jflemmin@ford.com</a>) -->
				</td>
				
				</tr>
				
			</table>
		</form>
	</div>
</div>

<script>
function ConfirmFrm(formObj)
{
	if(validateKeycode(formObj)==true && validateFrm(formObj)==true)
	{		
		formObj.actionType.value='validateData';
		formObj.submit();
	}
		
	else
	{
		return false;	
	}	
}

function validateFrm(formObj)
{
	if(document.getElementById('dealerVehicleYear').value=='')
	{
		alert('Please Enter Vehicle Year value');
		document.getElementById('dealerVehicleYear').focus();
		return false;		
	}
	if(document.getElementById('dealerVehicleMake').value=='')
	{
		alert('Please Enter Vehicle Make value');
		document.getElementById('dealerVehicleMake').focus();
		return false;		
	}
	if(document.getElementById('dealerVehicleModel').value=='')
	{
		alert('Please Enter Vehicle Model value');
		document.getElementById('dealerVehicleModel').focus();
		return false;		
	}
	
	if(document.getElementById('dealerVehicleInfo').value=='')
	{
		alert('Please Enter Vehicle Info value');
		document.getElementById('dealerVehicleInfo').focus();
		return false;		
	}
	
	if(!(document.getElementById('agreementCheck').checked))
	{
		alert('Please check the Agree checkbox');
		document.getElementById('agreementCheck').focus();
		return false;	
	}

	return true;
}


function validateKeycode(frmObj)
{

	var strKey = "" ;			
	var isContinue = false ;
	var index = 1 ;
	var count = 0 ;
	
	var fldValue = getVinNumber();
			//document.getElementById('vinNumber1').value ;
	//alert('fldValue'+ fldValue);

	if(fldValue == '' || fldValue == null)
	{
		alert('Please Enter valid 17 digit keycode');
		document.getElementById('vinNVNumber1').focus();
		document.getElementById('vinNVNumber1').select();
		isContinue = false ;
	}	
	
	if(fldValue.length > 0)
	{
		if(fldValue.length < 17 )
		{
			alert('Please Enter valid 17 digit keycode');
			document.getElementById('vinNVNumber1').focus();
			document.getElementById('vinNVNumber1').select();
			isContinue = false ;			
		}
		else
		{
			document.getElementById('vinNum').value=fldValue;
			isContinue = true ;
		}
		if(isContinue){
			
			var index = 1 ;
			var vinNo = fldValue ;
			
			
			var url = "vin.do?actionType=validateNew&keycode="+vinNo ;

			if(vinNo != null && vinNo != "" && vinNo != undefined){
			
				 if (window.ActiveXObject) 
				    {  
				        httpRequest = new ActiveXObject("Microsoft.XMLHTTP"); 
				    }  
				    else if (window.XMLHttpRequest) 
				    {  
				        httpRequest = new XMLHttpRequest(); 
				    }  
				    
				
					//document.getElementById('itemLoader').innerHTML = '<img src="images/ajax-loader.gif" width="15" height="15">' ;
					
					//document.getElementById('btnSampleButton').disabled = true ;
					//document.getElementById('btnNextButton').disabled = true ;
					
				    httpRequest.open("POST", url, true); 
				    httpRequest.onreadystatechange = function() {isContinue = validateResult(isContinue); } ; 
				    httpRequest.send(null);
			    }
		     
		     } 
		
		
		
	}
	return isContinue;
}

function validateResult(isContinue){

 if (httpRequest.readyState == 4) 
	{ 
    	if(httpRequest.status == 200) 
        { 
            //alert(httpRequest.responseText);
			//document.getElementById('itemLoader').innerHTML = '' ;

            var mySplitResult = httpRequest.responseText ;
			

            
			 if(mySplitResult == 'Y')
			 {				       	
             	var vinNum = document.getElementById('vinNum').value;
             	//document.getElementById('vinNumber1').value ;
             	//document.vinForm.action = "vinExist.do?actionType=exist&vin="+vinNum ;
             	//document.vinForm.submit();             	
             	//document.location.href = "vinExist.do?actionType=exist&vin="+vinNum ;
             	alert("Vin : "+vinNum+"\n\nNew Vehicle Key Code request has already been made.")
        		resetVinNumber();isContinue=false;  
        		return false;
             	           	
             }else {
             	   
             	//document.getElementById('btnNextButton').disabled = false ;
             	//document.getElementById('btnSampleButton').disabled = false ;
            	 isContinue=true;          				
             }

			
		}
	}
	return isContinue;
 }  


function resetVinNumber()
{
	
	var inputArr = document.getElementsByTagName("input");

	for (var i = 0; i < inputArr.length; i++)
	{
		inputArr[i].value="";
	}
	
}
function getVinNumber()
{
	var keyVal = '';
	var inputArr = document.getElementsByTagName("input");

	for (var i = 0; i < inputArr.length; i++)
	{
		if(inputArr[i].name.indexOf("vinNVNumber") != -1)
		{						
			if(inputArr[i].value !=null && inputArr[i].value != '')
			{
				keyVal = keyVal + inputArr[i].value;
			}
		}
	}
	return keyVal;
}


function checkVal(currentId, evt) 
{
	var keycode;
	if (window.event) 
	{
        keycode = window.event.keyCode;
	}
	else if (evt) 
	{ 
        keycode = evt.which;				
	} 
    else   return true;
	
	if((keycode >= 48 && keycode <= 57)|| (keycode >= 61 && keycode <= 90) || (keycode >= 96 && keycode <= 105)) 
	{					
		document.getElementById(currentId).value='';
		document.getElementById(currentId).focus();
	}
}

function movetoNext(current, currentId, nextFieldID, evt) 
{
	current.value = (current.value).toUpperCase();
	var curItemVal = current.value;				
	var keycode;				
	
	if (window.event) 
	{
        keycode = window.event.keyCode;
	}
	else if (evt) 
	{ 
        keycode = evt.which;				
	} 
    else  return true;
	
	if (curItemVal.length >= current.maxLength) 
	{
		
		if (keycode != 9 && ((keycode >= 48 && keycode <= 57)|| (keycode >= 61 && keycode <= 90) || (keycode >= 96 && keycode <= 105))) 
		{
			document.getElementById(nextFieldID).focus();
		}
		else
		{
			document.getElementById(currentId).value='';
			document.getElementById(currentId).focus();
		}						
	}
}

function checkNumericInput(ob) 
{
	var invalidChars = /[^0-9]/gi
	if(invalidChars.test(ob.value)) 
	{
		ob.value = ob.value.replace(invalidChars,"");
	}
}

</script>
            