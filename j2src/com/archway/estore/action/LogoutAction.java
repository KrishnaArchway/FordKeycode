package com.archway.estore.action;

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
 * File Name               : LogoutAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:55:25 PM
 * 
 * Change Date             : Jan 20, 2014 8:55:25 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class LogoutAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( LogoutAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{
		String methodName = "LogoutAction.execute ::: ";
		logger.debug ( "******************************************************" );
		logger.entering ( methodName );
		HttpSession session = request.getSession ();
		session.invalidate ();
		ActionForward target = mapping.findForward ( "continue" );
		logger.exiting ( methodName );
		logger.debug ( "******************************************************" );
		return target;
	}

}
