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
 * File Name               : NewVehicleSubmittedByAction.java 
 * Package Name            : com.archway.estore.newVehicle
 * 
 * Date                    : May 11, 2014 9:29:01 AM
 * 
 * Change Date             : May 11, 2014 9:29:01 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class NewVehicleSubmittedByAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( NewVehicleSubmittedByAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "NewVehicleSubmittedByAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );
		HttpSession session = request.getSession ();

		String vinNum = request.getParameter ( "vinNum" );
		String dealerVehicleYear = request.getParameter ( "dealerVehicleYear" );
		String dealerVehicleMake = request.getParameter ( "dealerVehicleMake" );
		String dealerVehicleModel = request.getParameter ( "dealerVehicleModel" );
		String dealerVehicleInfo = request.getParameter ( "dealerVehicleInfo" );
		String agreementCheck = request.getParameter ( "agreementCheck" );

		request.setAttribute ( "vinNum" , vinNum );
		request.setAttribute ( "dealerVehicleYear" , dealerVehicleYear );
		request.setAttribute ( "dealerVehicleMake" , dealerVehicleMake );
		request.setAttribute ( "dealerVehicleModel" , dealerVehicleModel );
		request.setAttribute ( "dealerVehicleInfo" , dealerVehicleInfo );
		request.setAttribute ( "agreementCheck" , agreementCheck );

		String target = "continue";

		return mapping.findForward ( target );
	}
}
