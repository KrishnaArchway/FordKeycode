//
// JavaScript Calendar Component
// Author: Robert W. Husted  (robert.husted@iname.com)
// Date:   8/22/1999
// Modified Date: 11/30/1999
// Modified By:   Robert W. Husted
// Notes:  Added frameset support (changed reference for "newWin" to "top.newWin")
//         Also changed Spanish "March" from "Marcha" to "Marzo"
//         Fixed JavaScript Date Anomaly affecting days > 28
// 
// 
// 
// Usage:  Add the following lines of code to your page to enable the Calendar
//         component.
//
//
//         // THIS LINE LOADS THE JS LIBRARY FOR THE CALENDAR COMPONENT 
//
//         <SCRIPT LANGUAGE="JavaScript" SRC="calendar.js"></SCRIPT>
//
//
//
//         // THIS LINE IS USED IN CONJUNCTION WITH A FORM FIELD (myDateField) IN A FORM (myForm).
//         // Replace "myForm" and "myDateField" WITH THE NAME OF YOUR FORM AND INPUT FIELD RESPECTIVELY
//         // WINDOW OPTIONS SET THE WIDTH, HEIGHT, AND X/Y POSITION OF THE CALENDAR WINDOW 
//         // WITH TITLEBAR ON, ALL OTHER OPTIONS (TOOLBARS, ETC) ARE DISABLED BY DEFAULT
//
//         <A HREF="javascript:doNothing()" onClick="setDateField(document.myForm.myDateField);top.newWin = window.open('calendar.html','cal','dependent=yes,width=210,height=230,screenX=200,screenY=300,titlebar=yes')">
//         <IMG SRC="calendar.gif" BORDER=0></A><font size=1>Popup Calendar</font>
//
//
// 
// Required Files:
//
//         calendar.js   - contains all JavaScript functions to make the calendar work
//
//         calendar.html - frameset document (not required if you call the showCalendar()
//                         function.  However, calling showCalendar() directly causes
//                         the Java Virtual Machine (JVM) to start which slows down the
//                         loading of the calendar.)
//
// 
// Files Generally Included:
//
//         calendar.gif  - image that looks like a little calendar
// 
//         yourPage.html - page that contains a form and a date field which implements 
//                         the calendar component
// 



// BEGIN USER-EDITABLE SECTION -----------------------------------------------------



// SPECIFY DATE FORMAT RETURNED BY THIS CALENDAR
// (THIS IS ALSO THE DATE FORMAT RECOGNIZED BY THIS CALENDAR)

// DATE FORMAT OPTIONS:
//
// dd   = 1 or 2-digit Day
// DD   = 2-digit Day
// mm   = 1 or 2-digit Month
// MM   = 2-digit Month
// yy   = 2-digit Year
// YY   = 4-digit Year
// yyyy = 4-digit Year
// month   = Month name in lowercase letters
// Month   = Month name in initial caps
// MONTH   = Month name in captital letters
// mon     = 3-letter month abbreviation in lowercase letters
// Mon     = 3-letter month abbreviation in initial caps
// MON     = 3-letter month abbreviation in uppercase letters
// weekday = name of week in lowercase letters
// Weekday = name of week in initial caps
// WEEKDAY = name of week in uppercase letters
// wkdy    = 3-letter weekday abbreviation in lowercase letters
// Wkdy    = 3-letter weekday abbreviation in initial caps
// WKDY    = 3-letter weekday abbreviation in uppercase letters
//
// Examples:
//
calDateFormat = "MM/DD/YY";
// calDateFormat = "Weekday, Month dd, yyyy";
// calDateFormat = "wkdy, mon dd, yyyy";
// calDateFormat = "DD.MM.YY";     // FORMAT UNSUPPORTED BY JAVASCRIPT -- REQUIRES CUSTOM PARSING
//

//calDateFormat    = "DD-Mon-yyyy";


// CALENDAR COLORS
topBackground    = "white";         // BG COLOR OF THE TOP FRAME
bottomBackground = "white";         // BG COLOR OF THE BOTTOM FRAME
tableBGColor     = "black";         // BG COLOR OF THE BOTTOM FRAME'S TABLE
cellColor        = "lightgrey";     // TABLE CELL BG COLOR OF THE DATE CELLS IN THE BOTTOM FRAME
headingCellColor = "white";         // TABLE CELL BG COLOR OF THE WEEKDAY ABBREVIATIONS
headingTextColor = "black";         // TEXT COLOR OF THE WEEKDAY ABBREVIATIONS
dateColor        = "blue";          // TEXT COLOR OF THE LISTED DATES (1-28+)
focusColor       = "#ff0000";       // TEXT COLOR OF THE SELECTED DATE (OR CURRENT DATE)
hoverColor       = "darkred";       // TEXT COLOR OF A LINK WHEN YOU HOVER OVER IT
fontStyle        = "12pt arial, helvetica";           // TEXT STYLE FOR DATES
headingFontStyle = "bold 12pt arial, helvetica";      // TEXT STYLE FOR WEEKDAY ABBREVIATIONS

