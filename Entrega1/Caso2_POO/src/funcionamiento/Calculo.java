package funcionamiento;

import java.util.ArrayList;

import extraccion_json.*;

public class Calculo {
	
	private ArrayList<Provincia> provincias_lista;
	private ArrayList<Region> regiones_lista;
	private String region_entrada;
	private String provincia_entrada;
	
	
	
	public Calculo(String pprovincia_entrada, String pregion_entrada) {
		this.provincia_entrada = pprovincia_entrada;
		this.region_entrada = pregion_entrada;
		Generador_Json generador_info = new Generador_Json();
		provincias_lista = generador_info.cargarListaProvincias();
		regiones_lista = generador_info.cargarListaRegion();
		
	}
	
	public void compararDatos() {
		for (Provincia elemento: provincias_lista) {
			if(elemento.getNombre()== provincia_entrada) {
				
				//recorro la lista de regiones para buscar la que sea igual a la entrada y luego 
				//comienzo a generar los numeros aleatorios para el promedio
			}
		}
	}
	
	public void conectarUI() {
		
	}
	public void Asimilar_solicitud() {
		
	}
}
