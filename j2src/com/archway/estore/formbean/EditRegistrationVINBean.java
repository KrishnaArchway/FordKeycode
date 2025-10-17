package com.archway.estore.formbean;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.archway.estore.util.StringUtility;

public class EditRegistrationVINBean extends ActionForm
{
	private static final long	serialVersionUID	= 1L;
	
	private String				vin;
	
	private String				vin_verification_id;
	
	private String				vo_last_name ;
	
	private String				vo_first_name;
	
	private String				submit_last_name;
	
	private String				submit_first_name;
	
	private String				pa_code;
	
	private String				fmcdealer_userid;
	
	private String				dealership_name ;
	
	private String				vo_business_name;
	
	private String				vo_address;
	
	private String				vo_city;
	
	private String				vo_state;
	
	private String				vo_zip;
	
	private String				vo_phone;
	
	private String				vo_drivers_license;
	
	private String				vo_license_state;
	
	private String				vo_license_exp_date;
	
	private String				id_title;
	
	private String				id_registration;
	
	private String				id_insurance;
	
	private String				id_other;    
	
	private String				other_descrip;
	
	private String				vehicle_year;
	
	private String				vehicle_make;
	
	private String				vehicle_model;
	
	private String				vehicle_color;
	
	private String				license_plate_number;
	
	private String				state_vehicle_reg;
	
	private String 				authentification_vin;
	
	private String				odometer;
	
	private String				dealer_owned;
	
	private String				dealer_titled;
	
	private String				dealer_posess;
	
	private String				buy_sell;
	
	private String				fkc_exception;
	
	private String				circumstances;
	
	private String				circumstances_descrip;
	
	private String				authentification_date;
	
	private String				exception_terms;
	
	private String				new_vehicle;
	
	private String				additionalIdentity;

	/**
	 * @return Returns the vo_last_name.
	 */
	public String getVo_last_name() {
		return (StringUtility.isStringBlank(vo_last_name)) ? StringUtility.processNullToEmpty(vo_last_name) : vo_last_name.toUpperCase();
	}

	/**
	 * @param vo_last_name The vo_last_name to set.
	 */
	public void setVo_last_name(String vo_last_name) {
		this.vo_last_name = vo_last_name;
	}

	/**
	 * @return Returns the vo_first_name.
	 */
	public String getVo_first_name() {
		return (StringUtility.isStringBlank(vo_first_name)) ? StringUtility
				.processNullToEmpty(vo_first_name) : vo_first_name.toUpperCase();
	}

	/**
	 * @param vo_first_name The vo_first_name to set.
	 */
	public void setVo_first_name(String vo_first_name) {
		this.vo_first_name = vo_first_name;
	}

	/**
	 * @return Returns the submit_last_name.
	 */
	public String getSubmit_last_name() {
		return (StringUtility.isStringBlank(submit_last_name)) ? StringUtility
				.processNullToEmpty(submit_last_name) : submit_last_name
				.toUpperCase();
	}

	/**
	 * @param submit_last_name The submit_last_name to set.
	 */
	public void setSubmit_last_name(String submit_last_name) {
		this.submit_last_name = submit_last_name;
	}

	/**
	 * @return Returns the submit_first_name.
	 */
	public String getSubmit_first_name() {
		return (StringUtility.isStringBlank(submit_first_name)) ? StringUtility
				.processNullToEmpty(submit_first_name) : submit_first_name
				.toUpperCase();
	}

	/**
	 * @param submit_first_name The submit_first_name to set.
	 */
	public void setSubmit_first_name(String submit_first_name) {
		this.submit_first_name = submit_first_name;
	}

	/**
	 * @return Returns the pa_code.
	 */
	public String getPa_code() {
		return (StringUtility.isStringBlank(pa_code)) ? StringUtility
				.processNullToEmpty(pa_code) : pa_code.toUpperCase();
	}

	/**
	 * @param pa_code The pa_code to set.
	 */
	public void setPa_code(String pa_code) {
		this.pa_code = pa_code;
	}

