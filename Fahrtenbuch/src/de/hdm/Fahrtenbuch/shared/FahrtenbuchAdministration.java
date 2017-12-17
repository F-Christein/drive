package de.hdm.Fahrtenbuch.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.Fahrtenbuch.shared.bo.Nutzer;

public interface FahrtenbuchAdministration extends RemoteService{
	
	public void init() throws IllegalArgumentException;

	boolean checkStatus(LoginInfo log);

	public Nutzer createNutzer() throws IllegalArgumentException;
	

}
