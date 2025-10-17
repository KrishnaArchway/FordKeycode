function newSmallWindow(link) {
	var dialogWidth = 800;
	var dialogHeight = 340;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link,  dialogWidth + 'x' + dialogHeight, 'toolbar=no,status=no,scrollbars=yes,location=no,menubar=no,directories=no,width=' + dialogWidth + ',height=' + dialogHeight);
}

function newSeperateSmallWindow(link) {
	/*var dialogWidth = 800;
	var dialogHeight = 340;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link, "newSeperateSmallWindow", dialogWidth + 'x' + dialogHeight, 'toolbar=no,status=no,scrollbars=yes,location=no,menubar=no,directories=no,width=' + dialogWidth + ',height=' + dialogHeight);
	*/
	//alert("amar");
	var dialogWidth = 860;
	var dialogHeight = 540;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open (link, dialogWidth + 'x' + dialogHeight ,'scrollbars=yes,width=' + dialogWidth + ',height=' + dialogHeight);
}

function newReportWindow(link) {
	var dialogWidth = 800;
	var dialogHeight = 600;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link, dialogWidth + 'x' + dialogHeight, 'toolbar=no,status=no,scrollbars=yes,location=no,menubar=no,directories=no,width=' + dialogWidth + ',height=' + dialogHeight);
}

function newPrintWindow(link) {
	var dialogWidth = 540;
	var dialogHeight = 525;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link, dialogWidth + 'x' + dialogHeight, 'toolbar=no,status=no,scrollbars=yes,location=no,menubar=no,directories=no,width=' + dialogWidth + ',height=' + dialogHeight);
}

function newNormalWindow(link) {
	var dialogWidth = 850;
	var dialogHeight = 650;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link, dialogWidth + 'x' + dialogHeight, 'toolbar=yes,status=yes,resizable=1,scrollbars=yes,location=yes,menubar=yes,directories=yes,width=' + dialogWidth + ',height=' + dialogHeight);
} 

function openExternalURLWindow(link, targetWin, w, h) {
	h = parseInt(h);
	if (isNaN(h) || h <= 0)
		dialogHeight=600;
	else
		dialogHeight=h;

	w = parseInt(w);
	if (isNaN(w) || w <= 0)
		dialogWidth=800;
	else
		dialogWidth=w;

	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);

	var winParams = "toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,width=" + dialogWidth + ",height=" + dialogHeight + ",top=" + y + ",left=" + x;
	window.open(link, targetWin, winParams);
}

function newViewWindow(link, targetWin, w, h) {
	if (h && h > 0)
		dialogHeight=h;
	else
		dialogHeight=470;

	if (w && w > 0)
		dialogWidth=w;
	else
		dialogWidth=630;

	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);

	var winParams = "toolbar=0,location=0,directories=0,status=no,menubar=0,scrollbars=0,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight + ",top=" + y + ",left=" + x;
	popup = window.open(link, targetWin, winParams);
}

function newCategoryWindow(link, targetWin, w, h) {
	if (h && h > 0)
		dialogHeight=h;
	else
		dialogHeight=470;

	if (w && w > 0)
		dialogWidth=w;
	else
		dialogWidth=630;

	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight + ",top=" + y + ",left=" + x;
	popup = window.open(link, targetWin, winParams);
	return popup;
}

function openLink(url) {
    window.opener.location.href = url;
    window.close();
}

function openAddressBook(returnElement) {
	var dialogWidth = 556;
	var dialogHeight = 433;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);

	addressbookPopup = window.open("addressbook?action=AddressBook.viewContacts&loadExistingValue=true&returnElement="
	+ returnElement, dialogWidth + "x" + dialogHeight,
	"toolbar=no,status=no,scrollbars=no,location=no,menubar=no,directories=no,width=" + dialogWidth + ",height=" + dialogHeight + "," +
	"screenX=" + x + ",left=" + x + ",screenY=" + y + ",top=" + y);
}

