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
	
	public Region(String pnombre, int ptempmin, int ptempmax, int pvimin, int pvimax, int pllmin, int pllmax) {
		this.nombre = pnombre;
		this.max_lluvia = pllmax;
		this.min_lluvia = pllmin;
		this.temp_max = ptempmax;
		this.temp_min = ptempmin;
		this.vel_max = pvimax;
		this.vel_min = pvimin;
	}
	


	public String getNombre() {
		return nombre;
	}

	public int getTemp_min() {
		return temp_min;
	}

	public int getTemp_max() {
		return temp_max;
	}

	public int getVel_min() {
		return vel_min;
	}

	public int getVel_max() {
		return vel_max;
	}

	public int getMin_lluvia() {
		return min_lluvia;
	}

	public int getMax_lluvia() {
		return max_lluvia;
	}
	
}
