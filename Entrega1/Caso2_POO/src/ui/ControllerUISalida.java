package ui;

import java.util.ArrayList;

import extraccion_json.ObjetoHistorico;

public class ControllerUISalida {
	
	public ControllerUISalida(ArrayList<ArrayList<ObjetoHistorico>> informacion, ShowResults resultado, String pprovincia) {
		conectarUI(resultado, informacion, pprovincia);
	}
	
	public void conectarUI(ShowResults presultado, ArrayList<ArrayList<ObjetoHistorico>> pinformacion, String provincia) {
		presultado.setVisible(true);
		
		for (ArrayList<ObjetoHistorico> arrayList : pinformacion) {
			for (ObjetoHistorico arrayList2 : arrayList) {
				String viento = String.valueOf(arrayList2.getViento());
				String temp = String.valueOf(arrayList2.getTemp());
				String lluvia = String.valueOf(arrayList2.getLluvia());
				
				presultado.llenarTable(arrayList2.getFecha(), arrayList2.getNombre_region(), viento, temp, lluvia, provincia);
			}
		}
		
		
		
		//Aqui se van acomodando los datos que se van mostrando
		//se debe de tener cuidado porque los datos se van tirando para abajo
		//se puede seguir el ejemplo de patio
	}
}