function openAddressBookWithContacts(returnElement) {
	var dialogWidth = 556;
	var dialogHeight = 433;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);

	addressbookPopup = window.open("addressbook?action=AddressBook.viewContacts&loadExistingValue=true&showContacts=true&returnElement="
	+ returnElement, dialogWidth + "x" + dialogHeight,
	"toolbar=no,status=no,scrollbars=no,location=no,menubar=no,directories=no,width=" + dialogWidth + ",height=" + dialogHeight + "," +
	"screenX=" + x + ",left=" + x + ",screenY=" + y + ",top=" + y);
}

function openMyLibrary(link) {
	var dialogWidth = 565;
	var dialogHeight = 565;
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var x = Math.ceil((screenWidth - dialogWidth) / 2);
	var y = Math.ceil((screenHeight - dialogHeight) / 2);
	window.open(link, 'myLib', 'resizable=yes,toolbar=no,status=no,scrollbars=yes,location=no,menubar=no,directories=no,width=565,height=565,top=' + y + ',left=' + x);
}

function errorDialog(title, description, reason, details, baseUrl, errorUrl, userFullName, dialogWidth, dialogHeight) {
	dialogWidth = getRealDialogWidth(dialogWidth);
	dialogHeight = getRealDialogHeight(dialogHeight);
	var x = getPositionX(dialogWidth);
	var y = getPositionY(dialogHeight);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight;
	winParams += ",top=" + y + ",left=" + x;

	if(details == null || details == "")
		details = reason;

	popupDialog = window.open("","errorDialog",winParams/*,true*/)
	if(popupDialog == null) {
		if(details != null && details != "")
			alert("Error: " + description + "\n\nDetails:\n" + details);
		else
			alert("Error: " + description);
	} else {

		popupDialog.focus()

		description = description.replace("\n", "<br>");
		var content = "<head><title>" + title + "</title>\n" + styleText + toggleDialogDetailText +
			"</head><body>" +
			"\n<form action=reporterror>" +
			"\n<input type=hidden name=errorUrl value=\"" + errorUrl + "\">" +
			"\n<input type=hidden name=userFullName value=\"" + userFullName + "\">" +
			"\n<input type=hidden name=detailMessage value=\"" + details + "\">" +
			"\n<input type=hidden name=description value=\"" + description + "\">" +
			"\n<table border=0 width=100% height=100% cellpadding=0 cellspacing=0 valign=top>\n" +
			"	<tr><td height=25><table border=0 cellpadding=0 cellspacing=0 align=left><tr><td height=25 align=right style=\"padding-right:10px\"><img border=0 src='" + baseUrl + "icons/error.gif' width='25' height='25'></td><td class=caption>Server Error:</td></tr></table></td></tr>\n" +
			"	<tr><td height=10><hr noshade size=2></td></tr>" +
			"	<tr><td height=110 valign=top style=\"padding-bottom:5px\">" + description + "</td></tr>" +
			"	<tr><td height=30><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td>";
		if(details != null && details != "") {
			content += "<input name=detailButton type=button class=button style=\"width:80px\" value='Show Details' onClick='toggleDialogDetail(\"details\");'>";
		}
		content +=
			"<input type=button class=button value='Send to Support' onclick='this.form.submit();'>" +
			"</td><td align=right><input type=button class=submitButton value='Close' onClick='parent.close();window.opener.focus();'></td></tr></table></td></tr>\n" +
			"	<tr><td >\n" +
			"		<div id='details' style='display: none;'>\n" +
			"			<b>Details:</b><br>\n" +
			"			<textarea rows=10 wrap=off>" + details + "</textarea>\n" +
			"		</div>\n" +
			"	</td></tr>\n" +
			"	<tr><td height=10><hr noshade></td></tr>\n" +
			"	<tr><td height=40><small>'Send to support' will send a copy of this error to the support team and aide in fixing any problems.  It will also close this dialog.</small></td></tr>\n" +
			"	<tr><td></td></tr>\n" +
			"</table>\n" +
			"</form>" +
			"</body>\n" +
			"</html>";

		popupDialog.document.writeln(content);
		popupDialog.document.close();
	}
}

