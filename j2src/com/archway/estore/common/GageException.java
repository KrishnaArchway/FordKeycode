package com.archway.estore.common;

import java.io.PrintWriter;

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
 * File Name               : GageException.java 
 * Package Name            : com.archway.estore.common
 * 
 * Date                    : Jan 20, 2014 9:00:02 PM
 * 
 * Change Date             : Jan 20, 2014 9:00:02 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class GageException extends Exception
{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long	serialVersionUID	= 1L;

	private String				_strErrorMessage;

	private int					_iErrorCode;

	private Throwable			_throwable;

	private static final Logger	logger				= Logger.getLogger ( GageException.class );

	/**
	 * Creates a <code>GageException</code> object.
	 * 
	 * @param e
	 *            the exception.
	 * @param errorCode
	 *            the application associated error code.
	 * @param throwable
	 *            the parent exception.
	 */
	public GageException (
							String errorMessage ,
							int errorCode ,
							Throwable throwable )
	{
		super ( errorMessage + " Error Code=" + errorCode );
		this._strErrorMessage = errorMessage;
		this._iErrorCode = errorCode;
		this._throwable = throwable;
		if ( null == throwable )
		{
			logger.warn ( errorMessage + " ErrorCode=" + errorCode );
		}
		else
		{
			logger.error ( errorMessage + " ErrorCode=" + errorCode , throwable );
		}
	}

	/**
	 * Gets the parameter name.
	 * 
	 * @returns the parameter name.
	 */
	public int getErrorCode ()
	{
		return _iErrorCode;
	}

	/**
	 * Gets the parameter name.
	 * 
	 * @returns the parameter name.
	 */
	public String getErrorMessage ()
	{
		return _strErrorMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace ( PrintWriter s )
	{
		super.printStackTrace ( s );
		if ( null != _throwable )
		{
			s.println ( "Caused By:" );
			_throwable.printStackTrace ( s );
		}
	}
}