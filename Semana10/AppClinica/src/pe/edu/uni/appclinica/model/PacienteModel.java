package pe.edu.uni.appclinica.model;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class PacienteModel {

	private int idpaciente;
	private String nombre;
	private String apellido;
	private int idpersonal;

	public PacienteModel() {
	}

	public PacienteModel(int idpaciente, String nombre, String apellido, int idpersonal) {
		this.idpaciente = idpaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idpersonal = idpersonal;
	}

	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}

}
