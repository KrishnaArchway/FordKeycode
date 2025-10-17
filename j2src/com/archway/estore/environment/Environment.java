package com.archway.estore.environment;

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
 * File Name               : Environment.java 
 * Package Name            : com.archway.estore.environment
 * 
 * Date                    : Jan 20, 2014 9:01:10 PM
 * 
 * Change Date             : Jan 20, 2014 9:01:10 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class Environment
{

	public static String getEnv ()
	{

		// possible values can be "dev", "qa", "prd" , "local"
		// this will be needed to change before build the war file depending on
		// which environment needs to be pointed.
		// return "QA";
		return System.getProperty ( "ENV" );
	}

}
