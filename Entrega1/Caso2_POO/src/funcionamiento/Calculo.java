package funcionamiento;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import extraccion_json.*;
import ui.*;

public class Calculo {
	
	private ArrayList<Provincia> provincias_lista;
	private ArrayList<ObjetoHistorico> regionNecesitada = new ArrayList<>();
	private String region_entrada;
	private String provincia_entrada;
	private Date fechaSolicitada;
	private Hashtable<String, ArrayList<ObjetoHistorico>> historicosPorProvincia;
	private ShowResults resultados;
	
	
	//Listas de los valores de cada region
	private ArrayList<Integer> velViento = new ArrayList<>();
	private ArrayList<Integer> temperatura = new ArrayList<>();
	private ArrayList<Integer> precipitacion = new ArrayList<>();
	
	//Historico para estarle actualizando la informacion y utilizarla para las predicciones
	
	private Historico history;
	private Generador_Json generador;
	

    // Obtener la fecha actual como un objeto Date
	private Calendar calendario = Calendar.getInstance();
    private Date fechaActual = calendario.getTime();
    private int cantSemanas;
    
    //Clases hijas
    private Pronosticador_lluvia pronosLluvia;
    private Pronosticador_temp pronosTemp;
    private Pronosticador_viento pronosViento;
	
    public Calculo() {
		//constructor vacio para las clases hijas
	}
	
	public Calculo(String pprovincia_entrada, String pregion_entrada, Date fechaActual, ShowResults presultados, Generador_Json generadorInfo) {
		this.provincia_entrada = pprovincia_entrada;
		this.region_entrada = pregion_entrada;
		this.resultados = presultados;
		this.fechaSolicitada = fechaActual;
		generador = generadorInfo;
		history = new Historico(generador.cargarListaProvincias());
		historicosPorProvincia = history.getHistoricosPorProvincia();
		
		//Para actualizar las listas y comenzar a trabajar
		actualizarListas();
		
		pronosLluvia = new Pronosticador_lluvia();
		pronosTemp = new Pronosticador_temp();
		pronosViento = new Pronosticador_viento();
		
		//Para iniciar el ciclo de prediccion hasta la fecha solicitada
		crearInstancias();
		
	}
	
	
	
	
	public void actualizarListas() {
		
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
		
		//Llenar las listas con los valores especificos por separado
		for (ObjetoHistorico objeto : regionNecesitada) {
			temperatura.add(objeto.getTemp());
			velViento.add(objeto.getViento());
			precipitacion.add(objeto.getLluvia());
		}
		
		
		//System.out.println("Tamano de region necesitada" + regionNecesitada.size());
		
	}
	
	
	
	public ArrayList<Integer> predecirAtributo(ArrayList<Integer> atributoPrincipal, ArrayList<Integer> atributoSecundario) {
		RegresionLinealSimple modeloAtributo = new RegresionLinealSimple();
		modeloAtributo.ajustarModelo(atributoPrincipal, atributoSecundario);  // valores serían los valores correspondientes al atributo
        
     // Realizar predicciones para los próximos 7 días
        ArrayList<Integer> pronosticoSemana = new ArrayList<>();
        
        for (int i = 0; i < 7; i++) {
            double prediccionAtributo = modeloAtributo.predecir(atributoPrincipal.get(i));
            //pasar valores a enteros
            int prediccionAtributo_ = (int) prediccionAtributo;
            
            pronosticoSemana.add(prediccionAtributo_);
        }
        
        return pronosticoSemana;
	}
	

	public void crearInstancias() {
		
		ArrayList<ArrayList<ObjetoHistorico>> infoMostrar = new ArrayList<>();

        while (fechaActual.getTime() <= fechaSolicitada.getTime()) {
			
        	//Esto ocurre semanalmente en este caso solo para la lluvia
        	pronosLluvia.setPrecipitaciones(precipitacion);
			pronosLluvia.setTemperaturas(temperatura);
			
			//Temperatura
			pronosTemp.setTemperaturas(temperatura);
			pronosTemp.setVelViento(velViento);
			
			//Velocidad viento
			pronosViento.setVelVientos(velViento);
			pronosViento.setPrecipitacion(precipitacion);
			
			//Ahora predecimos
			//en estas listas lo que se encuentra es el pronostico de 7 dias de cada atributo
			ArrayList<Integer> lluvia = pronosLluvia.predecirLluvia();
			ArrayList<Integer> temperatura = pronosTemp.predecirTemp();
			ArrayList<Integer> viento = pronosViento.predecirViento();
			
			//Lista para ser mostrada por semana
			//Esta lista se creo para ser guardada en otra lista y poder mostrar la informacion de tal manera
			ArrayList<ObjetoHistorico> semana = new ArrayList<>();
			//Ahora creamos los objetos de tipo objeto historico para luego actualizar las listas
			for (int i = 0; i < 7; i++) {
				//Se crea el objeto para ser actualizado en el historico
				ObjetoHistorico objeto = new ObjetoHistorico(region_entrada, temperatura.get(i), fechaActual, viento.get(i), lluvia.get(i)); 
				
				//Aqui se extrae la lista donde van las regiones de la provincia en la que se esta trabajando para actualizarla
				ArrayList<ObjetoHistorico> listRegion = historicosPorProvincia.get(provincia_entrada);
				listRegion.add(objeto);
				semana.add(objeto);
				
				//Se llama a conectarUI para ser imprimido en 9
				//se le agrega un dia a la fecha actual
				calendario.add(Calendar.DAY_OF_YEAR, 1);
		        fechaActual = calendario.getTime();
			}
			infoMostrar.add(semana);
			actualizarListas();
		}
        
        conectarUI(infoMostrar);
        
	}

	public void conectarUI(ArrayList<ArrayList<ObjetoHistorico>> pMuestra) {
		ControllerUISalida salidaDatos = new ControllerUISalida(pMuestra, resultados, provincia_entrada);
	}

}
