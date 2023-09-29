package extraccion_json;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Provincia {
	private String nombre;
	private ArrayList<String> listRegiones;
	
	//constructor guarda el nombre de la provincia y un jsonarray para extraerlo

	public Provincia(String pnombre, ArrayList<String> plistRegiones) {
		this.nombre = pnombre;
		
		this.listRegiones = plistRegiones;
	}
	
	public ArrayList<String> getListRegiones(){
		return listRegiones;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
