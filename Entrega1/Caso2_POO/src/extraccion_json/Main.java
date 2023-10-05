package extraccion_json;
import java.util.ArrayList;

import funcionamiento.*;

public class Main {

	public static void main(String[]args) {
		Generador_Json g = new Generador_Json();
		ArrayList<Provincia> provincias = g.cargarListaProvincias();
		ArrayList<Region> regiones = g.cargarListaRegion();

		Historico historico = new Historico(provincias, regiones);
		ArrayList<ObjetoHistorico> heredia = historico.getHeredia();
		
		
		for (ObjetoHistorico objeto : heredia) {
			if (objeto.getNombre_region().equals("Santo Domingo")) {
				
				System.out.println("Año: " + objeto.getFecha().getAño() + " Mes: " + objeto.getFecha().getMes() + " Dia: " + objeto.getFecha().getDia() + "    Lluvia: " + objeto.getLluvia());
			}
			
		}
		
		//impresion
		/*for(Provincia elemento: provincias) {
			System.out.println("Nombre de la provincia: " + elemento.getNombre());
			System.out.println("Regiones");
			for(String region: elemento.getListRegiones()) {
				System.out.println(region);
			}
		}*/
		
		/*for(Region elemento: regiones) {
			System.out.println("Nombre de la region " + elemento.getNombre());
			System.out.println(elemento.getMax_lluvia());
			System.out.println(elemento.getMin_lluvia());
			System.out.println(elemento.getTemp_max());
			System.out.println(elemento.getTemp_min());
			System.out.println(elemento.getVel_max());
			System.out.println(elemento.getVel_min());
		}*/
		
		
		
		
		
	}

}
