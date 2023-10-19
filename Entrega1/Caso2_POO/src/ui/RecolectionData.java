package ui;

import java.awt.Color;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import extraccion_json.*;


import com.toedter.calendar.JDateChooser;
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
 */
public class RecolectionData extends JFrame{
	JDateChooser dateChooser;
	SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public RecolectionData(Generador_Json archivoJson) {
		
		
		setTitle("RECOLECCION DE DATA / INFO. A BUSCAR");
        setSize(500, 600); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        
        
        
        dateChooser = new JDateChooser();
        
        JLabel label_titulo = new JLabel("Busqueda de datos del clima de una region");
        JLabel label_region = new JLabel("Region");
        JLabel label_provincia = new JLabel("Provincia");
        JLabel label_date = new JLabel("Date");
        
        label_titulo.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_titulo.setForeground(Color.BLACK); // Set text color
        label_titulo.setBounds(150, 10, 350, 40);
        
        label_provincia.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_provincia.setForeground(Color.BLACK); // Set text color
        label_provincia.setBounds(40, 60, 100, 40);
        
        label_region.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_region.setForeground(Color.BLACK); // Set text color
        label_region.setBounds(40, 80, 100, 40);
        
        label_date.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_date.setForeground(Color.BLACK); // Set text color
        label_date.setBounds(40, 120, 100, 40);
        
        //Objeto Calendario
        dateChooser.setBounds(120, 120, 100, 40);

        // Add label to the frame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(label_titulo);
        getContentPane().add(label_region);
        getContentPane().add(label_provincia);
        getContentPane().add(label_date);
        getContentPane().add(dateChooser);

        
     // Crear un arreglo de opciones
        String[] opciones = {"Cartago", "Alajuela", "Heredia", "Limón", "San José", "Guanacaste", "Puntarenas"};
        // Crear un JComboBox y agregar las opciones
        JComboBox<String> comboBox_provincias = new JComboBox<>(opciones);
        comboBox_provincias.setBounds(120, 70, 180, 20);
        getContentPane().add(comboBox_provincias);
        
     // Crear un arreglo de opciones
        String[] opciones_regiones = {"Cartago Centro", "Turrialba ", "Orosi", "Heredia Centro",
        		"Santo Domingo", "Barva", "San Jose Centro", "San Pedro", "Escazu", "Alajuela Centro",
        		"San Ramon", "La Fortuna de San Carlos", "Golfo de Papagayo", "Nicoya", "Rincón de la vieja",
        		"Peninsula de Nicoya", "Golfito", "Monte verde", "Cahuita", "Tortuguero", "Puerto viejo"};
        // Crear un JComboBox y agregar las opciones
        JComboBox<String> comboBox_regiones = new JComboBox<>(opciones_regiones);
        comboBox_regiones.setBounds(120, 95, 180, 20);
        getContentPane().add(comboBox_regiones);
        
        
        JButton button1 = new JButton("Mostrar");
        

        // Define positions for the buttons
        button1.setBounds(40, 280, 100, 30);

        // Add buttons to the frame's content pane
        getContentPane().add(button1);

        // Set null layout
        getContentPane().setLayout(null);
        
        
        button1.addActionListener(e -> ConectarController(comboBox_regiones,comboBox_provincias, dateChooser, archivoJson));

	}
	
	private void ConectarController(JComboBox<String> boton_region,JComboBox<String> boton_provincia, JDateChooser fecha, Generador_Json parchivoJson) {
        
		ShowResults muestra = new ShowResults();
		//Fecha
        Date date = fecha.getDate();
        
		//creo instancia del controller
		ControllerUIEntrada solicitud = new ControllerUIEntrada(date, boton_provincia.getSelectedItem().toString(), boton_region.getSelectedItem().toString(), muestra, parchivoJson);
		
	}
	


}
