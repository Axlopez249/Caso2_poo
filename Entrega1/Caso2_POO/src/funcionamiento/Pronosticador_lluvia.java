package funcionamiento;

import ui.*;
import java.util.ArrayList;
import extraccion_json.*;

public class Pronosticador_lluvia extends Calculo{
	
	private ArrayList<Integer> precipitaciones;
	private ArrayList<Integer> temperaturas;

	public Pronosticador_lluvia() {
		
	}
	
	public ArrayList<Integer> predecirLluvia() {
		ArrayList<Integer> semanaLluvia;
		semanaLluvia = predecirAtributo(precipitaciones, temperaturas);
		return semanaLluvia;
	}

	public void setPrecipitaciones(ArrayList<Integer> precipitaciones) {
		this.precipitaciones = precipitaciones;
	}

	public void setTemperaturas(ArrayList<Integer> temperaturas) {
		this.temperaturas = temperaturas;
	}
	
	

}
