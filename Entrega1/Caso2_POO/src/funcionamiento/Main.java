package funcionamiento;

import ui.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import extraccion_json.*;


public class Main {

	public static void main(String[] args) {
		
		Generador_Json generadorInfo = new Generador_Json();
		Historico his = new Historico(generadorInfo.cargarListaProvincias());
		RecolectionData ventanaInicial = new RecolectionData(generadorInfo);
		ventanaInicial.setVisible(true);
		
		
		ArrayList<Provincia> prueba = generadorInfo.cargarListaProvincias();
		 
		


		
		

	}

}
