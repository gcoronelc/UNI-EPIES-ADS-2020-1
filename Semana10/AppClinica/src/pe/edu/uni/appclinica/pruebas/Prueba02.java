package pe.edu.uni.appclinica.pruebas;

import pe.edu.uni.appclinica.model.PersonalModel;
import pe.edu.uni.appclinica.service.LogonService;


/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class Prueba02 {
	
	public static void main(String[] args) {
		try {
			// Datos
			String usuario = "jtorres";
			String clave = "123456";
			// Proceso
			LogonService service = new LogonService();
			PersonalModel model = service.validarUsuario(usuario, clave);
			// Reporte
			System.out.println("Hola: " + model.getNombre());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
