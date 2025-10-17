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

<form name="vinForm" method="post" action="pathDecider.do">
<input type="hidden" name="keycode" id="keycode" value=""/>
<input type="hidden" name="vinNum" id="vinNum" value=""/>

<div class="ui-widget">
   <div class="ui-widget-header section-header"><bean:message key="vinPage.label.information"/></div>
   <div class="ui-widget-content" style="min-height: 300px">
   <br> <br> <br>
               
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="33%" align="right" valign="center"><b><bean:message key="vinPage.lable.vinNumber"/></b><BR><bean:message key="vinPage.lable.vinNumber.addtionalText"/></td>
			<td width="4%" valign="center" ><p align="center"><b>:</b><br></td>
			<td width="63%" valign="center">
				<table border="0" cellpadding="0" cellspacing="0" width="75%">
					<tr>
						<td>
							<input  type="<bean:message key="vinPage.lable.vinNumber1.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber1.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber1.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber2.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber2.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber1.value" />"
							tabindex="<%=tabIndex++ %>"  style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"				
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber2.name" />', event)">
						</td>
						<td>			
							<input type="<bean:message key="vinPage.lable.vinNumber2.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber2.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber2.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber2.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber2.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber2.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber3.name" />', event)">
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber3.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber3.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber3.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber3.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber3.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber3.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber4.name" />', event)">
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber4.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber4.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber4.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber4.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber4.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber4.value" />"
							tabindex="<%=tabIndex++ %>"  style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber5.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber5.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber5.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber5.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber5.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber5.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber5.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber6.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber6.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber6.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber6.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber6.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber6.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber6.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber7.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber7.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber7.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber7.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber7.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber7.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber7.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber8.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber8.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber8.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber8.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber8.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber8.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber8.value" />"
							tabindex="<%=tabIndex++ %>"  style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber9.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber9.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber9.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber9.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber9.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber9.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber9.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber10.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber10.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber10.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber10.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber10.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber10.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber10.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber11.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber11.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber11.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber11.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber11.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber11.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber11.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber12.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber12.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber12.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber12.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber12.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber12.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber12.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber13.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber13.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber13.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber13.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber13.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber13.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber13.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber14.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber14.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber14.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber14.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber14.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber14.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber14.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber15.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber15.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber15.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber15.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber15.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber15.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber15.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber16.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber16.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber16.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber16.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber16.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber16.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber16.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.vinNumber17.name" />', event)">	
						</td>
						<td>
							<input type="<bean:message key="vinPage.lable.vinNumber17.type" />" 
							id="<bean:message key="vinPage.lable.vinNumber17.id" />" 
							name="<bean:message key="vinPage.lable.vinNumber17.name" />" 
							size="<bean:message key="vinPage.lable.vinNumber17.size" />" 
							MaxLength="<bean:message key="vinPage.lable.vinNumber17.maxLength" />" 
							value="<bean:message key="vinPage.lable.vinNumber17.value" />"
							tabindex="<%=tabIndex++ %>" style="<bean:message key="vinPage.lable.vinNumber.widthStyle" />" 
							onblur="javascript:validateKeycode(this.form)"
							onkeypress="checkVal(this.id, event)" 
							onkeyup="movetoNext(this, this.id, '<bean:message key="vinPage.lable.registeredOwnersVehicle.id" />', event)">	
						</td>
					</tr>
				</table>	
				<span id="itemLoader" />
			</td>
		</tr>
	</table>
	<br><br>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="33%" align="right"><b><bean:message key="vinPage.lable.registeredOwnersVehicle"/></b></td>
			<td width="4%" align="center"><b>:</b></td>
			<td width="63%"><input 
			type="<bean:message key="vinPage.lable.registeredOwnersVehicle.type" />" 
			value="<bean:message key="vinPage.lable.registeredOwnersVehicle.value" />" 
			name="<bean:message key="vinPage.lable.registeredOwnersVehicle.name" />"
			id="<bean:message key="vinPage.lable.registeredOwnersVehicle.id" />">
			</td>
		</tr>
		<tr>
			<td width="33%" align="right"><b><bean:message key="vinPage.lable.registeredDealershipVehicle"/></b></td>
			<td width="4%" align="center"><b>:</b></td>
			<td width="63%"><input 
			type="<bean:message key="vinPage.lable.registeredOwnersVehicle.type" />" 
			value="<bean:message key="vinPage.lable.registeredDealershipVehicle.value" />" 
			name="<bean:message key="vinPage.lable.registeredOwnersVehicle.name" />"
			id="<bean:message key="vinPage.lable.registeredDealershipVehicle.id" />">
			</td>
		</tr>
	</table>	
  	</div>     
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr>
		    <td width="50%" align="center">
		      <p align="center"><div class="buttons ui-widget">                
		                <input type="button" id="btnSampleButton" class="JQueryButton" value="<bean:message key="back.to.fmcdealer.com"/>" onClick="javascript : goToFMCDealer(this.form)"/>
		                </div></td>	
		    <td width="50%" align="center">      
		     <p align="center"><div class="buttons ui-widget">      
		      	<input type="button" id="btnNextButton" class="JQueryButton" value="<bean:message key="next"/>" onClick="javascript:return NextFrm(this.form)"/>
		      </div></td>
		  </tr>
		</table>
  	</div>
	</form> 
            
            
