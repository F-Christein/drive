package de.hdm.Fahrtenbuch.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.Fahrtenbuch.shared.bo.Nutzer;

public interface FahrtenbuchAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void checkStatus(LoginInfo log, AsyncCallback<Boolean> asyncCallback);

	void createNutzer(AsyncCallback<Nutzer> asyncCallback);
}
