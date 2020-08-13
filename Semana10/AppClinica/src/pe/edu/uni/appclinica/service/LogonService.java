package pe.edu.uni.appclinica.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.edu.uni.appclinica.db.AccesoDB;
import pe.edu.uni.appclinica.model.PersonalModel;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class LogonService {

	public PersonalModel validarUsuario(String usuario, String clave) {
		PersonalModel personalModel = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select idpersonal, apellido, nombre, tipo, usuario "
					  + "from dbo.personal "
					  + "where usuario = ? and clave = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				personalModel = new PersonalModel();
				personalModel.setIdpersonal(rs.getInt("idpersonal"));
				personalModel.setApellido(rs.getString("apellido"));
				personalModel.setNombre(rs.getString("nombre"));
				personalModel.setTipo(rs.getString("tipo"));
				personalModel.setUsuario(rs.getString("usuario"));
				personalModel.setClave("******");
			}
			rs.close();
			pstm.close();
			if( personalModel == null ){
				throw new Exception("Datos no son correctos.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso. " + e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return personalModel;
	}

}
