package de.hdm.Fahrtenbuch.shared;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ReportGenerator extends RemoteService{
	
	public void init() throws IllegalArgumentException;

}
