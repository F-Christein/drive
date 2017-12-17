package de.hdm.Fahrtenbuch.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.Fahrtenbuch.client.ClientsideSettings;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.Fahrtenbuch.shared.bo.Nutzer;

public class NutzerClient extends Composite {

	FahrtenbuchAdministrationAsync FahrtenbuchVerwaltung = ClientsideSettings.getFahrtenbuchVerwaltung();

	FlexTable flexTable = new FlexTable();
	FlexTable additionalEigenschaften = new FlexTable();
	Label email = new Label("E-Mail:");
	TextBox mail = new TextBox();
	Label nutzerName = new Label("Profilname:");
	TextBox nutzerNam = new TextBox();

	Button add = new Button("Eigenschaft hinzufügen");
	Button speichern = new Button("Speichern");
	Button deleteOrga = new Button("Nutzerprofil löschen");
	Button bearbeiten = new Button("Nutzername bearbeiten");
	// Button save = new Button("Nutzername speichern");

	Nutzer neuerNutzer = new Nutzer();

	VerticalPanel vPanel = new VerticalPanel();

	public NutzerClient() {

		RootPanel.get("contentHeader").clear();
		Label newProfil = new Label("neuer Nutzer anlegen");
		RootPanel.get("contentHeader").add(newProfil);

		vPanel.add(add);

		mail.setValue(ClientsideSettings.getAktuellerUser().getEmailAddress());
		mail.setEnabled(false);

		flexTable.setWidget(0, 0, email);
		flexTable.setWidget(0, 1, mail);
		flexTable.setWidget(1, 0, nutzerName);
		flexTable.setWidget(1, 1, nutzerNam);

		
		
		speichern.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (mail.getValue().isEmpty() || nutzerNam.getValue().isEmpty()) {
					Window.alert("Bitte Feld ausfuellen!");
				} else {
					
					FahrtenbuchVerwaltung.createNutzer(new AsyncCallback<Nutzer>() {
						
						@Override
						public void onSuccess(Nutzer result){
							neuerNutzer = result;
							
							speichern.setEnabled(false);
							neuerNutzer.setGoogleId(mail.getValue());
							neuerNutzer.setName(nutzerNam.getValue());
							neuerNutzer.setProfilId(neuerNutzer.getProfilId());
							
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage());
							
						}
					});

				}
			}

		});
	}

}
