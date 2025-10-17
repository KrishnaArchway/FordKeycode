package com.archway.estore.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.archway.estore.bo.DMLManager;
import com.archway.estore.common.Logger;
import com.archway.estore.formbean.EditRegistrationVINBean;
import com.archway.estore.util.StringUtility;

public class EditRegistrationAction extends Action
{
private static Logger	logger	= Logger.getLogger ( EditRegistrationAction.class );
	
	public ActionForward execute (
									ActionMapping mapping ,
									ActionForm form ,
									HttpServletRequest request ,
									HttpServletResponse response )
																	throws Exception
	{
		String methodName = "EditRegistrationAction.java ActionForward( ActionMapping , ActionForm , HttpServletRequest , HttpServletResponse)";
		logger.entering ( methodName );		
		String target ="continue";
		
		EditRegistrationVINBean editRegistrationVINBean = (EditRegistrationVINBean)form;
		
		String mode = request.getParameter ( "mode" );
		logger.debug("mode:" + mode);
		
		if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "menuPage" ) )
		{			
			target ="menuPage";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "searchByVin" ) )
		{
			logger.debug("inside searchByVin mode:" );
			String searchVin = request.getParameter("searchVin");
			int noOfDays = 0;
			if(request.getParameter("daysVin")!=null && request.getParameter("daysVin").trim().length()>0)
				noOfDays = Integer.parseInt(request.getParameter("daysVin"));			
			
			EditRegistrationVINBean ArrEditRegistrationVINBean = DMLManager.getVinInfo (searchVin, noOfDays);
			request.setAttribute("EditRegistrationVINBean", ArrEditRegistrationVINBean);
			request.setAttribute("searchVin", searchVin);
			request.setAttribute("daysVin", Integer.toString(noOfDays));
			
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "searchByPa" ) )
		{
			logger.debug("inside searchByPa mode:" );
			String searchPa = request.getParameter("searchPa");
			int noOfDays = 0;
			if(request.getParameter("daysPa")!=null && request.getParameter("daysPa").trim().length()>0)
				noOfDays = Integer.parseInt(request.getParameter("daysPa"));
			
			EditRegistrationVINBean [] ArrEditRegistrationVINBean = DMLManager.getVinInfoPa (searchPa, noOfDays);
			request.setAttribute("EditRegistrationVINBean", ArrEditRegistrationVINBean);
			request.setAttribute("searchPa", searchPa);
			request.setAttribute("daysPa", Integer.toString(noOfDays));
		}
		
		
//For vehicle Owner Info Page		
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "VehicleOwnerInfo" ) )
		{
			logger.debug("inside VehicleOwnerInfo mode:" );
			String selectedVin = request.getParameter("selectedVin");
			editRegistrationVINBean = DMLManager.getVinInfo (selectedVin, 0);
			
			if(StringUtility.isStringBlank ( editRegistrationVINBean.getDealer_owned() ))
			{
				if( (StringUtility.isStringBlank ( editRegistrationVINBean.getVo_first_name() )) && (StringUtility.isStringBlank ( editRegistrationVINBean.getVo_last_name())))
				{
					editRegistrationVINBean.setDealer_owned("Y");
				}
				else
				{
					editRegistrationVINBean.setDealer_owned("N");
				}
			}			
			
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			
			String dealership_name = editRegistrationVINBean.getDealership_name();
			if (StringUtility.isStringBlank ( dealership_name ))
				dealership_name = "Not Available";
			String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			String temp = "VIN : "+ editRegistrationVINBean.getVin() + tab + "PA Code : "+ editRegistrationVINBean.getPa_code() + tab + "Dealership Name : "+ dealership_name;
			request.getSession().setAttribute("VIN_PACODE_DEALERNAME",temp);
			
			if( editRegistrationVINBean.getDealer_owned().equalsIgnoreCase("Y"))
				target ="editVehicleInfo";
			else
				target ="editVehicleOwnerInfo";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "saveVehicleOwnerInfo" ) )
		{			
			logger.debug(editRegistrationVINBean.toString());
			boolean flag = DMLManager.updateVinRegistration(editRegistrationVINBean);
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			if(flag)
			{
				target ="menuPage";
			}
			else
			{
				request.setAttribute("updateRecordMsgError", "Record is not updated/saved Successfully");
				target ="editVehicleOwnerInfo";
			}
				
			
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToEditRegistration" ) )
		{
			request.setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			target ="continue";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToMenuScreen" ) )
		{			
			target ="menuPage";
		}
//end vehicle Owner Info Page
		
//For Personal Id Information Page		
		
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "personalIdInformation" ) )
		{
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			target ="editPersonalIdInfo";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "savePersonalIdInfo" ) )
		{			
			logger.debug(editRegistrationVINBean.toString());
			boolean flag = DMLManager.updateVinRegistration(editRegistrationVINBean);
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			if(flag)
			{
				target ="menuPage";
			}
			else
			{
				request.setAttribute("updateRecordMsgError", "Record is not updated/saved Successfully");
				target ="editPersonalIdInfo";
			}
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToVehicleOwnerInfo" ) )
		{
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			target ="editVehicleOwnerInfo";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToMenuScreen" ) )
		{			
			target ="menuPage";
		}
		
//end  Personal Id Information Page		
		
//For Vehicle Information Page		
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "vehicleInformation" ) )
		{
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			target ="editVehicleInfo";
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "saveVehicleInfo" ) )
		{			
			logger.debug(editRegistrationVINBean.toString());
			
			String dealerSell = request.getParameter ( "buy_sell" );
			String dealerPosses = request.getParameter ( "dealer_posess" );
			String dealerTitled = request.getParameter ( "dealer_titled" );

			logger.debug ( "dealerSell : " + dealerSell + " | dealerPosses = " + dealerPosses + " | dealerTitled = " + dealerTitled );

			if ( ! StringUtility.isStringBlank ( dealerSell ) )
			{
				editRegistrationVINBean.setBuy_sell( "Y" );
			}
			else
			{
				editRegistrationVINBean.setBuy_sell ( "N" );
			}

			if ( ! StringUtility.isStringBlank ( dealerTitled ) )
			{
				editRegistrationVINBean.setDealer_titled( "Y" );
			}
			else
			{
				editRegistrationVINBean.setDealer_titled ( "N" );
			}

			if ( ! StringUtility.isStringBlank ( dealerPosses ) )
			{
				editRegistrationVINBean.setDealer_posess( "Y" );
			}
			else
			{
				editRegistrationVINBean.setDealer_posess ( "N" );
			}
						
			boolean flag = DMLManager.updateVinRegistration(editRegistrationVINBean);
			request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			if(flag)
			{
				target ="menuPage";
			}
			else
			{
				request.setAttribute("updateRecordMsgError", "Record is not updated/saved Successfully");				
				target ="editVehicleInfo";
			}
		}
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToPersonalIdInfo" ) )
		{			
			if(editRegistrationVINBean.getDealer_owned().equalsIgnoreCase("Y"))
			{
				request.setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
				target ="continue";
			}
			else			
			{
				target ="editPersonalIdInfo";
				request.getSession().setAttribute("EditRegistrationVINBean", editRegistrationVINBean);
			}
		}		
		else if ( ! StringUtility.isStringBlank ( mode ) && mode.equalsIgnoreCase ( "backToMenuScreen" ) )
		{			
			target ="menuPage";
		}
//end Vehicle Information Page		
		
		return mapping.findForward ( target );
	}
}
