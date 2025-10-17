package com.archway.estore.newVehicle;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.session.SessionBean;
import com.archway.estore.util.StringUtility;
import com.archway.estore.wslx.CollectCookieInformationBean;

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
 * File Name               : VinNewVehicleAction.java 
 * Package Name            : com.archway.estore.newVehicle
 * 
 * Date                    : Mar 27, 2014 10:46:47 AM
 * 
 * Change Date             : Mar 27, 2014 10:46:47 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VinNewVehicleAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( VinNewVehicleAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "VinNewVehicleAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "success";
		
		HttpSession session = request.getSession ();
		SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );
		
		String pacode = sb.getPacode();
		logger.warn ("pacode @ VinNewVehicleAction===== " + pacode);
		if ( ! StringUtility.isStringBlank ( pacode ) )
		{
			pacode = request.getParameter ( "pacode" );
			CollectCookieInformationBean c = ( CollectCookieInformationBean ) session.getAttribute ( "WSLXBEAN" );
			logger.warn ( "START WSLXBEAN  From PreShowAction----------------------------------------" );
			c.loginfo ();
			logger.warn ( "END   WSLXBEAN  From PreShowAction----------------------------------------" );
			int counter = DMLManager.getCounterNewVehicle ( pacode );
			
			logger.warn ("COUNTER @ VinNewVehicleAction===== " + counter);
			int maxCount = Integer.parseInt(ConfigurationServlet.getApplicationProperty("MAX_REG_PER_MONTH"));
			if ( counter >= maxCount )
			{
				logger.debug ( "Actionn Forward ````````````````````````````````````````: " + "threeFail" );
				return mapping.findForward ( "threeFail" );
			}
			
		}

		String actionType = request.getParameter ( "actionType" );
		logger.debug ( "actionType:" + actionType );
		if ( actionType != null && actionType.equalsIgnoreCase ( "validateData" ) )
		{
			logger.debug ( "Confirmation page" );

			String vinNum = request.getParameter ( "vinNum" );
			String dealerVehicleYear = request.getParameter ( "dealerVehicleYear" );
			String dealerVehicleMake = request.getParameter ( "dealerVehicleMake" );
			String dealerVehicleModel = request.getParameter ( "dealerVehicleModel" );
			String dealerVehicleInfo = request.getParameter ( "dealerVehicleInfo" );
			String agreementCheck = request.getParameter ( "agreementCheck" );
			String submittedFirstName = request.getParameter ( "submittedFirstName" );
			String submittedLastName = request.getParameter ( "submittedLastName" );

			request.setAttribute ( "vinNum" , vinNum );
			request.setAttribute ( "dealerVehicleYear" , dealerVehicleYear );
			request.setAttribute ( "dealerVehicleMake" , dealerVehicleMake );
			request.setAttribute ( "dealerVehicleModel" , dealerVehicleModel );
			request.setAttribute ( "dealerVehicleInfo" , dealerVehicleInfo );
			request.setAttribute ( "agreementCheck" , agreementCheck );
			request.setAttribute ( "submittedFirstName" , submittedFirstName );
			request.setAttribute ( "submittedLastName" , submittedLastName );

			target = "confirmationPage";
		}

		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "*************************************" );
		return mapping.findForward ( target );
	}
}
