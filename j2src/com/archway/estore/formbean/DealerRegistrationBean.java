package com.archway.estore.formbean;

import com.archway.estore.util.StringUtility;

import org.apache.struts.action.ActionForm;

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
 * File Name               : DealerRegistrationBean.java 
 * Package Name            : com.archway.estore.formbean
 * 
 * Date                    : Jan 20, 2014 9:01:49 PM
 * 
 * Change Date             : Jan 20, 2014 9:01:49 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class DealerRegistrationBean extends ActionForm
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String				dealerVehicleYear;

	private String				dealerVehicleMake;

	private String				dealerVehicleModel;

	private String				dealerVehicleColor;

	private String				dealerVehiclePlateNo;

	private String				dealerVehicleState;

	private String				dealerVehicleOdometer;

	private String				dealerFirstName;

	private String				dealerLastName;

	private String				ownershipProof;

	private String				dealerTitled;

	private String				dealerPosses;

	private String				dealerSell;

	/**
	 * @return Returns the dealerFirstName.
	 */
	public String getDealerFirstName ()
	{
		return ( StringUtility.isStringBlank ( dealerFirstName ) ) ? dealerFirstName : dealerFirstName.toUpperCase ();
	}

	/**
	 * @param dealerFirstName The dealerFirstName to set.
	 */
	public void setDealerFirstName ( String dealerFirstName )
	{
		this.dealerFirstName = dealerFirstName;
	}

	/**
	 * @return Returns the dealerLastName.
	 */
	public String getDealerLastName ()
	{
		return ( StringUtility.isStringBlank ( dealerLastName ) ) ? dealerLastName : dealerLastName.toUpperCase ();
	}

	/**
	 * @param dealerLastName The dealerLastName to set.
	 */
	public void setDealerLastName ( String dealerLastName )
	{
		this.dealerLastName = dealerLastName;
	}

	/**
	 * @return Returns the dealerPosses.
	 */
	public String getDealerPosses ()
	{
		return ( StringUtility.isStringBlank ( dealerPosses ) ) ? dealerPosses : dealerPosses.toUpperCase ();
	}

	/**
	 * @param dealerPosses The dealerPosses to set.
	 */
	public void setDealerPosses ( String dealerPosses )
	{
		this.dealerPosses = dealerPosses;
	}

	/**
	 * @return Returns the dealerSell.
	 */
	public String getDealerSell ()
	{
		return ( StringUtility.isStringBlank ( dealerSell ) ) ? dealerSell : dealerSell.toUpperCase ();
	}

	/**
	 * @param dealerSell The dealerSell to set.
	 */
	public void setDealerSell ( String dealerSell )
	{
		this.dealerSell = dealerSell;
	}

	/**
	 * @return Returns the dealerTitled.
	 */
	public String getDealerTitled ()
	{
		return ( StringUtility.isStringBlank ( dealerTitled ) ) ? dealerTitled : dealerTitled.toUpperCase ();
	}

	/**
	 * @param dealerTitled The dealerTitled to set.
	 */
	public void setDealerTitled ( String dealerTitled )
	{
		this.dealerTitled = dealerTitled;
	}

	/**
	 * @return Returns the dealerVehicleColor.
	 */
	public String getDealerVehicleColor ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleColor ) ) ? dealerVehicleColor : dealerVehicleColor.toUpperCase ();
	}

	/**
	 * @param dealerVehicleColor The dealerVehicleColor to set.
	 */
	public void setDealerVehicleColor ( String dealerVehicleColor )
	{
		this.dealerVehicleColor = dealerVehicleColor;
	}

	/**
	 * @return Returns the dealerVehicleMake.
	 */
	public String getDealerVehicleMake ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleMake ) ) ? dealerVehicleMake : dealerVehicleMake.toUpperCase ();
	}

	/**
	 * @param dealerVehicleMake The dealerVehicleMake to set.
	 */
	public void setDealerVehicleMake ( String dealerVehicleMake )
	{
		this.dealerVehicleMake = dealerVehicleMake;
	}

	/**
	 * @return Returns the dealerVehicleModel.
	 */
	public String getDealerVehicleModel ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleModel ) ) ? dealerVehicleModel : dealerVehicleModel.toUpperCase ();
	}

	/**
	 * @param dealerVehicleModel The dealerVehicleModel to set.
	 */
	public void setDealerVehicleModel ( String dealerVehicleModel )
	{
		this.dealerVehicleModel = dealerVehicleModel;
	}

	/**
	 * @return Returns the dealerVehicleOdometer.
	 */
	public String getDealerVehicleOdometer ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleOdometer ) ) ? dealerVehicleOdometer : dealerVehicleOdometer.toUpperCase ();
	}

	/**
	 * @param dealerVehicleOdometer The dealerVehicleOdometer to set.
	 */
	public void setDealerVehicleOdometer ( String dealerVehicleOdometer )
	{
		this.dealerVehicleOdometer = dealerVehicleOdometer;
	}

	/**
	 * @return Returns the dealerVehiclePlateNo.
	 */
	public String getDealerVehiclePlateNo ()
	{
		return ( StringUtility.isStringBlank ( dealerVehiclePlateNo ) ) ? dealerVehiclePlateNo : dealerVehiclePlateNo.toUpperCase ();
	}

	/**
	 * @param dealerVehiclePlateNo The dealerVehiclePlateNo to set.
	 */
	public void setDealerVehiclePlateNo ( String dealerVehiclePlateNo )
	{
		this.dealerVehiclePlateNo = dealerVehiclePlateNo;
	}

	/**
	 * @return Returns the dealerVehicleState.
	 */
	public String getDealerVehicleState ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleState ) ) ? dealerVehicleState : dealerVehicleState.toUpperCase ();
	}

	/**
	 * @param dealerVehicleState The dealerVehicleState to set.
	 */
	public void setDealerVehicleState ( String dealerVehicleState )
	{
		this.dealerVehicleState = dealerVehicleState;
	}

	/**
	 * @return Returns the dealerVehicleYear.
	 */
	public String getDealerVehicleYear ()
	{
		return ( StringUtility.isStringBlank ( dealerVehicleYear ) ) ? dealerVehicleYear : dealerVehicleYear.toUpperCase ();
	}

	/**
	 * @param dealerVehicleYear The dealerVehicleYear to set.
	 */
	public void setDealerVehicleYear ( String dealerVehicleYear )
	{
		this.dealerVehicleYear = dealerVehicleYear;
	}

	/**
	 * @return Returns the ownershipProof.
	 */
	public String getOwnershipProof ()
	{
		return ( StringUtility.isStringBlank ( ownershipProof ) ) ? ownershipProof : ownershipProof.toUpperCase ();
	}

	/**
	 * @param ownershipProof The ownershipProof to set.
	 */
	public void setOwnershipProof ( String ownershipProof )
	{
		this.ownershipProof = ownershipProof;
	}

}
