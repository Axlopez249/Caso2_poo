package extraccion_json;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Historico {
	
	private ArrayList<Provincia> provincias;

	private Hashtable<String, ArrayList<ObjetoHistorico>> historicosPorProvincia;
	
	public Historico(ArrayList<Provincia> pprovincias) {
		
		this.provincias = pprovincias;
		
		historicosPorProvincia= new Hashtable<>();

		
		//llamo la funcion para generar los historicos
		generarHistorico();
	}
	
	public void generarHistorico() {
	    // Obtener las fechas desde un año atrás hasta la fecha actual
	    Calendar calendario = Calendar.getInstance();
	    calendario.set(2015, Calendar.JANUARY, 1); // Restar un año
	    

	    // Iterar a través de las provincias
	    for (Provincia provincia : provincias) {
	        String nombreProvincia = provincia.getNombre();
	        ArrayList<String> regionesProvincia = provincia.getListRegiones();
	        ArrayList<ObjetoHistorico> historicoProvincia = new ArrayList<>();

	        // Viene el bucle para crear todo un historico por region
	        while (calendario.getTime().before(new Date())) {
	            Date fecha = calendario.getTime();

                for (Region region : provincia.getRegiones()) {
                    
                    // Creacion del random
                    Random random = new Random();

                    // Creacion de los valores aleatorios dentro de un rango
                    int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
                    int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
                    int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min();

                    // Se crea el objeto historico y se agrega a la lista correspondiente
                    ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
                    historicoProvincia.add(dato);
                    
                }
	            

	            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
	        }

	        // Agregar el historico de la provincia al Hashtable
	        historicosPorProvincia.put(nombreProvincia, historicoProvincia);
	    }

	    // Ahora tienes historicosPorProvincia que contiene los datos históricos de cada provincia en un Hashtable.
	}

	public Hashtable<String, ArrayList<ObjetoHistorico>> getHistoricosPorProvincia() {
		return historicosPorProvincia;
	}
	
}
