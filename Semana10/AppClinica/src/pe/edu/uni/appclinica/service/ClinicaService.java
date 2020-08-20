package pe.edu.uni.appclinica.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.edu.uni.appclinica.db.AccesoDB;
import pe.edu.uni.appclinica.model.PacienteModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ClinicaService {
	
	
	public void procRegistrarPaciente(PacienteModel model){
		Connection cn = null;
		try {
			// Iniciar Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Registrar paciente
			String sql = "insert into dbo.PACIENTE(NOMBRE,APELLIDO,IDPERSONAL) values( ?, ?, ? )";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, model.getNombre());
			pstm.setString(2, model.getApellido());
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
	

}
