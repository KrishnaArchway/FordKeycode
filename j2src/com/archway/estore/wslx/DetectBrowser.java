package com.archway.estore.wslx;

import com.archway.estore.common.Logger;

import java.io.Serializable;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

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
 * File Name               : DetectBrowser.java 
 * Package Name            : com.archway.estore.wslx
 * 
 * Date                    : Jan 20, 2014 9:04:05 PM
 * 
 * Change Date             : Jan 20, 2014 9:04:05 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class DetectBrowser implements Serializable
{

	private static Logger		logger				= Logger.getLogger ( DetectBrowser.class );

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private boolean				ie					= false;

	private boolean				netEnabled			= false;

	private boolean				ns4					= false;

	private boolean				ns6					= false;

	/**
	 *
	 * Declaring variables
	 *
	 */

	private HttpServletRequest	request				= null;

	private String				strHostName			= "";

	private String				useragent			= null;

	private String				UserIPAddress		= "";

	public DetectBrowser ()
	{

	}

	/**
	 * return the hostName from where the request
	 * is being generated
	 */
	public String getHostName ()
	{
		return this.strHostName;
	}

	/**
	 * return user agent from the request
	 */
	public String getUseragent ()
	{
		return useragent;
	}

	/**
	 * return the IP Address from where the request
	 * is being generated
	 */
	public String getUserIPAddress ()
	{
		return this.UserIPAddress;
	}

	/**
	 * return is the browser IE from where the request
	 * is being generated
	 */
	public boolean isIE ()
	{
		return ie;
	}

	/**
	 * return net enables from the request
	 */
	public boolean isNetEnabled ()
	{
		return netEnabled;
	}

	/**
	 * return is the browser NestScape 4.0 from where the request
	 * is being generated
	 */
	public boolean isNS4 ()
	{
		return ns4;
	}

	/**
	 * return is the browser NetScape 6.0 from where the request
	 * is being generated
	 */
	public boolean isNS6 ()
	{
		return ns6;
	}

	/**
	 * this method is for setting the request
	 * and logging the information in to a log file.
	 *
	 */
	public void setRequest ( HttpServletRequest req )
	{
		request = req;
		useragent = request.getHeader ( "User-Agent" );

		String user = useragent.toLowerCase ();
		if ( user.indexOf ( "msie" ) != - 1 )
		{
			ie = true;
		}
		else if ( user.indexOf ( "netscape6" ) != - 1 )
		{
			ns6 = true;
		}
		else if ( user.indexOf ( "mozilla" ) != - 1 )
		{
			ns4 = true;
		}

		if ( user.indexOf ( ".net clr" ) != - 1 ) netEnabled = true;

		//now log the information

		try
		{
			this.strHostName = InetAddress.getLocalHost ().getHostName ();
			this.UserIPAddress = request.getRemoteAddr ();
		}
		catch ( Exception e )
		{
		}

		//cat.fatal("************************** USER INFORMATION ******************************");
		//cat.fatal("Browser Type and User Operation System 	--> "+getUseragent());
		//cat.fatal("Net Enabled                           	--> "+isNetEnabled());
		//cat.fatal("Is Browser Internet Explorer           	--> "+isIE());
		//cat.fatal("Is Browser Netscape ver 6              	--> "+isNS6());
		//cat.fatal("Is Browser Netscape ver 4              	--> "+isNS4());
		//cat.fatal("Host Name you are coming from          	--> "+getHostName());
		//cat.fatal("Host IP address you are coming from    	--> "+getUserIPAddress());
		//cat.fatal("************************** USER INFORMATION ******************************");

	}

}
