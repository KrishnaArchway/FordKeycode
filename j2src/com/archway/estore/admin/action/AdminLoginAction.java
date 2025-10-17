package com.archway.estore.admin.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;
import com.archway.estore.formbean.BlockedPACodeBean;
import com.archway.estore.session.SessionBean;
import com.archway.estore.util.StringUtility;
import com.archway.estore.wslx.CollectCookieInformationBean;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;

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
 * File Name               : AdminLoginAction.java 
 * Package Name            : com.archway.estore.admin.action
 * 
 * Date                    : Jan 20, 2014 8:59:20 PM
 * 
 * Change Date             : Jan 20, 2014 8:59:20 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class AdminLoginAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( AdminLoginAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "AdminLoginAction.java ActionForward( ActionMapping , ActionForm , HttpServletRequest , HttpServletResponse)";
		logger.debug ( "******************************************************************************************************************" );
		logger.entering ( methodName );
		String target = "";
		HttpSession session = request.getSession ();

		try
		{
			String mode = request.getParameter ( "mode" );
			SessionBean sb = new SessionBean ();
			sb.setSessionId ( session.getId () );
			session.setAttribute ( "SessionBean" , sb );

			/*if ( StringUtility.isStringBlank ( mode ) )
			 {
			 target = "adminLogin";				
			 }*/

			/*if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "auth" ) )
			 {
			 // authincate the user id and password
			 String userId = "";
			 String password = "";
			 if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "userId" ) ) )
			 {
			 userId = request.getParameter ( "userId" );
			 }
			 else
			 {
			 target = "adminLogin";
			 request.setAttribute ( "adminAuthError" , "Y" );
			 }
			 if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "password" ) ) )
			 {
			 password = request.getParameter ( "password" );
			 }
			 else
			 {
			 target = "adminLogin";
			 request.setAttribute ( "adminAuthError" , "Y" );
			 }
			 
			 logger.warn ( "User Id  :" + userId );
			 logger.warn ( "password :" + password );
			 
			 if ( userId.equalsIgnoreCase ( ConfigurationServlet.getApplicationProperty ( "ADMIN_LOGIN_ID" ) ) && password.equalsIgnoreCase ( ConfigurationServlet.getApplicationProperty ( "ADMIN_PASSWORD" ) ) )
			 {
			 target = "adminHome";
			 }
			 else
			 {
			 target = "adminLogin";
			 request.setAttribute ( "adminAuthError" , "Y" );
			 }
			 } else*/

			CollectCookieInformationBean WSLXBEAN = ( CollectCookieInformationBean ) session.getAttribute ( "WSLXBEAN" );
			
			if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "menuPage" ) )
			{
				target = "adminHome";
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "get_blocked_pa_codes" ) )
			{
				try
				{
					session.removeAttribute ( "SAVE_MSG" );
					session.removeAttribute ( "blockedPACodeList" );
					session.removeAttribute ( "blockedPACodeList_orginal" );

					BlockedPACodeBean [] blockedPACodeList = DMLManager.getBlockedPACode ();

					session.setAttribute ( "blockedPACodeList" , blockedPACodeList );
					session.setAttribute ( "blockedPACodeList_orginal" , blockedPACodeList );

					target = "showBlockedPACodeList";
				}
				catch ( Exception e )
				{
					logger.warn ( "Exception : While getting Blocked PA Codes == " + e.getMessage () );
				}
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "updatePACode" ) )
			{

				try
				{
					session.removeAttribute ( "SAVE_MSG" );
					String paId = ( String ) request.getParameter ( "paId" );

					String statusReturn = DMLManager.updateBlockedPACode ( paId );

					BlockedPACodeBean [] blockedPACodeList = DMLManager.getBlockedPACode ();

					session.setAttribute ( "blockedPACodeList" , blockedPACodeList );
					session.setAttribute ( "SAVE_MSG" , statusReturn );

					logger.debug ( "Return Msg : " + statusReturn );
					target = "showBlockedPACodeList";

				}
				catch ( Exception e )
				{
					logger.warn ( "Exception : While getting Blocked PA Codes == " + e.getMessage () );
				}
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "addPaCode" ) )
			{
				target = "addPACodePage";
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "savePACode" ) )
			{
				try
				{
					session.removeAttribute ( "SAVE_MSG" );
					String paCode = ( String ) request.getParameter ( "paCode" );
					String statusReturn = DMLManager.savePACode ( paCode );

					BlockedPACodeBean [] blockedPACodeList = DMLManager.getBlockedPACode ();

					session.setAttribute ( "blockedPACodeList" , blockedPACodeList );
					session.setAttribute ( "SAVE_MSG" , statusReturn );

					target = "showBlockedPACodeList";

				}
				catch ( Exception e )
				{
					logger.warn ( "Exception : While getting Blocked PA Codes == " + e.getMessage () );
				}
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "searchPaCode" ) )
			{
				try
				{
					session.removeAttribute ( "SAVE_MSG" );
					String paCode = ( String ) request.getParameter ( "paCode" );
					ArrayList aList = new ArrayList ();

					BlockedPACodeBean [] blockedPACodeList = ( BlockedPACodeBean [] ) session.getAttribute ( "blockedPACodeList_orginal" );

					for ( int i = 0 ; i < blockedPACodeList.length ; i++ )
					{
						if ( blockedPACodeList [i].getPaCode ().equalsIgnoreCase ( paCode ) )
						{
							aList.add ( blockedPACodeList [i] );
						}
					}

					session.setAttribute ( "blockedPACodeList" , ( BlockedPACodeBean [] ) aList.toArray ( new BlockedPACodeBean[0] ) );
					target = "showBlockedPACodeList";
				}
				catch ( Exception e )
				{
					logger.warn ( "Exception : While getting Blocked PA Codes == " + e.getMessage () );
				}
			}
			else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "showAllPaCode" ) )
			{
				try
				{
					session.removeAttribute ( "SAVE_MSG" );
					session.setAttribute ( "blockedPACodeList" , session.getAttribute ( "blockedPACodeList_orginal" ) );
					target = "showBlockedPACodeList";
				}
				catch ( Exception e )
				{
					logger.warn ( "Exception : While getting Blocked PA Codes == " + e.getMessage () );
				}
			}

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception " + e.getMessage () );
		}
		finally
		{
			//logger.exiting ( methodName );
		}

		logger.exiting ( "Action Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "******************************************************************************************************************" );
		return mapping.findForward ( target );
	}

}
