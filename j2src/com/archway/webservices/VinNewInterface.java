package com.archway.webservices;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : VinNewInterface.java 
 * Package Name            : com.archway.webservices
 * 
 * Date                    : Apr 29, 2014 9:35:25 AM
 * 
 * Change Date             : Apr 29, 2014 9:35:25 AM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public interface VinNewInterface
{

	public VinResponseEntity validateVinNewVehicle (
													VinRequestEntity vinRequestEntity )
																						throws java.rmi.RemoteException;

}