	/**
	 * @return Returns the fmcdealer_userid.
	 */
	public String getFmcdealer_userid() {
		return (StringUtility.isStringBlank(fmcdealer_userid)) ? StringUtility
				.processNullToEmpty(fmcdealer_userid) : fmcdealer_userid
				.toUpperCase();
	}

	/**
	 * @param fmcdealer_userid The fmcdealer_userid to set.
	 */
	public void setFmcdealer_userid(String fmcdealer_userid) {
		this.fmcdealer_userid = fmcdealer_userid;
	}

	/**
	 * @return Returns the dealership_name.
	 */
	public String getDealership_name() {
		return (StringUtility.isStringBlank(dealership_name)) ? StringUtility
				.processNullToEmpty(dealership_name) : dealership_name
				.toUpperCase();
	}

	/**
	 * @param dealership_name The dealership_name to set.
	 */
	public void setDealership_name(String dealership_name) {
		this.dealership_name = dealership_name;
	}

	/**
	 * @return Returns the vo_business_name.
	 */
	public String getVo_business_name() {
		return (StringUtility.isStringBlank(vo_business_name)) ? StringUtility
				.processNullToEmpty(vo_business_name) : vo_business_name
				.toUpperCase();
	}

	/**
	 * @param vo_business_name The vo_business_name to set.
	 */
	public void setVo_business_name(String vo_business_name) {
		this.vo_business_name = vo_business_name;
	}

	/**
	 * @return Returns the vo_address.
	 */
	public String getVo_address() {
		return (StringUtility.isStringBlank(vo_address)) ? StringUtility
				.processNullToEmpty(vo_address) : vo_address.toUpperCase();
	}

	/**
	 * @param vo_address The vo_address to set.
	 */
	public void setVo_address(String vo_address) {
		this.vo_address = vo_address;
	}

	/**
	 * @return Returns the vo_city.
	 */
	public String getVo_city() {
		return (StringUtility.isStringBlank(vo_city)) ? StringUtility
				.processNullToEmpty(vo_city) : vo_city.toUpperCase();
	}

	/**
	 * @param vo_city The vo_city to set.
	 */
	public void setVo_city(String vo_city) {
		this.vo_city = vo_city;
	}

	/**
	 * @return Returns the vo_state.
	 */
	public String getVo_state() {
		return (StringUtility.isStringBlank(vo_state)) ? StringUtility
				.processNullToEmpty(vo_state) : vo_state.toUpperCase();
	}

	/**
	 * @param vo_state The vo_state to set.
	 */
	public void setVo_state(String vo_state) {
		this.vo_state = vo_state;
	}

	/**
	 * @return Returns the vo_zip.
	 */
	public String getVo_zip() {
		return (StringUtility.isStringBlank(vo_zip)) ? StringUtility
				.processNullToEmpty(vo_zip) : vo_zip.toUpperCase();
	}

	/**
	 * @param vo_zip The vo_zip to set.
	 */
	public void setVo_zip(String vo_zip) {
		this.vo_zip = vo_zip;
	}

	/**
	 * @return Returns the vo_phone.
	 */
	public String getVo_phone() {
		return (StringUtility.isStringBlank(vo_phone)) ? StringUtility
				.processNullToEmpty(vo_phone) : vo_phone.toUpperCase();
	}

	/**
	 * @param vo_phone The vo_phone to set.
	 */
	public void setVo_phone(String vo_phone) {
		this.vo_phone = vo_phone;
	}

	/**
	 * @return Returns the vo_drivers_license.
	 */
	public String getVo_drivers_license() {
		return (StringUtility.isStringBlank(vo_drivers_license)) ? StringUtility
				.processNullToEmpty(vo_drivers_license) : vo_drivers_license
				.toUpperCase();
	}

	/**
	 * @param vo_drivers_license The vo_drivers_license to set.
	 */
	public void setVo_drivers_license(String vo_drivers_license) {
		this.vo_drivers_license = vo_drivers_license;
	}

