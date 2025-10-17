package com.archway.webservices;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;

/**
 * Archway Marketing Services. 7525 Cogswell Rd, Romulus, MI - 48174. Phone -
 * 734.713.2000
 * 
 * Project Name : FordKeyCode
 * 
 * Author : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH.
 * 734.713.2019 File Name : VinImpl.java Package Name : com.archway.webservices
 * 
 * Date : Apr 15, 2013 9:17:53 PM
 * 
 * Change Date : Apr 15, 2013 9:17:53 PM
 * 				 Jun 3, 2013 1:57:05 PM
 * 				 Jul 31, 2013 3:56:22 PM
 * 
 * --------------------------------------------------------- Description :- Add
 * Class Description here
 * ---------------------------------------------------------
 */

public class VinImpl
{

	private static Logger	logger	= Logger.getLogger ( VinImpl.class );

	public VinImpl ()
	{

	}

	/**
	 * 
	 * @return
	 */
	/*public String helloWebServiceTest ()
	 {
	 String methodName = "VinImpl.java helloWebServiceTest()";
	 logger.entering ( methodName );
	 String returnString = DateUtility.getCurrentDateTime ();
	 logger.warn ( "returnString :" + returnString );
	 return "ARCHWAY [EST TIME] : " + returnString;

	 }*/

	/**
	 * 
	 * @param key
	 * @param vin
	 * @param pacode
	 * @return
	 * @throws Exception
	 */
	public VinResponseEntity validateVin ( VinRequestEntity vinRequestEntity )
																				throws Exception
	{
		String methodName = "VinImpl.java validateVin(VinRequestEntity)";
		logger.entering ( methodName );

		String returnString = "Y";

		VinResponseEntity vre = new VinResponseEntity ();
		String key = vinRequestEntity.getKEY ();
		String pacode = vinRequestEntity.getPACODE ();
		String vin = vinRequestEntity.getVIN ();
		try
		{

			if ( VinImplHelper.dokeyValidation ( key ) )
			{
				if ( VinImplHelper.doParametersValidation ( vin , pacode ) )
				{

					vre.setERROR_MESSAGE ( "2000-SUCCESS" );
					vre.setPACODE ( pacode );
					vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
					vre.setVIN ( vin );
					// call the database and return an success message and also
					// the vin result.
					String value = DMLManager.getAuthVinRegistration4WebService ( vin , pacode );
					vre.setVIN_RESULT ( value );
				}
				else
				{
					// vin and pacode not valid
					vre.setERROR_MESSAGE ( "1010-VIN OR PACODE NOT VALID" );
					vre.setPACODE ( pacode );
					vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
					vre.setVIN ( vin );
					vre.setVIN_RESULT ( "N" );
				}

			}
			else
			{
				// key not valid
				vre.setERROR_MESSAGE ( "1000-KEY NOT VALID" );
				vre.setPACODE ( pacode );
				vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
				vre.setVIN ( vin );
				vre.setVIN_RESULT ( "N" );

			}

		}
		catch ( Exception e )
		{
			logger.warn ( "Exception e :" + e.getMessage () );
			vre.setERROR_MESSAGE ( "9999-FATAL ERROR CONTACT ARCHWAY" );
			vre.setPACODE ( pacode );
			vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
			vre.setVIN ( vin );
			vre.setVIN_RESULT ( "N" );
		}
		finally
		{
			logger.exiting ( methodName );
		}

		return vre;
	}

	/**
	 * 
	 * @param key
	 * @param pacode
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	/*public String validateVin ( String key , String pacode , String vin )
	 throws Exception
	 {
	 String methodName = "VinImpl.java validateVin(String , String , String)";
	 logger.entering ( methodName );

	 String returnString = "Y";
	 VinResponseEntity vre = new VinResponseEntity ();
	 try
	 {

	 if ( VinImplHelper.dokeyValidation ( key ) )
	 {
	 if ( VinImplHelper.doParametersValidation ( vin , pacode ) )
	 {

	 vre.setERROR_MESSAGE ( "2000-SUCCESS" );
	 vre.setPACODE ( pacode );
	 vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
	 vre.setVIN ( vin );
	 // call the database and return an success message and also
	 // the vin result.
	 vre.setVIN_RESULT ( "Y" );
	 returnString = "Y";
	 }
	 else
	 {
	 // vin and pacode not valid
	 vre.setERROR_MESSAGE ( "1010-VIN OR PACODE NOT VALID" );
	 vre.setPACODE ( pacode );
	 vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
	 vre.setVIN ( vin );
	 vre.setVIN_RESULT ( "N" );
	 returnString = "N";
	 }

	 }
	 else
	 {
	 // key not valid
	 vre.setERROR_MESSAGE ( "1000-KEY NOT VALID" );
	 vre.setPACODE ( pacode );
	 vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
	 vre.setVIN ( vin );
	 vre.setVIN_RESULT ( "N" );
	 returnString = "N";

	 }

	 }
	 catch ( Exception e )
	 {
	 logger.warn ( "Exception e :" + e.getMessage () );
	 vre.setERROR_MESSAGE ( "9999-FATAL ERROR CONTACT ARCHWAY" );
	 vre.setPACODE ( pacode );
	 vre.setPAYLOAD_ID ( VinImplHelper.getPayloadID () );
	 vre.setVIN ( vin );
	 vre.setVIN_RESULT ( "N" );
	 returnString = "N";
	 }
	 finally
	 {
	 logger.exiting ( methodName );
	 }

	 return returnString;

	 }*/

}
