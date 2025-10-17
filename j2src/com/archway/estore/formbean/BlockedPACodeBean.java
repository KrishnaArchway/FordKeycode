package com.archway.estore.formbean;

import com.archway.estore.util.StringUtility;

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
 * File Name               : BlockedPACodeBean.java 
 * Package Name            : com.archway.estore.formbean
 * 
 * Date                    : Jan 20, 2014 9:01:43 PM
 * 
 * Change Date             : Jan 20, 2014 9:01:43 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class BlockedPACodeBean
{

	private static final long	serialVersionUID	= 1L;

	private String				blockedPaId;

	private String				paCode;

	private String				dealerShipName;

	private String				blockedFalg;

	/**
	 * @return Returns the blockedFalg.
	 */
	public String getBlockedFalg ()
	{
		return ( StringUtility.isStringBlank ( blockedFalg ) ) ? StringUtility.processNullToEmpty ( blockedFalg ) : blockedFalg.toUpperCase ();
	}

	/**
	 * @param blockedFalg The blockedFalg to set.
	 */
	public void setBlockedFalg ( String blockedFalg )
	{
		this.blockedFalg = blockedFalg;
	}

	/**
	 * @return Returns the blockedPaId.
	 */
	public String getBlockedPaId ()
	{
		return ( StringUtility.isStringBlank ( blockedPaId ) ) ? StringUtility.processNullToEmpty ( blockedPaId ) : blockedPaId.toUpperCase ();
	}

	/**
	 * @param blockedPaId The blockedPaId to set.
	 */
	public void setBlockedPaId ( String blockedPaId )
	{
		this.blockedPaId = blockedPaId;
	}

	/**
	 * @return Returns the dealerShipName.
	 */
	public String getDealerShipName ()
	{
		return ( StringUtility.isStringBlank ( dealerShipName ) ) ? StringUtility.processNullToEmpty ( dealerShipName ) : dealerShipName.toUpperCase ();
	}

	/**
	 * @param dealerShipName The dealerShipName to set.
	 */
	public void setDealerShipName ( String dealerShipName )
	{
		this.dealerShipName = dealerShipName;
	}

	/**
	 * @return Returns the paCode.
	 */
	public String getPaCode ()
	{
		return ( StringUtility.isStringBlank ( paCode ) ) ? StringUtility.processNullToEmpty ( paCode ) : paCode.toUpperCase ();
	}

	/**
	 * @param paCode The paCode to set.
	 */
	public void setPaCode ( String paCode )
	{
		this.paCode = paCode;
	}

}
