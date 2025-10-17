/**
 * VinNewImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.newservices;

public class VinNewImplServiceLocator extends org.apache.axis.client.Service implements com.archway.webservices.newservices.VinNewImplService
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4502348669050669600L;

	public VinNewImplServiceLocator ()
	{
	}

	public VinNewImplServiceLocator ( org.apache.axis.EngineConfiguration config )
	{
		super ( config );
	}

	public VinNewImplServiceLocator (
										java.lang.String wsdlLoc ,
										javax.xml.namespace.QName sName )
																			throws javax.xml.rpc.ServiceException
	{
		super ( wsdlLoc , sName );
	}

	// Use to get a proxy class for validateNewVin
	private java.lang.String	validateNewVin_address	= "http://bhattam0.tsdet.archway.com/webservices/services/vin/validateNewVin";

	public java.lang.String getvalidateNewVinAddress ()
	{
		return validateNewVin_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String	validateNewVinWSDDServiceName	= "validateNewVin";

	public java.lang.String getvalidateNewVinWSDDServiceName ()
	{
		return validateNewVinWSDDServiceName;
	}

	public void setvalidateNewVinWSDDServiceName ( java.lang.String name )
	{
		validateNewVinWSDDServiceName = name;
	}

	public com.archway.webservices.newservices.VinNewImpl getvalidateNewVin ()
																				throws javax.xml.rpc.ServiceException
	{
		java.net.URL endpoint;
		try
		{
			endpoint = new java.net.URL ( validateNewVin_address );
		}
		catch ( java.net.MalformedURLException e )
		{
			throw new javax.xml.rpc.ServiceException ( e );
		}
		return getvalidateNewVin ( endpoint );
	}

	public com.archway.webservices.newservices.VinNewImpl getvalidateNewVin (
																				java.net.URL portAddress )
																											throws javax.xml.rpc.ServiceException
	{
		try
		{
			com.archway.webservices.newservices.ValidateNewVinSoapBindingStub _stub = new com.archway.webservices.newservices.ValidateNewVinSoapBindingStub ( portAddress , this );
			_stub.setPortName ( getvalidateNewVinWSDDServiceName () );
			return _stub;
		}
		catch ( org.apache.axis.AxisFault e )
		{
			return null;
		}
	}

	public void setvalidateNewVinEndpointAddress ( java.lang.String address )
	{
		validateNewVin_address = address;
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
			if ( com.archway.webservices.newservices.VinNewImpl.class.isAssignableFrom ( serviceEndpointInterface ) )
			{
				com.archway.webservices.newservices.ValidateNewVinSoapBindingStub _stub = new com.archway.webservices.newservices.ValidateNewVinSoapBindingStub ( new java.net.URL ( validateNewVin_address ) , this );
				_stub.setPortName ( getvalidateNewVinWSDDServiceName () );
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
		if ( "validateNewVin".equals ( inputPortName ) )
		{
			return getvalidateNewVin ();
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
		return new javax.xml.namespace.QName ( "urn:validateNewVin" , "VinNewImplService" );
	}

	private java.util.HashSet	ports	= null;

	public java.util.Iterator getPorts ()
	{
		if ( ports == null )
		{
			ports = new java.util.HashSet ();
			ports.add ( new javax.xml.namespace.QName ( "urn:validateNewVin" , "validateNewVin" ) );
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

		if ( "validateNewVin".equals ( portName ) )
		{
			setvalidateNewVinEndpointAddress ( address );
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
