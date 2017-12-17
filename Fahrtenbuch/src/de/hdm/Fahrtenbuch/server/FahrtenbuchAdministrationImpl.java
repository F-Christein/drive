package de.hdm.Fahrtenbuch.server;

import java.io.Serializable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.Fahrtenbuch.shared.LoginInfo;
import de.hdm.Fahrtenbuch.shared.bo.Nutzer;

@SuppressWarnings("serial")
public class FahrtenbuchAdministrationImpl extends RemoteServiceServlet implements FahrtenbuchAdministration, Serializable{
	
	public FahrtenbuchAdministrationImpl() throws IllegalArgumentException{
		
	}
	
	public void init() throws IllegalArgumentException{
		
	}

	@Override
	public boolean checkStatus(LoginInfo log) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nutzer createNutzer() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