// FORMATTING PREFERENCES
bottomBorder  = false;        // TRUE/FALSE (WHETHER TO DISPLAY BOTTOM CALENDAR BORDER)
tableBorder   = 0;            // SIZE OF CALENDAR TABLE BORDER (BOTTOM FRAME) 0=none



// END USER-EDITABLE SECTION -------------------------------------------------------



// DETERMINE BROWSER BRAND
var isNav = false;
var isIE  = false;

// ASSUME IT'S EITHER NETSCAPE OR MSIE
if (navigator.appName == "Netscape") {
    isNav = true;
}
else {
    isIE = true;
}

// GET CURRENTLY SELECTED LANGUAGE
selectedLanguage = navigator.language;

// PRE-BUILD PORTIONS OF THE CALENDAR WHEN THIS JS LIBRARY LOADS INTO THE BROWSER
buildCalParts();



// CALENDAR FUNCTIONS BEGIN HERE ---------------------------------------------------



// SET THE INITIAL VALUE OF THE GLOBAL DATE FIELD
function setDateField(dateField) 
{

    // ASSIGN THE INCOMING FIELD OBJECT TO A GLOBAL VARIABLE
    calDateField = dateField;

    // GET THE VALUE OF THE INCOMING FIELD
    inDate = dateField.value;

    // SET calDate TO THE DATE IN THE INCOMING FIELD OR DEFAULT TO TODAY'S DATE
    setInitialDate();

    // THE CALENDAR FRAMESET DOCUMENTS ARE CREATED BY JAVASCRIPT FUNCTIONS
    calDocTop    = buildTopCalFrame();

    calDocBottom = buildBottomCalFrame();

}


// SET THE INITIAL CALENDAR DATE TO TODAY OR TO THE EXISTING VALUE IN dateField
function setInitialDate() 
{
   
    // CREATE A NEW DATE OBJECT (WILL GENERALLY PARSE CORRECT DATE EXCEPT WHEN "." IS USED AS A DELIMITER)
    // (THIS ROUTINE DOES *NOT* CATCH ALL DATE FORMATS, IF YOU NEED TO PARSE A CUSTOM DATE FORMAT, DO IT HERE)

	var datePattern = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{2}|\d{4})$/;
	var matchArray = inDate.match(datePattern); // is the format ok?
	
	if (matchArray == null) {
	// Rob K, LogicaCMG 10/22/2003 - routine was returning bad display if date format was bad
        inDate = '';
    }
    
    if (inDate != '') 
    {
        //IF TEXT FIELD IS NOT BLANK--Added by Suman on 21st October, 2001
        //THIS CUSTOM PARSING IS WHEN DATE IS IN FORMAT DD-MM-yyyy
        //var day = inDate.substring(0,2);
        //var month = inDate.substring(3,5);
        //var year = inDate.substring(6,11);
        //calDate = new Date(year,month-1,day);
        
        //IF TEXT FIELD IS NOT BLANK--Added by Suman on 31st October, 2001
        //THIS CUSTOM PARSING IS WHEN DATE IS IN FORMAT MM-DD-YYYY
        var month = inDate.substring(0,2);
        var day = inDate.substring(3,5);
        var year = inDate.substring(6,10);
        
        //BEGIN VK 07/01/2004
        cyear = getCorrectedYear(year);
        
        if (!isDate(day,month,cyear))
        {
            alert("Invalid Date Entered, Defaulting to Current Date. Valid Formats: MM/DD/YY or MM/DD/YYYY");
            calDate = new Date();
        }
        else
        {
            //END VK 07/01/2004
            var customDate = month + "/" + day + "/" + cyear;
            calDate = new Date(customDate);
        }
     } 
     else 
     {
        //IF TEXT FIELD IS BLANK--Added by Suman on 21st October, 2001
        calDate = new Date();
     }
     
    // KEEP TRACK OF THE CURRENT DAY VALUE
    calDay  = calDate.getDate();

    // SET DAY VALUE TO 1... TO AVOID JAVASCRIPT DATE CALCULATION ANOMALIES
    // (IF THE MONTH CHANGES TO FEB AND THE DAY IS 30, THE MONTH WOULD CHANGE TO MARCH
    //  AND THE DAY WOULD CHANGE TO 2.  SETTING THE DAY TO 1 WILL PREVENT THAT)
    calDate.setDate(1);
}
 
