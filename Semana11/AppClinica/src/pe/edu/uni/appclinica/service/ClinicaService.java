package pe.edu.uni.appclinica.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.appclinica.db.AccesoDB;
import pe.edu.uni.appclinica.model.IngresoModel;
import pe.edu.uni.appclinica.model.PacienteModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ClinicaService {

	public void procRegistrarPaciente(PacienteModel model) {
		Connection cn = null;
		try {
			// Iniciar Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Registrar paciente
			String sql = "insert into dbo.PACIENTE(NOMBRE,APELLIDO,IDPERSONAL) values( ?, ?, ? )";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, model.getNombre().toUpperCase());
			pstm.setString(2, model.getApellido().toUpperCase());
			pstm.setInt(3, model.getIdpersonal());
			pstm.executeUpdate();
			// Confirmar Tx
			cn.commit();
			pstm.close();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso Registrar Paciente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}

	}

	public List<PacienteModel> traerPacientes(String nombre, String apellido) {
		List<PacienteModel> lista = new ArrayList<>();
		Connection cn = null;
		// Preparar variables
		nombre = "%" + nombre + "%";
		apellido = "%" + apellido + "%";
		// Proceso
		try {
			cn = AccesoDB.getConnection();
			String sql = "select idpaciente, nombre, apellido, idpersonal "
					  + "from dbo.paciente "
					  + "where nombre like ? "
					  + "and apellido like ? ";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, apellido);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				PacienteModel model = new PacienteModel();
				model.setIdpaciente(rs.getInt("idpaciente"));
				model.setApellido(rs.getString("apellido"));
				model.setNombre(rs.getString("nombre"));
				model.setIdpersonal(rs.getInt("idpersonal"));
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

	public void procRegistrarIngreso(IngresoModel model) {
		Connection cn = null;
		try {
			// Iniciar Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Registrar paciente
			String sql = "insert into dbo.ingreso( idpersonal, idpaciente, fecha, habitacion, glosa ) " +
							"values(?,?,convert(datetime,?,131),?,?)";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, model.getIdpersonal());
			pstm.setInt(2, model.getIdpaciente());
			pstm.setString(3, model.getFecha());
			pstm.setInt(4, model.getHabitacion());
			pstm.setString(5, model.getGlosa());
			pstm.executeUpdate();
			// Confirmar Tx
			cn.commit();
			pstm.close();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso Registrar Paciente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
	}
}
