package de.hdm.Fahrtenbuch.client;

import com.google.gwt.core.client.GWT;

import de.hdm.Fahrtenbuch.shared.CommonSettings;
import de.hdm.Fahrtenbuch.client.ClientsideSettings;
import de.hdm.Fahrtenbuch.shared.LoginInfo;
import de.hdm.Fahrtenbuch.shared.LoginService;
import de.hdm.Fahrtenbuch.shared.LoginServiceAsync;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.Fahrtenbuch.shared.ReportGenerator;
import de.hdm.Fahrtenbuch.shared.ReportGeneratorAsync;

public class ClientsideSettings extends CommonSettings{
	
	
	//Leere Objektvariablen, um Project4uAdministrationAsync einmalig zu instaziieren

	private static FahrtenbuchAdministrationAsync fahrtenbuchVerwaltung = null;
	private static ReportGeneratorAsync reportVerwaltung = null;
	private static LoginServiceAsync loginService = null;
	private static LoginInfo aktuellerUser = null;

	public static LoginServiceAsync getLoginService(){
		if(loginService == null){
			loginService = GWT.create(LoginService.class);
		}
		return loginService;
	}
	
	/**
	 * gibt den aktuelle eingeloggten User zurueck
	 * @return aktuellerUser
	 */
	public static LoginInfo getAktuellerUser() {
		return aktuellerUser;
	}

	/**
	 * setzt den aktuell eingeloggten User als Userd
	 */
	public static void setAktuellerUser(LoginInfo nutzer) {
		ClientsideSettings.aktuellerUser = nutzer;
	}


	//Sollte es keine Instanz dieser Klasse geben, so wird diese hier erzeugt.
	public static FahrtenbuchAdministrationAsync getFahrtenbuchVerwaltung(){
		
		if(fahrtenbuchVerwaltung == null){
			fahrtenbuchVerwaltung = GWT.create(FahrtenbuchAdministration.class);
		}
		
		return fahrtenbuchVerwaltung;
	}
	
	/**
	 * Anlegen und Auslesen des applikationsweit eindeutigen ReportGenerators.
	 * Diese Methode erstellt den ReportGenerator, sofern dieser noch nicht
	 * existiert. Bei wiederholtem Aufruf dieser Methode wird stets das bereits
	 * zuvor angelegte Objekt zurueckgegeben.
	 * 
	 * @return Instanz des Typs ReportGeneratorAsync
	 */
	public static ReportGeneratorAsync getReportVerwaltung() {

		if (reportVerwaltung == null) {
			reportVerwaltung = GWT.create(ReportGenerator.class);
		}
		return reportVerwaltung;

	}

}
