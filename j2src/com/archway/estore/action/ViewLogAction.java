package com.archway.estore.action;

import com.archway.estore.common.Logger;
import com.archway.estore.entities.FileBean;
import com.archway.estore.util.FileUtility;
import com.archway.estore.util.StringUtility;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
 * File Name               : ViewLogAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : May 24, 2013 9:19:43 AM
 * 
 * Change Date             : May 24, 2013 9:19:43 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class ViewLogAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( ViewLogAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "ViewLogAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "continue";
		HttpSession session = request.getSession ();
		try
		{
			String logPath = System.getProperty ( "LOG_DIR" );
			//String logPath =  "C:\\fordkeycode\\logs\\" ;			
			logger.warn ( "logPath " + logPath );
			if ( ! StringUtility.isStringBlank ( logPath ) )
			{
				FileBean fb[] = FileUtility.getFileInfoFromDirectory ( logPath );
				request.setAttribute ( "FileBean" , fb );
				request.setAttribute ( "FilePath" , logPath );

			}
			else
			{

				request.setAttribute ( "FileBean" , null );
				request.setAttribute ( "FilePath" , null );
			}

		}
		catch ( Exception e )
		{
			target = "fail";
			//e.printStackTrace ();
			logger.debug ( "************************************************" );
			logger.debug ( "--- ViewLogAction.execute() ---" );
			logger.debug ( "Exception :: " + e.getLocalizedMessage () );
			logger.debug ( "************************************************" );
		}
		finally
		{
		}

		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "************************************************" );

		return mapping.findForward ( target );

	}
}
