package com.archway.estore.util;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;

import java.net.InetAddress;

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
 * File Name               : SmtpFinder.java 
 * Package Name            : com.archway.estore.util
 * 
 * Date                    : Jan 20, 2014 9:03:35 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:35 PM
 * 							 Jan 28, 2014 6:18:47 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class SmtpFinder
{

	protected static final Logger	logger	= Logger.getLogger ( SmtpFinder.class );

	/**
	 * Default Constructor.
	 */

	public SmtpFinder ()
	{

	}

	/**
	 * Get's the local server name for relaying the email.
	 */
	public String getLocalSmtpServer () throws Exception
	{
		String smtp = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_MAIL_HOST" );
		logger.warn ( "returning smtp server name as :" + smtp );
		return smtp;
	}

	public String getServerName () throws Exception
	{
		String host = "";
		InetAddress address = InetAddress.getLocalHost ();
		host = address.getHostName ();
		return host;

	}

}