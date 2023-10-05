package extraccion_json;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Historico {
	
	private ArrayList<Provincia> provincias;
	private ArrayList<Region> regiones;
	
	private ArrayList<ObjetoHistorico> sanjose;
	private ArrayList<ObjetoHistorico> puntarenas;
	private ArrayList<ObjetoHistorico> limon;
	private ArrayList<ObjetoHistorico> cartago;
	private ArrayList<ObjetoHistorico> guanacaste;
	private ArrayList<ObjetoHistorico> alajuela;
	private ArrayList<ObjetoHistorico> heredia;
	
	public Historico(ArrayList<Provincia> pprovincias, ArrayList<Region> pregiones) {
		
		this.provincias = pprovincias;
		this.regiones = pregiones;
		
		sanjose = new ArrayList();
		puntarenas = new ArrayList();
		limon = new ArrayList();
		cartago = new ArrayList();
		guanacaste = new ArrayList();
		alajuela = new ArrayList();
		heredia = new ArrayList();
		
		//llamo la funcion para generar los historicos
		generarHistorico();
	}
	
	public void generarHistorico() {
		//Guardemos el historico de san jose
		ArrayList<String> regiones_provincia = new ArrayList();
		//Calendar limite = Calendar.getInstance();
	    //limite.set(Calendar.YEAR, 2019);
		
		for (Provincia elemento: provincias) {
			
			
			// Obtener las fechas desde un año atrás hasta la fecha actual
	        Calendar calendario = Calendar.getInstance();
	        calendario.set(2015, Calendar.JANUARY, 1); // Restar un año
			
			if ("San Jose".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								sanjose.add(dato);
							}
						}
					}
		        }

			}if ("Alajuela".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								alajuela.add(dato);
							}
						}
					}
		        }

			}if ("Cartago".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								cartago.add(dato);
							}
						}
					}
		        }

			}if ("Heredia".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								heredia.add(dato);
							}
						}
					}
		        }

			}if ("Guanacaste".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								guanacaste.add(dato);
							}
						}
					}
		        }

			}if ("Puntarenas".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								puntarenas.add(dato);
							}
						}
					}
		        }

			}if ("Limon".equals(elemento.getNombre())){
				
				
				regiones_provincia = elemento.getListRegiones();
				//viene el bucle para crear todo un historico por region
				
		        while (calendario.getTime().before(new Date())) {
		        	
		            Fecha fecha = new Fecha();
		            fecha.setDia(calendario.get(Calendar.DAY_OF_MONTH));
		            fecha.setMes(calendario.get(Calendar.MONTH) + 1); // Meses en Calendar van de 0 a 11
		            fecha.setAño(calendario.get(Calendar.YEAR));
		            calendario.add(Calendar.DAY_OF_MONTH, 1); // Agregar un día a la fecha
		            
		            //System.out.println(fecha.getAño() + " " + fecha.getMes() + " " + fecha.getDia());
		            
		            for (String eleRegion: regiones_provincia) {
		            	//System.out.println(eleRegion);
		            	//System.out.println("");
						
		            	//Se necesita recorrer la lista de las regiones con las reglas para determinar los atributos de cada fecha
		            	for (Region region : regiones) {
		            		//System.out.println(region.getNombre());
							if (eleRegion.equals('"' + region.getNombre() + '"')) {
								
								
								//Creacion del random
								Random random = new Random();
								
								//Creacion de los valores aleatorios dentro de un rango
								int tempAle = random.nextInt(region.getTemp_max() - region.getTemp_min() + 1) + region.getTemp_min();
								int lluviaAle = random.nextInt(region.getMax_lluvia() - region.getMin_lluvia() + 1) + region.getMin_lluvia();
								int vientoAle = random.nextInt(region.getVel_max() - region.getVel_min() + 1) + region.getVel_min(); 
								
								//Se crea el objeto historico y se agrega a la lista correspondiente
								ObjetoHistorico dato = new ObjetoHistorico(region.getNombre(), tempAle, fecha, vientoAle, lluviaAle);
								limon.add(dato);
							}
						}
					}
		        }

			}
			
		}

	}
	
	ArrayList<ObjetoHistorico> getSanjose(){
		return sanjose;
	}

	public ArrayList<ObjetoHistorico> getPuntarenas() {
		return puntarenas;
	}

	public ArrayList<ObjetoHistorico> getLimon() {
		return limon;
	}

	public ArrayList<ObjetoHistorico> getCartago() {
		return cartago;
	}

	public ArrayList<ObjetoHistorico> getGuanacaste() {
		return guanacaste;
	}

	public ArrayList<ObjetoHistorico> getAlajuela() {
		return alajuela;
	}

	public ArrayList<ObjetoHistorico> getHeredia() {
		return heredia;
	}
	
	
}
