package pe.edu.uni.appclinica.pruebas;

import pe.edu.uni.appclinica.model.IngresoModel;
import pe.edu.uni.appclinica.model.PacienteModel;
import pe.edu.uni.appclinica.service.ClinicaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba06 {

	public static void main(String[] args) {
		try {
			// Datos
			IngresoModel model = new IngresoModel();
			model.setIdpersonal(2);
			model.setIdpaciente(5);
			model.setFecha("23/08/2020 10:30");
			model.setHabitacion(60);
			model.setGlosa("Requiere examenes de prostata.");
			// Proceso
			ClinicaService service = new ClinicaService();
			service.procRegistrarIngreso(model);
			// Reporte
			System.out.println("Proceso ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
