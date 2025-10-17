/**
 * VinImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.services;

public class VinImplServiceLocator extends org.apache.axis.client.Service implements com.archway.webservices.services.VinImplService
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= - 5049469190717307206L;

	public VinImplServiceLocator ()
	{
	}

	public VinImplServiceLocator ( org.apache.axis.EngineConfiguration config )
	{
		super ( config );
	}

	public VinImplServiceLocator (
									java.lang.String wsdlLoc ,
									javax.xml.namespace.QName sName )
																		throws javax.xml.rpc.ServiceException
	{
		super ( wsdlLoc , sName );
	}

	// Use to get a proxy class for validateVin
	private java.lang.String	validateVin_address	= "http://bhattam0.tsdet.archway.com/webservices/services/vin/validateVin";

	public java.lang.String getvalidateVinAddress ()
	{
		return validateVin_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String	validateVinWSDDServiceName	= "validateVin";

	public java.lang.String getvalidateVinWSDDServiceName ()
	{
		return validateVinWSDDServiceName;
	}

	public void setvalidateVinWSDDServiceName ( java.lang.String name )
	{
		validateVinWSDDServiceName = name;
	}

	public com.archway.webservices.services.VinImpl getvalidateVin ()
																		throws javax.xml.rpc.ServiceException
	{
		java.net.URL endpoint;
		try
		{
			endpoint = new java.net.URL ( validateVin_address );
		}
		catch ( java.net.MalformedURLException e )
		{
			throw new javax.xml.rpc.ServiceException ( e );
		}
		return getvalidateVin ( endpoint );
	}

	public com.archway.webservices.services.VinImpl getvalidateVin (
																	java.net.URL portAddress )
																								throws javax.xml.rpc.ServiceException
	{
		try
		{
			com.archway.webservices.services.ValidateVinSoapBindingStub _stub = new com.archway.webservices.services.ValidateVinSoapBindingStub ( portAddress , this );
			_stub.setPortName ( getvalidateVinWSDDServiceName () );
			return _stub;
		}
		catch ( org.apache.axis.AxisFault e )
		{
			return null;
		}
	}

	public void setvalidateVinEndpointAddress ( java.lang.String address )
	{
		validateVin_address = address;
	}

	/**
	 * For the given interface, get the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort ( Class serviceEndpointInterface )
																		throws javax.xml.rpc.ServiceException
	{
		try
		{
			if ( com.archway.webservices.services.VinImpl.class.isAssignableFrom ( serviceEndpointInterface ) )
			{
				com.archway.webservices.services.ValidateVinSoapBindingStub _stub = new com.archway.webservices.services.ValidateVinSoapBindingStub ( new java.net.URL ( validateVin_address ) , this );
				_stub.setPortName ( getvalidateVinWSDDServiceName () );
				return _stub;
			}
		}
		catch ( java.lang.Throwable t )
		{
			throw new javax.xml.rpc.ServiceException ( t );
		}
		throw new javax.xml.rpc.ServiceException ( "There is no stub implementation for the interface:  " + ( serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName () ) );
	}

	/**
	 * For the given interface, get the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort (
									javax.xml.namespace.QName portName ,
									Class serviceEndpointInterface )
																	throws javax.xml.rpc.ServiceException
	{
		if ( portName == null )
		{
			return getPort ( serviceEndpointInterface );
		}
		java.lang.String inputPortName = portName.getLocalPart ();
		if ( "validateVin".equals ( inputPortName ) )
		{
			return getvalidateVin ();
		}
		else
		{
			java.rmi.Remote _stub = getPort ( serviceEndpointInterface );
			( ( org.apache.axis.client.Stub ) _stub ).setPortName ( portName );
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName ()
	{
		return new javax.xml.namespace.QName ( "urn:validateVin" , "VinImplService" );
	}

	private java.util.HashSet	ports	= null;

	public java.util.Iterator getPorts ()
	{
		if ( ports == null )
		{
			ports = new java.util.HashSet ();
			ports.add ( new javax.xml.namespace.QName ( "urn:validateVin" , "validateVin" ) );
		}
		return ports.iterator ();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress (
									java.lang.String portName ,
									java.lang.String address )
																throws javax.xml.rpc.ServiceException
	{

		if ( "validateVin".equals ( portName ) )
		{
			setvalidateVinEndpointAddress ( address );
		}
		else
		{ // Unknown Port Name
			throw new javax.xml.rpc.ServiceException ( " Cannot set Endpoint Address for Unknown Port" + portName );
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress (
									javax.xml.namespace.QName portName ,
									java.lang.String address )
																throws javax.xml.rpc.ServiceException
	{
		setEndpointAddress ( portName.getLocalPart () , address );
	}

}
