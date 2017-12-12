package de.hdm.Fahrtenbuch.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FahrtenbuchAdministrationAsync {

	void init(AsyncCallback<Void> callback);

	void checkStatus(LoginInfo log, AsyncCallback<Boolean> asyncCallback);
}
