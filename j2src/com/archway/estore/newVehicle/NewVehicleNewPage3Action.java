package com.archway.estore.newVehicle;

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
 * File Name               : NewVehicleNewPage3Action.java 
 * Package Name            : com.archway.estore.newVehicle
 * 
 * Date                    : May 11, 2014 8:52:15 AM
 * 
 * Change Date             : May 11, 2014 8:52:15 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class NewVehicleNewPage3Action extends Action
{

	private static Logger	logger	= Logger.getLogger ( NewVehicleNewPage3Action.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "NewVehicleNewPage3Action.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );
		HttpSession session = request.getSession ();

		String target = "continue";

		return mapping.findForward ( target );
	}
}
