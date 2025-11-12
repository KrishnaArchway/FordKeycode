package com.archway.estore.helper;

import com.archway.estore.session.SessionBean;

public class Emailtest {

	public static void main(String[] vars){
		SessionBean sb = new SessionBean();
		sb.setRegisteredVehicleToWhom ("Krishna");
		EmailHelper.sendExceptionEmail ( sb );
	}
}
