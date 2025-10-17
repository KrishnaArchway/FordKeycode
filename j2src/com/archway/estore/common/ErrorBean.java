package com.archway.estore.common;

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
 * File Name               : ErrorBean.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Jan 20, 2014 8:59:54 PM
 * 
 * Change Date             : Jan 20, 2014 8:59:54 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class ErrorBean
{

	private String	strErrorMessage;

	private String	strErrorCode;

	public ErrorBean ()
	{
	}

	public String getStrErrorMessage ()
	{
		return strErrorMessage;
	}

	public void setStrErrorMessage ( String newStrErrorMessage )
	{
		strErrorMessage = newStrErrorMessage;
	}

	public String getStrErrorCode ()
	{
		return strErrorCode;
	}

	public void setStrErrorCode ( String newStrErrorCode )
	{
		strErrorCode = newStrErrorCode;
	}

	public void setError ( String newStrErrorCode , String newStrErrorMessage )
	{
		setStrErrorCode ( newStrErrorCode );
		setStrErrorMessage ( newStrErrorMessage );
	}
}