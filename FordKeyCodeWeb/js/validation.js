var RULE_REQUIRED = "0";
var RULE_IS_NUMBER = "1";
var RULE_LARGER_THAN = "2";
var RULE_LESS_THAN = "3";
var RULE_BETWEEN = "4";
var RULE_IS_EMAIL = "5";
var RULE_LENGTH_EQUAL = "6";
var RULE_IS_INT = "7";
var RULE_LENGTH_LESS_THAN = "8";
 
function validate(field, displayName, rules, needFocus, errorMsg) {
	if(needFocus == null) {
		needFocus = true;
	}
 
	isRadio = false;
	fieldType = null; 	
 	
 	// test if the field is radio
	try {
		isRadio = field.length && field[0].type == "radio";		 
	} catch(ex) {
		// do nothing
	}
 	
 	if(isRadio) {
 		fieldType = "radio";
 	} else {
		fieldType = field.type;
	}
	
	isValid = true;
	
	if(fieldType == "textarea") {  
		isValid = validateTextarea(field, displayName, rules, errorMsg);
	} else if(fieldType == "text" || fieldType == "password") {  
		isValid = validateText(field, displayName, rules, errorMsg);
	} else if(fieldType == "select-one") {  
		isValid = validateSelectOne(field, displayName, rules, errorMsg);
	} else if(fieldType == "radio") {
		isValid = validateRadio(field, displayName, rules, errorMsg);
	} else {
		alert("Invalid field type " + fieldType + " -- write your code");
		isValid = false;
	}
  
 	if(!isValid && !isRadio && needFocus) {
		field.focus();
 	}
  
	return isValid;
}

function validateTextarea(field, displayName, rules, errorMsg) {  
	curValue = field.value; 
	return validateRules(curValue, displayName, rules, errorMsg);  
}

function validateText(field, displayName, rules, errorMsg) { 
	curValue = field.value;
	return validateRules(curValue, displayName, rules, errorMsg);
}

function validateSelectOne(field, displayName, rules, errorMsg) { 
	curValue = getSelectValue(field);
	return validateRules(curValue, displayName, rules, errorMsg);
}

function validateRadio(field, displayName, rules, errorMsg) { 
	curValue = getRadioValue(field);
	return validateRules(curValue, displayName, rules, errorMsg);
}

function validateRules(curValue, displayName, rules, errorMsg) {  
	curRules = rules.split("|");
	for(_i = 0; _i < curRules.length; _i++) {
		rule = getRule(curRules[_i]);
	 	params = getParams(curRules[_i]); 

		if(rule == RULE_REQUIRED) {
			if(!validateRequired(curValue, displayName, errorMsg)) { 
				return false;
			}
		} else if(rule == RULE_IS_NUMBER) { 
			if(!validateIsNumber(curValue, displayName, errorMsg)) { 
				return false;
			}			
		} else if(rule == RULE_LARGER_THAN) {
		 	if(!validateIsNumber(curValue, displayName, errorMsg)) { 
				return false;
			}	
			if(!validateLargerThan(curValue, displayName, params[0], errorMsg)) { 
				return false;
			}			 	
 		} else if(rule == RULE_LESS_THAN) {  
		 	if(!validateIsNumber(curValue, displayName, errorMsg)) { 
				return false;
			}	
			if(!validateLessThan(curValue, displayName, params[0], errorMsg)) { 
				return false;
			}			
		} else if(rule == RULE_BETWEEN) {
		 	if(!validateIsNumber(curValue, displayName, errorMsg)) { 
				return false;
			}	
			if(!validateBetween(curValue, displayName, params[0], params[1], errorMsg)) { 
				return false;
			}						
		} else if(rule == RULE_IS_EMAIL) {
			if(!validateIsEmail(curValue, displayName, errorMsg)) { 
				return false;
			}
		} else if(rule == RULE_LENGTH_EQUAL) {
			if(!validateLengthEqual(curValue, displayName, params[0], errorMsg)) { 
				return false;
			}		
		} else if(rule == RULE_IS_INT) {
			if(!validateIsInt(curValue, displayName, errorMsg)) { 
				return false;
			}			
		} else if(rule == RULE_LENGTH_LESS_THAN) {
			if(!validateLengthLessThan(curValue, displayName, params[0], errorMsg)) { 
				return false;
			}			
		}
	} 
	return true;
}

function getParams(rule) {
	paramIndex = rule.indexOf("(");
	if(paramIndex > 0) {
		return rule.substring(paramIndex + 1, rule.length - 1).split(",");
	}
	return "";
}

function getRule(rawRule) {
	paramIndex = rawRule.indexOf("(");
	if(paramIndex > 0) {
		return rawRule.substring(0, paramIndex);
	} else {
		return rawRule;
	}
}

function validateRequired(curValue, displayName, errorMsg) {  
	if(curValue.isEmpty()) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] is a required field.");
		}
		return false;
	}
	
	return true;
}


function validateIsNumber(curValue, displayName, errorMsg) { 
	if(curValue.isEmpty()) {
		return true;
	}
	
	if(!isNumeric(curValue)) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] is not a number.");
		}	
		
		return false;
	}
	
	return true;
}

function validateIsInt(curValue, displayName, errorMsg) {
	if(curValue.isEmpty()) {
		return true;
	}
	
	if(!isInt(curValue)) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] is not numeric.");
		}	
		
		return false;
	}
	
	return true;
}


function validateLessThan(curValue, displayName, maxValue, errorMsg) {  
	if(curValue.isEmpty()) {
		return true;
	}
	
	numValue = parseFloat(curValue);
 
	if(!(numValue < maxValue)) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] should be less than or equal to " + (parseFloat(maxValue) - 1));
		}		
		
		return false;
	}
	
	return true; 
} 

function validateLargerThan(curValue, displayName, minValue, errorMsg) {  
	if(curValue.isEmpty()) {
		return true;
	}
	
	numValue = parseFloat(curValue);
	
	if(!(numValue > minValue)) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] should be larger than or equal to " + (parseFloat(minValue) + 1));
		}		

		return false;
	}
	
	return true; 
}

function validateBetween(curValue, displayName, lower, upper, errorMsg) {
	if(curValue.isEmpty()) {
		return true;
	}
	
	if(!validateLargerThan(curValue, displayName, lower)) {
		return false;
	}
	if(!validateLessThan(curValue, displayName, upper)) {
		return false;
	}
	
	return true;
}

function validateIsEmail(curValue, displayName, errorMsg) {
	if(curValue.isEmpty()) {
		return true;
	}
	
	if(!validateEmail(curValue)) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("[" + displayName + "] is not a valid email address.");
		}	
		
		return false;
	}
	
	return true;
}

function validateLengthEqual(curValue, displayName, requiredLength, errorMsg) {
	if(curValue.isEmpty()) {
		return true;
	}
	
	if(curValue.length != requiredLength) {
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("The length of [" + displayName + "] should be " + requiredLength + ".");
		}		
		
		return false;
	}
	
	return true;
}

function validateLengthLessThan(curValue, displayName, maxLength, errorMsg) {
	if(curValue.isEmpty()) {
		return true;
	}
		
	if(curValue && curValue.length >= maxLength) { 
		if(errorMsg) {
			alert(errorMsg);
		} else {
			alert("The length of [" + displayName + "] should be less than " + (maxLength - 1) + " characters.");
		}
		
		return false;		
	}
	
	return true;
}
