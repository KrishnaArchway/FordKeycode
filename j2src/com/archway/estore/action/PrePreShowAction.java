package com.archway.estore.action;

import com.archway.estore.bo.DMLManager;
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
 * File Name               : PrePreShowAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:56:03 PM
 * 
 * Change Date             : Jan 20, 2014 8:56:03 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 * 
 * * Local Urls WEB SITE :
 * http://localhost:8080/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156 ADMIN
 * URL :
 * http://localhost:8080/keycode/admin/adminLogin.do?pacode=99999&acl=ford&wsl=skuma156
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
 * http://autoweb.tsdet.archway.com/keycode/webservices/services/vin/validateVin?wsdl
 * 
 * Production URLS WEB SITE :
 * https://owner-verification.archway.com/keycode/show.do?pacode=NA&acl=ford&wsl=skuma156
 * WEB SERVICE :
 * https://owner-verification.archway.com/keycode/webservices/services/vin/validateVin?wsdl
 * 
 * 
 * 
 * 
 * 
 */

public class PrePreShowAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( PrePreShowAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "PreShowAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );

		String target = "success";
		HttpSession session = request.getSession ();

		session.removeAttribute ( "sessionBean" );
		session.removeAttribute ( "DealerRegistrationBean" );
		session.removeAttribute ( "RegisterBean" );

		try
		{
			String pacode = "";
			String acl = "";
			String wsl = "";
			if ( ! StringUtility.isStringBlank ( ( String ) request.getParameter ( "pacode" ) ) )
			{
				pacode = request.getParameter ( "pacode" );
				///String checkPaCode = DMLManager.isPABlocked ( pacode );
				String checkPaCode = "N";
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

			sb.setCollectCookieInformationBean ( c );
			session.setAttribute ( "SessionBean" , sb );

		}
		catch ( Exception ex )
		{

			logger.debug ( "***********************************************************************" );
			logger.debug ( "------------- ShowAction.execute() ----------------------" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "***********************************************************************" );

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
