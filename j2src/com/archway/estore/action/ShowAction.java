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
 * Archway Marketing Services. 7525 Cogswell Rd, Romulus, MI - 48174. Phone -
 * 734.713.2000
 * 
 * Project Name : FordKeyCode
 * 
 * Author : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH.
 * 734.713.2019 File Name : ShowAction.java Package Name :
 * com.archway.estore.action
 * 
 * Date : Apr 10, 2013 10:20:00 PM
 * 
 * Change Date : Apr 10, 2013 10:20:00 PM Apr 11, 2013 12:28:17 PM May 8, 2013
 * 2:15:09 PM
 * 
 * --------------------------------------------------------- Description :- Add
 * Class Description here
 * ---------------------------------------------------------
 * 
 * 
 * 
 * 
 * 
 * Local Urls WEB SITE :
 * http://localhost:8080/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156 ADMIN
 * URL :
 * http://localhost:8080/keycode/admin/adminLogin.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * http://localhost:8080/keycode/webservices/services/vin/validateVin?wsdl
 * Servlet Url :
 * http://localhost:8080/keycode/servlet/KeyCodeServlet?key=40778b756f90d97ffcff28b81e18de805a70ae4ef4084bd6c9126d0b63332ced&pacode=12345&vin=1234567890
 * 
 * 
 * Development URLS WEB SITE :
 * http://autoweb.tsdet.archway.com/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * http://autoweb.tsdet.archway.com/keycode/webservices/services/vin/validateVin?wsdl
 * Servlet Url :
 * http://autoweb.tsdet.archway.com/keycode/servlet/KeyCodeServlet?key=40778b756f90d97ffcff28b81e18de805a70ae4ef4084bd6c9126d0b63332ced&pacode=12345&vin=1234567890
 * 
 * Production URLS WEB SITE :
 * https://owner-verification.archway.com/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * https://owner-verification.archway.com/keycode/webservices/services/vin/validateVin?wsdl
 * Servlet Url :
 * http://owner-verification.archway.com/keycode/servlet/KeyCodeServlet?key=40778b756f90d97ffcff28b81e18de805a70ae4ef4084bd6c9126d0b63332ced&pacode=12345&vin=1234567890
 * 
 * Data Base Credentials for DEV User:fordkeycode_prod password:fkcpd_2012
 * Database:autodev (owner of packages , tables etc...) Data Base Credentials
 * for DEV User:fordkeycode_web password:fordkeycode_web Database:autodev (JUST
 * for WEB)
 * 
 * Data Base Credentials for PRD User:fordkeycode_prod password:fkcpp_2012
 * Database:auto (owner of packages , tables etc...) Data Base Credentials for
 * PRD User:fordkeycode_web password:fkcweb_2012 Database:auto (JUST for WEB)
 * 
 * 
 * Development URLS WEB SITE :
 * http://autoweb.tsdet.archway.com/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * https://wwwqa.ownerverification.dealerconnection.com/keycode/webservices/services/vin/validateVin?wsdl
 * https://wwwqa.ownerverification.dealerconnection.com/keycode/webservices/services/vin/validateNewVin?wsdl
 * 
 * Production URLS WEB SITE :
 * https://owner-verification.archway.com/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * https://owner-verification.archway.com/keycode/webservices/services/vin/validateVin?wsdl
 * 
 * 
 * https://wwwqa.ownerverification.dealerconnection.com
 * www.ownerverification.dealerconnection.com
 * 
 * 
 */

public class ShowAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( ShowAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "ShowAction.execute :::";
		logger.debug ( "*************************************" );
		logger.entering ( methodName );

		String target = "";
		HttpSession session = request.getSession ();

		try
		{
			/*String pacode = "";
			 String acl = "";
			 String wsl = "";
			 if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "pacode" ) ) )
			 {
			 pacode = request.getParameter ( "pacode" );
			 }
			 else
			 {
			 target = mapping.findForward ( "fail" );
			 return target;
			 }

			 if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "acl" ) ) )
			 {
			 acl = request.getParameter ( "acl" );
			 }
			 else
			 {
			 target = mapping.findForward ( "fail" );
			 return target;
			 }

			 if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "wsl" ) ) )
			 {
			 wsl = request.getParameter ( "wsl" );
			 }
			 else
			 {
			 target = mapping.findForward ( "fail" );
			 return target;
			 }

			 SessionBean sb = new SessionBean ();
			 sb.setPacode ( pacode );
			 sb.setAcl ( acl );
			 sb.setWsl ( wsl );
			 // setting session id for session validation.
			 sb.setSessionId ( session.getId () );

			 session.setAttribute ( "SessionBean" , sb );*/
			logger.debug ( "************************************* 1111111111111111 " );
			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );
			if ( sb.getPacode () != null && ( sb.getPacode ().equalsIgnoreCase ( "AECH" ) || sb.getPacode ().equalsIgnoreCase ( "AECHA" ) ) )
			{
				sb.setPacode ( request.getParameter ( "pacode" ) );
				sb.setDealerName ( request.getParameter ( "dealerName" ) );

				session.setAttribute ( "SessionBean" , sb );
				logger.warn ( "Hacked Pa Code : " + request.getParameter ( "pacode" ) );
			}

			target = "success";

		}
		catch ( Exception ex )
		{

			logger.debug ( "*************************************" );
			logger.debug ( "--- ShowAction.execute() ---" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "*************************************" );

			return mapping.findForward ( "contentError" );
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