<script language="javascript">
		var strVin = "<%= vin %>" ;
		var isVinExist = "<%= isVinExist %>" ;
		var registeredVehicle = "<%= registeredVehicle %>" ;
		
		if(registeredVehicle != null)
		{
			setRequestValues();
		}
		
		if(isVinExist != null){
			document.getElementById('vinNumber1').focus();
		}
		
		if(strVin != null){
			setVIN(strVin);
		}

		function setRequestValues()
		{
			var addIds = document.getElementsByName("registeredOwnersVehicle");
			var isAddInfo = false ;
			for(i=0;i<addIds.length;i++)
			{
				if(registeredVehicle == addIds[i].value){
					addIds[i].checked = true ;
					break ;
				}
			}
				
		}

		function setVIN(strVin)
		{			
			if(strVin != null && strVin.length <= 17)
			{
				var k = 1 ;
				for(var i=0;i<strVin.length;i++)
				{
					document.getElementById('vinNumber'+k).value = strVin.charAt(i) ;		
					k++;
				}
			}
		}


		function NextFrm(formObj)
		{
			//alert(validateFrm(formObj));
			if(validateFrm(formObj)==true)
			{
				formObj.submit();
			}
			else
			{
				return false;
			}
		}

		function validateFrm(formObj)
		{
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber1.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber2.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber3.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber4.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber5.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber6.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber7.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber8.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber9.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber10.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber11.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber12.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber13.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber14.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber15.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber16.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}
			
			if(!validate(formObj.<bean:message key="vinPage.lable.vinNumber17.id" />, "<bean:message key="vinPage.lable.vinNumber.errorMessage" />", RULE_REQUIRED)) 
			{
				return false;
			}

			if(!GetSelectedItem(formObj))
			{
				alert("Please select \nFor a Registered Vehicle Owner's Vehicle\n\nor\n\nFor as Dealership Owned Used Vehicle 	\nto continue.");
				return false;
			}
			return true;
		}
		
		
		function GetSelectedItem(formObj) 
		{
				var result = 0;
				len = formObj.registeredOwnersVehicle.length;
				//alert(len);
				for (i = 0; i <len; i++) 
				{
					if (formObj.registeredOwnersVehicle[i].checked==true) 
					{
						result = 1;
					}
				}
				//alert(result);
				if (result==0) 
				{
					//alert("Please select \n\n For a Registered Vehicle Owner's Vehicle 	\n\nor\n\nFor as Dealership Owned Used Vehicle 	\n\n to continue.")
					return false;
				}
				else
				{
					return true;
				}
				
		}
 


		function validateKeycode(frmObj)
		{
		
			var strKey = "" ;			
			var isContinue = false ;
			var index = 1 ;
			var count = 0 ;
			
			var fldValue = getVinNumber();
					//document.getElementById('vinNumber1').value ;
			
			document.getElementById('vinNum').value = fldValue;
			if(fldValue.length > 0){
			
				if(fldValue.length < 17 ){
					alert('Please Enter valid 17 digit keycode');
					document.getElementById('vinNumber1').focus();
					document.getElementById('vinNumber1').select();
					isContinue = false ;
				}else{
					isContinue = true ;
				}
			}
			if(isContinue){
			
			var index = 1 ;
			var vinNo = fldValue ;
			
			
			var url = "vin.do?actionType=validate&keycode="+vinNo ;

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
					
					document.getElementById('btnSampleButton').disabled = true ;
					document.getElementById('btnNextButton').disabled = true ;
					
				    httpRequest.open("POST", url, true); 
				    httpRequest.onreadystatechange = function() {validateResult(); } ; 
				    httpRequest.send(null);
			    }
		     
		     } 
		    
		  }
    
    
 function validateResult(){

 if (httpRequest.readyState == 4) 
	{ 
    	if(httpRequest.status == 200) 
        { 
            //alert(httpRequest.responseText);
			document.getElementById('itemLoader').innerHTML = '' ;

            var mySplitResult = httpRequest.responseText ;
			

            
			 if(mySplitResult == 'Y')
			 {				       	
             	var vinNum = document.getElementById('vinNum').value;
             	//document.getElementById('vinNumber1').value ;
             	//document.vinForm.action = "vinExist.do?actionType=exist&vin="+vinNum ;
             	//document.vinForm.submit();             	
             	document.location.href = "vinExist.do?actionType=exist&vin="+vinNum ;
             	             	
             }else {
             	   
             	document.getElementById('btnNextButton').disabled = false ;
             	document.getElementById('btnSampleButton').disabled = false ;
            	           				
             }

			
		}
	}
 }  


function goBack()
{
	window.history.go(-1);
}

function goToFMCDealer(formObj)
{
	formObj.action='fmcDealer.do';
	formObj.submit();
}


function stopRKey(evt) {
  var evt = (evt) ? evt : ((event) ? event : null);
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
  if ((evt.keyCode == 13) && (node.type=="text"))  {return false;}
} 


document.onkeypress = stopRKey; 



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
			//if(curItemVal.match(/^\d+$/)) 
			//{
				if (keycode != 9 && ((keycode >= 48 && keycode <= 57)|| (keycode >= 61 && keycode <= 90) || (keycode >= 96 && keycode <= 105))) 
				{
					document.getElementById(nextFieldID).focus();
				}
				else
				{
					document.getElementById(currentId).value='';
					document.getElementById(currentId).focus();
				}
			//}
			//else
			//{
			//	document.getElementById(currentId).value='';
			//	document.getElementById(currentId).focus();
			//}					
		}
	}
	
	function getVinNumber()
	{
		var keyVal = '';
		var inputArr = document.getElementsByTagName("input");

		for (var i = 0; i < inputArr.length; i++)
		{
			if(inputArr[i].name.indexOf("vinNumber") != -1)
			{						
				if(inputArr[i].value !=null && inputArr[i].value != '')
				{
					keyVal = keyVal + inputArr[i].value;
				}
			}
		}
		return keyVal;
	}

 </script>
            