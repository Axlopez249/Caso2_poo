package extraccion_json;
import java.util.ArrayList;

import funcionamiento.*;

public class Main {
	
	/*
	 * Contrato 
	 * Se le solicita al usuario que ingrese una región y una fecha válida: El programa empieza 
	 * mostrando una UI que coleccione una fecha y una región. Se realizarán los movimientos necesarios 
	 * para concretar formatos de fecha válidos
	 * Por dentro del programa, se tomarán datos históricos de regiones y sus tiempos y climas provenientes 
	 * de fuentes seguras. El programa toma datos o archivos json con la información y realiza una integración de los datos
	 * Posteriormente, hace una búsqueda de la información solicitada con la que se tiene y se conecta con la UI del sistema
	 * Finalmente, se mostrarán los datos a los usuarios por medio del traspaso de datos. En la pantalla se mostrará la información solicitada por el usuario respecto al pronostico de lluvia del día 
	 * o informacion general del clima de ese día en específico con esa region
	 * 
	 * es un sistema de consulta únicamente, como decis, region y fecha, para hacer un pronóstico
	 * dado que se ocupan muchos datos, podemos darle parámetros al json para que el programa auto 
	 * genere los datos, salvo que tengas otra fuente para los datos
	 *
	 *Estrategia B del preliminar 2 
	 */

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
