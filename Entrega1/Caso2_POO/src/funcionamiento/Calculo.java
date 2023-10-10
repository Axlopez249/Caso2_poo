package funcionamiento;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import extraccion_json.*;
import ui.*;

public class Calculo {
	
	private ArrayList<Provincia> provincias_lista;
	private ArrayList<ObjetoHistorico> regionNecesitada;
	private String region_entrada;
	private String provincia_entrada;
	private Hashtable<String, ArrayList<ObjetoHistorico>> historicosPorProvincia;
	private ShowResults resultados;
	
	
	public Calculo(String pprovincia_entrada, String pregion_entrada, ShowResults presultados) {
		this.provincia_entrada = pprovincia_entrada;
		this.region_entrada = pregion_entrada;
		this.resultados = presultados;
		
		
		Generador_Json generador_info = new Generador_Json();
		provincias_lista = generador_info.cargarListaProvincias();
		Historico history = new Historico(provincias_lista);
		historicosPorProvincia = history.getHistoricosPorProvincia();
		
		compararDatos();
		Pronosticador_lluvia pronosLluvia = new Pronosticador_lluvia(regionNecesitada, pprovincia_entrada, pregion_entrada, presultados);
		Pronosticador_temp pronosTemp = new Pronosticador_temp(regionNecesitada, pprovincia_entrada, pregion_entrada, presultados);
		Pronosticador_viento pronosViento = new Pronosticador_viento(regionNecesitada, pprovincia_entrada, pregion_entrada, presultados);

		

		
	}
	
	public void compararDatos() {
		
		//Aqui ya tengo una lista especifica de la region solicitada
		//
		for (Map.Entry<String, ArrayList<ObjetoHistorico>> entry : historicosPorProvincia.entrySet()) {
		    String provincia = entry.getKey();
		    ArrayList<ObjetoHistorico> histo = entry.getValue();

		    if (provincia.equals(provincia_entrada)) {
				for (ObjetoHistorico objetoHistorico : histo) {
					if (objetoHistorico.getNombre_region().equals(region_entrada)) {
						regionNecesitada.add(objetoHistorico);
					}
				}
			}
		}
		
		//Ahora falta ir sacando las semanas
		//Necesito pronosticar de forma semanal
		//Cada semana hasta la fecha que se solicita, tiene una temperatura, velocidad de viento, la lluvia
		
		//Cuando lo vaya a imprimir yo necesito una lista de informacion para imprimirla y acomodarla
		//Me ayudo de la funcion que conecta a la UI
		
		
		
	}
	
	public void conectarUI() {
		//ControllerUISalida salidaDatos = new ControllerUISalida(velViento, lluvia, temp, region, provincia, resultados);
	}

}
