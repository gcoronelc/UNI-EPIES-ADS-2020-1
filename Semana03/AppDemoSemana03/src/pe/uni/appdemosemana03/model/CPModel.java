package pe.uni.appdemosemana03.model;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class CPModel {

	private int idCursoProg;
	private String idCurso;
	private String idCiclo;
	private String idProfesor;
	private int vacantes;
	private int matriculados;
	private double preCursoProg;
	private String horario;
	private int activo;

	public CPModel() {
	}

	public CPModel(int idCursoProg, String idCurso, String idCiclo, String idProfesor, int vacantes, int matriculados, double preCursoProg, String horario, int activo) {
		this.idCursoProg = idCursoProg;
		this.idCurso = idCurso;
		this.idCiclo = idCiclo;
		this.idProfesor = idProfesor;
		this.vacantes = vacantes;
		this.matriculados = matriculados;
		this.preCursoProg = preCursoProg;
		this.horario = horario;
		this.activo = activo;
	}

	public int getIdCursoProg() {
		return idCursoProg;
	}

	public void setIdCursoProg(int idCursoProg) {
		this.idCursoProg = idCursoProg;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(String idCiclo) {
		this.idCiclo = idCiclo;
	}

	public String getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public int getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}

	public double getPreCursoProg() {
		return preCursoProg;
	}

	public void setPreCursoProg(double preCursoProg) {
		this.preCursoProg = preCursoProg;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
