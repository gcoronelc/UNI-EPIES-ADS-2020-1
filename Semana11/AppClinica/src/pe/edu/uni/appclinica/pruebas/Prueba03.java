package pe.edu.uni.appclinica.pruebas;

import pe.edu.uni.appclinica.model.PacienteModel;
import pe.edu.uni.appclinica.service.ClinicaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba03 {

	public static void main(String[] args) {
		try {
			// Datos
			PacienteModel model = new PacienteModel();
			model.setNombre("TEOFILO");
			model.setApellido("SEGAMA");
			model.setIdpersonal(1);
			// Proceso
			ClinicaService service = new ClinicaService();
			service.procRegistrarPaciente(model);
			// Reporte
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
