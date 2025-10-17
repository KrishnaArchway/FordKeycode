package com.archway.estore.filters;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;
import com.archway.estore.util.DateUtility;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * File Name               : SessionFilter.java 
 * Package Name            : com.archway.estore.filters
 * 
 * Date                    : Jan 20, 2014 9:01:28 PM
 * 
 * Change Date             : Jan 20, 2014 9:01:28 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class SessionFilter implements Filter
{

	private static final Logger	logger		= Logger.getLogger ( "SessionFilter" );

	private static final Logger	loggerOld	= Logger.getLogger ( SessionFilter.class );

	public void doFilter (
							ServletRequest req ,
							ServletResponse res ,
							FilterChain chain )
												throws IOException ,
												ServletException
	{

		HttpServletRequest request = ( HttpServletRequest ) req;
		HttpServletResponse response = ( HttpServletResponse ) res;
		HttpSession session = request.getSession ();

		// Get the IP address of client machine.
		String ipAddress = request.getRemoteAddr ();
		String uri = request.getRequestURI ().toUpperCase ();
		String url = request.getRequestURL ().toString ();

		logger.warn ( "******************************************************************************************" );
		logger.warn ( "IP " + ipAddress + ", Time " + new Date ().toString () );
		logger.warn ( "URI    " + uri );
		logger.warn ( "URL    " + url );

		// Log the IP address and current timestamp.
		logger.warn ( "IP " + ipAddress + ", Time " + DateUtility.getCurrentDateTime () );
		logger.warn ( "******************************************************************************************" );
		
		if(uri.contains("NULL")) {
			response.sendRedirect ( response.encodeURL ( "index.jsp" ) );
		}
		/*SessionBean sb = null;
		 sb = ( SessionBean ) session.getAttribute ( "SessionBean" );

		 if ( sb == null )
		 {
		 if ( uri.indexOf ( "newVehicle.do".toUpperCase () ) != - 1 
		 || uri.indexOf ( "newVehicle.jsp".toUpperCase () ) != - 1 
		 || uri.indexOf ( "index.jsp".toUpperCase () ) != - 1 
		 || uri.indexOf ( "sessionExpired.do".toUpperCase () ) != - 1 
		 || uri.indexOf ( "logout.do".toUpperCase () ) != - 1 
		 || uri.indexOf ( "show.do".toUpperCase () ) != - 1 
		 || uri.indexOf ( "adminLogin.do".toUpperCase () ) != - 1 
		 || uri.indexOf ( "KeyCodeServlet".toUpperCase () ) != - 1 || uri.indexOf ( "webservices".toUpperCase () ) != - 1 )
		 {

		 }
		 else
		 {
		 String redirectUrl = ConfigurationServlet.getApplicationProperty ( "fail.url" );
		 logger.warn ( "redirectUrl :" + redirectUrl );
		 loggerOld.warn ( "redirectUrl :" + redirectUrl );
		 response.sendRedirect ( response.encodeURL ( redirectUrl ) );
		 logger.warn ( "session invalid" );
		 loggerOld.warn ( "session invalid" );
		 }
		 }*/

		chain.doFilter ( req , res );
	}

	public void init ( FilterConfig config ) throws ServletException
	{
		try
		{
			DMLManager.testConnection ();
		}
		catch ( Exception e )
		{

		}

	}

	public void destroy ()
	{
		// add code to release any resource
	}
}
