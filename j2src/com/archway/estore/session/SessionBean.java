package com.archway.estore.session;

import com.archway.estore.common.Logger;
import com.archway.estore.formbean.VINRegisterBean;
import com.archway.estore.wslx.CollectCookieInformationBean;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;

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
 * File Name               : SessionBean.java 
 * Package Name            : com.archway.estore.session
 * 
 * Date                    : Jan 20, 2014 9:02:35 PM
 * 
 * Change Date             : Jan 20, 2014 9:02:35 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class SessionBean implements Serializable
{

	private static Logger					logger							= Logger.getLogger ( SessionBean.class );

	/**
	 * 
	 */
	private static final long				serialVersionUID				= 8062292990889979271L;

	private String							acl								= "";

	private CollectCookieInformationBean	collectCookieInformationBean	= null;

	private VINRegisterBean					objVinRegisterBean				= null;

	private String							pacode							= "";

	private String							registeredVehicleToWhom			= "";

	private String							sessionId						= "";

	private String							vin								= "";

	private String							wsl								= "";

	private String							dealerName						= "";

	private boolean							isSuperUser						= false;

	private int								newVehCounter					= 0;

	/**
	 * @return Returns the newVehCounter.
	 */
	public int getNewVehCounter ()
	{
		return newVehCounter;
	}

	/**
	 * @param newVehCounter The newVehCounter to set.
	 */
	public void setNewVehCounter ( int newVehCounter )
	{
		this.newVehCounter = newVehCounter;
	}

	/**
	 * @return Returns the isSuperUser.
	 */
	public boolean isSuperUser ()
	{
		return isSuperUser;
	}

	/**
	 * @param isSuperUser The isSuperUser to set.
	 */
	public void setSuperUser ( boolean isSuperUser )
	{
		this.isSuperUser = isSuperUser;
	}

	public SessionBean ()
	{

	}

	/**
	 * @return Returns the acl.
	 */
	public String getAcl ()
	{
		return acl;
	}

	/**
	 * @return Returns the collectCookieInformationBean.
	 */
	public CollectCookieInformationBean getCollectCookieInformationBean ()
	{
		return ( collectCookieInformationBean );
	}

	/**
	 * @return Returns the objVinRegisterBean.
	 */
	public VINRegisterBean getObjVinRegisterBean ()
	{
		return objVinRegisterBean;
	}

	/**
	 * @return Returns the pacode.
	 */
	public String getPacode ()
	{
		return pacode;
	}

	/**
	 * @return Returns the registeredVehicleToWhom.
	 */
	public String getRegisteredVehicleToWhom ()
	{
		return registeredVehicleToWhom;
	}

	/**
	 * @return Returns the sessionId.
	 */
	public String getSessionId ()
	{
		return sessionId;
	}

	/**
	 * @return Returns the vin.
	 */
	public String getVin ()
	{
		return vin;
	}

	/**
	 * @return Returns the wsl.
	 */
	public String getWsl ()
	{
		return wsl;
	}

	/**
	 * @param acl
	 *            The acl to set.
	 */
	public void setAcl ( String acl )
	{
		this.acl = acl;
	}

	/**
	 * @param collectCookieInformationBean The collectCookieInformationBean to set.
	 */
	public void setCollectCookieInformationBean (
													CollectCookieInformationBean collectCookieInformationBean )
	{
		this.collectCookieInformationBean = collectCookieInformationBean;
	}

	/**
	 * @param objVinRegisterBean The objVinRegisterBean to set.
	 */
	public void setObjVinRegisterBean ( VINRegisterBean objVinRegisterBean )
	{
		this.objVinRegisterBean = objVinRegisterBean;
	}

	/**
	 * @param pacode
	 *            The pacode to set.
	 */
	public void setPacode ( String pacode )
	{
		this.pacode = pacode;
	}

	/**
	 * @param registeredVehicleToWhom
	 *            The registeredVehicleToWhom to set.
	 */
	public void setRegisteredVehicleToWhom ( String registeredVehicleToWhom )
	{
		this.registeredVehicleToWhom = registeredVehicleToWhom;
	}

	/**
	 * @param sessionId
	 *            The sessionId to set.
	 */
	public void setSessionId ( String sessionId )
	{
		this.sessionId = sessionId;
	}

	/**
	 * @param vin
	 *            The vin to set.
	 */
	public void setVin ( String vin )
	{
		this.vin = vin;
	}

	/**
	 * @param wsl
	 *            The wsl to set.
	 */
	public void setWsl ( String wsl )
	{
		this.wsl = wsl;
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
			returnString = returnString.substring ( 1 , returnString.length () - 1 );// .replaceAll(",",
			// "\n");
			return returnString;
		}
		catch ( Exception e )
		{
			logger.warn ( "Exception e " + e.getMessage () );
		}
		return super.toString ();
	}

	/**
	 * @return Returns the dealerName.
	 */
	public String getDealerName ()
	{
		return dealerName.toUpperCase ();
	}

	/**
	 * @param dealerName The dealerName to set.
	 */
	public void setDealerName ( String dealerName )
	{
		this.dealerName = dealerName;
	}

}
