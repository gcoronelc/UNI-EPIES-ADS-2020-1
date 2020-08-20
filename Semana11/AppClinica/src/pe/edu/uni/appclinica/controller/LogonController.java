package pe.edu.uni.appclinica.controller;

import pe.edu.uni.appclinica.model.PersonalModel;
import pe.edu.uni.appclinica.service.LogonService;
import pe.edu.uni.appclinica.view.Session;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class LogonController {

	public void validar(String usuario, String clave) {
		LogonService service = new LogonService();
		PersonalModel model = service.validarUsuario(usuario, clave);
		Session.put("USUARIO", model);
	}

}
