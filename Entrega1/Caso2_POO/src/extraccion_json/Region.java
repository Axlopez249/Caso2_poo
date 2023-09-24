package extraccion_json;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Region {
	private String nombre;
	private int temp_min;
	private int temp_max;
	private int vel_min;
	private int vel_max;
	private int min_lluvia;
	private int max_lluvia;
	
	public Region(String pnombre, JsonObject ptemp, JsonObject pvelocidadViento, JsonObject plluvia) {
		this.nombre = pnombre;
		
		extraer_dator(ptemp, pvelocidadViento, plluvia);
	}
	
	public void extraer_dator(JsonObject temperatura, JsonObject viento, JsonObject lluvia) {
		this.temp_min = temperatura.getInt("min");
		this.temp_max = temperatura.getInt("max");
		
		this.vel_min = viento.getInt("min");
		this.vel_max = viento.getInt("max");
		
		this.min_lluvia = lluvia.getInt("min");
		this.max_lluvia = lluvia.getInt("max");
		
	}
	
}
