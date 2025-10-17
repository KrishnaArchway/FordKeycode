package com.archway.estore.entities;

import com.archway.estore.common.Logger;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Date;

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
 * File Name               : FileBean.java 
 * Package Name            : com.archway.estore.entities
 * 
 * Date                    : Jan 20, 2014 9:00:41 PM
 * 
 * Change Date             : Jan 20, 2014 9:00:41 PM
 * 							 
 * ---------------------------------------------------------
 * Description :- Add Class Description here
 * ---------------------------------------------------------
 */

public class FileBean
{

	private static Logger		logger	= Logger.getLogger ( FileBean.class );

	private String				canRead;

	private String				canWrite;

	private java.lang.String	description;

	private java.lang.String	description_for_www;

	private String				exists;

	private Date				fileLastModified;

	private String				fileName;

	private String				isAbs;

	private String				isDir;

	private String				isFile;

	private String				isHid;

	private String				lastModified;

	private java.lang.String	nomenclature_id;

	private String				size;

	private long				sizeInBytes;

	private String				stockNumber;

	private String				thumbNailAvailable;

	private java.lang.String	uofm_description;

	public FileBean ()
	{

	}

	/**
	 * @return Returns the canRead.
	 */
	public String getCanRead ()
	{
		return canRead;
	}

	/**
	 * @return Returns the canWrite.
	 */
	public String getCanWrite ()
	{
		return canWrite;
	}

	/**
	 * @return Returns the description.
	 */
	public java.lang.String getDescription ()
	{
		return description;
	}

	/**
	 * @return Returns the description_for_www.
	 */
	public java.lang.String getDescription_for_www ()
	{
		return description_for_www;
	}

	/**
	 * @return Returns the exists.
	 */
	public String getExists ()
	{
		return exists;
	}

	/**
	 * @return Returns the fileLastModified.
	 */
	public Date getFileLastModified ()
	{
		return fileLastModified;
	}

	/**
	 * @return Returns the fileName.
	 */
	public String getFileName ()
	{
		return fileName;
	}

	/**
	 * @return Returns the isAbs.
	 */
	public String getIsAbs ()
	{
		return isAbs;
	}

	/**
	 * @return Returns the isDir.
	 */
	public String getIsDir ()
	{
		return isDir;
	}

	/**
	 * @return Returns the isFile.
	 */
	public String getIsFile ()
	{
		return isFile;
	}

	/**
	 * @return Returns the isHid.
	 */
	public String getIsHid ()
	{
		return isHid;
	}

	/**
	 * @return Returns the lastModified.
	 */
	public String getLastModified ()
	{
		return lastModified;
	}

	/**
	 * @return Returns the nomenclature_id.
	 */
	public java.lang.String getNomenclature_id ()
	{
		return nomenclature_id;
	}

	/**
	 * @return Returns the size.
	 */
	public String getSize ()
	{
		return size;
	}

	public long getSizeInBytes ()
	{
		return sizeInBytes;
	}

	/**
	 * @return Returns the stockNumber.
	 */
	public String getStockNumber ()
	{
		return stockNumber;
	}

	/**
	 * @return Returns the thumbNailAvailable.
	 */
	public String getThumbNailAvailable ()
	{
		return thumbNailAvailable;
	}

	/**
	 * @return Returns the uofm_description.
	 */
	public java.lang.String getUofm_description ()
	{
		return uofm_description;
	}

	/**
	 * @param canRead
	 *            The canRead to set.
	 */
	public void setCanRead ( String canRead )
	{
		this.canRead = canRead;
	}

	/**
	 * @param canWrite
	 *            The canWrite to set.
	 */
	public void setCanWrite ( String canWrite )
	{
		this.canWrite = canWrite;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	public void setDescription ( java.lang.String description )
	{
		this.description = description;
	}

	/**
	 * @param description_for_www
	 *            The description_for_www to set.
	 */
	public void setDescription_for_www ( java.lang.String description_for_www )
	{
		this.description_for_www = description_for_www;
	}

	/**
	 * @param exists
	 *            The exists to set.
	 */
	public void setExists ( String exists )
	{
		this.exists = exists;
	}

	/**
	 * @param fileLastModified
	 *            The fileLastModified to set.
	 */
	public void setFileLastModified ( Date fileLastModified )
	{
		this.fileLastModified = fileLastModified;
	}

	/**
	 * @param fileName
	 *            The fileName to set.
	 */
	public void setFileName ( String fileName )
	{
		this.fileName = fileName;
	}

	/**
	 * @param isAbs
	 *            The isAbs to set.
	 */
	public void setIsAbs ( String isAbs )
	{
		this.isAbs = isAbs;
	}

	/**
	 * @param isDir
	 *            The isDir to set.
	 */
	public void setIsDir ( String isDir )
	{
		this.isDir = isDir;
	}

	/**
	 * @param isFile
	 *            The isFile to set.
	 */
	public void setIsFile ( String isFile )
	{
		this.isFile = isFile;
	}

	/**
	 * @param isHid
	 *            The isHid to set.
	 */
	public void setIsHid ( String isHid )
	{
		this.isHid = isHid;
	}

	/**
	 * @param lastModified
	 *            The lastModified to set.
	 */
	public void setLastModified ( String lastModified )
	{
		this.lastModified = lastModified;
	}

	/**
	 * @param nomenclature_id
	 *            The nomenclature_id to set.
	 */
	public void setNomenclature_id ( java.lang.String nomenclature_id )
	{
		this.nomenclature_id = nomenclature_id;
	}

	/**
	 * @param size
	 *            The size to set.
	 */
	public void setSize ( String size )
	{
		this.size = size;
	}

	public void setSizeInBytes ( long sizeInBytes )
	{
		this.sizeInBytes = sizeInBytes;
	}

	/**
	 * @param stockNumber
	 *            The stockNumber to set.
	 */
	public void setStockNumber ( String stockNumber )
	{
		this.stockNumber = stockNumber;
	}

	/**
	 * @param thumbNailAvailable
	 *            The thumbNailAvailable to set.
	 */
	public void setThumbNailAvailable ( String thumbNailAvailable )
	{
		this.thumbNailAvailable = thumbNailAvailable;
	}

	/**
	 * @param uofm_description
	 *            The uofm_description to set.
	 */
	public void setUofm_description ( java.lang.String uofm_description )
	{
		this.uofm_description = uofm_description;
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
