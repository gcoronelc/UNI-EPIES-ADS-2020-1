package pe.uni.appdemosemana03.controller;

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
public class ConsultaController {

	private ConsultasService consultasService;

	public ConsultaController() {
		consultasService = new ConsultasService();
	}

	public List<CPModel> getCursosProgramados(String ciclo) {
		return consultasService.conCursosProgramados(ciclo);
	}

	public List<AlumnoModel> conAlumnos(String apellido, String nombre) {
		return consultasService.conAlumnos(apellido, nombre);
	}
	
}
