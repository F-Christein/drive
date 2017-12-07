package de.hdm.Fahrtenbuch.server.report;

import java.io.Serializable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.Fahrtenbuch.server.FahrtenbuchAdministrationImpl;
import de.hdm.Fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.Fahrtenbuch.shared.ReportGenerator;
import de.hdm.Fahrtenbuch.shared.report.CompositeParagraph;
import de.hdm.Fahrtenbuch.shared.report.Report;
import de.hdm.Fahrtenbuch.shared.report.SimpleParagraph;

public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private FahrtenbuchAdministration fahrtenbuchAdministration = null;
	
	public ReportGeneratorImpl() throws IllegalArgumentException{
		
	}
	
	public void init() throws IllegalArgumentException{
		FahrtenbuchAdministrationImpl f = new FahrtenbuchAdministrationImpl();
		f.init();
		this.fahrtenbuchAdministration = f;
	}
	
	protected FahrtenbuchAdministration getFahrtenbuchAdministration(){
		return this.fahrtenbuchAdministration;
	}
	
	/**
	 * Die Methode soll dem Report ein Impressum hinzufuegen. Dazu wird
	 * zunaechst ein neuer CompositeParagraph angelegt, da das Impressum
	 * mehrzeilig sein soll. Danach werden belibige SimpleParagraph dem
	 * CompositeParagraph hinzugefuegt. Zum Schluss wird CompositeParagraph dem
	 * Report hinzugefuegt ueber setImprint.
	 * 
	 * @param r
	 *            der um das Impressum zu erweiternde Report.
	 */
	protected void addImprint(Report r) {

		// Das Impressum kann aus mehreren Zeilen bestehen
		CompositeParagraph imprint = new CompositeParagraph();

		// 1.Zeile:
		imprint.addSubParagraph(new SimpleParagraph("Fahrtenbuch"));

		// weitere Zeilen kï¿½nnen ergï¿½nzt wrden

		// Das eigentliche Hinzufuegen des Impressums zum Report
		r.setImprint(imprint);
	}
	
	
	//TODO Report-Methoden ergänzen
	

}
