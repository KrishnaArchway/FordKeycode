package com.archway.webservices;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : VinNewImpl.java 
 * Package Name            : com.archway.webservices
 * 
 * Date                    : Apr 29, 2014 9:34:18 AM
 * 
 * Change Date             : Apr 29, 2014 9:34:18 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VinNewImpl
{

	private static Logger	logger	= Logger.getLogger ( VinNewImpl.class );

	public VinNewImpl ()
	{

	}

	/**
	 * 
	 * @param vinRequestEntity
	 * @return
	 * @throws Exception
	 */
	public VinResponseEntity validateVinNewVehicle (
													VinRequestEntity vinRequestEntity )
																						throws Exception
	{
		String methodName = "VinImpl.java validateVinNewVehicle(VinRequestEntity)";
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
					String value = DMLManager.getAuthNewVinRegistration4WebService ( vin , pacode);
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
}