function infoDialog(title, description, details, baseUrl, dialogWidth, dialogHeight) {
	dialogWidth = getRealDialogWidth(dialogWidth);
	dialogHeight = getRealDialogHeight(dialogHeight);
	var x = getPositionX(dialogWidth);
	var y = getPositionY(dialogHeight);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight;
	winParams += ",top=" + y + ",left=" + x;

	popupDialog = window.open("", "infoDialog", winParams/*, true*/);
	if(popupDialog == null) {
		if(details != null && details != "")
			alert("Notice: " + description + "\n\nDetails: " + details);
		else
			alert("Notice: " + description);
	} else {
		popupDialog.focus()

		description = description.replace("\n", "<br>");
		var content = "<head><title>" + title + "</title>\n" + styleText + toggleDialogDetailText +
			"</head><body onload=\"self.focus();document.getElementById('closeButton').focus();\">" +
			"\n<form>" +
			"\n<table border=0 width=100% height=100% cellpadding=0 cellspacing=0 valign=top>\n" +
			"	<tr><td height=25><table border=0 cellpadding=0 cellspacing=0 align=left><tr><td height=25 align=right style=\"padding-right:10px\"><img border=0 src='" + baseUrl + "icons/info.gif' width='25' height='25'></td><td class=caption>Notice:</td></tr></table></td></tr>\n" +
			"	<tr><td height=10><hr noshade size=2></td></tr>" +
			"	<tr><td height=110 valign=top style=\"padding-bottom:5px\">" + description + "</td></tr>" +
			"	<tr><td height=30><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td>";
		if(details != null && details != "") {
			content += "<input name=detailButton type=button class=button style=\"width:80px\" value='Show Details' onClick='toggleDialogDetail(\"details\");'>";
		}
		content +=
			"</td><td align=right><input type=button id=closeButton class=submitButton value='Close' onClick='parent.close();if(window.opener){window.opener.focus();}'></td></tr></table></td></tr>\n" +
			"	<tr><td >\n" +
			"		<div id='details' style='display: none;'>\n" +
			"			<b>Details:</b><br>\n" +
			"			<textarea rows=10 wrap=off>" + details + "</textarea>\n" +
			"		</div>\n" +
			"	</td></tr>\n" +
			"	<tr><td></td></tr>\n" +
			"</table>\n" +
			"</form>" +
			"</body>\n" +
			"</html>";

		popupDialog.document.writeln(content);
		popupDialog.document.close();
	}
}

