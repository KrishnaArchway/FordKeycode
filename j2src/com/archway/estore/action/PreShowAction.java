package com.archway.estore.action;

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
 * File Name               : PreShowAction.java 
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

public class PreShowAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( PreShowAction.class );

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

		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "*************************************" );
		return mapping.findForward ( target );

	}
}
