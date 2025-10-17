/**
 * VinResponseEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.archway.webservices.services;

public class VinResponseEntity implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= - 7492950950654657923L;

	private java.lang.String	ERROR_MESSAGE;

	private java.lang.String	PACODE;

	private java.lang.String	PAYLOAD_ID;

	private java.lang.String	VIN;

	private java.lang.String	VIN_RESULT;

	public VinResponseEntity ()
	{
	}

	public VinResponseEntity (
								java.lang.String ERROR_MESSAGE ,
								java.lang.String PACODE ,
								java.lang.String PAYLOAD_ID ,
								java.lang.String VIN ,
								java.lang.String VIN_RESULT )
	{
		this.ERROR_MESSAGE = ERROR_MESSAGE;
		this.PACODE = PACODE;
		this.PAYLOAD_ID = PAYLOAD_ID;
		this.VIN = VIN;
		this.VIN_RESULT = VIN_RESULT;
	}

	/**
	 * Gets the ERROR_MESSAGE value for this VinResponseEntity.
	 * 
	 * @return ERROR_MESSAGE
	 */
	public java.lang.String getERROR_MESSAGE ()
	{
		return ERROR_MESSAGE;
	}

	/**
	 * Sets the ERROR_MESSAGE value for this VinResponseEntity.
	 * 
	 * @param ERROR_MESSAGE
	 */
	public void setERROR_MESSAGE ( java.lang.String ERROR_MESSAGE )
	{
		this.ERROR_MESSAGE = ERROR_MESSAGE;
	}

	/**
	 * Gets the PACODE value for this VinResponseEntity.
	 * 
	 * @return PACODE
	 */
	public java.lang.String getPACODE ()
	{
		return PACODE;
	}

	/**
	 * Sets the PACODE value for this VinResponseEntity.
	 * 
	 * @param PACODE
	 */
	public void setPACODE ( java.lang.String PACODE )
	{
		this.PACODE = PACODE;
	}

	/**
	 * Gets the PAYLOAD_ID value for this VinResponseEntity.
	 * 
	 * @return PAYLOAD_ID
	 */
	public java.lang.String getPAYLOAD_ID ()
	{
		return PAYLOAD_ID;
	}

	/**
	 * Sets the PAYLOAD_ID value for this VinResponseEntity.
	 * 
	 * @param PAYLOAD_ID
	 */
	public void setPAYLOAD_ID ( java.lang.String PAYLOAD_ID )
	{
		this.PAYLOAD_ID = PAYLOAD_ID;
	}

	/**
	 * Gets the VIN value for this VinResponseEntity.
	 * 
	 * @return VIN
	 */
	public java.lang.String getVIN ()
	{
		return VIN;
	}

	/**
	 * Sets the VIN value for this VinResponseEntity.
	 * 
	 * @param VIN
	 */
	public void setVIN ( java.lang.String VIN )
	{
		this.VIN = VIN;
	}

	/**
	 * Gets the VIN_RESULT value for this VinResponseEntity.
	 * 
	 * @return VIN_RESULT
	 */
	public java.lang.String getVIN_RESULT ()
	{
		return VIN_RESULT;
	}

	/**
	 * Sets the VIN_RESULT value for this VinResponseEntity.
	 * 
	 * @param VIN_RESULT
	 */
	public void setVIN_RESULT ( java.lang.String VIN_RESULT )
	{
		this.VIN_RESULT = VIN_RESULT;
	}

	private java.lang.Object	__equalsCalc	= null;

	public synchronized boolean equals ( java.lang.Object obj )
	{
		if ( ! ( obj instanceof VinResponseEntity ) ) return false;
		VinResponseEntity other = ( VinResponseEntity ) obj;
		if ( obj == null ) return false;
		if ( this == obj ) return true;
		if ( __equalsCalc != null )
		{
			return ( __equalsCalc == obj );
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ( ( this.ERROR_MESSAGE == null && other.getERROR_MESSAGE () == null ) || ( this.ERROR_MESSAGE != null && this.ERROR_MESSAGE.equals ( other.getERROR_MESSAGE () ) ) ) && ( ( this.PACODE == null && other.getPACODE () == null ) || ( this.PACODE != null && this.PACODE.equals ( other.getPACODE () ) ) ) && ( ( this.PAYLOAD_ID == null && other.getPAYLOAD_ID () == null ) || ( this.PAYLOAD_ID != null && this.PAYLOAD_ID.equals ( other.getPAYLOAD_ID () ) ) ) && ( ( this.VIN == null && other.getVIN () == null ) || ( this.VIN != null && this.VIN.equals ( other.getVIN () ) ) ) && ( ( this.VIN_RESULT == null && other.getVIN_RESULT () == null ) || ( this.VIN_RESULT != null && this.VIN_RESULT.equals ( other.getVIN_RESULT () ) ) );
		__equalsCalc = null;
		return _equals;
	}

	private boolean	__hashCodeCalc	= false;

	public synchronized int hashCode ()
	{
		if ( __hashCodeCalc )
		{
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if ( getERROR_MESSAGE () != null )
		{
			_hashCode += getERROR_MESSAGE ().hashCode ();
		}
		if ( getPACODE () != null )
		{
			_hashCode += getPACODE ().hashCode ();
		}
		if ( getPAYLOAD_ID () != null )
		{
			_hashCode += getPAYLOAD_ID ().hashCode ();
		}
		if ( getVIN () != null )
		{
			_hashCode += getVIN ().hashCode ();
		}
		if ( getVIN_RESULT () != null )
		{
			_hashCode += getVIN_RESULT ().hashCode ();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc	typeDesc	= new org.apache.axis.description.TypeDesc ( VinResponseEntity.class , true );

	static
	{
		typeDesc.setXmlType ( new javax.xml.namespace.QName ( "urn:validateVin" , "VinResponseEntity" ) );
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "ERROR_MESSAGE" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "ERROR_MESSAGE" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "PACODE" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "PACODE" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "PAYLOAD_ID" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "PAYLOAD_ID" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "VIN" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "VIN" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
		elemField = new org.apache.axis.description.ElementDesc ();
		elemField.setFieldName ( "VIN_RESULT" );
		elemField.setXmlName ( new javax.xml.namespace.QName ( "" , "VIN_RESULT" ) );
		elemField.setXmlType ( new javax.xml.namespace.QName ( "http://schemas.xmlsoap.org/soap/encoding/" , "string" ) );
		elemField.setNillable ( true );
		typeDesc.addFieldDesc ( elemField );
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc ()
	{
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer (
																		java.lang.String mechType ,
																		java.lang.Class _javaType ,
																		javax.xml.namespace.QName _xmlType )
	{
		return new org.apache.axis.encoding.ser.BeanSerializer ( _javaType , _xmlType , typeDesc );
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer (
																			java.lang.String mechType ,
																			java.lang.Class _javaType ,
																			javax.xml.namespace.QName _xmlType )
	{
		return new org.apache.axis.encoding.ser.BeanDeserializer ( _javaType , _xmlType , typeDesc );
	}

}
