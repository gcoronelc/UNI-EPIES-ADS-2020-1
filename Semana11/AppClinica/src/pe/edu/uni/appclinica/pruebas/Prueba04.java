package pe.edu.uni.appclinica.pruebas;

import java.util.List;
import pe.edu.uni.appclinica.model.PacienteModel;
import pe.edu.uni.appclinica.service.ClinicaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba04 {

	public static void main(String[] args) {
		try {
			// Datos
			String nombre = "a";
			String apellido = "or";
			// Proceso
			ClinicaService service = new ClinicaService();
			List<PacienteModel> lista = service.traerPacientes(nombre, apellido);
			// Reporte
			for (PacienteModel model : lista) {
				System.out.println(model.getIdpaciente() + " - " + model.getNombre() 
				+ " - " + model.getApellido());
			}
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
