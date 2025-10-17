	
/**
 * validate email address
 */
function validateEmail(email) {
	regular = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
	
	trimed = trimAll(email);
	return(regular.test(trimed));
}

/**
 *  Validates that a string is not all blank (whitespace) characters.	 
 */	
function isAllBlank(input) {

	if(input == null || input == "") {
		return true;
	}
		
	temp = trimAll(input);
	if(temp.length > 0) {
		return false;
	} else {
		return true;
	}
}

function countWords(input) {
	if(isAllBlank(input)) {
		return 0;
	}
	
	var matches = input.match(/\w+/g); 
	var count = matches.length; // this is how many! 
	return count;
}
	
function trimAll(strValue) {
	var objRegExp = /^(\s*)$/;

    //check for all spaces
    if(objRegExp.test(strValue)) {
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }
   	//check for leading & trailing spaces
   	objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   	if(objRegExp.test(strValue)) {
       	//remove leading and trailing whitespace characters
       	strValue = strValue.replace(objRegExp, '$2');
    }
  	return strValue;
}

function validateDollar(obj, name) {
	curValue = obj.value;
	if(!obj.value || trimAll(curValue).length == 0) {
		obj.value = "0.00";
		return false;
	} else {
		
		curValue = replaceAll(curValue, ",", "");
		curValue = replaceAll(curValue, "$", "");
		curValue = replaceAll(curValue, " ", "");

		dotIndex = curValue.indexOf(".");

		if(dotIndex == -1) {
			curValue = curValue + ".00";
		} else {
			if(dotIndex == 0) { 
				curValue = 0 + curValue;
				dotIndex = 1;
			} 

			if((curValue.length - dotIndex) == 1) { 
				curValue = curValue + "00";
			} else if((curValue.length - dotIndex) == 2) { 
				curValue = curValue + "0";
			}
		}
		objRegExp = /^\d+(\.\d\d)?$/;     

		if(!objRegExp.test(curValue )) {
   			alert("The format for " + name + " is not valid.");	
			obj.value = "0.00";
			obj.focus();
			return false;
		} else {
			//remove unnecessary "0"s
			while(curValue.indexOf("0") == 0) {
				if(curValue.indexOf("0.") == 0) {
					break;
				}
				curValue = curValue.replace("0", "");
			}
		
			obj.value = curValue;
			return true;
		} 
	}
}

function replaceAll(input, replaceThis, replaceWith) {
	while(input.indexOf(replaceThis) >= 0) {
		input = input.replace(replaceThis, replaceWith);
	}
	return input;
}

function isFileNameValid(fileName, validExtensions) {
	if(isAllBlank(fileName)) {
		alert("File name cannot be empty.");
		return false;
	}
	
	extension = getFileExtension(fileName);
	for(i = 0; i < validExtensions.length; i++) {
		if(extension.equalsIgnoreCase(validExtensions[i])) {
			return true;
		}	
	}
	
	alert("Only [" + validExtensions + "] files are allowed.");
	
	return false;
}

function getFileExtension(fileName) {
	dotIndex = fileName.lastIndexOf(".");
	if(dotIndex > 0) {
		return fileName.substring(dotIndex + 1, fileName.length);
	} else {
		return "";
	}
}

function getFileName(filePath) {
	dotIndex = Math.max(filePath.lastIndexOf("/"), filePath.lastIndexOf("\\"));
	if(dotIndex >= 0) {
		return filePath.substring(dotIndex + 1, filePath.length);
	} else {
		return filePath;
	}
}


String.prototype.equalsIgnoreCase=MatchIgnoreCase;

function MatchIgnoreCase(strTerm){
	var strToSearch = this.toLowerCase();
	strTerm = strTerm.toLowerCase();
	if(strToSearch==strTerm){
		return true;
	} else {
		return false;
	}
} 

String.prototype.isEmpty=isEmpty;

function isEmpty() {
	return isAllBlank(this);
}

//  check for valid numeric strings	
function isNumeric(strString) {
	var strValidChars = "0123456789.-";
   	var strChar;
   	var blnResult = true;

   	if (strString.length == 0) return false;

   	//  test strString consists of valid characters listed above
   	for (i = 0; i < strString.length && blnResult == true; i++) {
    	strChar = strString.charAt(i);
      	if (strValidChars.indexOf(strChar) == -1) {
        	blnResult = false;
        }
   	}
   	return blnResult;
}

// check for valid int strings
function isInt(strString) { 
	var strValidChars = "0123456789-";
   	var strChar;
   	var blnResult = true;

   	if (strString.length == 0) return false;

   	//  test strString consists of valid characters listed above
   	for (i = 0; i < strString.length && blnResult == true; i++) {
    	strChar = strString.charAt(i);
      	if (strValidChars.indexOf(strChar) == -1) {
        	blnResult = false;
        }
   	}
   	return blnResult;	
}

/**
 * check if the input country is U.S.
 */
function isUSA(value) {
	if(value.isEmpty()) {
		return false;
	}
	value = replaceAll(value, ".", "");
	value = replaceAll(value, " ", "");
	value = value.toUpperCase();
 
	return value == "US" || value == "USA" || value == "AMERICA";
}

function getSelectValue(selectObj) {
	return selectObj.options[selectObj.options.selectedIndex].value;
}

function getRadioValue(radioObj) {
 	for(_radioCount = 0; _radioCount < radioObj.length; _radioCount++) {
		if(radioObj[_radioCount].checked) {
			return radioObj[_radioCount].value;
		}
	}
	
	return "";
}

function disableButton(buttonObj) {
	buttonObj.disabled = true;
	buttonObj.className = "largeButtonDisabled";
}


disableButtons = new Array();
disableButtonCount = 0;
 
function addDiableButton(buttonID) {
	buttonObj = document.getElementById(buttonID);
	disableButtons[disableButtonCount] = buttonObj;
	disableButtonCount++;
}

function disablePageButtons() {
	for(i = 0; i < disableButtons.length; i++) {
		disableButton(disableButtons[i]);
	}
}