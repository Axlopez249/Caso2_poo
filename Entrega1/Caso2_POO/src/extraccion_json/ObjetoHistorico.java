package extraccion_json;

import java.util.Date;

public class ObjetoHistorico {
	private String nombre_region;
	private int temp;
	private Fecha fecha;
	private int viento;
	private int lluvia;
	
	public ObjetoHistorico(String pnombre_region, int ptemp, Fecha pfecha, int pviento, int plluvia) {
		this.fecha = pfecha;
		this.lluvia = plluvia;
		this.nombre_region = pnombre_region;
		this.viento = pviento;
		this.temp = ptemp;
	}
	
	
	public String getNombre_region() {
		return nombre_region;
	}
	public int getTemp() {
		return temp;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public int getViento() {
		return viento;
	}
	public int getLluvia() {
		return lluvia;
	}
	
	
}
