package com.archway.estore.helper;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.formbean.VINRegisterBean;
import com.archway.estore.session.SessionBean;
import com.archway.estore.util.DateUtility;
import com.archway.estore.util.Email;
import com.archway.estore.util.FileUtility;
import com.archway.estore.util.Html;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : EmailHelper.java 
 * Package Name            : com.archway.estore.helper
 * 
 * Date                    : Jan 27, 2014 6:33:38 PM
 * 
 * Change Date             : Jan 27, 2014 6:33:38 PM
 * 							 Jan 27, 2014 8:41:04 PM
 * 							 Jan 27, 2014 9:34:23 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class EmailHelper
{

	private static Logger	logger	= Logger.getLogger ( EmailHelper.class );

	public EmailHelper ()
	{

	}

	public static final String	TEMPLATE_PATH	= "D:/auto/keycode/WEB-INF/classes/com/archway/estore/common/";

	/**
	 * 
	 * @param SessionBean
	 * @return
	 */
	public static boolean sendExceptionEmail ( SessionBean sb )
	{
		String methodName = "EmailHelper.java sendExceptionEmail ( SessionBean ) ";
		logger.entering ( methodName );

		boolean flag = false;

		try
		{
			logger.warn ( "1............... " );
			String submittedBy = ( String ) sb.getRegisteredVehicleToWhom ();
			logger.warn ( "2............... " );
			String ownedBy = sb.getObjVinRegisterBean ().getOwnedBy ();
			logger.warn ( "3............... " );
			VINRegisterBean infoBean = ( VINRegisterBean ) sb.getObjVinRegisterBean ();
			logger.warn ( "4............... " );

			logger.warn ( "submittedBy    :" + submittedBy );
			logger.warn ( "ownedBy        :" + ownedBy );

			String templatePathAndFileName = TEMPLATE_PATH + getTemplateName ( submittedBy , ownedBy );

			logger.warn ( "templatePathAndFileName        :" + templatePathAndFileName );

			String fileContents = FileUtility.ReadFile ( templatePathAndFileName );

			logger.warn ( "Before   html body " + Html.cleanHtml ( fileContents ) );

			String finalEmailBody = fileContents.replaceAll ( "%sysdate%" , DateUtility.getCurrentDateTime () ).replaceAll ( "%vin%" , sb.getVin () ).replaceAll ( "%panda%" , sb.getPacode () ).replaceAll ( "%wsl%" , sb.getWsl () ).replaceAll ( "%firstname%" , infoBean.getFirstName () ).replaceAll ( "%lastname%" , infoBean.getLastName () ).replaceAll ( "%businessFleetName%" , infoBean.getBusinessOrFleetName () ).replaceAll ( "%address%" , infoBean.getAddress () ).replaceAll ( "%city%" , infoBean.getCity () ).replaceAll ( "%state%" , infoBean.getState () ).replaceAll ( "%zip%" , infoBean.getZipcode () ).replaceAll ( "%phone%" , infoBean.getPhoneNo () ).replaceAll ( "%dlnumber%" , infoBean.getLicenseNo () ).replaceAll ( "%licstate%" , infoBean.getLicenseState () ).replaceAll ( "%expirationDate%" , infoBean.getLicenseExpiryDate () ).replaceAll ( "%copyRetained%" , infoBean.getAdditionalIdentity () ).replaceAll ( "%exceptionFlag%" , infoBean.getNoAdditionalIdentity ().equalsIgnoreCase ( "true" ) ? "True" : " " ).replaceAll ( "%exceptionComments%" , infoBean.getDescribeCircumstances () ).replaceAll ( "%year%" , infoBean.getVehicleYear () ).replaceAll ( "%make%" , infoBean.getVehicleMake () ).replaceAll ( "%model%" , infoBean.getVehicleModel () ).replaceAll ( "%color%" , infoBean.getVehiclecolor () ).replaceAll ( "%licPlateNumber%" , infoBean.getVehiclePlateNo () ).replaceAll ( "%stateVehicleInformation%" , infoBean.getVehicleState () ).replaceAll ( "%odometerReading%" , infoBean.getVehicleOdometer () ).replaceAll ( "%submissionFirstName%" , infoBean.getSubmitFirstName () ).replaceAll ( "%submissionLastName%" , infoBean.getSubmitLastName () ).replaceAll ( "%titledDealership%" , infoBean.getDealerTitled () ).replaceAll ( "%titlePossession%" , infoBean.getDealerPosses () ).replaceAll ( "%buySellAgreement%" , infoBean.getDealerSell () );

			logger.warn ( "After   html body " + Html.cleanHtml ( finalEmailBody ) );

			String from = ConfigurationServlet.getApplicationProperty ( "FROM_EMAIL" );
			String to = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_TO_EMAIL" );
			String cc = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_CC_EMAIL" );
			String bcc = ConfigurationServlet.getApplicationProperty ( System.getProperty ( "ENV" ) + "_BCC_EMAIL" );
			String subject = ( ConfigurationServlet.getApplicationProperty ( "SUBJECT" ) + ( System.getProperty ( "ENV" ).equalsIgnoreCase ( "dev" ) ? " [ENVIRONMENT : DEV] " : "" ) ).replaceAll ( "%pandacode%" , sb.getPacode () );
			String plainText = ConfigurationServlet.getApplicationProperty ( "PLAIN_TEXT" );

			logger.warn ( "from     :" + from );
			logger.warn ( "to     :" + to );
			logger.warn ( "cc     :" + cc );
			logger.warn ( "bcc     :" + bcc );
			logger.warn ( "subject     :" + subject );
			logger.warn ( "plainText     :" + plainText );

			if ( infoBean.getNoAdditionalIdentity () != null && infoBean.getNoAdditionalIdentity ().equalsIgnoreCase ( "true" ) )
			{
				Email.SendHtmlEmailWithFileAttachment ( from , to.split ( "\\," ) , cc.split ( "\\," ) , bcc.split ( "\\," ) , subject , null , finalEmailBody , plainText );
			}

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception  : " + e.getMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return flag;
	}

	/**
	 * 
	 * @param submittedBy
	 * @param ownedBy
	 * @return
	 */
	public static String getTemplateName ( String submittedBy , String ownedBy )
	{
		String methodName = "EmailHelper.java getTemplateName ( String , String ) ";
		logger.entering ( methodName );

		String returnString = "";

		try
		{

			if ( submittedBy != null && submittedBy.equalsIgnoreCase ( "OWNER" ) )
			{
				returnString = "keycode_registration_Individual.htm";

				if ( ownedBy != null && ownedBy.equalsIgnoreCase ( "BUSINESSFLEET" ) )
				{
					returnString = "keycode_registration_businessfleet.htm";
				}

			}

			if ( submittedBy.equalsIgnoreCase ( "DEALER" ) )
			{
				returnString = "keycode_registration_dealer.htm";
			}

			logger.warn ( "returnString :" + returnString );
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception  : " + e.getMessage () );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return returnString;

	}

}