function alertDialog(title, description, details, baseUrl, dialogWidth, dialogHeight) {
	dialogWidth = getRealDialogWidth(dialogWidth);
	dialogHeight = getRealDialogHeight(dialogHeight);
	var x = getPositionX(dialogWidth);
	var y = getPositionY(dialogHeight);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight;
	winParams += ",top=" + y + ",left=" + x;

	popupDialog = window.open("", "alertDialog", winParams/*, true*/);
	if(popupDialog == null) {
		if(details != null && details != "")
			alert("Notice: " + description + "\n\nDetails: " + details);
		else
			alert("Notice: " + description);
	} else {
		popupDialog.focus()

		description = description.replace("\n", "<br>");
		var content = "<head><title>" + title + "</title>\n" + styleText + toggleDialogDetailText +
			"</head><body onload=\"self.focus();document.getElementById('closeButton').focus();\">" +
			"\n<form>" +
			"\n<table border=0 width=100% height=100% cellpadding=0 cellspacing=0 valign=top>\n" +
			"	<tr><td height=25><table border=0 cellpadding=0 cellspacing=0 align=left><tr><td height=25 align=right style=\"padding-right:10px\"><img border=0 src='" + baseUrl + "icons/info.gif' width='25' height='25'></td><td class=caption>Notice:</td></tr></table></td></tr>\n" +
			"	<tr><td height=10><hr noshade size=2></td></tr>" +
			"	<tr><td height=110 valign=top style=\"padding-bottom:5px\">" + description + "</td></tr>" +
			"	<tr><td height=30><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td>";
		if(details != null && details != "") {
			content += "<input name=detailButton type=button class=button style=\"width:80px\" value='Show Details' onClick='toggleDialogDetail(\"details\");'>";
		}
		content +=
			"</td><td align=right><input type=button id=closeButton class=submitButton value='Close' onClick='parent.close();window.opener.focus();'></td></tr></table></td></tr>\n" +
			"	<tr><td >\n" +
			"		<div id='details' style='display: none;'>\n" +
			"			<b>Details:</b><br>\n" +
			"			<textarea rows=10 wrap=off>" + details + "</textarea>\n" +
			"		</div>\n" +
			"	</td></tr>\n" +
			"	<tr><td></td></tr>\n" +
			"</table>\n" +
			"</form>" +
			"</body>\n" +
			"</html>";

		popupDialog.document.writeln(content);
		popupDialog.document.close();
	}
}

function warningDialog(title, description, details, baseUrl, dialogWidth, dialogHeight) {
	dialogWidth = getRealDialogWidth(dialogWidth);
	dialogHeight = getRealDialogHeight(dialogHeight);
	var x = getPositionX(dialogWidth);
	var y = getPositionY(dialogHeight);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight;
	winParams += ",top=" + y + ",left=" + x;

	popupDialog = window.open("", "warningDialog", winParams/*, true*/);
	if(popupDialog == null) {
		if(details != null && details != "")
			alert("Notice: " + description + "\n\nDetails: " + details);
		else
			alert("Notice: " + description);
	} else {
		popupDialog.focus()

		description = description.replace("\n", "<br>");
		var content = "<head><title>" + title + "</title>\n" + styleText + toggleDialogDetailText +
			"</head><body onload=\"self.focus();document.getElementById('closeButton').focus();\">" +
			"\n<form>" +
			"\n<table border=0 width=95% height=95% cellpadding=0 cellspacing=0 valign=top>\n" +
			"	<tr><td height=25><table border=0 cellpadding=0 cellspacing=0 align=left><tr><td height=25 align=right style=\"padding-right:10px\"><img border=0 src='" + baseUrl + "icons/warning.gif' width='25' height='25'></td><td class=caption>Warning:</td></tr></table></td></tr>\n" +
			"	<tr><td height=10><hr noshade size=2></td></tr>" +
			"	<tr><td height=110 valign=top style=\"padding-bottom:5px\">" + description + "</td></tr>" +
			"	<tr><td height=30><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td>";
		if(details != null && details != "") {
			content += "<input name=detailButton type=button class=button style=\"width:80px\" value='Show Details' onClick='toggleDialogDetail(\"details\");'>";
		}
		content +=
			"</td><td align=right><input type=button id=closeButton class=submitButton value='Close' onClick='parent.close();window.opener.focus();'></td></tr></table></td></tr>\n" +
			"	<tr><td >\n" +
			"		<div id='details' style='display: none;'>\n" +
			"			<b>Details:</b><br>\n" +
			"			<textarea rows=10 wrap=off>" + details + "</textarea>\n" +
			"		</div>\n" +
			"	</td></tr>\n" +
			"	<tr><td></td></tr>\n" +
			"</table>\n" +
			"</form>" +
			"</body>\n" +
			"</html>";

		popupDialog.document.writeln(content);
		popupDialog.document.close();
	}
}
function confirmAndSubmitParentForm(message, parentFormName, title, baseUrl, dialogWidth, dialogHeight) {
	confirmDialog(message, null, parentFormName, title, baseUrl, dialogWidth, dialogHeight);
}

