package com.archway.estore.entities;

import com.archway.estore.common.Logger;
import com.archway.estore.util.StringUtility;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Archway Marketing Services.
 * 7525 Cogswell Rd,
 * Romulus, MI - 48174.
 * Phone - 734.713.2000
 * 
 * Project Name            : FordKeyCode
 * 
 * Author                  : bhattam0 - Amar Bhatt Email:(AMAR_BHATT@ARCHWAY.COM) PH. 734.713.2019
 * File Name               : ReportEntity.java 
 * Package Name            : com.archway.estore.entities
 * 
 * Date                    : Sep 9, 2014 2:56:11 PM
 * 
 * Change Date             : Sep 9, 2014 2:56:11 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class ReportEntity
{

	private static Logger	logger	= Logger.getLogger ( ReportEntity.class );

	private String	circumstances_descrip;

	private String	creation_date;

	private String	exception;

	private String	fmcdealer_userid;

	private String	id_insurance;

	private String	id_other;

	private String	id_registration;

	private String	id_title;

	private String	license_plate_number;

	private String	odometer;

	private String	other_descrip;

	private String	pa_code;

	private String	pa_name;

	private String	pa_phone;

	private String	state_vehicle_reg;

	private String	submit_first_name;

	private String	submit_last_name;

	private String	vehicle_color;

	private String	vehicle_make;

	private String	vehicle_model;

	private String	vehicle_year;

	private String	vin;

	private String	vo_address;

	private String	vo_city;

	private String	vo_first_name;

	private String	vo_last_name;

	private String	vo_phone;

	private String	vo_state;

	private String	vo_zip;

	public ReportEntity ()
	{
		this.vin = "";
		this.pa_code = "";
		this.pa_name = "";
		this.pa_phone = "";
		this.fmcdealer_userid = "";
		this.vo_first_name = "";
		this.vo_last_name = "";
		this.vo_address = "";
		this.vo_city = "";
		this.vo_state = "";
		this.vo_zip = "";
		this.vo_phone = "";
		this.id_title = "";
		this.id_registration = "";
		this.id_insurance = "";
		this.id_other = "";
		this.other_descrip = "";
		this.exception = "";
		this.circumstances_descrip = "";
		this.vehicle_year = "";
		this.vehicle_make = "";
		this.vehicle_model = "";
		this.vehicle_color = "";
		this.license_plate_number = "";
		this.state_vehicle_reg = "";
		this.odometer = "";
		this.submit_first_name = "";
		this.submit_last_name = "";
		this.creation_date = "";

	}

	/**
	 * @return Returns the circumstances_descrip.
	 */
	public String getCircumstances_descrip ()
	{
		return ( StringUtility.isStringBlank ( circumstances_descrip ) ) ? StringUtility.processNullToEmpty ( circumstances_descrip ) : circumstances_descrip.toUpperCase ();
	}

	/**
	 * @return Returns the creation_date.
	 */
	public String getCreation_date ()
	{
		return ( StringUtility.isStringBlank ( creation_date ) ) ? StringUtility.processNullToEmpty ( creation_date ) : creation_date.toUpperCase ();
	}

	/**
	 * @return Returns the exception.
	 */
	public String getException ()
	{
		return ( StringUtility.isStringBlank ( exception ) ) ? StringUtility.processNullToEmpty ( exception ) : exception.toUpperCase ();
	}

	/**
	 * @return Returns the fmcdealer_userid.
	 */
	public String getFmcdealer_userid ()
	{
		return ( StringUtility.isStringBlank ( fmcdealer_userid ) ) ? StringUtility.processNullToEmpty ( fmcdealer_userid ) : fmcdealer_userid.toUpperCase ();
	}

	/**
	 * @return Returns the id_insurance.
	 */
	public String getId_insurance ()
	{
		return ( StringUtility.isStringBlank ( id_insurance ) ) ? StringUtility.processNullToEmpty ( id_insurance ) : id_insurance.toUpperCase ();
	}

	/**
	 * @return Returns the id_other.
	 */
	public String getId_other ()
	{
		return ( StringUtility.isStringBlank ( id_other ) ) ? StringUtility.processNullToEmpty ( id_other ) : id_other.toUpperCase ();
	}

	/**
	 * @return Returns the id_registration.
	 */
	public String getId_registration ()
	{
		return ( StringUtility.isStringBlank ( id_registration ) ) ? StringUtility.processNullToEmpty ( id_registration ) : id_registration.toUpperCase ();
	}

	/**
	 * @return Returns the id_title.
	 */
	public String getId_title ()
	{
		return ( StringUtility.isStringBlank ( id_title ) ) ? StringUtility.processNullToEmpty ( id_title ) : id_title.toUpperCase ();
	}

	/**
	 * @return Returns the license_plate_number.
	 */
	public String getLicense_plate_number ()
	{
		return ( StringUtility.isStringBlank ( license_plate_number ) ) ? StringUtility.processNullToEmpty ( license_plate_number ) : license_plate_number.toUpperCase ();
	}

	/**
	 * @return Returns the odometer.
	 */
	public String getOdometer ()
	{
		return ( StringUtility.isStringBlank ( odometer ) ) ? StringUtility.processNullToEmpty ( odometer ) : odometer.toUpperCase ();
	}

	/**
	 * @return Returns the other_descrip.
	 */
	public String getOther_descrip ()
	{
		return ( StringUtility.isStringBlank ( other_descrip ) ) ? StringUtility.processNullToEmpty ( other_descrip ) : other_descrip.toUpperCase ();
	}

	/**
	 * @return Returns the pa_code.
	 */
	public String getPa_code ()
	{
		return ( StringUtility.isStringBlank ( pa_code ) ) ? StringUtility.processNullToEmpty ( pa_code ) : pa_code.toUpperCase ();
	}

	/**
	 * @return Returns the pa_name.
	 */
	public String getPa_name ()
	{
		return ( StringUtility.isStringBlank ( pa_name ) ) ? StringUtility.processNullToEmpty ( pa_name ) : pa_name.toUpperCase ();
	}

	/**
	 * @return Returns the pa_phone.
	 */
	public String getPa_phone ()
	{
		return ( StringUtility.isStringBlank ( pa_phone ) ) ? StringUtility.processNullToEmpty ( pa_phone ) : pa_phone.toUpperCase ();
	}

	/**
	 * @return Returns the state_vehicle_reg.
	 */
	public String getState_vehicle_reg ()
	{
		return ( StringUtility.isStringBlank ( state_vehicle_reg ) ) ? StringUtility.processNullToEmpty ( state_vehicle_reg ) : state_vehicle_reg.toUpperCase ();
	}

	/**
	 * @return Returns the submit_first_name.
	 */
	public String getSubmit_first_name ()
	{
		return ( StringUtility.isStringBlank ( submit_first_name ) ) ? StringUtility.processNullToEmpty ( submit_first_name ) : submit_first_name.toUpperCase ();
	}

	/**
	 * @return Returns the submit_last_name.
	 */
	public String getSubmit_last_name ()
	{
		return ( StringUtility.isStringBlank ( submit_last_name ) ) ? StringUtility.processNullToEmpty ( submit_last_name ) : submit_last_name.toUpperCase ();
	}

	/**
	 * @return Returns the vehicle_color.
	 */
	public String getVehicle_color ()
	{
		return ( StringUtility.isStringBlank ( vehicle_color ) ) ? StringUtility.processNullToEmpty ( vehicle_color ) : vehicle_color.toUpperCase ();
	}

	/**
	 * @return Returns the vehicle_make.
	 */
	public String getVehicle_make ()
	{
		return ( StringUtility.isStringBlank ( vehicle_make ) ) ? StringUtility.processNullToEmpty ( vehicle_make ) : vehicle_make.toUpperCase ();
	}

	/**
	 * @return Returns the vehicle_model.
	 */
	public String getVehicle_model ()
	{
		return ( StringUtility.isStringBlank ( vehicle_model ) ) ? StringUtility.processNullToEmpty ( vehicle_model ) : vehicle_model.toUpperCase ();
	}

	/**
	 * @return Returns the vehicle_year.
	 */
	public String getVehicle_year ()
	{
		return ( StringUtility.isStringBlank ( vehicle_year ) ) ? StringUtility.processNullToEmpty ( vehicle_year ) : vehicle_year.toUpperCase ();
	}

	/**
	 * @return Returns the vin.
	 */
	public String getVin ()
	{
		return ( StringUtility.isStringBlank ( vin ) ) ? StringUtility.processNullToEmpty ( vin ) : vin.toUpperCase ();
	}

	/**
	 * @return Returns the vo_address.
	 */
	public String getVo_address ()
	{
		return ( StringUtility.isStringBlank ( vo_address ) ) ? StringUtility.processNullToEmpty ( vo_address ) : vo_address.toUpperCase ();
	}

	/**
	 * @return Returns the vo_city.
	 */
	public String getVo_city ()
	{
		return ( StringUtility.isStringBlank ( vo_city ) ) ? StringUtility.processNullToEmpty ( vo_city ) : vo_city.toUpperCase ();
	}

	/**
	 * @return Returns the vo_first_name.
	 */
	public String getVo_first_name ()
	{
		return ( StringUtility.isStringBlank ( vo_first_name ) ) ? StringUtility.processNullToEmpty ( vo_first_name ) : vo_first_name.toUpperCase ();
	}

	/**
	 * @return Returns the vo_last_name.
	 */
	public String getVo_last_name ()
	{
		return ( StringUtility.isStringBlank ( vo_last_name ) ) ? StringUtility.processNullToEmpty ( vo_last_name ) : vo_last_name.toUpperCase ();
	}

	/**
	 * @return Returns the vo_phone.
	 */
	public String getVo_phone ()
	{
		return ( StringUtility.isStringBlank ( vo_phone ) ) ? StringUtility.processNullToEmpty ( vo_phone ) : vo_phone.toUpperCase ();
	}

	/**
	 * @return Returns the vo_state.
	 */
	public String getVo_state ()
	{
		return ( StringUtility.isStringBlank ( vo_state ) ) ? StringUtility.processNullToEmpty ( vo_state ) : vo_state.toUpperCase ();
	}

	/**
	 * @return Returns the vo_zip.
	 */
	public String getVo_zip ()
	{
		return ( StringUtility.isStringBlank ( vo_zip ) ) ? StringUtility.processNullToEmpty ( vo_zip ) : vo_zip.toUpperCase ();
	}

	/**
	 * @param circumstances_descrip The circumstances_descrip to set.
	 */
	public void setCircumstances_descrip ( String circumstances_descrip )
	{
		this.circumstances_descrip = circumstances_descrip;
	}

	/**
	 * @param creation_date The creation_date to set.
	 */
	public void setCreation_date ( String creation_date )
	{
		this.creation_date = creation_date;
	}

	/**
	 * @param exception The exception to set.
	 */
	public void setException ( String exception )
	{
		this.exception = exception;
	}

	/**
	 * @param fmcdealer_userid The fmcdealer_userid to set.
	 */
	public void setFmcdealer_userid ( String fmcdealer_userid )
	{
		this.fmcdealer_userid = fmcdealer_userid;
	}

	/**
	 * @param id_insurance The id_insurance to set.
	 */
	public void setId_insurance ( String id_insurance )
	{
		this.id_insurance = id_insurance;
	}

	/**
	 * @param id_other The id_other to set.
	 */
	public void setId_other ( String id_other )
	{
		this.id_other = id_other;
	}

	/**
	 * @param id_registration The id_registration to set.
	 */
	public void setId_registration ( String id_registration )
	{
		this.id_registration = id_registration;
	}

	/**
	 * @param id_title The id_title to set.
	 */
	public void setId_title ( String id_title )
	{
		this.id_title = id_title;
	}

	/**
	 * @param license_plate_number The license_plate_number to set.
	 */
	public void setLicense_plate_number ( String license_plate_number )
	{
		this.license_plate_number = license_plate_number;
	}

	/**
	 * @param odometer The odometer to set.
	 */
	public void setOdometer ( String odometer )
	{
		this.odometer = odometer;
	}

	/**
	 * @param other_descrip The other_descrip to set.
	 */
	public void setOther_descrip ( String other_descrip )
	{
		this.other_descrip = other_descrip;
	}

	/**
	 * @param pa_code The pa_code to set.
	 */
	public void setPa_code ( String pa_code )
	{
		this.pa_code = pa_code;
	}

	/**
	 * @param pa_name The pa_name to set.
	 */
	public void setPa_name ( String pa_name )
	{
		this.pa_name = pa_name;
	}

	/**
	 * @param pa_phone The pa_phone to set.
	 */
	public void setPa_phone ( String pa_phone )
	{
		this.pa_phone = pa_phone;
	}

	/**
	 * @param state_vehicle_reg The state_vehicle_reg to set.
	 */
	public void setState_vehicle_reg ( String state_vehicle_reg )
	{
		this.state_vehicle_reg = state_vehicle_reg;
	}

	/**
	 * @param submit_first_name The submit_first_name to set.
	 */
	public void setSubmit_first_name ( String submit_first_name )
	{
		this.submit_first_name = submit_first_name;
	}

	/**
	 * @param submit_last_name The submit_last_name to set.
	 */
	public void setSubmit_last_name ( String submit_last_name )
	{
		this.submit_last_name = submit_last_name;
	}

	/**
	 * @param vehicle_color The vehicle_color to set.
	 */
	public void setVehicle_color ( String vehicle_color )
	{
		this.vehicle_color = vehicle_color;
	}

	/**
	 * @param vehicle_make The vehicle_make to set.
	 */
	public void setVehicle_make ( String vehicle_make )
	{
		this.vehicle_make = vehicle_make;
	}

	/**
	 * @param vehicle_model The vehicle_model to set.
	 */
	public void setVehicle_model ( String vehicle_model )
	{
		this.vehicle_model = vehicle_model;
	}

	/**
	 * @param vehicle_year The vehicle_year to set.
	 */
	public void setVehicle_year ( String vehicle_year )
	{
		this.vehicle_year = vehicle_year;
	}

	/**
	 * @param vin The vin to set.
	 */
	public void setVin ( String vin )
	{
		this.vin = vin;
	}

	/**
	 * @param vo_address The vo_address to set.
	 */
	public void setVo_address ( String vo_address )
	{
		this.vo_address = vo_address;
	}

	/**
	 * @param vo_city The vo_city to set.
	 */
	public void setVo_city ( String vo_city )
	{
		this.vo_city = vo_city;
	}

	/**
	 * @param vo_first_name The vo_first_name to set.
	 */
	public void setVo_first_name ( String vo_first_name )
	{
		this.vo_first_name = vo_first_name;
	}

	/**
	 * @param vo_last_name The vo_last_name to set.
	 */
	public void setVo_last_name ( String vo_last_name )
	{
		this.vo_last_name = vo_last_name;
	}

	/**
	 * @param vo_phone The vo_phone to set.
	 */
	public void setVo_phone ( String vo_phone )
	{
		this.vo_phone = vo_phone;
	}

	/**
	 * @param vo_state The vo_state to set.
	 */
	public void setVo_state ( String vo_state )
	{
		this.vo_state = vo_state;
	}

	/**
	 * @param vo_zip The vo_zip to set.
	 */
	public void setVo_zip ( String vo_zip )
	{
		this.vo_zip = vo_zip;
	}

	/**
	 * toString
	 */
	public String toString ()
	{
		String returnString = "";
		try
		{
			returnString = BeanUtils.describe ( this ).toString ();
			returnString = returnString.substring ( 1 , returnString.length () - 1 );
			return returnString;
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception e " + e.getMessage () );
		}
		return super.toString ();
	}

}
