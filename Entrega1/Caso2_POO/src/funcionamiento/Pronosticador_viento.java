package funcionamiento;

import java.util.ArrayList;

import extraccion_json.Historico;
import extraccion_json.ObjetoHistorico;
import ui.ShowResults;

public class Pronosticador_viento extends Calculo{
	
	private ArrayList<Integer> velVientos;
	private ArrayList<Integer> precipitacion;

	public Pronosticador_viento() {
		
	}
	
	public ArrayList<Integer> predecirViento() {
		ArrayList<Integer> semanaViento;
		semanaViento = predecirAtributo(velVientos, precipitacion);
		return semanaViento;
	}

	public void setVelVientos(ArrayList<Integer> velVientos) {
		this.velVientos = velVientos;
	}

	public void setPrecipitacion(ArrayList<Integer> precipitacion) {
		this.precipitacion = precipitacion;
	}
	
	

}
