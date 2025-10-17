package com.archway.estore.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;
import com.archway.estore.formbean.VINRegisterBean;
import com.archway.estore.helper.EmailHelper;
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
 * File Name               : DealerVehicleRegistrationAcion.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:55:13 PM
 * 
 * Change Date             : Jan 20, 2014 8:55:13 PM
 * 							 Jan 28, 2014 11:42:32 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class DealerVehicleRegistrationAcion extends Action
{

	private static Logger	logger	= Logger.getLogger ( DealerVehicleRegistrationAcion.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
	{

		String methodName = "DealerVehicleRegistrationAcion.execute :::";
		logger.debug ( "*********************Test RJ*********************************" );
		logger.entering ( methodName );

		String target = "";
		try
		{
			HttpSession session = request.getSession ();
			String strAction = request.getParameter ( "actionType" );

			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );
			VINRegisterBean dealerBean = null;

			if ( sb.getObjVinRegisterBean () == null )
				dealerBean = new VINRegisterBean ();
			else
				dealerBean = ( VINRegisterBean ) sb.getObjVinRegisterBean ();

			logger.debug ( "DealerVehicleRegistrationAcion | strAction = " + strAction );

			if ( ! StringUtility.isStringBlank ( strAction ) )
			{
				if ( strAction.equalsIgnoreCase ( "pageOne" ) )    
				{
					dealerBean.setVehicleYear ( ( String ) request.getParameter ( "dealerVehicleYear" ) );
					dealerBean.setVehicleMake ( ( String ) request.getParameter ( "dealerVehicleMake" ) );
					dealerBean.setVehicleModel ( ( String ) request.getParameter ( "dealerVehicleModel" ) );
					dealerBean.setVehiclecolor ( ( String ) request.getParameter ( "dealerVehicleColor" ) );
					dealerBean.setVehiclePlateNo ( ( String ) request.getParameter ( "dealerVehiclePlateno" ) );
					dealerBean.setVehicleState ( ( String ) request.getParameter ( "dealerVehicleState" ) );
					dealerBean.setVehicleOdometer ( ( String ) request.getParameter ( "dealerVehicleOdometer" ) );

					String dealerSell = request.getParameter ( "dealerSell" );
					String dealerPosses = request.getParameter ( "dealerPosses" );
					String dealerTitled = request.getParameter ( "dealerTitled" );

					logger.debug ( "dealerSell : " + dealerSell + " | dealerPosses = " + dealerPosses + " | dealerTitled = " + dealerTitled );

					if ( ! StringUtility.isStringBlank ( dealerSell ) )
					{
						dealerBean.setDealerSell ( "Y" );
					}
					else
					{
						dealerBean.setDealerSell ( "N" );
					}

					if ( ! StringUtility.isStringBlank ( dealerTitled ) )
					{
						dealerBean.setDealerTitled ( "Y" );
					}
					else
					{
						dealerBean.setDealerTitled ( "N" );
					}

					if ( ! StringUtility.isStringBlank ( dealerPosses ) )
					{
						dealerBean.setDealerPosses ( "Y" );
					}
					else
					{
						dealerBean.setDealerPosses ( "N" );
					}   
					//logger.debug ( "redirect to page two" );   
					logger.debug ( "redirect to confirm page" );

					sb.setObjVinRegisterBean ( dealerBean );
					session.setAttribute ( "SessionBean" , sb );
					target = "showConfirmPage";

				}
				else if ( strAction.equalsIgnoreCase ( "pageTwo" ) )
				{

					dealerBean.setSubmitFirstName ( ( String ) request.getParameter ( "submittedFirstName" ) );
					dealerBean.setSubmitLastName ( ( String ) request.getParameter ( "submittedLastName" ) );
					sb.setObjVinRegisterBean ( dealerBean );
					session.setAttribute ( "SessionBean" , sb );

					target = "showConfirmPage";
				}
				else if ( strAction.equalsIgnoreCase ( "completeRegistration" ) )
				{

					boolean isInsert= false;
					
					if(( sb.getObjVinRegisterBean()!=null ) && (! StringUtility.isStringBlank ( sb.getVin() )))
					{						
						boolean isValid = DMLManager.authincateVIn ( sb.getVin() );
						logger.debug ( "isValid : " + isValid );
						
						if(!isValid)
						{
							session.removeAttribute("DuplicateInsert");
							isInsert = DMLManager.insertVerification ( sb );
		
							if ( isInsert )
							{	
								//code to send the email for exception. -- DEALER
								EmailHelper.sendExceptionEmail ( sb );
		
								dealerBean = null;
								sb.setObjVinRegisterBean ( dealerBean );
								session.setAttribute ( "SessionBean" , sb );
								session.setAttribute ( "InsertedVinNum" , sb.getVin() );
							}
						}
						else
						{
							String msg = "<b>Your Ownership Verification Record for Vin# " +  (String)session.getAttribute("InsertedVinNum") + " has <font color='red'>already been created/submitted.</font></b>";
							session.setAttribute ( "DuplicateInsert" , msg);
						}
	
						request.setAttribute ( "SUBMITTED_BY" , "DEALER" );
						logger.debug ( "isInsert : " + isInsert );
					}
					else
					{
						String msg = "<b>Your Ownership Verification Record for Vin# " +  (String)session.getAttribute("InsertedVinNum") + " has <font color='red'>already been created/submitted.</font></b>";
						session.setAttribute ( "DuplicateInsert" , msg);
					}

					target = "complete";

				}
			}

		}
		catch ( Exception ex )
		{

			logger.debug ( "***********************************************************************" );
			logger.debug ( "------------- DealerVehicleRegistrationAcion.execute() ----------------------" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			// logger.debug ( "Error : " +e);
			logger.debug ( "***********************************************************************" );

			target = "contentError";
		}

		logger.debug ( "Actionn Forward : " + target );
		logger.exiting ( methodName );
		logger.debug ( "************************************************" );
		return mapping.findForward ( target );
	}
}
