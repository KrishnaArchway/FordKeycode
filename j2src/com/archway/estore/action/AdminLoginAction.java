package com.archway.estore.action;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.util.StringUtility;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * File Name               : AdminLoginAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:54:37 PM
 * 
 * Change Date             : Jan 20, 2014 8:54:37 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class AdminLoginAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( AdminLoginAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "AdminLoginAction.java ActionForward( ActionMapping , ActionForm , HttpServletRequest , HttpServletResponse)";
		logger.debug ( "******************************************************************************************************************" );
		logger.entering ( methodName );
		String target = "";

		try
		{
			String mode = request.getParameter ( "mode" );
			if ( StringUtility.isStringBlank ( mode ) )
			{
				target = "adminLogin";
				//return target;
			}

			if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "auth" ) )
			{
				// authincate the user id and password
				String userId = "";
				String password = "";
				if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "userId" ) ) )
				{
					userId = request.getParameter ( "userId" );
				}
				else
				{
					target = "adminLogin";
					request.setAttribute ( "adminAuthError" , "Y" );
					//return target;
				}
				if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "password" ) ) )
				{
					password = request.getParameter ( "password" );
				}
				else
				{
					target = "adminLogin";
					request.setAttribute ( "adminAuthError" , "Y" );
					//return target;
				}

				logger.warn ( "User Id  :" + userId );
				logger.warn ( "password :" + password );

				// Admin Login and passowrd. Storing it statically in properties
				// file as auto database does
				// not have the Structure to support database authincation
				if ( userId.equalsIgnoreCase ( ConfigurationServlet.getApplicationProperty ( "ADMIN_LOGIN_ID" ) ) && password.equalsIgnoreCase ( ConfigurationServlet.getApplicationProperty ( "ADMIN_PASSWORD" ) ) )
				{
					target = "adminHome";
					//return target;
				}
				else
				{
					target = "adminLogin";
					request.setAttribute ( "adminAuthError" , "Y" );
					//return target;
				}

			}

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
		}
		finally
		{
			//logger.exiting ( methodName );
		}
		logger.exiting ( "Action Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "******************************************************************************************************************" );
		return mapping.findForward ( target );

	}

}
