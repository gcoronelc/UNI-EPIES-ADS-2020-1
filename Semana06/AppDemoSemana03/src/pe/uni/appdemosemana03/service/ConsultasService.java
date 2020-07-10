package pe.uni.appdemosemana03.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.uni.appdemosemana03.db.AccesoDB;
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
			String sql = "select * from dbo.CursoProgramado "
							+ "where IdCiclo = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, ciclo);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				CPModel model = new CPModel();
				model.setIdCursoProg(rs.getInt("idcursoprog"));
				model.setIdCurso(rs.getString("idcurso"));
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

}
