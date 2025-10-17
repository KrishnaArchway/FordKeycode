package com.archway.estore.action;

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
 * File Name               : RegistrationCompleteAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:56:34 PM
 * 
 * Change Date             : Jan 20, 2014 8:56:34 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class RegistrationCompleteAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( RegistrationCompleteAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "RegistrationCompleteAction.java execute()";
		logger.entering ( methodName );
		ActionForward target = null;

		target = mapping.findForward ( "complete" );

		return target;
	}
}
