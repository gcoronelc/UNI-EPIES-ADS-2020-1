package pe.uni.appdemosemana03.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.uni.appdemosemana03.db.AccesoDB;
import pe.uni.appdemosemana03.model.AlumnoModel;
import pe.uni.appdemosemana03.model.CPModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class ConsultasService {

	public List<CPModel> conCursosProgramados(String ciclo) {
		List<CPModel> lista = new ArrayList<>();
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select cp.IdCursoProg, cp.IdCiclo, cp.IdCurso, cp.IdProfesor,"
					  + "cp.Matriculados, cp.Vacantes, cp.PreCursoProg, cp.Horario, "
					  + "cp.Activo, c.NomCurso nomCurso "
					  + "from dbo.Curso c "
					  + "join dbo.CursoProgramado cp "
					  + "on c.IdCurso = cp.IdCurso "
					  + "where IdCiclo = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, ciclo);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				CPModel model = new CPModel();
				model.setIdCursoProg(rs.getInt("idcursoprog"));
				model.setIdCurso(rs.getString("idcurso"));
				model.setCurso(rs.getString("nomCurso"));
				model.setIdCiclo(rs.getString("idciclo"));
				model.setIdProfesor(rs.getString("idprofesor"));
				model.setVacantes(rs.getInt("vacantes"));
				model.setMatriculados(rs.getInt("matriculados"));
				model.setPreCursoProg(rs.getDouble("precursoprog"));
				model.setHorario(rs.getString("horario"));
				model.setActivo(rs.getInt("activo"));
				lista.add(model);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso. " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	public List<AlumnoModel> conAlumnos(String apellido, String nombre) {
		List<AlumnoModel> lista = new ArrayList<>();
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select IdAlumno, ApeAlumno, NomAlumno, "
					  + "DirAlumno, TelAlumno, EmailAlumno "
					  + "from dbo.alumno "
					  + "where apealumno like ? "
					  + "and nomalumno like ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			apellido = "%" + apellido + "%";
			nombre = "%" + nombre + "%";
			pstm.setString(1, apellido);
			pstm.setString(2, nombre);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				AlumnoModel model = new AlumnoModel();
				model.setIdalumno(rs.getString("IdAlumno"));
				model.setApellido(rs.getString("ApeAlumno"));
				model.setNombre(rs.getString("NomAlumno"));
				model.setDireccion(rs.getString("DirAlumno"));
				model.setTelefono(rs.getString("TelAlumno"));
				model.setEmail(rs.getString("EmailAlumno"));
				model.setClave("******");
				lista.add(model);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso. " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

}
