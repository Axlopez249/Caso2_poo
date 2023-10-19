package funcionamiento;

import java.util.ArrayList;

import extraccion_json.Historico;
import extraccion_json.ObjetoHistorico;
import ui.ShowResults;

public class Pronosticador_temp extends Calculo{
	
	private ArrayList<Integer> temperaturas;
	private ArrayList<Integer> velViento;

	public Pronosticador_temp() {
		
	}
	
	public ArrayList<Integer> predecirTemp() {
		ArrayList<Integer> semanaTemp;
		semanaTemp = predecirAtributo(temperaturas, velViento);
		return semanaTemp;
	}

	public void setTemperaturas(ArrayList<Integer> temperaturas) {
		this.temperaturas = temperaturas;
	}

	public void setVelViento(ArrayList<Integer> velViento) {
		this.velViento = velViento;
	}
	
	
	

}
