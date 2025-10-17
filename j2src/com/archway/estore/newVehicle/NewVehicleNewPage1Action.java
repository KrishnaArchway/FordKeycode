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
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : NewVehiclePage1NewPage1Action.java 
 * Package Name            : com.archway.estore.newVehicle
 * 
 * Date                    : May 11, 2014 8:31:22 AM
 * 
 * Change Date             : May 11, 2014 8:31:22 AM
 * 							 Aug 12, 2014 10:21:32 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class NewVehicleNewPage1Action extends Action
{

	private static Logger	logger	= Logger.getLogger ( NewVehicleNewPage1Action.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "NewVehicleAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );
		HttpSession session = request.getSession ();

		String target = "continue";

		String pacode = "";
		String acl = "";
		String wsl = "";
		if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "pacode" ) ) )
		{
			pacode = request.getParameter ( "pacode" );
			String checkPaCode = DMLManager.isPABlocked ( pacode );
			if ( checkPaCode.equalsIgnoreCase ( "Y" ) )
			{
				request.setAttribute ( "ErrorMsg" , "P&A Code:<b>" + pacode + "</b> is blocked from entering Owner Verifications." );
				target = "fail";
			}
		}
		else
		{
			request.setAttribute ( "ErrorMsg" , "Parameters Passed In Request are invalid!!!" );
			target = "fail";
		}

		if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "acl" ) ) )
		{
			acl = request.getParameter ( "acl" );
		}
		else
		{ 
			request.setAttribute ( "ErrorMsg" , "Parameters Passed In Request are invalid!!!" );
			target = "fail";
		}

		if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "wsl" ) ) )
		{
			wsl = request.getParameter ( "wsl" );
		}
		else
		{
			request.setAttribute ( "ErrorMsg" , "Parameters Passed In Request are invalid!!!" );
			target = "fail";
		}

		SessionBean sb = new SessionBean ();
		sb.setPacode ( pacode );
		sb.setAcl ( acl );
		sb.setWsl ( wsl );
		// setting session id for session validation.
		sb.setSessionId ( session.getId () );
		CollectCookieInformationBean c = ( CollectCookieInformationBean ) session.getAttribute ( "WSLXBEAN" );
		logger.warn ( "START WSLXBEAN  From PreShowAction----------------------------------------" );
		c.loginfo ();
		logger.warn ( "END   WSLXBEAN  From PreShowAction----------------------------------------" );

		//get the counter 
		int counter = DMLManager.getCounterNewVehicle ( pacode );
		
		logger.warn ("COUNTER ===== " + counter);
		
		sb.setNewVehCounter ( counter );

		sb.setCollectCookieInformationBean ( c );
		session.setAttribute ( "SessionBean" , sb );
		
		logger.debug (ConfigurationServlet.getApplicationProperty("MAX_REG_PER_MONTH"));
		int maxCount = Integer.parseInt(ConfigurationServlet.getApplicationProperty("MAX_REG_PER_MONTH"));
		if ( counter >= maxCount )
		{
			logger.debug ( "Actionn Forward ````````````````````````````````````````: " + "threeFail" );
			return mapping.findForward ( "threeFail" );
		}

		

		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "*************************************" );
		return mapping.findForward ( target );
	}
}
