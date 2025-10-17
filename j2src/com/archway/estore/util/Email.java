package com.archway.estore.util;

import com.archway.estore.common.Logger;
import com.archway.estore.environment.Environment;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

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
 * File Name               : Email.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:02:50 PM
 * 
 * Change Date             : Jan 20, 2014 9:02:50 PM
 * 							 Jan 28, 2014 6:18:40 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class Email
{

	protected static final Logger	logger	= Logger.getLogger ( Email.class );

	/**
	 * Send Email with File Attachment and Body as HTML format.
	 * 
	 * @param from
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param subject
	 * @param fileName
	 * @param htmlText
	 * @param plainText
	 * @return
	 * @throws Exception
	 */
	public static boolean SendHtmlEmailWithFileAttachment (
															String from ,
															String to[] ,
															String cc[] ,
															String bcc[] ,
															String subject ,
															String fileName[] ,
															String htmlText ,
															String plainText )
																				throws Exception
	{
		logger.entering ( "SendHtmlEmailWithFileAttachment(String, String[], String [], String[], String,String[],String,String)" );
		boolean returnFlag = false;
		try
		{
			SmtpFinder sf = new SmtpFinder ();
			// Create the email message
			HtmlEmail email = new HtmlEmail ();
			email.setHostName ( sf.getLocalSmtpServer () );
			email.setFrom ( from , from );
			email.setBounceAddress ( from );
			email.addReplyTo ( from , from );

			// START sets the emails address depending on which Database the
			// email job is running againts.
			String ENVIRONMENT = Environment.getEnv ();
			String emailAlwaysBcc = "";

			for ( int i = 0 ; i < to.length ; i++ )
			{
				email.addTo ( to [i] , to [i] );
			}
			if ( cc != null )
			{
				for ( int i = 0 ; i < cc.length ; i++ )
				{
					email.addCc ( cc [i] , cc [i] );
				}
			}
			if ( bcc != null )
			{
				for ( int i = 0 ; i < bcc.length ; i++ )
				{
					email.addBcc ( bcc [i] , bcc [i] );
				}
			}
			email.setSubject ( StringUtility.displayNoSubjectForBlank ( subject ) );

			// Create the attachment if any....
			if ( fileName != null )
			{
				for ( int i = 0 ; i < fileName.length ; i++ )
				{
					if ( ! StringUtility.isStringBlank ( fileName [i] ) )
					{

						EmailAttachment attachment = new EmailAttachment ();
						attachment.setPath ( fileName [i] );
						attachment.setDisposition ( EmailAttachment.ATTACHMENT );
						attachment.setDescription ( Splitter ( fileName [i] ) );
						attachment.setName ( "" );
						// add the attachment
						email.attach ( attachment );
					}
				}
			}
			// set the character set
			email.setCharset ( "iso-8859-1" );
			// set the html message
			email.setHtmlMsg ( Html.cleanHtml ( htmlText ) );
			// set the alternative message
			email.setTextMsg ( plainText );
			// send the email
			email.send ();
			returnFlag = true;

		}
		catch ( Exception e )
		{
			returnFlag = false;
			logger.debug ( "Exception encountered Email.java " + e.getMessage () );
			System.out.println ( "Exception encountered Email.java " + e.getMessage () );
		}
		logger.exiting ( "SendHtmlEmailWithFileAttachment(String, String[], String [], String[], String, String[],String ,String)" );
		return returnFlag;
	}

	/**
	 * returns just the file name from the path i.e. "c:/temp/temp/dummy.txt"
	 * will return "dummy.txt"
	 * 
	 * @param str
	 * @return
	 */
	public static String Splitter ( String str )
	{
		int maxLength = 0;

		if ( ! StringUtility.isStringBlank ( str ) )
		{
			// str=str.replaceAll("\\\","/");
			String [] temp = str.split ( "/" );
			maxLength = temp.length;
			return temp [maxLength - 1];
		}
		else
		{
			return "";
		}
	}

	/**
	 * Default Constructor.
	 */
	public Email ()
	{

	}

}