package pe.uni.appdemosemana03.pruebas;

import java.sql.Connection;
import pe.uni.appdemosemana03.db.AccesoDB;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 */
public class Prueba01 {
	
	public static void main(String[] args) {
		try {
			Connection cn = AccesoDB.getConnection();
			System.out.println("Conexión OK.");
			cn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
