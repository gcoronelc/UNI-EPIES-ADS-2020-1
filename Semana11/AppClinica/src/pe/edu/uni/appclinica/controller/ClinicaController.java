package pe.edu.uni.appclinica.controller;

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
public class ClinicaController {
	
	private ClinicaService clinicaService;

	public ClinicaController() {
		clinicaService = new ClinicaService();
	}
	
	
	public void registrarPaciente(PacienteModel pacienteModel) {
		clinicaService.procRegistrarPaciente(pacienteModel);
	}

	public List<PacienteModel> traerPacientes(String nombre, String apellido){
		return clinicaService.traerPacientes(nombre, apellido);
	}
	
}