// POPUP A WINDOW WITH THE CALENDAR IN IT
function showCalendar(dateField) 
{  
 	if(dateField.disabled) {
 		return;
 	}
 	
    inDate = '';
    setInitialDate();

    // SET INITIAL VALUE OF THE DATE FIELD AND CREATE TOP AND BOTTOM FRAMES
    setDateField(dateField);

    // USE THE JAVASCRIPT-GENERATED DOCUMENTS (calDocTop, calDocBottom) IN THE FRAMESET
    calDocFrameset = 
        "<HTML><HEAD><TITLE>JavaScript Calendar</TITLE></HEAD>\n" +
        "<FRAMESET ROWS='70,*' FRAMEBORDER='0'>\n" +
        "  <FRAME NAME='topCalFrame' SRC='javascript:parent.opener.calDocTop' SCROLLING='no'>\n" +
        "  <FRAME NAME='bottomCalFrame' SRC='javascript:parent.opener.calDocBottom' SCROLLING='no'>\n" +
        "</FRAMESET>\n";

    // DISPLAY THE CALENDAR IN A NEW POPUP WINDOW
    top.newWin = window.open("javascript:parent.opener.calDocFrameset", "calWin", "width=208,height=230,top=325,left=325");
    //dateField.focus();
    top.newWin.focus();
    
}

function setMyYear()
{

}

// CREATE THE TOP CALENDAR FRAME
function buildTopCalFrame() 
{

    // CREATE THE TOP FRAME OF THE CALENDAR
    var calDoc =
        "<HTML>" +
        "<HEAD>" + 
        "</HEAD>" +
        "<BODY BGCOLOR='" + topBackground + "'>" +
        "<FORM NAME='calControl' onSubmit='parent.opener.setYear();return false;'>" +
        "<CENTER>" +
        "<TABLE CELLPADDING=0 CELLSPACING=1 BORDER=0>" +
        "<TR><TD COLSPAN=7>" +
        "<CENTER>" +
        getMonthSelect() +
        "<INPUT NAME='year' VALUE='" + calDate.getFullYear() + "'TYPE=TEXT SIZE=4 MAXLENGTH=4 onChange='parent.opener.setYear()'>" +
        "</CENTER>" +
        "</TD>" +
        "</TR>" +
        "<TR>" +
        "<TD COLSPAN=7 align='center'>" +
        "<INPUT " +
        "TYPE='BUTTON' style='margin:1px;width:33px' NAME='previousYear' VALUE='<<'    onClick='parent.opener.setPreviousYear()'><INPUT " +
        "TYPE='BUTTON' style='margin:1px;width:27px' NAME='previousMonth' VALUE=' < '   onClick='parent.opener.setPreviousMonth()'><INPUT " +
        "TYPE='BUTTON' style='margin:1px;width:58px' NAME='today' VALUE='Today' onClick='parent.opener.setToday()'><INPUT " +
        "TYPE='BUTTON' style='margin:1px;width:27px' NAME='nextMonth' VALUE=' > '   onClick='parent.opener.setNextMonth()'><INPUT " +
        "TYPE='BUTTON' style='margin:1px;width:33px' NAME='nextYear' VALUE='>>'    onClick='parent.opener.setNextYear()'>" +
        "</TD>" +
        "</TR>" +
        "</TABLE>" +
        "</CENTER>" +
        "</FORM>" +
        "</BODY>" +
        "</HTML>";

    return calDoc;
}


