package de.hdm.Fahrtenbuch.client.gui;

import com.google.gwt.user.client.ui.Composite;

import de.hdm.Fahrtenbuch.client.ClientsideSettings;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministrationAsync;

public class Startseite extends Composite{
	
	FahrtenbuchAdministrationAsync fahrtenbuchVerwaltung = ClientsideSettings.getFahrtenbuchVerwaltung();
}
