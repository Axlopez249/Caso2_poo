package extraccion_json;

import java.io.FileReader;
import java.util.ArrayList;



import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class Generador_Json {

	private JsonArray jsonProvincias;
	private JsonArray jsonRegiones;
	
	public Generador_Json() {
		loadJson();
	}

	public ArrayList<Provincia> cargarListaProvincias() {
	    ArrayList<Provincia> result = new ArrayList<Provincia>();

	    for (JsonValue provin : jsonProvincias) {
	        JsonObject objeto_provincia = (JsonObject) provin;
	        ArrayList<String> regiones = new ArrayList<String>(); // Nueva lista para cada provincia

	        JsonArray regionesJson = objeto_provincia.getJsonArray("Regiones");
	        for (JsonValue ele : regionesJson) {
	            regiones.add(ele.toString());
	            
	        }

	        Provincia provincia = new Provincia(objeto_provincia.getString("nombre"), regiones);
	        result.add(provincia);
	    }

	    return result;
	}	
	
	public ArrayList<Region> cargarListaRegion() {
		ArrayList<Region> result = new ArrayList<Region>();
		
        for (JsonValue regi : jsonRegiones) {
            JsonObject objeto_region = (JsonObject) regi;
            
            JsonObject temp = objeto_region.getJsonObject("temp");
            JsonObject viento = objeto_region.getJsonObject("velocidad_viento");
            JsonObject lluvia = objeto_region.getJsonObject("lluvia");
            
            Region region = new Region(objeto_region.getString("nombre"), temp.getInt("min"), temp.getInt("max"), viento.getInt("min"), viento.getInt("max"),
            		lluvia.getInt("min"), lluvia.getInt("max"));
            result.add(region);
        }
        return result;
	}
	
	private void loadJson() {
		String pathtofile = "C:\\Users\\Axel\\Documents\\C2_poo\\Entrega1\\Caso2_POO\\src\\extraccion_json\\JSON.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            JsonObject jsonparser = reader.readObject();
            
            jsonProvincias = jsonparser.getJsonArray("provincias_regiones");
            jsonRegiones = jsonparser.getJsonArray("caracteristicas_regiones");
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
}







