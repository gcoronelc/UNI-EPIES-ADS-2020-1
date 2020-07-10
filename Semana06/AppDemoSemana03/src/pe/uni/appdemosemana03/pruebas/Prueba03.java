package pe.uni.appdemosemana03.pruebas;

import java.util.List;
import pe.uni.appdemosemana03.model.AlumnoModel;
import pe.uni.appdemosemana03.model.CPModel;
import pe.uni.appdemosemana03.service.ConsultasService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class Prueba03 {
	
	public static void main(String[] args) {
		try {
			// Datos
			String apellido = "ar";
			String nombre = "";
			// Proceso
			ConsultasService service = new ConsultasService();
			List<AlumnoModel> lista = service.conAlumnos(apellido, nombre);
			// Reporte
			for (AlumnoModel model : lista) {
				System.out.println(model.getIdalumno() + " - " + model.getApellido() + " - " + model.getNombre());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
