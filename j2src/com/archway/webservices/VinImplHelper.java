package com.archway.webservices;

import com.archway.estore.common.ConfigurationServlet;
import com.archway.estore.common.Logger;
import com.archway.estore.util.StringUtility;

import java.util.Random;

/**
 * Archway Marketing Services. 7525 Cogswell Rd, Romulus, MI - 48174. Phone -
 * 734.713.2000
 * 
 * Project Name : FordKeyCode
 * 
 * Author : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH.
 * 734.713.2019 File Name : VinImplHelper.java Package Name :
 * com.archway.webservices
 * 
 * Date : Apr 15, 2013 11:34:33 PM
 * 
 * Change Date : Apr 15, 2013 11:34:33 PM
 * 
 * --------------------------------------------------------- Description :- Add
 * Class Description here
 * ---------------------------------------------------------
 */

public class VinImplHelper
{

	private static VinImplHelper	instance	= null;

	private static Logger			logger		= Logger.getLogger ( VinImplHelper.class );

	/**
	 * 
	 * @param accessKey
	 * @return
	 */
	public static boolean dokeyValidation ( String accessKey )
	{
		String methodName = "VinImpl.java dokeyValidation (String)";
		logger.entering ( methodName );

		String env = System.getProperty ( "ENV" );
		logger.warn ( "Environment :" + env );

		boolean returnFlag = false;
		if ( StringUtility.isStringBlank ( accessKey ) )
		{
			return false;
		}

		String arr[] = ConfigurationServlet.getApplicationProperty ( env + "_WEBSERVICE_ACCESS_KEYS" ).split ( "\\|" );
		for ( int i = 0 ; i < arr.length ; i++ )
		{
			if ( accessKey.equals ( arr [i] ) )
			{
				returnFlag = true;
				break;
			}
		}
		logger.warn ( "returnFlag :" + returnFlag );
		logger.exiting ( methodName );
		return returnFlag;
	}

	/**
	 * 
	 * @param vin
	 * @param pacode
	 * @return
	 */
	public static boolean doParametersValidation ( String vin , String pacode )
	{
		String methodName = "VinImpl.java doParametersValidation (String , String)";
		logger.entering ( methodName );
		boolean returnFlag = true;

		if ( StringUtility.isStringBlank ( vin ) )
		{
			return false;
		}

		if ( StringUtility.isStringBlank ( pacode ) )
		{
			return false;
		}

		if ( vin.length () != 17 )
		{
			return false;
		}

		return returnFlag;
	}

	/**
	 * 
	 * @return
	 */
	public static String getPayloadID ()
	{
		initialize ();
		return System.currentTimeMillis () + "." + instance.getProcessID () + "." + instance.getRandomNumber () + "@" + "Archway-Key-Code-Application.home";
	}

	/**
	 * 
	 * 
	 */
	private static void initialize ()
	{
		if ( null == instance )
		{
			instance = new VinImplHelper ();
		}
	}

	public static void main ( String args[] )
	{
		System.out.println ( "\n\n\n" );
		for ( int i = 0 ; i < 100 ; i++ )
		{
			System.out.println ( getPayloadID () );
		}
	}

	private Random	random	= null;

	public VinImplHelper ()
	{
		random = new Random ();
	}

	/**
	 * 
	 * @return
	 */
	private int getProcessID ()
	{
		return Thread.currentThread ().hashCode ();
	}

	/**
	 * 
	 * @return
	 */
	private long getRandomNumber ()
	{
		long randomNumber = random.nextLong ();
		return Math.max ( randomNumber , randomNumber * - 1 ); // Make sure the
		// number is
		// positive.
	}
}
