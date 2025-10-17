package com.archway.estore.action;

import com.archway.estore.common.Logger;
import com.archway.estore.session.SessionBean;

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
 * File Name               : VINExistAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:59:09 PM
 * 
 * Change Date             : Jan 20, 2014 8:59:09 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VINExistAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( VINExistAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "VINExistAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "vinExist";

		try
		{
			HttpSession session = request.getSession ();
			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );

			if ( request.getParameter ( "actionType" ) != null )
			{
				String actionType = request.getParameter ( "actionType" );
				String strVin = request.getParameter ( "vin" );
				//request.setAttribute("VIN", strVin) ;
				sb.setVin ( strVin );

				logger.debug ( "actionType : " + actionType );

				if ( actionType.equalsIgnoreCase ( "exist" ) )
				{
					target = "vinExist";
				}
				else if ( actionType.equalsIgnoreCase ( "back" ) )
				{
					request.setAttribute ( "VIN_EXIST" , "Y" );
					target = "back";
				}
				else if ( actionType.equalsIgnoreCase ( "continue" ) )
				{
					target = "continue";
				}

			}

		}
		catch ( Exception ex )
		{

			logger.debug ( "***********************************************************************" );
			logger.debug ( "------------- VINExistAction.execute() ----------------------" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "***********************************************************************" );

			target = "contentError";
		}

		finally
		{
			logger.exiting(methodName);
		}
		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "************************************************" );
		return mapping.findForward ( target );
	}

}
