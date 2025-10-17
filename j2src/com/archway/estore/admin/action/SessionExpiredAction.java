package com.archway.estore.admin.action;

import com.archway.estore.common.Logger;

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
 * File Name               : SessionExpiredAction.java 
 * Package Name            : com.archway.estore.admin.action
 * 
 * Date                    : Jan 20, 2014 8:59:27 PM
 * 
 * Change Date             : Jan 20, 2014 8:59:27 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class SessionExpiredAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( SessionExpiredAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "SessionExpiredAction.java execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse";
		logger.entering ( methodName );
		return mapping.findForward ( "continue" );

	}
}
