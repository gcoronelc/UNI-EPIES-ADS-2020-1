package pe.uni.appdemosemana03.controller;

import java.util.List;
import pe.uni.appdemosemana03.model.CPModel;
import pe.uni.appdemosemana03.service.ConsultasService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class ConsultaController {

	public List<CPModel> getCursosProgramados(String ciclo) {
		ConsultasService service = new ConsultasService();
		return service.conCursosProgramados(ciclo);
	}

}
