package pe.edu.uni.appclinica.view;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Session {

	// Actua como repositorio de objetos
	private static Map<String,Object> datos;
	
	static {
		datos = new HashMap<>();
	}
	
	private Session() {
	}

	public static void put(String key, Object value){
		datos.put(key, value);
	}
	
	public static Object get( String key ){ 
		return datos.get(key);
	}
	
}