// CREATE THE BOTTOM CALENDAR FRAME 
// (THE MONTHLY CALENDAR)
function buildBottomCalFrame() 
{       

    // START CALENDAR DOCUMENT
    var calDoc = calendarBegin;

    // GET MONTH, AND YEAR FROM GLOBAL CALENDAR DATE
    month   = calDate.getMonth();
    year    = calDate.getFullYear();


    // GET GLOBALLY-TRACKED DAY VALUE (PREVENTS JAVASCRIPT DATE ANOMALIES)
    day     = calDay;

    var i   = 0;

    // DETERMINE THE NUMBER OF DAYS IN THE CURRENT MONTH
    var days = getDaysInMonth();

    // IF GLOBAL DAY VALUE IS > THAN DAYS IN MONTH, HIGHLIGHT LAST DAY IN MONTH
    if (day > days) {
        day = days;
    }

    // DETERMINE WHAT DAY OF THE WEEK THE CALENDAR STARTS ON
    var firstOfMonth = new Date (year, month, 1);

    // GET THE DAY OF THE WEEK THE FIRST DAY OF THE MONTH FALLS ON
    var startingPos  = firstOfMonth.getDay();
    days += startingPos;

    // KEEP TRACK OF THE COLUMNS, START A NEW ROW AFTER EVERY 7 COLUMNS
    var columnCount = 0;

    // MAKE BEGINNING NON-DATE CELLS BLANK
    for (i = 0; i < startingPos; i++) 
    {
        calDoc += blankCell;
    columnCount++;
    }

    // SET VALUES FOR DAYS OF THE MONTH
    var currentDay = 0;
    var dayType    = "weekday";

    // DATE CELLS CONTAIN A NUMBER
    for (i = startingPos; i < days; i++) 
    {
    var paddingChar = "&nbsp;";

        // ADJUST SPACING SO THAT ALL LINKS HAVE RELATIVELY EQUAL WIDTHS
        if (i-startingPos+1 < 10) {
            padding = "&nbsp;&nbsp;";
        } else {
            padding = "&nbsp;";
        }

        // GET THE DAY CURRENTLY BEING WRITTEN
        currentDay = i-startingPos+1;

        // SET THE TYPE OF DAY, THE focusDay GENERALLY APPEARS AS A DIFFERENT COLOR
        if (currentDay == day) {
            dayType = "focusDay";
        } else {
            dayType = "weekDay";
        }

        // ADD THE DAY TO THE CALENDAR STRING
        calDoc += "<TD align=center bgcolor='" + cellColor + "'>" +
                  "<a class='" + dayType + "' href='javascript:parent.opener.returnDate(" + 
                  currentDay + ")'>" + padding + currentDay + paddingChar + "</a></TD>";

        columnCount++;

        // START A NEW ROW WHEN NECESSARY
        if (columnCount % 7 == 0) {
            calDoc += "</TR><TR>";
        }
    }

    // MAKE REMAINING NON-DATE CELLS BLANK
    for (i=days; i<42; i++)  
    {

        calDoc += blankCell;
    columnCount++;

        // START A NEW ROW WHEN NECESSARY
        if (columnCount % 7 == 0) {
            calDoc += "</TR>";
            if (i<41) {
                calDoc += "<TR>";
            }
        }
    }

    // FINISH THE NEW CALENDAR PAGE
    calDoc += calendarEnd;

    // RETURN THE COMPLETED CALENDAR PAGE
    return calDoc;
}


// WRITE THE MONTHLY CALENDAR TO THE BOTTOM CALENDAR FRAME
function writeCalendar() 
{

    // CREATE THE NEW CALENDAR FOR THE SELECTED MONTH & YEAR
    calDocBottom = buildBottomCalFrame();

    // WRITE THE NEW CALENDAR TO THE BOTTOM FRAME
    //top.newWin.frames['bottomCalFrame'].document.open();
    //top.newWin.frames['bottomCalFrame'].document.write(calDocBottom);
   // top.newWin.frames['bottomCalFrame'].document.close();
    
    top.newWin.frames[1].document.open();
    top.newWin.frames[1].document.write(calDocBottom);
    top.newWin.frames[1].document.close();

}


// SET THE CALENDAR TO TODAY'S DATE AND DISPLAY THE NEW CALENDAR
function setToday() 
{

    // SET GLOBAL DATE TO TODAY'S DATE
    calDate = new Date();
    
    //SET DAY TO TODAYS DAY-ADDED BY SUMAN ON 21st October, 2001                 
    calDay  = calDate.getDate();
    
    // SET DAY MONTH AND YEAR TO TODAY'S DATE
    var month = calDate.getMonth();
    var year  = calDate.getFullYear();

    // SET MONTH IN DROP-DOWN LIST
    top.newWin.frames['topCalFrame'].document.calControl.month.selectedIndex = month;

    // SET YEAR VALUE
    top.newWin.frames['topCalFrame'].document.calControl.year.value = year;

    // DISPLAY THE NEW CALENDAR
    writeCalendar();
}


// SET THE GLOBAL DATE TO THE NEWLY ENTERED YEAR AND REDRAW THE CALENDAR
function setYear() 
{

    // GET THE NEW YEAR VALUE
    var year  = top.newWin.frames['topCalFrame'].document.calControl.year.value;

    // IF IT'S A FOUR-DIGIT YEAR THEN CHANGE THE CALENDAR
    if (isFourDigitYear(year)) {
        calDate.setFullYear(year);
        writeCalendar();
    } else {
        // HIGHLIGHT THE YEAR IF THE YEAR IS NOT FOUR DIGITS IN LENGTH
        top.newWin.frames['topCalFrame'].document.calControl.year.focus();
        top.newWin.frames['topCalFrame'].document.calControl.year.select();
    }
}


// SET THE GLOBAL DATE TO THE SELECTED MONTH AND REDRAW THE CALENDAR
function setCurrentMonth() 
{

    // GET THE NEWLY SELECTED MONTH AND CHANGE THE CALENDAR ACCORDINGLY
    var month = top.newWin.frames['topCalFrame'].document.calControl.month.selectedIndex;

    calDate.setMonth(month);
    writeCalendar();
}