function confirmAndSetUrl(message, nextUrl, title, baseUrl, dialogWidth, dialogHeight) {
	confirmDialog(message, nextUrl, null, title, baseUrl, dialogWidth, dialogHeight);
}

function confirmDialog(message, nextUrl, parentFormName, title, baseUrl, dialogWidth, dialogHeight) {
	if(!dialogWidth) {
		dialogWidth = 350;
	}
	if(!dialogHeight) {
		dialogHeight = 150;
	}
	if(!title) {
		title = "Confirm";
	}
	if(!baseUrl) {
		baseUrl = "http://tank.atdoner.com/";
	}

	var x = getPositionX(dialogWidth);
	var y = getPositionY(dialogHeight);

	var winParams = "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width=" + dialogWidth + ",height=" + dialogHeight;
	winParams += ",top=" + y + ",left=" + x;

	popupDialog = window.open("", "confirmDialog", winParams/*, true*/);
	if(popupDialog == null) {
	/** TODO: will this happen?
		if(details != null && details != "")
			alert("Notice: " + description + "\n\nDetails: " + details);
		else
			alert("Notice: " + description);
	*/
	} else {
		popupDialog.focus()
		var content = "<head><title>" + title + "</title>\n" + styleText +
			"</head><body onload=\"self.focus();\">" +
			"\n<table border=0 width=100% height=95% cellpadding=0 cellspacing=0 valign=top>\n" +
			"	<tr><td height=25><table border=0 cellpadding=0 cellspacing=0 align=left><tr><td height=25 align=right style=\"padding-right:10px\"><img border=0 src='" + baseUrl + "icons/confirm.gif' width='25' height='25'></td><td class=caption>Confirm:</td></tr></table></td></tr>\n" +
			"	<tr><td height=10><hr noshade size=2></td></tr>" +
			"	<tr><td valign=top style=\"padding-bottom:5px\">" + message + "</td></tr>" +
			"	<tr><td height=30><table width=100% border=0 cellpadding=0 cellspacing=0></td></tr>" +
			"	<tr><td align=right>" +
			"			<input type=button class=button value='Cancel' onClick='if(opener) {opener.focus();} self.close();'>" +
			"			<input type=button class=submitButton value='OK' onClick='clickOK(this);'>" +
			"		</td></tr>" +
			"</table>\n" +
			"</body>\n" +
			"</html>\n"  +
			"<script language='JavaScript'>\n" +
			"function clickOK(obj) {\n";

		if(nextUrl) {
			content += "\tself.location = '" + nextUrl + "';\n";
		} else if(parentFormName) {
			content += "\topener.document.forms['" + parentFormName + "'].target=this.window.name;\n";
 			content += "\topener.document.forms['" + parentFormName + "'].submit();\n";
		} else {
			content += "\if(opener) {opener.focus();}\n\tself.close();\n";
		}

		content += "\tobj.disabled = true;\n";

		content += "}\n</script>\n";

		popupDialog.document.writeln(content);
		popupDialog.document.close();
	}
}


var styleText = "<style>\n" +
				"body {	background-color: #e4e4e4; font-family: Verdana; font-size: 11px; margin:5 10 5 10; }\n" +
				"td { font-size:11px; } input { font-size: 11px; }\n" +
				"#details {	font-size: 11px; height: 150px; padding:5 5 5 5; border:1px solid red;}\n" +
				"textarea { font-family: Verdana; font-size: 9px; height: 120px; width: 300px; margin-top: 3px;}\n" +
				".caption { font-family: Verdana; font-size: 20px; line-height:25px; font-weight: bold}\n" +
				".button { margin-right: 14px; }\n" +
				"</style>\n";

