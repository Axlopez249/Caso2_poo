package ui;

import funcionamiento.*;

public class ControllerUIEntrada {
	private String fecha;
	private String provincia;
	private String region;
	
	public ControllerUIEntrada(String pfecha, String pprovincia, String pregion) {
		this.fecha = pfecha;
		this.provincia = pprovincia;
		this.region = pregion;
		
		//Se crean las instancias de calculo para que hagan su trabajo
		Calculo calculo = new Calculo(provincia, region);
	}
}