// SET THE GLOBAL DATE TO THE PREVIOUS YEAR AND REDRAW THE CALENDAR
function setPreviousYear() 
{

    var year  = top.newWin.frames[0].document.calControl.year.value;
        if (isFourDigitYear(year) && year > 1000) {
        year--;
        calDate.setFullYear(year);
        top.newWin.frames[0].document.calControl.year.value = year;
        writeCalendar();
    }
}


// SET THE GLOBAL DATE TO THE PREVIOUS MONTH AND REDRAW THE CALENDAR
function setPreviousMonth() 
{

    var year  = top.newWin.frames[0].document.calControl.year.value;
    if (isFourDigitYear(year)) {
        var month = top.newWin.frames[0].document.calControl.month.selectedIndex;

        // IF MONTH IS JANUARY, SET MONTH TO DECEMBER AND DECREMENT THE YEAR
        if (month == 0) {
            month = 11;
            if (year > 1000) {
                year--;
                calDate.setFullYear(year);
                top.newWin.frames[0].document.calControl.year.value = year;
            }
        } else {
            month--;
        }
        calDate.setMonth(month);
        top.newWin.frames[0].document.calControl.month.selectedIndex = month;
        writeCalendar();
    }
}


// SET THE GLOBAL DATE TO THE NEXT MONTH AND REDRAW THE CALENDAR
function setNextMonth() 
{

    var year = top.newWin.frames[0].document.calControl.year.value;

    if (isFourDigitYear(year)) {
        var month = top.newWin.frames[0].document.calControl.month.selectedIndex;

        // IF MONTH IS DECEMBER, SET MONTH TO JANUARY AND INCREMENT THE YEAR
        if (month == 11) {
            month = 0;
            year++;
            calDate.setFullYear(year);
            top.newWin.frames[0].document.calControl.year.value = year;
        } else {
            month++;
        }
        calDate.setMonth(month);
        top.newWin.frames[0].document.calControl.month.selectedIndex = month;
        writeCalendar();
    }
}


// SET THE GLOBAL DATE TO THE NEXT YEAR AND REDRAW THE CALENDAR
function setNextYear() 
{

    var year  = top.newWin.frames[0].document.calControl.year.value;
    if (isFourDigitYear(year)) {
        year++;
        calDate.setFullYear(year);
        top.newWin.frames[0].document.calControl.year.value = year;
        writeCalendar();
    }
}


// GET NUMBER OF DAYS IN MONTH
function getDaysInMonth()  
{

    var days;
    var month = calDate.getMonth()+1;
    var year  = calDate.getFullYear();

    // RETURN 31 DAYS
    if (month==1 || month==3 || month==5 || month==7 || month==8 ||
        month==10 || month==12)  {
        days=31;
    }
    // RETURN 30 DAYS
    else if (month==4 || month==6 || month==9 || month==11) {
        days=30;
    }
    // RETURN 29 DAYS
    else if (month==2)  {
        if (isLeapYear(year)) {
            days=29;
        }
        // RETURN 28 DAYS
        else {
            days=28;
        }
    }
    return (days);
}


// CHECK TO SEE IF YEAR IS A LEAP YEAR
function isLeapYear (Year) 
{

    if (((Year % 4)==0) && ((Year % 100)!=0) || ((Year % 400)==0)) {
        return (true);
    } else {
        return (false);
    }
}


// ENSURE THAT THE YEAR IS FOUR DIGITS IN LENGTH
function isFourDigitYear(year) 
{

    if (year.length != 4) {
        top.newWin.frames[0].document.calControl.year.value = calDate.getFullYear();
        top.newWin.frames[0].document.calControl.year.select();
        top.newWin.frames[0].document.calControl.year.focus();
    } else {
        return true;
    }
}