	/**
	 * @return Returns the vo_license_state.
	 */
	public String getVo_license_state() {
		return (StringUtility.isStringBlank(vo_license_state)) ? StringUtility
				.processNullToEmpty(vo_license_state) : vo_license_state
				.toUpperCase();
	}

	/**
	 * @param vo_license_state The vo_license_state to set.
	 */
	public void setVo_license_state(String vo_license_state) {
		this.vo_license_state = vo_license_state;
	}

	/**
	 * @return Returns the vo_license_exp_date.
	 */
	public String getVo_license_exp_date() {
		return (StringUtility.isStringBlank(vo_license_exp_date)) ? StringUtility
				.processNullToEmpty(vo_license_exp_date) : vo_license_exp_date
				.toUpperCase();
	}

	/**
	 * @param vo_license_exp_date The vo_license_exp_date to set.
	 */
	public void setVo_license_exp_date(String vo_license_exp_date) {
		this.vo_license_exp_date = vo_license_exp_date;
	}

	/**
	 * @return Returns the id_title.
	 */
	public String getId_title() {
		return (StringUtility.isStringBlank(id_title)) ? StringUtility
				.processNullToEmpty(id_title) : id_title.toUpperCase();
	}

	/**
	 * @param id_title The id_title to set.
	 */
	public void setId_title(String id_title) {
		this.id_title = id_title;
	}

	/**
	 * @return Returns the id_registration.
	 */
	public String getId_registration() {
		return (StringUtility.isStringBlank(id_registration)) ? StringUtility
				.processNullToEmpty(id_registration) : id_registration
				.toUpperCase();
	}

	/**
	 * @param id_registration The id_registration to set.
	 */
	public void setId_registration(String id_registration) {
		this.id_registration = id_registration;
	}

	/**
	 * @return Returns the id_insurance.
	 */
	public String getId_insurance() {
		return (StringUtility.isStringBlank(id_insurance)) ? StringUtility
				.processNullToEmpty(id_insurance) : id_insurance.toUpperCase();
	}

	/**
	 * @param id_insurance The id_insurance to set.
	 */
	public void setId_insurance(String id_insurance) {
		this.id_insurance = id_insurance;
	}

	/**
	 * @return Returns the id_other.
	 */
	public String getId_other() {
		return (StringUtility.isStringBlank(id_other)) ? StringUtility
				.processNullToEmpty(id_other) : id_other.toUpperCase();
	}

	/**
	 * @param id_other The id_other to set.
	 */
	public void setId_other(String id_other) {
		this.id_other = id_other;
	}

	/**
	 * @return Returns the other_descrip.
	 */
	public String getOther_descrip() {
		return (StringUtility.isStringBlank(other_descrip)) ? StringUtility
				.processNullToEmpty(other_descrip) : other_descrip.toUpperCase();
	}

	/**
	 * @param other_descrip The other_descrip to set.
	 */
	public void setOther_descrip(String other_descrip) {
		this.other_descrip = other_descrip;
	}

	/**
	 * @return Returns the vehicle_color.
	 */
	public String getVehicle_color() {
		return (StringUtility.isStringBlank(vehicle_color)) ? StringUtility
				.processNullToEmpty(vehicle_color) : vehicle_color.toUpperCase();
	}

	/**
	 * @param vehicle_color The vehicle_color to set.
	 */
	public void setVehicle_color(String vehicle_color) {
		this.vehicle_color = vehicle_color;
	}

	/**
	 * @return Returns the license_plate_number.
	 */
	public String getLicense_plate_number() {
		return (StringUtility.isStringBlank(license_plate_number)) ? StringUtility
				.processNullToEmpty(license_plate_number) : license_plate_number
				.toUpperCase();
	}

	/**
	 * @param license_plate_number The license_plate_number to set.
	 */
	public void setLicense_plate_number(String license_plate_number) {
		this.license_plate_number = license_plate_number;
	}

	/**
	 * @return Returns the state_vehicle_reg.
	 */
	public String getState_vehicle_reg() {
		return (StringUtility.isStringBlank(state_vehicle_reg)) ? StringUtility
				.processNullToEmpty(state_vehicle_reg) : state_vehicle_reg
				.toUpperCase();
	}

