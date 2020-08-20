package pe.edu.uni.appclinica.model;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class PersonalModel {

	private int idpersonal;
	private String nombre;
	private String apellido;
	private String tipo;
	private String usuario;
	private String clave;

	public PersonalModel() {
	}

	public PersonalModel(int idpersonal, String nombre, String apellido, String tipo, String usuario, String clave) {
		this.idpersonal = idpersonal;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.usuario = usuario;
		this.clave = clave;
	}

	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
