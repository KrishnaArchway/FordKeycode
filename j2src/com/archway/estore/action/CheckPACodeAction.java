package com.archway.estore.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;

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
 * File Name               : CheckPACodeAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:55:08 PM
 * 
 * Change Date             : Jan 20, 2014 8:55:08 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class CheckPACodeAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( PreShowAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "CheckPACodeAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "success";
		HttpSession session = request.getSession ();
		String html = "";
		try
		{
			String pacode = request.getParameter ( "pacode" );
			String paCodeDesc = DMLManager.isPACodeValid ( pacode );
			html = paCodeDesc + "~";
		}
		catch ( Exception ex )
		{

			logger.debug ( "***********************************************************************" );
			logger.debug ( "------------- ShowAction.execute() ----------------------" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "***********************************************************************" );

			target = "contentError";
		}
		finally
		{
		}

		response.setContentType ( "text/html" );
		/*response.setHeader ( "Cache-Control" , "no-cache" );*/
		response.getWriter ().write ( html );

		logger.exiting ( methodName );
		logger.debug ( "*************************************" );
		return null;

	}
}
