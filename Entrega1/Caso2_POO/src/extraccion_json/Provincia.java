package extraccion_json;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Provincia {
	private String nombre;
	private ArrayList<String> listRegiones;
	private ArrayList<Region> regiones;
	
	//constructor guarda el nombre de la provincia y un jsonarray para extraerlo

	public Provincia(String pnombre, ArrayList<String> plistRegiones, ArrayList<Region> pregiones) {
		this.nombre = pnombre;
		this.listRegiones = plistRegiones;
		this.regiones = pregiones;
	}
	
	public ArrayList<String> getListRegiones(){
		return listRegiones;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Region> getRegiones() {
		return regiones;
	}
	
	
	
	
}
