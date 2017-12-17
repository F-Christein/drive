package de.hdm.Fahrtenbuch.shared.bo;

import java.util.Date;

public class Nutzer extends BusinessObject {

	private static final long serialVersionUID = 1L;

	private int profilId;
	private String google_id;
	private String name;
	private boolean status = false;
	private Date erstelldatum;

	public int getProfilId() {
		return profilId;
	}

	public void setProfilId(int profilId) {
		this.profilId = profilId;
	}

	public Date getErstelldatum() {
		return erstelldatum;
	}

	public void setErstelldatum(Date erstelldatum) {
		this.erstelldatum = erstelldatum;
	}

	public String getGoogleId() {
		return google_id;
	}

	public void setGoogleId(String google_id) {
		this.google_id = google_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