// BUILD THE MONTH SELECT LIST
function getMonthSelect() 
{

    // BROWSER LANGUAGE CHECK DONE PREVIOUSLY (navigator.language())
    // FIRST TWO CHARACTERS OF LANGUAGE STRING SPECIFIES THE LANGUAGE
    // (THE LAST THREE OPTIONAL CHARACTERS SPECIFY THE LANGUAGE SUBTYPE)
    // SET THE NAMES OF THE MONTH TO THE PROPER LANGUAGE (DEFAULT TO ENGLISH)

    // IF FRENCH
    if (selectedLanguage == "fr") {
        monthArray = new Array('Janvier', 'F?vrier', 'Mars', 'Avril', 'Mai', 'Juin',
                               'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'D?cembre');
    }
    // IF GERMAN
    else if (selectedLanguage == "de") {
        monthArray = new Array('Januar', 'Februar', 'M?rz', 'April', 'Mai', 'Juni',
                               'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
    }
    // IF SPANISH
    else if (selectedLanguage == "es") {
        monthArray = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
                               'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');
    }
    // DEFAULT TO ENGLISH
    else {
        monthArray = new Array('January', 'February', 'March', 'April', 'May', 'June',
                               'July', 'August', 'September', 'October', 'November', 'December');
    }

    // DETERMINE MONTH TO SET AS DEFAULT
    var activeMonth = calDate.getMonth();

    // START HTML SELECT LIST ELEMENT
    monthSelect = "<SELECT NAME='month' onChange='parent.opener.setCurrentMonth()'>";

    // LOOP THROUGH MONTH ARRAY
    for (i in monthArray) 
    {
        
        // SHOW THE CORRECT MONTH IN THE SELECT LIST
        if (i == activeMonth) {
            monthSelect += "<OPTION SELECTED>" + monthArray[i] + "\n";
        } else {
            monthSelect += "<OPTION>" + monthArray[i] + "\n";
        }
    }
    monthSelect += "</SELECT>";

    // RETURN A STRING VALUE WHICH CONTAINS A SELECT LIST OF ALL 12 MONTHS
    return monthSelect;
}


// SET DAYS OF THE WEEK DEPENDING ON LANGUAGE
function createWeekdayList() 
{

    // IF FRENCH
    if (selectedLanguage == "fr") {
        weekdayList  = new Array('Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi');
        weekdayArray = new Array('Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa');
    }
    // IF GERMAN
    else if (selectedLanguage == "de") {
        weekdayList  = new Array('Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag');
        weekdayArray = new Array('So', 'Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa');
    }
    // IF SPANISH
    else if (selectedLanguage == "es") {
        weekdayList  = new Array('Domingo', 'Lunes', 'Martes', 'Mi?rcoles', 'Jueves', 'Viernes', 'S?bado')
        weekdayArray = new Array('Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa');
    }
    else {
        weekdayList  = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
        weekdayArray = new Array('Su','Mo','Tu','We','Th','Fr','Sa');
    }

    // START HTML TO HOLD WEEKDAY NAMES IN TABLE FORMAT
    var weekdays = "<TR BGCOLOR='" + headingCellColor + "'>";

    // LOOP THROUGH WEEKDAY ARRAY
    for (i in weekdayArray) 
    {

        weekdays += "<TD class='heading' align=center>" + weekdayArray[i] + "</TD>";
    }
    weekdays += "</TR>";

    // RETURN TABLE ROW OF WEEKDAY ABBREVIATIONS TO DISPLAY ABOVE THE CALENDAR
    return weekdays;
}


// PRE-BUILD PORTIONS OF THE CALENDAR (FOR PERFORMANCE REASONS)
function buildCalParts() 
{

    // GENERATE WEEKDAY HEADERS FOR THE CALENDAR
    weekdays = createWeekdayList();

    // BUILD THE BLANK CELL ROWS
    blankCell = "<TD align=center bgcolor='" + cellColor + "'>&nbsp;&nbsp;&nbsp;</TD>";

    // BUILD THE TOP PORTION OF THE CALENDAR PAGE USING CSS TO CONTROL SOME DISPLAY ELEMENTS
    calendarBegin =
        "<HTML>" +
        "<HEAD>" +
        // STYLESHEET DEFINES APPEARANCE OF CALENDAR
        "<STYLE type='text/css'>" +
        "<!--" +
        "TD.heading { text-decoration: none; color:" + headingTextColor + "; font: " + headingFontStyle + "; }" +
        "A.focusDay:link { color: " + focusColor + "; text-decoration: none; font: " + fontStyle + "; }" +
        "A.focusDay:hover { color: " + focusColor + "; text-decoration: none; font: " + fontStyle + "; }" +
        "A.weekday:link { color: " + dateColor + "; text-decoration: none; font: " + fontStyle + "; }" +
        "A.weekday:hover { color: " + hoverColor + "; font: " + fontStyle + "; }" +
        "-->" +
        "</STYLE>" +
        "</HEAD>" +
        "<BODY BGCOLOR='" + bottomBackground + "'" +
        "<CENTER>";

        // NAVIGATOR NEEDS A TABLE CONTAINER TO DISPLAY THE TABLE OUTLINES PROPERLY
        if (isNav) {
            calendarBegin += 
                "<TABLE CELLPADDING=0 CELLSPACING=1 BORDER=" + tableBorder + " ALIGN=CENTER BGCOLOR='" + tableBGColor + "'><TR><TD>";
        }

        // BUILD WEEKDAY HEADINGS
        calendarBegin +=
            "<TABLE CELLPADDING=0 CELLSPACING=1 BORDER=" + tableBorder + " ALIGN=CENTER BGCOLOR='" + tableBGColor + "'>" +
            weekdays +
            "<TR>";


    // BUILD THE BOTTOM PORTION OF THE CALENDAR PAGE
    calendarEnd = "";

        // WHETHER OR NOT TO DISPLAY A THICK LINE BELOW THE CALENDAR
        if (bottomBorder) {
            calendarEnd += "<TR></TR>";
        }

        // NAVIGATOR NEEDS A TABLE CONTAINER TO DISPLAY THE BORDERS PROPERLY
        if (isNav) {
            calendarEnd += "</TD></TR></TABLE>";
        }

        // END THE TABLE AND HTML DOCUMENT
        calendarEnd +=
            "</TABLE>" +
            "</CENTER>" +
            "</BODY>" +
            "</HTML>";
}


// REPLACE ALL INSTANCES OF find WITH replace
// inString: the string you want to convert
// find:     the value to search for
// replace:  the value to substitute
//
// usage:    jsReplace(inString, find, replace);
// example:  jsReplace("To be or not to be", "be", "ski");
//           result: "To ski or not to ski"
//
function jsReplace(inString, find, replace) 
{

    var outString = "";

    if (!inString) {
        return "";
    }

    // REPLACE ALL INSTANCES OF find WITH replace
    if (inString.indexOf(find) != -1) {
        // SEPARATE THE STRING INTO AN ARRAY OF STRINGS USING THE VALUE IN find
        t = inString.split(find);

        // JOIN ALL ELEMENTS OF THE ARRAY, SEPARATED BY THE VALUE IN replace
        return (t.join(replace));
    } else {
        return inString;
    }
}


// JAVASCRIPT FUNCTION -- DOES NOTHING (USED FOR THE HREF IN THE CALENDAR CALL)
function doNothing() 
{
}


// ENSURE THAT VALUE IS TWO DIGITS IN LENGTH
function makeTwoDigit(inValue) 
{

    var numVal = parseInt(inValue, 10);

    // VALUE IS LESS THAN TWO DIGITS IN LENGTH
    if (numVal < 10) {

        // ADD A LEADING ZERO TO THE VALUE AND RETURN IT
        return("0" + numVal);
    }
    else {
        return numVal;
    }
}


// SET FIELD VALUE TO THE DATE SELECTED AND CLOSE THE CALENDAR WINDOW
function returnDate(inDay)
{

    // inDay = THE DAY THE USER CLICKED ON
    calDate.setDate(inDay);

    // SET THE DATE RETURNED TO THE USER
    var day           = calDate.getDate();
    var month         = calDate.getMonth()+1;
    var year          = calDate.getFullYear();
    var monthString   = monthArray[calDate.getMonth()];
    var monthAbbrev   = monthString.substring(0,3);
    var weekday       = weekdayList[calDate.getDay()];
    var weekdayAbbrev = weekday.substring(0,3);

    outDate = calDateFormat;

    // RETURN TWO DIGIT DAY
    if (calDateFormat.indexOf("DD") != -1) {
        day = makeTwoDigit(day);
        outDate = jsReplace(outDate, "DD", day);
    }
    // RETURN ONE OR TWO DIGIT DAY
    else if (calDateFormat.indexOf("dd") != -1) {
        outDate = jsReplace(outDate, "dd", day);
    }

    // RETURN TWO DIGIT MONTH
    if (calDateFormat.indexOf("MM") != -1) {
        month = makeTwoDigit(month);
        outDate = jsReplace(outDate, "MM", month);
    }
    // RETURN ONE OR TWO DIGIT MONTH
    else if (calDateFormat.indexOf("mm") != -1) {
        outDate = jsReplace(outDate, "mm", month);
    }

    // RETURN FOUR-DIGIT YEAR
    if (calDateFormat.indexOf("yyyy") != -1) {
        outDate = jsReplace(outDate, "yyyy", year);
    }
    // RETURN TWO-DIGIT YEAR
    else if (calDateFormat.indexOf("yy") != -1) {
        var yearString = "" + year;
        var yearString = yearString.substring(2,4);
        outDate = jsReplace(outDate, "yy", yearString);
    }
    // RETURN FOUR-DIGIT YEAR
    else if (calDateFormat.indexOf("YY") != -1) {
        outDate = jsReplace(outDate, "YY", year);
    }

    // RETURN DAY OF MONTH (Initial Caps)
    if (calDateFormat.indexOf("Month") != -1) {
        outDate = jsReplace(outDate, "Month", monthString);
    }
    // RETURN DAY OF MONTH (lowercase letters)
    else if (calDateFormat.indexOf("month") != -1) {
        outDate = jsReplace(outDate, "month", monthString.toLowerCase());
    }
    // RETURN DAY OF MONTH (UPPERCASE LETTERS)
    else if (calDateFormat.indexOf("MONTH") != -1) {
        outDate = jsReplace(outDate, "MONTH", monthString.toUpperCase());
    }

    // RETURN DAY OF MONTH 3-DAY ABBREVIATION (Initial Caps)
    if (calDateFormat.indexOf("Mon") != -1) {
        outDate = jsReplace(outDate, "Mon", monthAbbrev);
    }
    // RETURN DAY OF MONTH 3-DAY ABBREVIATION (lowercase letters)
    else if (calDateFormat.indexOf("mon") != -1) {
        outDate = jsReplace(outDate, "mon", monthAbbrev.toLowerCase());
    }
    // RETURN DAY OF MONTH 3-DAY ABBREVIATION (UPPERCASE LETTERS)
    else if (calDateFormat.indexOf("MON") != -1) {
        outDate = jsReplace(outDate, "MON", monthAbbrev.toUpperCase());
    }

    // RETURN WEEKDAY (Initial Caps)
    if (calDateFormat.indexOf("Weekday") != -1) {
        outDate = jsReplace(outDate, "Weekday", weekday);
    }
    // RETURN WEEKDAY (lowercase letters)
    else if (calDateFormat.indexOf("weekday") != -1) {
        outDate = jsReplace(outDate, "weekday", weekday.toLowerCase());
    }
    // RETURN WEEKDAY (UPPERCASE LETTERS)
    else if (calDateFormat.indexOf("WEEKDAY") != -1) {
        outDate = jsReplace(outDate, "WEEKDAY", weekday.toUpperCase());
    }

    // RETURN WEEKDAY 3-DAY ABBREVIATION (Initial Caps)
    if (calDateFormat.indexOf("Wkdy") != -1) {
        outDate = jsReplace(outDate, "Wkdy", weekdayAbbrev);
    }
    // RETURN WEEKDAY 3-DAY ABBREVIATION (lowercase letters)
    else if (calDateFormat.indexOf("wkdy") != -1) {
        outDate = jsReplace(outDate, "wkdy", weekdayAbbrev.toLowerCase());
    }
    // RETURN WEEKDAY 3-DAY ABBREVIATION (UPPERCASE LETTERS)
    else if (calDateFormat.indexOf("WKDY") != -1) {
        outDate = jsReplace(outDate, "WKDY", weekdayAbbrev.toUpperCase());
    }

    // SET THE VALUE OF THE FIELD THAT WAS PASSED TO THE CALENDAR
    calDateField.value = outDate;

    // GIVE FOCUS BACK TO THE DATE FIELD
    calDateField.focus();

    // CLOSE THE CALENDAR WINDOW
    top.newWin.close();
    
    
}


//New functions Added
//BEGIN Venkat Karuppagounder 07/01/2004

function y2k(number) { return (number < 1000) ? number + 1900 : number; }

function getCorrectedYear(year) 
{
    year = year - 0;
    if (year < 70) return (2000 + year);
    if (year < 1900) return (1900 + year);
    return year;
}

function isDate (day,month,year) {
// checks if date passed is valid
// will accept dates in following format:
// isDate(dd,mm,ccyy), or
// isDate(dd,mm) - which defaults to the current year, or
// isDate(dd) - which defaults to the current month and year.
// Note, if passed the month must be between 1 and 12, and the
// year in ccyy format.
    var today = new Date();
    year = ((!year) ? y2k(today.getYear()):year);
    month = ((!month) ? today.getMonth():month-1);
    if (!day) return false
    var test = new Date(year,month,day);
    if ( (y2k(test.getYear()) == year) &&
         (month == test.getMonth()) &&
         (day == test.getDate()) )
        return true;
    else
        return false
}

//END VK 07/01/04


function addZero(vNumber){ 
    return ((vNumber < 10) ? "0" : "") + vNumber 
}
        
function formatDate(vDate, vFormat){ 
    var vDay              = addZero(vDate.getDate()); 
    var vMonth            = addZero(vDate.getMonth()+1); 
    var vYearLong         = addZero(vDate.getFullYear()); 
    var vYearShort        = addZero(vDate.getFullYear().toString().substring(3,4)); 
    var vYear             = (vFormat.indexOf("yyyy")>-1?vYearLong:vYearShort) 
    var vHour             = addZero(vDate.getHours()); 
    var vMinute           = addZero(vDate.getMinutes()); 
    var vSecond           = addZero(vDate.getSeconds()); 
    var vDateString       = vFormat.replace(/dd/g, vDay).replace(/MM/g, vMonth).replace(/y{1,4}/g, vYear) 
    vDateString           = vDateString.replace(/hh/g, vHour).replace(/mm/g, vMinute).replace(/ss/g, vSecond) 
    return vDateString 
} 