	/**
	 * @param state_vehicle_reg The state_vehicle_reg to set.
	 */
	public void setState_vehicle_reg(String state_vehicle_reg) {
		this.state_vehicle_reg = state_vehicle_reg;
	}

	/**
	 * @return Returns the odometer.
	 */
	public String getOdometer() {
		return (StringUtility.isStringBlank(odometer)) ? StringUtility
				.processNullToEmpty(odometer) : odometer.toUpperCase();
	}

	/**
	 * @param odometer The odometer to set.
	 */
	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	/**
	 * @return Returns the dealer_owned.
	 */
	public String getDealer_owned() {
		return (StringUtility.isStringBlank(dealer_owned)) ? StringUtility
				.processNullToEmpty(dealer_owned) : dealer_owned.toUpperCase();
	}

	/**
	 * @param dealer_owned The dealer_owned to set.
	 */
	public void setDealer_owned(String dealer_owned) {
		this.dealer_owned = dealer_owned;
	}

	/**
	 * @return Returns the dealer_titled.
	 */
	public String getDealer_titled() {
		return (StringUtility.isStringBlank(dealer_titled)) ? StringUtility
				.processNullToEmpty(dealer_titled) : dealer_titled.toUpperCase();
	}

	/**
	 * @param dealer_titled The dealer_titled to set.
	 */
	public void setDealer_titled(String dealer_titled) {
		this.dealer_titled = dealer_titled;
	}

	/**
	 * @return Returns the dealer_posess.
	 */
	public String getDealer_posess() {
		return (StringUtility.isStringBlank(dealer_posess)) ? StringUtility
				.processNullToEmpty(dealer_posess) : dealer_posess.toUpperCase();
	}

	/**
	 * @param dealer_posess The dealer_posess to set.
	 */
	public void setDealer_posess(String dealer_posess) {
		this.dealer_posess = dealer_posess;
	}

	/**
	 * @return Returns the buy_sell.
	 */
	public String getBuy_sell() {
		return (StringUtility.isStringBlank(buy_sell)) ? StringUtility
				.processNullToEmpty(buy_sell) : buy_sell.toUpperCase();
	}

