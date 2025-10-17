package com.archway.estore.util;

import com.archway.estore.common.Logger;

import org.w3c.tidy.Tidy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

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
 * File Name               : Html.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:18 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:18 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class Html
{

	public static final Logger	logger	= Logger.getLogger ( Html.class );

	/**
	 * 
	 * @param in
	 * @return
	 */
	public static String removeHtmlAndGetText ( String in )
	{
		if ( StringUtility.isStringBlank ( in ) )
		{
			return "";
		}

		String returnString = "";
		try
		{
			StringBuffer sb = new StringBuffer ();
			sb.append ( in );
			returnString = sb.toString ().replaceAll ( "\\<.*?>" , "" );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
		}

		return returnString.replaceAll ( "'" , "" ).replaceAll ( "&nbsp;" , " " ).replaceAll ( "&amp;" , "&" ).replaceAll ( "\\s\\s+|\\n|\\r" , " " );
	}

	/**
	 * formats and clean the string containing html
	 * 
	 * @param in
	 * @return
	 */
	public static String cleanHtml ( String in )
	{

		String outx = "";
		try
		{
			Tidy tidy = new Tidy ();
			tidy.setCharEncoding ( 4 );
			long tidylength;
			// at input not XML
			tidy.setQuiet ( true );
			tidy.setShowWarnings ( false );
			// tidy.setXmlOut(true);
			tidy.setXHTML ( true );
			tidy.setWord2000 ( true );
			tidy.setUpperCaseTags ( true );
			tidy.setCharEncoding ( org.w3c.tidy.Configuration.UTF8 );
			tidy.setMakeClean ( true );
			tidy.setSmartIndent ( true );
			tidy.setUpperCaseAttrs ( true );
			String s = in;
			char chars[] = s.toCharArray ();
			byte bytes[] = new byte[chars.length];
			for ( int i = 0 ; i < chars.length ; i++ )
			{
				bytes [i] = ( byte ) chars [i];
			}
			ByteArrayInputStream bais = new ByteArrayInputStream ( bytes );
			ByteArrayOutputStream out = new ByteArrayOutputStream ();
			tidy.parse ( bais , out );
			// outx = "\n********\n" + out.toString () + "********\n";
			outx = out.toString ();
		}
		catch ( Exception e )
		{
			logger.warn ( e.getMessage () );
		}
		return outx;
	}

	/**
	 * Default Constructor
	 * 
	 */
	public Html ()
	{

	}
}