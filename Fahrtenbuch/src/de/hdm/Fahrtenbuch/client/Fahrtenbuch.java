package de.hdm.Fahrtenbuch.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.Fahrtenbuch.client.ClientsideSettings;
import de.hdm.Fahrtenbuch.shared.LoginInfo;
import de.hdm.Fahrtenbuch.shared.LoginService;
import de.hdm.Fahrtenbuch.shared.LoginServiceAsync;
import de.hdm.Fahrtenbuch.client.gui.Navigationsleiste;
import de.hdm.Fahrtenbuch.client.gui.NutzerClient;
import de.hdm.Fahrtenbuch.client.gui.MessageBox;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministrationAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Fahrtenbuch implements EntryPoint {

	FahrtenbuchAdministrationAsync FahrtenbuchVerwaltung = ClientsideSettings.getFahrtenbuchVerwaltung();

	private static String editorHtmlName = "Fahrtenbuch.html";

	static final int REFRESH_INTERVAL = 5000; // ms

	public static final Navigationsleiste nt = new Navigationsleiste();

	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Bitte einloggen um auf die Fahrtenbuch-Plattform zugreifen zu können");
	private Anchor signInLink = new Anchor("Sign In");

	public void onModuleLoad() {
		// Check login status using login service.

		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL() + editorHtmlName, new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {
			}

			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				ClientsideSettings.setAktuellerUser(result);
				if (loginInfo.isLoggedIn()) {
					loadFahrtenbuch();
					newUserCheck(result);
				} else {
					loadLogin();
				}
			}

			private void loadFahrtenbuch() {
				// TODO Auto-generated method stub

			}
		});
	}

	private void loadLogin() {
		// Assemble login panel.
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		RootPanel.get("content").add(loginPanel);
	}

	private void newUserCheck(LoginInfo log) {
		FahrtenbuchVerwaltung.checkStatus(log, new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean result) {
				if (!result) {
					nt.setButtonsUnabled();

					MessageBox.alertWidget("Nutzerkonto", "Sie haben noch kein Profil, bitte legen Sie eines an");
					RootPanel.get("content").clear();
					RootPanel.get("content").add(new NutzerClient());
				}
			}

			public void onFailure(Throwable caught) {
			}
		});
	}

}

// Test