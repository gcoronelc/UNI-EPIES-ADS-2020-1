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
public class Prueba04 {
	
	public static void main(String[] args) {
		try {
			// Datos
			String ciclo = "2019-01";
			// Proceso
			ConsultasService service = new ConsultasService();
			List<CPModel> lista = service.conCursosProgramados(ciclo);
			// Reporte
			for (CPModel model : lista) {
				System.out.println(model.getIdCurso() + " - " + model.getCurso());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