	/**
	 * @param buy_sell The buy_sell to set.
	 */
	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}

	/**
	 * @return Returns the fkc_exception.
	 */
	public String getFkc_exception() {
		return (StringUtility.isStringBlank(fkc_exception)) ? StringUtility
				.processNullToEmpty(fkc_exception) : fkc_exception.toUpperCase();
	}

	/**
	 * @param fkc_exception The fkc_exception to set.
	 */
	public void setFkc_exception(String fkc_exception) {
		this.fkc_exception = fkc_exception;
	}

	/**
	 * @return Returns the circumstances.
	 */
	public String getCircumstances() {
		return (StringUtility.isStringBlank(circumstances)) ? StringUtility
				.processNullToEmpty(circumstances) : circumstances.toUpperCase();
	}

	/**
	 * @param circumstances The circumstances to set.
	 */
	public void setCircumstances(String circumstances) {
		this.circumstances = circumstances;
	}

	/**
	 * @return Returns the circumstances_descrip.
	 */
	public String getCircumstances_descrip() {
		return (StringUtility.isStringBlank(circumstances_descrip)) ? StringUtility
				.processNullToEmpty(circumstances_descrip) : circumstances_descrip
				.toUpperCase();
	}

	/**
	 * @param circumstances_descrip The circumstances_descrip to set.
	 */
	public void setCircumstances_descrip(String circumstances_descrip) {
		this.circumstances_descrip = circumstances_descrip;
	}

	/**
	 * @return Returns the authentification_date.
	 */
	public String getAuthentification_date() {
		return (StringUtility.isStringBlank(authentification_date)) ? StringUtility
				.processNullToEmpty(authentification_date) : authentification_date
				.toUpperCase();
	}

	/**
	 * @param authentification_date The authentification_date to set.
	 */
	public void setAuthentification_date(String authentification_date) {
		this.authentification_date = authentification_date;
	}

	/**
	 * @return Returns the exception_terms.
	 */
	public String getException_terms() {
		return (StringUtility.isStringBlank(exception_terms)) ? StringUtility
				.processNullToEmpty(exception_terms) : exception_terms
				.toUpperCase();
	}

	/**
	 * @param exception_terms The exception_terms to set.
	 */
	public void setException_terms(String exception_terms) {
		this.exception_terms = exception_terms;
	}

	/**
	 * @return Returns the new_vehicle.
	 */
	public String getNew_vehicle() {
		return (StringUtility.isStringBlank(new_vehicle)) ? StringUtility
				.processNullToEmpty(new_vehicle) : new_vehicle.toUpperCase();
	}

	/**
	 * @param new_vehicle The new_vehicle to set.
	 */
	public void setNew_vehicle(String new_vehicle) {
		this.new_vehicle = new_vehicle;
	}

	/**
	 * @return Returns the vin.
	 */
	public String getVin() {
		return (StringUtility.isStringBlank(vin)) ? StringUtility
				.processNullToEmpty(vin) : vin.toUpperCase();
	}

	/**
	 * @param vin The vin to set.
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return Returns the vin_verification_id.
	 */
	public String getVin_verification_id() {
		return (StringUtility.isStringBlank(vin_verification_id)) ? StringUtility
				.processNullToEmpty(vin_verification_id) : vin_verification_id
				.toUpperCase();
	}

	/**
	 * @param vin_verification_id The vin_verification_id to set.
	 */
	public void setVin_verification_id(String vin_verification_id) {
		this.vin_verification_id = vin_verification_id;
	}

	/**
	 * @return Returns the vehicle_year.
	 */
	public String getVehicle_year() {
		return (StringUtility.isStringBlank(vehicle_year)) ? StringUtility
				.processNullToEmpty(vehicle_year) : vehicle_year.toUpperCase();
	}

	/**
	 * @param vehicle_year The vehicle_year to set.
	 */
	public void setVehicle_year(String vehicle_year) {
		this.vehicle_year = vehicle_year;
	}

	/**
	 * @return Returns the vehicle_make.
	 */
	public String getVehicle_make() {
		return (StringUtility.isStringBlank(vehicle_make)) ? StringUtility
				.processNullToEmpty(vehicle_make) : vehicle_make.toUpperCase();
	}

	/**
	 * @param vehicle_make The vehicle_make to set.
	 */
	public void setVehicle_make(String vehicle_make) {
		this.vehicle_make = vehicle_make;
	}

	/**
	 * @return Returns the vehicle_model.
	 */
	public String getVehicle_model() {
		return (StringUtility.isStringBlank(vehicle_model)) ? StringUtility
				.processNullToEmpty(vehicle_model) : vehicle_model.toUpperCase();
	}

	/**
	 * @param vehicle_model The vehicle_model to set.
	 */
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	/**
	 * @return Returns the authentification_vin.
	 */
	public String getAuthentification_vin() {
		return (StringUtility.isStringBlank(authentification_vin)) ? StringUtility
				.processNullToEmpty(authentification_vin) : authentification_vin
				.toUpperCase();
	}

	/**
	 * @param authentification_vin The authentification_vin to set.
	 */
	public void setAuthentification_vin(String authentification_vin) {
		this.authentification_vin = authentification_vin;
	}
	
	/**
	 * @return Returns the additionalIdentity.
	 */
	public String getAdditionalIdentity() {
		return (StringUtility.isStringBlank(additionalIdentity)) ? StringUtility
				.processNullToEmpty(additionalIdentity) : additionalIdentity
				.toUpperCase();
	}

	/**
	 * @param additionalIdentity The additionalIdentity to set.
	 */
	public void setAdditionalIdentity(String additionalIdentity) {
		this.additionalIdentity = additionalIdentity;
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
			return returnString.replaceAll ( "\\," , "\n" );
		}
		catch ( Exception e )
		{
			
		}
		return super.toString ();
	}
	
	
}
