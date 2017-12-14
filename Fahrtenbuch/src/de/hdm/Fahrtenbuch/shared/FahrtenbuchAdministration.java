package de.hdm.Fahrtenbuch.shared;

import com.google.gwt.user.client.rpc.RemoteService;

public interface FahrtenbuchAdministration extends RemoteService{
	
	public void init() throws IllegalArgumentException;

	boolean checkStatus(LoginInfo log);
	

}
