package com.archway.webservices;

/**
 * Archway Marketing Services. 7525 Cogswell Rd, Romulus, MI - 48174. Phone -
 * 734.713.2000
 * 
 * Project Name : FordKeyCode
 * 
 * Author : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH.
 * 734.713.2019 File Name : VinInterface.java Package Name :
 * com.archway.webservices
 * 
 * Date : Apr 15, 2013 9:19:10 PM
 * 
 * Change Date : Apr 15, 2013 9:19:10 PM
 * 				 Jun 3, 2013 1:53:47 PM
 * 				 Apr 29, 2014 9:27:23 AM
 * 
 * --------------------------------------------------------- Description :- Add
 * Class Description here
 * ---------------------------------------------------------
 */

public interface VinInterface
{

	public VinResponseEntity validateVin ( VinRequestEntity vinRequestEntity )
																				throws java.rmi.RemoteException;

}
