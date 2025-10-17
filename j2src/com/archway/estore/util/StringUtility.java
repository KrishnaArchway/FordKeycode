package com.archway.estore.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : StringUtility.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:43 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:43 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class StringUtility
{

	public StringUtility ()
	{

	}

	public static String escapeString ( String in )
	{
		return StringEscapeUtils.escapeJavaScript ( in );
	}

	public static String FormatPhone ( String phone )
	{
		/*
		 * boolean flag = false; String aString1 = phone; StringBuffer
		 * newString1 = new StringBuffer (); String returnString = ""; if ( !
		 * isStringBlank ( phone ) ) {
		 * 
		 * newString1.append ( "(" ); for ( int i = 0 ; i < aString1.length () ;
		 * i++ ) { if ( Character.isDigit ( aString1.charAt ( i ) ) )
		 * newString1.append ( aString1.charAt ( i ) ); if ( i == 2 )
		 * newString1.append ( ")-" ); if ( i == 5 ) newString1.append ( "-" );
		 *  } //cat.warn("from UtilFormat "+newString1.toString()); //return
		 * newString1.toString(); flag = true; } else { flag = false; }
		 * 
		 * if ( flag == true ) { returnString = ( newString1.toString ().length () >=
		 * 3 ) ? newString1.toString () : ""; } else { returnString = ""; }
		 */

		return phone;

	}

	/**
	 * 
	 * @return
	 */
	public static String getRandomPasswordSevenDigits ()
	{
		String random = String.valueOf ( Math.random () );
		random = random.substring ( random.length () - 7 , random.length () );
		if ( random.endsWith ( "0" ) )
		{
			random = random.substring ( random.length () - 1 , random.length () ) + "9";
		}
		return random;
	}

	public static String arrayToString2 ( String [] a , String separator )
	{
		StringBuffer result = new StringBuffer ();
		if ( a.length > 0 )
		{
			result.append ( a [0] );
			for ( int i = 1 ; i < a.length ; i++ )
			{
				result.append ( separator );
				result.append ( a [i] );
			}
		}
		return result.toString ();
	}

	public static String setStringValue ( String istrStrValue )
	{
		if ( istrStrValue == null || istrStrValue.trim ().equalsIgnoreCase ( "null" ) )
			return null;
		else
			return istrStrValue.trim ();
	}

	/**
	 * 
	 * @param in
	 * @param len
	 * @return
	 */
	public static String padSpaces ( String in , int len )
	{
		String returnString = in;
		int len2 = len - in.length ();
		// len++;
		for ( int i = 0 ; i < len2 ; i++ )
		{
			returnString += "%";
		}

		return returnString;
	}

	/**
	 * 
	 * @param in
	 * @param len
	 * @return
	 */
	public static String padDots ( String in , int len )
	{
		String returnString = "";
		if ( in.trim ().length () >= len )
			returnString = in.substring ( 0 , len - 3 ) + "...";
		else
			returnString = in;
		returnString = in;
		return returnString;
	}

	/**
	 * This method process parameters to return the correct value
	 * 
	 * @param input
	 * @return
	 */
	public static String processNullToEmpty ( String input )
	{
		if ( input == null || input.equalsIgnoreCase ( "null" ) )
			return "";
		else
			return input;
	}

	public static String processNullToEmptyDollarAmount ( String input )
	{
		if ( input == null || input.equalsIgnoreCase ( "null" ) )
			return "0.0";
		else
			return input;
	}

	/**
	 * returns "N/A" for a blank string
	 * 
	 * @param input
	 * @return
	 */
	public static String displayNAForBlank ( String input )
	{
		if ( StringUtils.isBlank ( input ) )
		{
			return "N/A";
		}
		else
		{
			return input;
		}
	}

	/**
	 * Replaces illegal characters with legal ones. Used to filter database
	 * content for display in HTML.
	 * 
	 * @param string
	 * @return
	 */
	public static String escape ( String string )
	{

		string = StringUtils.replace ( string , "&" , "&#38;" );
		string = StringUtils.replace ( string , "<" , "&lt;" );
		string = StringUtils.replace ( string , ">" , "&gt;" );
		string = StringUtils.replace ( string , "!" , "&#33;" );
		string = StringUtils.replace ( string , "{" , "&#123;" );
		string = StringUtils.replace ( string , "}" , "&#125;" );
		/*
		 * to remove these 3 lines? string = StringUtils.replace(string, "\\n",
		 * "\\\\n"); string = StringUtils.replace(string, "\\\'", "\\\'\\\'");
		 * string = StringUtils.replace(string, "'", "\\'");
		 */
		string = StringUtils.replace ( string , "'" , "&#39;" );
		string = StringUtils.replace ( string , "\"" , "&quot;" );

		return string;
	}

	/**
	 * Formats a string representation of a float value to look like $x.xx
	 * 
	 * @param amount
	 * @return
	 */
	public static String displayDollars ( String amount )
	{
		if ( amount == null || amount.equals ( "" ) ) amount = "0.00";
		return displayDollars ( new Float ( amount ).floatValue () );
	}

	/**
	 * Formats a float value to look like $x.xx
	 * 
	 * @param amount
	 * @return
	 */
	public static String displayDollars ( float amount )
	{
		Currency dollars = Currency.getInstance ( "USD" );
		NumberFormat usFormat = NumberFormat.getCurrencyInstance ( Locale.US );
		return usFormat.format ( amount );
	}

	/**
	 * 
	 * @param amount
	 * @return
	 */
	public static String displayDollars ( double amount )
	{
		Currency dollars = Currency.getInstance ( "USD" );
		NumberFormat usFormat = NumberFormat.getCurrencyInstance ( Locale.US );
		return usFormat.format ( amount );
	}

	/**
	 * Returns a string with the formatted float value such as xxx.xx if the
	 * value is only xxx.x Scale is the number of decimal places to include.
	 * 
	 * @param amount
	 * @param scale
	 * @return
	 */
	public static String displayFloat ( float amount , int scale )
	{
		/*
		 * below would require the percent to be stored as .XX instead of
		 * XXX.XX% NumberFormat numFormat = NumberFormat.getPercentInstance();
		 * numFormat.setMaximumFractionDigits(scale);
		 * numFormat.setMinimumFractionDigits(scale); return
		 * numFormat.format(amount);
		 */
		NumberFormat numFormat = NumberFormat.getNumberInstance ();
		numFormat.setMaximumFractionDigits ( scale );
		numFormat.setMinimumFractionDigits ( scale );
		return numFormat.format ( amount );
	}

	/**
	 * Test if the string is blank (null or empty string or equals to "null")
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isStringBlank ( String string )
	{
		return ( string == null || string.trim ().length () == 0 || string.trim ().equalsIgnoreCase ( "null" ) );
	}

	/**
	 * Escape any bad characters that are going into a sql string...
	 * 
	 * @param string
	 * @return
	 */
	public static String quote ( String string )
	{
		if ( string == null ) return string;
		// string = StringUtils.replace(string, "$", "\\$");
		string = StringUtils.replace ( string , "\\" , "\\\\" );
		string = StringUtils.replace ( string , "\\\'" , "\\\'\\\'" );
		string = StringUtils.replace ( string , "'" , "\\'" );
		return string;
	}

	public static boolean isEmailAddressValid ( String emailAddress )
																		throws Exception
	{
		final String QUOTEDSTRING = "\"(?:[^\"\\\\]|\\\\\\p{ASCII})*\"";
		final String ATOM = "[^()<>@,;:\\\\\".\\[\\] \\x28\\p{Cntrl}]+";
		final String WORD = "(?:" + ATOM + "|" + QUOTEDSTRING + ")";
		final String SUBDOMAIN = "(?:" + ATOM + "|\\[(?:[^\\[\\]\\\\]|\\\\\\p{ASCII})*\\])";
		final String DOMAIN = SUBDOMAIN + "(?:\\." + SUBDOMAIN + ")*";
		final String LOCALPART = WORD + "(?:\\." + WORD + ")*";
		final String EMAIL = LOCALPART + "@" + DOMAIN;
		Pattern p = Pattern.compile ( EMAIL );
		Matcher m = p.matcher ( emailAddress.trim () );
		return ( m.matches () );
	}

	/**
	 * returns "Not Available" for a blank string
	 * 
	 * @param input
	 * @return
	 */
	public static String displayNotAvailableForBlank ( String input )
	{
		// StringUtils.isBlank()
		if ( StringUtils.isBlank ( input ) )
		{
			return "N/A";
		}
		else
		{
			return input;
		}
	}

	/**
	 * returns "No Subject" for a blank string
	 * 
	 * @param input
	 * @return
	 */
	public static String displayNoSubjectForBlank ( String input )
	{
		if ( StringUtils.isBlank ( input ) )
		{
			return "No Subject";
		}
		else
		{
			return input;
		}
	}

	/*
	 * public static void TestOraCLobInsert () {
	 * 
	 * 
	 * try {
	 * 
	 * DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	 * Connection conn = DriverManager.getConnection
	 * ("jdbc:oracle:thin:@server:1521:sid", "uid", "pwd");
	 * 
	 * PreparedStatement ps = conn.prepareStatement("INSERT INTO CLOBTABLE
	 * VALUES (?)");
	 * 
	 * oracle.sql.CLOB newClob = oracle.sql.CLOB.createTemporary(conn, false,
	 * oracle.sql.CLOB.DURATION_CALL);
	 * 
	 * newClob.putString(1,"This string, up to 4 gigabytes will be inserted into
	 * the CLOB");
	 * 
	 * ps.setClob(1, newClob);
	 * 
	 * int rowcnt = ps.executeUpdate();
	 * 
	 * System.out.println("Successful update of "+rowcnt+" row");
	 * 
	 * ps.close(); conn.close(); } catch (Exception e) {
	 * System.out.println("Java Exception caught, error
	 * message="+e.getMessage()); } }
	 */

	/**
	 * Remove the single and double qoutes of given string
	 */
	public static String doReplaceAll ( String str )
	{
		String strReturn = "";

		if ( ! StringUtility.isStringBlank ( str ) )
		{
			strReturn = str.trim ().replaceAll ( "\"" , "\\\\\"" ).replaceAll ( "\'" , "\\\\\'" ).replaceAll ( "\\r\n" , " " ).replaceAll ( "\n" , " " );
		}
		else
		{
			strReturn = "";
		}

		return strReturn;
	}
}