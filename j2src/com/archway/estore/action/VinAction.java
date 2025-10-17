package com.archway.estore.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.GageException;
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
 * File Name               : VinAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:58:57 PM
 * 
 * Change Date             : Jan 20, 2014 8:58:57 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VinAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( VinAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "VinAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "";

		try
		{

			if ( request.getParameter ( "actionType" ) != null )
			{

				String actionType = request.getParameter ( "actionType" );
				String vin = request.getParameter ( "keycode" );

				logger.debug ( "actionType = " + actionType + " | vin = " + vin );

				if ( actionType.equalsIgnoreCase ( "validate" ) )
				{
					boolean isValid = false;

					isValid = DMLManager.authincateVIn ( vin );

					logger.debug ( "isValid = " + isValid );

					String html = "";
					if ( isValid )
					{
						html = "Y";
					}
					else
					{
						html = "N";
					}

					logger.warn ( "html = " + html );

					response.setContentType ( "text/html" );
					response.setHeader ( "Cache-Control" , "no-cache" );
					response.getWriter ().write ( html );

				}
				
				if ( actionType.equalsIgnoreCase ( "validateNew" ) )
				{
					boolean isValid = false;

					isValid = DMLManager.authincateVinNew ( vin );

					logger.debug ( "isValid = " + isValid );

					String html = "";
					if ( isValid )
					{
						html = "Y";
					}
					else
					{
						html = "N";
					}

					logger.warn ( "html = " + html );

					response.setContentType ( "text/html" );
					response.setHeader ( "Cache-Control" , "no-cache" );
					response.getWriter ().write ( html );

				}
				
				

			}
			else
			{

				target = "success";
			}

		}
		catch ( GageException ex )
		{

			logger.debug ( "*******************************" );
			logger.debug ( "--- VinAction.execute() ---" );
			logger.debug ( "GageException :: " + ex.getLocalizedMessage () );
			logger.debug ( "*******************************" );

			target = "contentError";

		}
		catch ( Exception ex )
		{

			logger.debug ( "*******************************" );
			logger.debug ( "--- VinAction.execute() ---" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			logger.debug ( "*******************************" );

			target = "contentError";
		}

		finally
		{

		}
		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "************************************************" );
		return mapping.findForward ( target );

	}
}
