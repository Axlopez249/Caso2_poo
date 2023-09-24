package extraccion_json;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Provincia {
	private String nombre;
	private ArrayList<String> listRegiones;
	
	//constructor guarda el nombre de la provincia y un jsonarray para extraerlo
	public Provincia(String pnombre, JsonArray pregionesProvincia) {
		this.nombre = pnombre;
		
		extraer_regiones(pregionesProvincia);
	}
	
	//Toma un jsonarray donde lo recorre y lo guarda en una lista de la provincia
	public void extraer_regiones(JsonArray pregionesProvincia) {
		for (JsonValue regi : pregionesProvincia) {
            listRegiones.add(regi.toString());
        }
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<String> getListRegiones() {
		return listRegiones;
	}
	
	
}
