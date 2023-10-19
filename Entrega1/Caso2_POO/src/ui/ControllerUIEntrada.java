package ui;

import java.util.Date;

import funcionamiento.*;
import extraccion_json.*;

public class ControllerUIEntrada {
	private Date fecha;
	private String provincia;
	private String region;
	
	public ControllerUIEntrada(Date pfecha, String pprovincia, String pregion, ShowResults resultados, Generador_Json generadorInfo) {
		this.fecha = pfecha;
		this.provincia = pprovincia;
		this.region = pregion;
		
		//Se crean las instancias de calculo para que hagan su trabajo
		Calculo calculo = new Calculo(provincia, region, fecha,  resultados, generadorInfo);
	}
}
