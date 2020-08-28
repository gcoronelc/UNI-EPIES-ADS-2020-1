package pe.edu.uni.appclinica.pruebas;

import pe.edu.uni.appclinica.model.PacienteModel;
import pe.edu.uni.appclinica.view.BuscarPacienteView;
import pe.edu.uni.appclinica.view.Session;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba05 {

	public static void main(String[] args) {
		try {
			Session.put("PACIENTE", null);
			BuscarPacienteView view = new BuscarPacienteView(null, true);
			view.setVisible(true);
			if( Session.get("PACIENTE") == null ){
				return;
			}
			PacienteModel model;
			model = (PacienteModel) Session.get("PACIENTE");
			System.out.println("Hola: " + model.getNombre());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
