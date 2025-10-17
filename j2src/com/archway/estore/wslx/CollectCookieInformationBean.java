package com.archway.estore.wslx;

import com.archway.estore.common.Logger;

import javax.servlet.http.HttpServletRequest;

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
 * File Name               : CollectCookieInformationBean.java 
 * Package Name            : com.archway.estore.wslx
 * 
 * Date                    : Jan 20, 2014 9:03:57 PM
 * 
 * Change Date             : Jan 20, 2014 9:03:57 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class CollectCookieInformationBean
{

	private static Logger	logger	= Logger.getLogger ( CollectCookieInformationBean.class );

	private String			aci;

	private String			company;

	private String			divAbbr;

	private String			empCode;

	private String			expires;

	private String			ip;

	private String			issued;

	private String			issuer;

	private String			org;

	private String			orgCode;

	private String			role;

	private String			site;

	private String			user;

	public CollectCookieInformationBean ()
	{
		this.issued = "";
		this.expires = "";
		this.issuer = "";
		this.user = "";
		this.ip = "";
		this.aci = "";
		this.site = "";
		this.orgCode = "";
		this.empCode = "";
		this.role = "";
		this.org = "";
		this.company = "";
		this.divAbbr = "";

	}

	// WSLX Cookie Issued Set and Get Method

	public String getAci ()
	{
		return ( this.aci );
	}

	public String getCompany ()
	{
		return ( this.company );
	}

	// WSLX Cookie Expires Set and Get Method

	public String getDivAbbr ()
	{
		return ( this.divAbbr );
	}

	public String getEmpCode ()
	{
		return ( this.empCode );
	}

	// WSLX Cookie Issuer Set and Get Method

	public String getExpires ()
	{
		return ( this.expires );
	}

	public String getIp ()
	{
		return ( this.ip );
	}

	// WSLX Cookie User Set and Get Method

	public String getIssued ()
	{
		return ( this.issued );
	}

	public String getIssuer ()
	{
		return ( this.issuer );
	}

	// WSLX Cookie IP Address Set and Get Method

	public String getOrg ()
	{
		return ( this.org );
	}

	public String getOrgCode ()
	{
		return ( this.orgCode );
	}

	// WSLX Cookie Aci Set and Get Method

	public String getRole ()
	{
		return ( this.role );
	}

	public String getSite ()
	{
		return ( this.site );
	}

	// WSLX Cookie Site Set and Get Method

	public String getUser ()
	{
		return ( this.user );
	}

	public void LogCookieInformationToLogFile ( HttpServletRequest req )
	{
		DetectBrowser db = new DetectBrowser ();
		db.setRequest ( req );
		logger.warn ( "**************Start ADFS Cookie Information Information per User*************************" );
		logger.warn ( "Issued					--> " + getIssued () );
		logger.warn ( "Expires					--> " + getExpires () );
		logger.warn ( "Issuer					--> " + getIssuer () );
		logger.warn ( "User						--> " + getUser () );
		logger.warn ( "IP						--> " + getIp () );
		logger.warn ( "ACI						--> " + getAci () );
		logger.warn ( "Site						--> " + getSite () );
		logger.warn ( "OrgCode					--> " + getOrgCode () );
		logger.warn ( "EmpCode					--> " + getEmpCode () );
		logger.warn ( "Role						--> " + getRole () );
		logger.warn ( "Org						--> " + getOrg () );
		logger.warn ( "Company 					--> " + getCompany () );
		logger.warn ( "DivAbbr 					--> " + getDivAbbr () );
		logger.warn ( "Browser Type and User Operation System 	--> " + db.getUseragent () );
		logger.warn ( "Net Enabled					--> " + db.isNetEnabled () );
		logger.warn ( "Is Browser Internet Explorer           	--> " + db.isIE () );
		logger.warn ( "Is Browser Netscape ver 6              	--> " + db.isNS6 () );
		logger.warn ( "Is Browser Netscape ver 4              	--> " + db.isNS4 () );
		logger.warn ( "Host Name you are coming from           	--> " + db.getHostName () );
		logger.warn ( "Host IP address you are coming from     	--> " + db.getUserIPAddress () );
		logger.warn ( "**************End ADFS Cookie Information Information per User**************************" );
	}

	public void loginfo ()
	{
		/*String returnString = "";
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
		 return super.toString ();*/

		logger.warn ( "**************Start toString () WSLX Cookie*************************" );
		logger.warn ( "Issued					--> " + getIssued () );
		logger.warn ( "Expires					--> " + getExpires () );
		logger.warn ( "Issuer					--> " + getIssuer () );
		logger.warn ( "User						--> " + getUser () );
		logger.warn ( "IP						--> " + getIp () );
		logger.warn ( "ACI						--> " + getAci () );
		logger.warn ( "Site						--> " + getSite () );
		logger.warn ( "OrgCode					--> " + getOrgCode () );
		logger.warn ( "EmpCode					--> " + getEmpCode () );
		logger.warn ( "Role						--> " + getRole () );
		logger.warn ( "Org						--> " + getOrg () );
		logger.warn ( "Company 					--> " + getCompany () );
		logger.warn ( "DivAbbr 					--> " + getDivAbbr () );
		logger.warn ( "**************End toString () WSLX Cookie*************************" );
	}

	// WSLX Cookie OrgCode Set and Get Method

	public void setAci ( String aci )
	{
		this.aci = aci;
	}

	public void setCompany ( String company )
	{
		this.company = company;
	}

	// WSLX Cookie EmpCode Set and Get Method

	public void setDivAbbr ( String divAbbr )
	{
		this.divAbbr = divAbbr;
	}

	public void setEmpCode ( String empCode )
	{
		this.empCode = empCode;
	}

	// WSLX Cookie Role Set and Get Method

	public void setExpires ( String expires )
	{
		this.expires = expires;
	}

	public void setIp ( String ip )
	{
		this.ip = ip;
	}

	// WSLX Cookie Org Set and Get Method (Parts Account)

	public void setIssued ( String issued )
	{
		this.issued = issued;
	}

	public void setIssuer ( String issuer )
	{
		this.issuer = issuer;
	}

	// WSLX Cookie Company Set and Get Method

	public void setOrg ( String org )
	{
		this.org = org;
	}

	public void setOrgCode ( String orgCode )
	{
		this.orgCode = orgCode;
	}

	// WSLX Cookie DivAbbr (Division Abbr) Set and Get Method

	public void setRole ( String role )
	{
		this.role = role;
	}

	public void setSite ( String site )
	{
		this.site = site;
	}

	public void setUser ( String user )
	{
		this.user = user;
	}
}