var toggleDialogDetailText = "<script type=text/javascript>\n" +
							"function toggleDialogDetail(idName) {\n" +
							"	if (document.getElementById(idName).style.display==\"none\") {\n" +
							"		document.getElementById(idName).style.display=\"block\";\n" +
							"		document.forms[0].detailButton.value= 'Hide Details';\n" +
							"		window.resizeBy(0, 150);\n" +
							"	} else {\n" +
							"		document.getElementById(idName).style.display=\"none\";\n" +
							"		document.forms[0].detailButton.value= 'Show Details';\n" +
							"		window.resizeBy(0, -150);\n" +
							"	}\n" +
							"}\n" +
							"<\/script>\n";


function getRealDialogWidth(dialogWidth) {
	if(dialogWidth == null)
		dialogWidth = 350;

	dialogWidth = (typeof(dialogWidth)=='string' ? Math.ceil(parseInt(dialogWidth)*window.screen.width/100) : dialogWidth);
	if (document.all && navigator.userAgent.indexOf("Win") != -1) {
		var border = 1;
		dialogWidth += border * 2 + 2;
	}

	//alert("tt: " + dialogWidth);
	return dialogWidth;
}

function getRealDialogHeight(dialogHeight) {
	if(dialogHeight == null)
		dialogHeight = 250

	dialogHeight = (typeof(dialogHeight) == 'string' ? Math.ceil(parseInt(dialogHeight)*window.screen.height/100) : dialogHeight);
	if (document.all && navigator.userAgent.indexOf("Win") != -1) {
		var border = 1;
		var textHeight = 20;
		dialogHeight += textHeight + border + 2;
	}

	//alert("dd: " + dialogHeight);
	return dialogHeight;
}

function getPositionX(dialogWidth) {
	return Math.ceil((window.screen.width - dialogWidth) / 2);
}

function getPositionY(dialogHeight) {
	return Math.ceil((window.screen.height - dialogHeight) / 2);
}

// This is the default "refreshMe" function that will simply reload a window
// individual page should override this function with their good URL
function refreshMe() {
	window.location.reload();
}


// This function will resize/relocate the popup window based on the size of table object passed in
function adjustWindow(obj, needMove, extraWidth, extraHeight) {

	if(!extraWidth) extraWidth = 80;
	if(!extraHeight) extraHeight = 60;

	var curWidth = obj.offsetWidth;
	var curHeight = obj.offsetHeight;

	var finalWidth = curWidth + extraWidth;
	var finalHeight = curHeight + extraHeight;

	if(finalWidth > screen.availWidth) finalWidth = screen.availWidth;
	if(finalHeight > screen.availHeight) finalHeight = screen.availHeight;


	// this is a workaround for the sick Safari browser, which will not respond to resizeTo() without a moveTo() call!
	if(navigator.userAgent.toLowerCase().indexOf("safari") != -1) {
		top.window.blur();
		window.moveTo((screen.availWidth - finalWidth) / 2, (screen.availHeight - finalHeight) / 2);
		top.window.focus();
	}


	top.window.resizeTo(finalWidth, finalHeight);

	if(needMove) {
		window.moveTo((screen.availWidth - finalWidth) / 2, (screen.availHeight - finalHeight) / 2);
	}

	top.window.focus();

}


/* This function is provided to address the problem in setting a select value in safari browser
 * For IE and Mozilla, use selectObj.value = desiredValue will work, but not in safari.
 * So we added the function to loop thru all options and then selected the correct one, for safari
 */
function setSelectValue(selectObj, desiredValue) {

	if(navigator.userAgent.toLowerCase().indexOf("safari") != -1) {
		var selectOptions = selectObj.options;
		var optionSize = selectObj.length;
		for(i = 0; i < optionSize; i++) {
			//alert(selectOptions[i].value + " vs " + desiredValue);
			if(selectOptions[i].value == desiredValue) {
				selectObj.selectedIndex = i;
				return;
			}
		}
	} else {
		selectObj.value = desiredValue;
	}
}