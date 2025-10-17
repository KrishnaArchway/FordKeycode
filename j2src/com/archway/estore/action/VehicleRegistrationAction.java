package com.archway.estore.action;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.GageException;
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
 * File Name               : VehicleRegistrationAction.java 
 * Package Name            : com.archway.estore.action
 * 
 * Date                    : Jan 20, 2014 8:58:40 PM
 * 
 * Change Date             : Jan 20, 2014 8:58:40 PM
 * 							 Jan 27, 2014 8:41:21 PM
 * 							 Jan 28, 2014 11:42:40 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VehicleRegistrationAction extends Action
{

	private static Logger	logger	= Logger.getLogger ( VehicleRegistrationAction.class );

	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
	{
		String methodName = "VehicleRegistrationAction.execute :::";
		logger.debug ( "************************************************" );
		logger.entering ( methodName );
		String strActionForward = "";

		try
		{

			HttpSession session = request.getSession ();
			String strAction = ( String ) request.getParameter ( "actionType" );

			SessionBean sb = ( SessionBean ) session.getAttribute ( "SessionBean" );
			session.removeAttribute ( "ExceptionFalg" );
			VINRegisterBean registerBean = null;

			if ( sb.getObjVinRegisterBean () == null )
				registerBean = new VINRegisterBean ();
			else
				registerBean = ( VINRegisterBean ) sb.getObjVinRegisterBean ();

			logger.debug ( "VehicleRegistrationAction | strAction = " + strAction );

			if ( ! StringUtility.isStringBlank ( strAction ) )
			{

				//VINRegisterBean registerBean = new VINRegisterBean ();

				if ( strAction.equalsIgnoreCase ( "pageOne" ) )
				{
					registerBean.setOwnedBy ( ( String ) request.getParameter ( "individualBusinessFleet" ) );
					registerBean.setFirstName ( ( String ) request.getParameter ( "first" ) );
					registerBean.setLastName ( ( String ) request.getParameter ( "last" ) );
					registerBean.setBusinessOrFleetName ( ( String ) request.getParameter ( "businessName" ) );
					registerBean.setAddress ( ( String ) request.getParameter ( "address" ) );
					registerBean.setCity ( ( String ) request.getParameter ( "city" ) );
					registerBean.setState ( ( String ) request.getParameter ( "state" ) );
					registerBean.setZipcode ( ( String ) request.getParameter ( "zip" ) );
					registerBean.setPhoneNo ( ( String ) request.getParameter ( "phone" ) );

					sb.setObjVinRegisterBean ( registerBean );
					session.setAttribute ( "SessionBean" , sb );

					//session.setAttribute ( "RegisterBean" , registerBean );
					strActionForward = "pageTwo";

				}
				else if ( strAction.equalsIgnoreCase ( "pageTwo" ) )
				{
					registerBean.setLicenseNo ( ( String ) request.getParameter ( "licenseNo" ) );
					registerBean.setLicenseState ( ( String ) request.getParameter ( "licenseState" ) );
					registerBean.setLicenseExpiryDate ( ( String ) request.getParameter ( "licenseExpiry" ) );
					registerBean.setAdditionalIdentity ( ( String ) request.getParameter ( "additionalID" ) );
					registerBean.setOtherExplain ( ( String ) request.getParameter ( "otherExplain" ) );
					registerBean.setNoAdditionalIdentity ( ( String ) request.getParameter ( "noAdditionl" ) );
					/*registerBean.setAddtionalCircumstances ( (String)request.getParameter("circumstances") );*/
					registerBean.setDescribeCircumstances ( ( String ) request.getParameter ( "describeCircumstances" ) );
					registerBean.setOwnerAgreeTermsFalg ( ( String ) request.getParameter ( "ownerAgreeTermFalg" ) );

					sb.setObjVinRegisterBean ( registerBean );
					session.setAttribute ( "SessionBean" , sb );

					//session.setAttribute ( "RegisterBean" , registerBean );

					//return mapping.findForward ( "pageThree" );
					strActionForward = "pageThree";
				}
				else if ( strAction.equalsIgnoreCase ( "pageThree" ) )
				{
					registerBean.setVehicleYear ( ( String ) request.getParameter ( "ownerVehicleYear" ) );
					registerBean.setVehicleMake ( ( String ) request.getParameter ( "ownerVehicleMake" ) );
					registerBean.setVehicleModel ( ( String ) request.getParameter ( "ownerVehicleModel" ) );
					registerBean.setVehiclecolor ( ( String ) request.getParameter ( "ownerVehicleColor" ) );
					registerBean.setVehiclePlateNo ( ( String ) request.getParameter ( "ownerVehiclePlateNo" ) );
					registerBean.setVehicleState ( ( String ) request.getParameter ( "ownerVehicleState" ) );
					registerBean.setVehicleOdometer ( ( String ) request.getParameter ( "ownerVehicleOdometer" ) );

					sb.setObjVinRegisterBean ( registerBean );
					session.setAttribute ( "SessionBean" , sb );

					//session.setAttribute ( "RegisterBean" , registerBean );
					request.setAttribute ( "SUBMITTED_BY" , "OWNER" );

					//return mapping.findForward ( "pageFourth" );

					strActionForward = "pageFourth";
				}
				else if ( strAction.equalsIgnoreCase ( "pageFour" ) )
				{
					registerBean.setSubmitFirstName ( ( String ) request.getParameter ( "submittedFirstName" ) );
					registerBean.setSubmitLastName ( ( String ) request.getParameter ( "submittedLastName" ) );

					sb.setObjVinRegisterBean ( registerBean );
					session.setAttribute ( "SessionBean" , sb );

					strActionForward = "showConfirmPage";

				}
				else if ( strAction.equalsIgnoreCase ( "completeRegistration" ) )
				{

					boolean isInsert= false;
										
					if(( sb.getObjVinRegisterBean()!=null ) && (! StringUtility.isStringBlank ( sb.getVin() )))
					{						
						///boolean isValid = DMLManager.authincateVIn ( sb.getVin() );
						boolean isValid = true;
						logger.debug ( "isValid : " + isValid );
						
						if(!isValid)
						{
							session.removeAttribute("DuplicateInsert");
							isInsert = DMLManager.insertVerification ( sb );
		
							logger.debug ( "isInsert : " + registerBean.getNoAdditionalIdentity () );
							session.setAttribute ( "ExceptionFalg" , registerBean.getNoAdditionalIdentity () );
							if ( isInsert )
							{
		
								//session.setAttribute ( "SessionBean" , sb );
		
								//						code to send the email for exception. -- OWNER
		
								EmailHelper.sendExceptionEmail ( sb );
								registerBean = null;
								sb.setObjVinRegisterBean ( registerBean );
								session.setAttribute ( "SessionBean" , sb );
								session.setAttribute ( "InsertedVinNum" , sb.getVin() );
							}
						}
						else
						{
							String msg = "<b>Your Ownership Verification Record for Vin# " +  (String)session.getAttribute("InsertedVinNum") + " has <font color='red'>already been created/submitted.</font></b>";
							session.setAttribute ( "DuplicateInsert" , msg);
						}
						request.setAttribute ( "SUBMITTED_BY" , "OWNER" );
						logger.debug ( "isInsert : " + isInsert );
					}
					else
					{
						String msg = "<b>Your Ownership Verification Record for Vin# " +  (String)session.getAttribute("InsertedVinNum") + " has <font color='red'>already been created/submitted.</font></b>";
						session.setAttribute ( "DuplicateInsert" , msg);
					}

					strActionForward = "complete";
				}
			}

		}
		catch ( GageException ex )
		{

			logger.debug ( "************************************************" );
			logger.debug ( "--- VehicleRegistrationAction.execute() ---" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			logger.debug ( "************************************************" );

			//return mapping.findForward ( "contentError" );
			strActionForward = "contentError";

		}
		catch ( Exception ex )
		{

			logger.debug ( "************************************************" );
			logger.debug ( "--- VehicleRegistrationAction.execute() ---" );
			logger.debug ( "Exception :: " + ex.getLocalizedMessage () );
			logger.debug ( "************************************************" );

			//return mapping.findForward ( "contentError" );
			strActionForward = "contentError";
		}
		finally
		{

		}

		logger.debug ( "Action Forward : " + strActionForward );
		logger.exiting ( methodName );
		logger.debug ( "************************************************" );
		//return mapping.findForward ( "continue" );
		return mapping.findForward ( strActionForward );
	}

	public boolean registerPageOne ()
	{
		boolean status = false;

		return status;
	}

	public boolean registerPageTwo ()
	{

		boolean status = false;

		return status;
	}

}
