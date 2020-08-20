package pe.edu.uni.appclinica.pruebas;

import java.sql.Connection;
import pe.edu.uni.appclinica.db.AccesoDB;

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
