package com.archway.estore.newVehicle;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.helper.EmailHelper;
import com.archway.estore.session.SessionBean;
import com.archway.estore.util.DateUtility;
import com.archway.estore.util.Email;
import com.archway.estore.util.FileUtility;
import com.archway.estore.util.Html;

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
 * File Name               : NewVehicleSubmitAction.java 
 * Package Name            : com.archway.estore.newVehicle
 * 
 * Date                    : Apr 7, 2014 8:35:12 AM
 * 
 * Change Date             : Apr 7, 2014 8:35:12 AM
 * 							 Apr 7, 2014 9:11:34 AM
 * 						     May 14, 2014 9:16:40 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class NewVehicleSubmitAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( NewVehicleSubmitAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{

		String methodName = "NewVehicleSubmitAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );
		String target = "continue";

		try
		{

			HttpSession session = request.getSession ();
			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );

			String vinNum = request.getParameter ( "vinNum" );
			String dealerVehicleYear = request.getParameter ( "dealerVehicleYear" );
			String dealerVehicleMake = request.getParameter ( "dealerVehicleMake" );
			String dealerVehicleModel = request.getParameter ( "dealerVehicleModel" );
			String dealerVehicleInfo = request.getParameter ( "dealerVehicleInfo" );
			String agreementCheck = request.getParameter ( "agreementCheck" );
			String submittedFirstName = request.getParameter ( "submittedFirstName" );
			String submittedLastName = request.getParameter ( "submittedLastName" );

			logger.warn ( "pacode                                			  :" + sb.getPacode () );
			logger.warn ( "fmcdealerId                                      :" + sb.getWsl () );
			logger.warn ( "vinNum                                			  :" + vinNum );
			logger.warn ( "dealerVehicleYear                                :" + dealerVehicleYear );
			logger.warn ( "dealerVehicleMake                                :" + dealerVehicleMake );
			logger.warn ( "dealerVehicleModel                               :" + dealerVehicleModel );
			logger.warn ( "dealerVehicleInfo                                :" + dealerVehicleInfo );
			logger.warn ( "agreementCheck                                   :" + agreementCheck );
			logger.warn ( "submittedFirstName                                   :" + submittedFirstName );
			logger.warn ( "submittedLastName                                   :" + submittedLastName );

			boolean flag = DMLManager.saveNewVehicleData ( sb.getPacode () , sb.getWsl () , vinNum , dealerVehicleYear , dealerVehicleMake , dealerVehicleModel , dealerVehicleInfo , agreementCheck , submittedFirstName , submittedLastName );
			int counter = DMLManager.getCounterNewVehicle ( sb.getPacode () );

			sb.setNewVehCounter ( counter );
			session.setAttribute ( "SessionBean" , sb );

			if ( counter == 3 )
			{
				//send the email
				String from = ConfigurationServlet.getApplicationProperty ( "FROM_EMAIL" );
				String to = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_TO_EMAIL" );
				String cc = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_CC_EMAIL" );
				String bcc = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_BCC_EMAIL" );
				String subject = ( ConfigurationServlet.getApplicationProperty ( "NEW_VEHICLE_SUBJECT" ) + ( System.getProperty ( "ENV" ).equalsIgnoreCase ( "dev" ) ? " [ENVIRONMENT : DEV] " : "" ) ).replaceAll ( "%pandacode%" , sb.getPacode () );
				String plainText = ConfigurationServlet.getApplicationProperty ( "PLAIN_TEXT" );

				logger.warn ( "From 											:" + from );
				logger.warn ( "to 											:" + to );
				logger.warn ( "cc 											:" + cc );
				logger.warn ( "bcc 											:" + bcc );
				logger.warn ( "subject 										:" + subject );
				logger.warn ( "plainText 										:" + plainText );

				String templatePathAndFileName = EmailHelper.TEMPLATE_PATH + "keycode_newvehicle_registration.htm";
				String fileContents = FileUtility.ReadFile ( templatePathAndFileName );

				String finalEmailBody = fileContents.replaceAll ( "%sysdate%" , DateUtility.getCurrentDateTime () ).replaceAll ( "%vin%" , vinNum ).replaceAll ( "%panda%" , sb.getPacode () ).replaceAll ( "%wsl%" , sb.getWsl () ).replaceAll ( "%year%" , dealerVehicleYear ).replaceAll ( "%make%" , dealerVehicleMake ).replaceAll ( "%model%" , dealerVehicleModel ).replaceAll ( "%submissionFirstName%" , submittedFirstName ).replaceAll ( "%submissionLastName%" , submittedLastName ).replaceAll ( "%comments%" , dealerVehicleInfo );

				Email.SendHtmlEmailWithFileAttachment ( from , to.split ( "\\," ) , cc.split ( "\\," ) , bcc.split ( "\\," ) , subject , null , finalEmailBody , plainText );

				logger.warn ( "After   html body " + Html.cleanHtml ( finalEmailBody ) );

			}
			logger.debug ( "Actionn Forward : " + target );
			logger.exiting ( methodName );
			logger.debug ( "*************************************" );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception e" + e.getMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return mapping.findForward ( target );
	}

}
