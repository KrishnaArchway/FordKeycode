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
 * File Name               : VINRegisterBean.java 
 * Package Name            : com.archway.estore.formbean
 * 
 * Date                    : Jan 20, 2014 9:01:54 PM
 * 
 * Change Date             : Jan 20, 2014 9:01:54 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class VINRegisterBean extends ActionForm
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String				ownedBy;

	private String				firstName;

	private String				lastName;

	private String				submitFirstName;

	private String				submitLastName;

	private String				businessOrFleetName;

	private String				address;

	private String				city;

	private String				state;

	private String				zipcode;

	private String				phoneNo;

	private String				licenseNo;

	private String				licenseState;

	private String				licenseExpiryDate;

	private String				additionalIdentity;

	private String				otherExplain;

	private String				noAdditionalIdentity;

	private String				addtionalCircumstances;

	private String				describeCircumstances;

	private String				vehicleYear;

	private String				vehicleMake;

	private String				vehicleModel;

	private String				vehiclecolor;

	private String				vehiclePlateNo;

	private String				vehicleState;

	private String				vehicleOdometer;

	private String				ownerAgreeTermsFalg;

	private String				dealerTitled;

	private String				dealerPosses;

	private String				dealerSell;

	/**
	 * @return Returns the dealerPosses.
	 */
	public String getDealerPosses ()
	{
		return ( StringUtility.isStringBlank ( dealerPosses ) ) ? StringUtility.processNullToEmpty ( dealerPosses ) : dealerPosses.toUpperCase ();
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
		return ( StringUtility.isStringBlank ( dealerSell ) ) ? StringUtility.processNullToEmpty ( dealerSell ) : dealerSell.toUpperCase ();
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
		return ( StringUtility.isStringBlank ( dealerTitled ) ) ? StringUtility.processNullToEmpty ( dealerTitled ) : dealerTitled.toUpperCase ();
	}

	/**
	 * @param dealerTitled The dealerTitled to set.
	 */
	public void setDealerTitled ( String dealerTitled )
	{
		this.dealerTitled = dealerTitled;
	}

	/**
	 * @return Returns the additionalIdentity.
	 */
	public String getAdditionalIdentity ()
	{
		return ( StringUtility.isStringBlank ( additionalIdentity ) ) ? StringUtility.processNullToEmpty ( additionalIdentity ) : additionalIdentity.toUpperCase ();
	}

	/**
	 * @param additionalIdentity The additionalIdentity to set.
	 */
	public void setAdditionalIdentity ( String additionalIdentity )
	{
		this.additionalIdentity = additionalIdentity;
	}

	/**
	 * @return Returns the address.
	 */
	public String getAddress ()
	{
		return ( StringUtility.isStringBlank ( address ) ) ? StringUtility.processNullToEmpty ( address ) : address.toUpperCase ();
	}

	/**
	 * @param address The address to set.
	 */
	public void setAddress ( String address )
	{
		this.address = address;
	}

	/**
	 * @return Returns the addtionalCircumstances.
	 */
	public String getAddtionalCircumstances ()
	{
		return ( StringUtility.isStringBlank ( addtionalCircumstances ) ) ? StringUtility.processNullToEmpty ( addtionalCircumstances ) : addtionalCircumstances.toUpperCase ();
	}

	/**
	 * @param addtionalCircumstances The addtionalCircumstances to set.
	 */
	public void setAddtionalCircumstances ( String addtionalCircumstances )
	{
		this.addtionalCircumstances = addtionalCircumstances;
	}

	/**
	 * @return Returns the businessOrFleetName.
	 */
	public String getBusinessOrFleetName ()
	{
		return ( StringUtility.isStringBlank ( businessOrFleetName ) ) ? StringUtility.processNullToEmpty ( businessOrFleetName ) : businessOrFleetName.toUpperCase ();
	}

	/**
	 * @param businessOrFleetName The businessOrFleetName to set.
	 */
	public void setBusinessOrFleetName ( String businessOrFleetName )
	{
		this.businessOrFleetName = businessOrFleetName;
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity ()
	{
		return ( StringUtility.isStringBlank ( city ) ) ? StringUtility.processNullToEmpty ( city ) : city.toUpperCase ();
	}

	/**
	 * @param city The city to set.
	 */
	public void setCity ( String city )
	{
		this.city = city;
	}

	/**
	 * @return Returns the describeCircumstances.
	 */
	public String getDescribeCircumstances ()
	{
		return ( StringUtility.isStringBlank ( describeCircumstances ) ) ? StringUtility.processNullToEmpty ( describeCircumstances ) : describeCircumstances.toUpperCase ();
	}

	/**
	 * @param describeCircumstances The describeCircumstances to set.
	 */
	public void setDescribeCircumstances ( String describeCircumstances )
	{
		this.describeCircumstances = describeCircumstances;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName ()
	{
		return ( StringUtility.isStringBlank ( firstName ) ) ? StringUtility.processNullToEmpty ( firstName ) : firstName.toUpperCase ();
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName ( String firstName )
	{
		this.firstName = firstName;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName ()
	{
		return ( StringUtility.isStringBlank ( lastName ) ) ? StringUtility.processNullToEmpty ( lastName ) : lastName.toUpperCase ();
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName ( String lastName )
	{
		this.lastName = lastName;
	}

	/**
	 * @return Returns the licenseExpiryDate.
	 */
	public String getLicenseExpiryDate ()
	{
		return ( StringUtility.isStringBlank ( licenseExpiryDate ) ) ? StringUtility.processNullToEmpty ( licenseExpiryDate ) : licenseExpiryDate.toUpperCase ();
	}

	/**
	 * @param licenseExpiryDate The licenseExpiryDate to set.
	 */
	public void setLicenseExpiryDate ( String licenseExpiryDate )
	{
		this.licenseExpiryDate = licenseExpiryDate;
	}

	/**
	 * @return Returns the licenseNo.
	 */
	public String getLicenseNo ()
	{
		return ( StringUtility.isStringBlank ( licenseNo ) ) ? StringUtility.processNullToEmpty ( licenseNo ) : licenseNo.toUpperCase ();
	}

	/**
	 * @param licenseNo The licenseNo to set.
	 */
	public void setLicenseNo ( String licenseNo )
	{
		this.licenseNo = licenseNo;
	}

	/**
	 * @return Returns the licenseState.
	 */
	public String getLicenseState ()
	{
		return ( StringUtility.isStringBlank ( licenseState ) ) ? StringUtility.processNullToEmpty ( licenseState ) : licenseState.toUpperCase ();
	}

	/**
	 * @param licenseState The licenseState to set.
	 */
	public void setLicenseState ( String licenseState )
	{
		this.licenseState = licenseState;
	}

	/**
	 * @return Returns the noAdditionalIdentity.
	 */
	public String getNoAdditionalIdentity ()
	{
		return ( StringUtility.isStringBlank ( noAdditionalIdentity ) ) ? StringUtility.processNullToEmpty ( noAdditionalIdentity ) : noAdditionalIdentity.toUpperCase ();
	}

	/**
	 * @param noAdditionalIdentity The noAdditionalIdentity to set.
	 */
	public void setNoAdditionalIdentity ( String noAdditionalIdentity )
	{
		this.noAdditionalIdentity = noAdditionalIdentity;
	}

	/**
	 * @return Returns the otherExplain.
	 */
	public String getOtherExplain ()
	{
		return ( StringUtility.isStringBlank ( otherExplain ) ) ? StringUtility.processNullToEmpty ( otherExplain ) : otherExplain.toUpperCase ();
	}

	/**
	 * @param otherExplain The otherExplain to set.
	 */
	public void setOtherExplain ( String otherExplain )
	{
		this.otherExplain = otherExplain;
	}

	/**
	 * @return Returns the ownedBy.
	 */
	public String getOwnedBy ()
	{
		return ( StringUtility.isStringBlank ( ownedBy ) ) ? StringUtility.processNullToEmpty ( ownedBy ) : ownedBy.toUpperCase ();
	}

	/**
	 * @param ownedBy The ownedBy to set.
	 */
	public void setOwnedBy ( String ownedBy )
	{
		this.ownedBy = ownedBy;
	}

	/**
	 * @return Returns the ownerAgreeTermsFalg.
	 */
	public String getOwnerAgreeTermsFalg ()
	{
		return ( StringUtility.isStringBlank ( ownerAgreeTermsFalg ) ) ? StringUtility.processNullToEmpty ( ownerAgreeTermsFalg ) : ownerAgreeTermsFalg.toUpperCase ();
	}

	/**
	 * @param ownerAgreeTermsFalg The ownerAgreeTermsFalg to set.
	 */
	public void setOwnerAgreeTermsFalg ( String ownerAgreeTermsFalg )
	{
		this.ownerAgreeTermsFalg = ownerAgreeTermsFalg;
	}

	/**
	 * @return Returns the vehiclecolor.
	 */
	public String getVehiclecolor ()
	{
		return ( StringUtility.isStringBlank ( vehiclecolor ) ) ? StringUtility.processNullToEmpty ( vehiclecolor ) : vehiclecolor.toUpperCase ();
	}

	/**
	 * @param vehiclecolor The vehiclecolor to set.
	 */
	public void setVehiclecolor ( String vehiclecolor )
	{
		this.vehiclecolor = vehiclecolor;
	}

	/**
	 * @return Returns the vehicleMake.
	 */
	public String getVehicleMake ()
	{
		return ( StringUtility.isStringBlank ( vehicleMake ) ) ? StringUtility.processNullToEmpty ( vehicleMake ) : vehicleMake.toUpperCase ();
	}

	/**
	 * @param vehicleMake The vehicleMake to set.
	 */
	public void setVehicleMake ( String vehicleMake )
	{
		this.vehicleMake = vehicleMake;
	}

	/**
	 * @return Returns the vehicleModel.
	 */
	public String getVehicleModel ()
	{
		return ( StringUtility.isStringBlank ( vehicleModel ) ) ? StringUtility.processNullToEmpty ( vehicleModel ) : vehicleModel.toUpperCase ();
	}

	/**
	 * @param vehicleModel The vehicleModel to set.
	 */
	public void setVehicleModel ( String vehicleModel )
	{
		this.vehicleModel = vehicleModel;
	}

	/**
	 * @return Returns the vehicleOdometer.
	 */
	public String getVehicleOdometer ()
	{
		return ( StringUtility.isStringBlank ( vehicleOdometer ) ) ? StringUtility.processNullToEmpty ( vehicleOdometer ) : vehicleOdometer.toUpperCase ();
	}

	/**
	 * @param vehicleOdometer The vehicleOdometer to set.
	 */
	public void setVehicleOdometer ( String vehicleOdometer )
	{
		this.vehicleOdometer = vehicleOdometer;
	}

	/**
	 * @return Returns the vehiclePlateNo.
	 */
	public String getVehiclePlateNo ()
	{
		return ( StringUtility.isStringBlank ( vehiclePlateNo ) ) ? StringUtility.processNullToEmpty ( vehiclePlateNo ) : vehiclePlateNo.toUpperCase ();
	}

	/**
	 * @param vehiclePlateNo The vehiclePlateNo to set.
	 */
	public void setVehiclePlateNo ( String vehiclePlateNo )
	{
		this.vehiclePlateNo = vehiclePlateNo;
	}

	/**
	 * @return Returns the vehicleState.
	 */
	public String getVehicleState ()
	{
		return ( StringUtility.isStringBlank ( vehicleState ) ) ? StringUtility.processNullToEmpty ( vehicleState ) : vehicleState.toUpperCase ();
	}

	/**
	 * @param vehicleState The vehicleState to set.
	 */
	public void setVehicleState ( String vehicleState )
	{
		this.vehicleState = vehicleState;
	}

	/**
	 * @return Returns the vehicleYear.
	 */
	public String getVehicleYear ()
	{
		return ( StringUtility.isStringBlank ( vehicleYear ) ) ? StringUtility.processNullToEmpty ( vehicleYear ) : vehicleYear.toUpperCase ();
	}

	/**
	 * @param vehicleYear The vehicleYear to set.
	 */
	public void setVehicleYear ( String vehicleYear )
	{
		this.vehicleYear = vehicleYear;
	}

	/**
	 * @return Returns the phoneNo.
	 */
	public String getPhoneNo ()
	{
		return ( StringUtility.isStringBlank ( phoneNo ) ) ? StringUtility.processNullToEmpty ( phoneNo ) : phoneNo.toUpperCase ();
	}

	/**
	 * @param phoneNo The phoneNo to set.
	 */
	public void setPhoneNo ( String phoneNo )
	{
		this.phoneNo = phoneNo;
	}

	/**
	 * @return Returns the state.
	 */
	public String getState ()
	{
		return ( StringUtility.isStringBlank ( state ) ) ? StringUtility.processNullToEmpty ( state ) : state.toUpperCase ();
	}

	/**
	 * @param state The state to set.
	 */
	public void setState ( String state )
	{
		this.state = state;
	}

	/**
	 * @return Returns the submitFirstName.
	 */
	public String getSubmitFirstName ()
	{
		return ( StringUtility.isStringBlank ( submitFirstName ) ) ? StringUtility.processNullToEmpty ( submitFirstName ) : submitFirstName.toUpperCase ();
	}

	/**
	 * @param submitFirstName The submitFirstName to set.
	 */
	public void setSubmitFirstName ( String submitFirstName )
	{
		this.submitFirstName = submitFirstName;
	}

	/**
	 * @return Returns the submitLastName.
	 */
	public String getSubmitLastName ()
	{
		return ( StringUtility.isStringBlank ( submitLastName ) ) ? StringUtility.processNullToEmpty ( submitLastName ) : submitLastName.toUpperCase ();
	}

	/**
	 * @param submitLastName The submitLastName to set.
	 */
	public void setSubmitLastName ( String submitLastName )
	{
		this.submitLastName = submitLastName;
	}

	/**
	 * @return Returns the zipcode.
	 */
	public String getZipcode ()
	{
		return ( StringUtility.isStringBlank ( zipcode ) ) ? StringUtility.processNullToEmpty ( zipcode ) : zipcode.toUpperCase ();
	}

	/**
	 * @param zipcode The zipcode to set.
	 */
	public void setZipcode ( String zipcode )
	{
		this.zipcode = zipcode;
	}

}
