package com.archway.estore.action;

import com.archway.estore.common.Logger;
import com.archway.estore.formbean.VINRegisterBean;
import com.archway.estore.session.SessionBean;
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
 * File Name               : PathDeciderAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:55:40 PM
 * 
 * Change Date             : Jan 20, 2014 8:55:40 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class PathDeciderAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( PathDeciderAction.class );

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getVin ( HttpServletRequest request )
	{
		String methodName = "PathDeciderAction : getVin(HttpServletRequest ) :::";
		logger.debug ( "***********************************************************" );
		logger.entering ( methodName );
		String vin = "";
		String vinNumber1 = StringUtility.isStringBlank ( ( String ) request.getParameter ( "vinNum" ) ) ? "" : ( String ) request.getParameter ( "vinNum" );
		vin = vinNumber1;
		logger.warn ( "VIN   :" + vin );
		logger.exiting ( methodName );
		logger.debug ( "***********************************************************" );
		return vin;
	}

	/**
	 * ActionForward
	 */
	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "PathDeciderAction.execute :::";
		logger.debug ( "*************************************" );
		logger.entering ( methodName );

		String target = "";
		HttpSession session = request.getSession ();

		try
		{
			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );
			VINRegisterBean ownerBean = new VINRegisterBean ();

			String vin = getVin ( request );
			String registeredVehicleToWhom = request.getParameter ( "registeredOwnersVehicle" );
			session.removeAttribute ( "ExceptionFalg" );
			logger.warn ( "VIN   :" + vin );
			logger.warn ( "registeredVehicleToWhom   :" + registeredVehicleToWhom );

			sb.setVin ( vin );
			sb.setRegisteredVehicleToWhom ( registeredVehicleToWhom );
			sb.setObjVinRegisterBean ( ownerBean );
			session.setAttribute ( "SessionBean" , sb );

			if ( registeredVehicleToWhom.equalsIgnoreCase ( "OWNER" ) )
			{
				logger.warn ( "Came in OWNER" );
				session.setAttribute ( "ExceptionFalg" , "" );
				target = "owner";
			}
			if ( registeredVehicleToWhom.equalsIgnoreCase ( "DEALER" ) )
			{
				logger.warn ( "Came in DEALER" );
				session.setAttribute ( "ExceptionFalg" , "" );
				target = "dealer";
			}

		}
		catch ( Exception ex )
		{

			logger.debug ( "*************************************" );
			logger.debug ( "--- PathDeciderAction.execute() ---" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "*************************************" );

			target = "contentError";
		}
		finally
		{

		}
		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "*************************************" );
		return mapping.findForward ( target );

	}
}
