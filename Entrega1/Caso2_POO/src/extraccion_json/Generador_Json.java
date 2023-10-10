package extraccion_json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class Generador_Json {

	private JsonArray jsonProvincias;
	private JsonObject jsonRegiones;
	
	public Generador_Json() {
		loadJson();
	}

	public ArrayList<Provincia> cargarListaProvincias() {
	    ArrayList<Provincia> result = new ArrayList<Provincia>();

	    for (JsonValue provin : jsonProvincias) {
	        JsonObject objeto_provincia = (JsonObject) provin;
	        ArrayList<String> regiones = new ArrayList<String>(); // Nueva lista para cada provincia
	        
	        ArrayList<Region> listRegiones = new ArrayList<Region>();
	        
	        
	        JsonArray regionesJson = objeto_provincia.getJsonArray("Regiones");
	        
	        for (JsonValue ele : regionesJson) {
	        	String elemento_region = ele.toString().substring(1, ele.toString().length() - 1);
	            regiones.add(elemento_region);
	            
	            //region es un string, cada uno de ellos es una region que pertenece a la provincia
	            //se recorre la vara preguntando por region
	            
	            //----------------------------------------------------------------------------------------------
	            //Obtener las propiedades del objeto jsonRegiones (que representan las regiones)
	            ArrayList<String> regionNames = new ArrayList<>(jsonRegiones.keySet());

	            for (String regionName : regionNames){
	            	if (elemento_region.equals(regionName)) {
	            		JsonObject regionJson = jsonRegiones.getJsonObject(elemento_region);

		                //Obtener los objetos temp, viento y lluvia de la región actual
		                JsonObject temp = regionJson.getJsonObject("temp");
		                JsonObject viento = regionJson.getJsonObject("velocidad_viento");
		                JsonObject lluvia = regionJson.getJsonObject("lluvia");

		                //Obtener los valores de temperatura, velocidad del viento y lluvia para la región actual
		                int tempMin = temp.getInt("min");
		                int tempMax = temp.getInt("max");
		                int vientoMin = viento.getInt("min");
		                int vientoMax = viento.getInt("max");
		                int lluviaMin = lluvia.getInt("min");
		                int lluviaMax = lluvia.getInt("max");

		                //Crear un objeto Region con los valores obtenidos y agregarlo a la lista de regiones
		                Region region = new Region(regionName, tempMin, tempMax, vientoMin, vientoMax, lluviaMin, lluviaMax);
		                listRegiones.add(region);
		                
					}
	            	
	            }
	            
	            
	            //----------------------------------------------------------------------------------------------   
	        }

	        Provincia provincia = new Provincia(objeto_provincia.getString("nombre"), regiones, listRegiones);
	        result.add(provincia);
	    }

	    return result;
	}	
	
	/*public ArrayList<Region> cargarListaRegion() {
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
	}*/
	
	private void loadJson() {
		String pathtofile = "C:\\Users\\Axel\\Documents\\C2_poo\\Entrega1\\Caso2_POO\\src\\extraccion_json\\JSON.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            JsonObject jsonparser = reader.readObject();
            
            jsonProvincias = jsonparser.getJsonArray("provincias_regiones");
            jsonRegiones = jsonparser.getJsonObject("caracteristicas_regiones");
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
}







