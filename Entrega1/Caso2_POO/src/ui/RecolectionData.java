package ui;

import java.awt.Color;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;


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
 * genere los datos
 *Será con un Json escrito y realizado para poder darle inicio al proceso y tener los datos necesarios
 */
public class RecolectionData extends JFrame{
	JDateChooser dateChooser;
	SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
	ShowResults muestra;
	
	public RecolectionData() {
		setTitle("RECOLECCION DE DATA / INFO. A BUSCAR");
        setSize(500, 600); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        
        muestra = new ShowResults();
        
        dateChooser = new JDateChooser();
        
        JLabel label_titulo = new JLabel("Busqueda de datos del clima de una region");
        JLabel label_region = new JLabel("Region");
        JLabel label_date = new JLabel("Date");
        
        label_titulo.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_titulo.setForeground(Color.BLACK); // Set text color
        label_titulo.setBounds(150, 10, 350, 40);
        
        label_region.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_region.setForeground(Color.BLACK); // Set text color
        label_region.setBounds(40, 60, 100, 40);
        
        label_date.setFont(new Font("Arial", Font.BOLD, 11)); // Set font and size
        label_date.setForeground(Color.BLACK); // Set text color
        label_date.setBounds(40, 90, 100, 40);
        
        //Objeto Calendario
        dateChooser.setBounds(90, 100, 100, 40);

        // Add label to the frame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(label_titulo);
        getContentPane().add(label_region);
        getContentPane().add(label_date);
        getContentPane().add(dateChooser);

        
     // Crear un arreglo de opciones
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5"};
        
        // Crear un JComboBox y agregar las opciones
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(120, 70, 180, 20);
        getContentPane().add(comboBox);
        
        
        JButton button1 = new JButton("Mostrar");

        // Define positions for the buttons
        button1.setBounds(40, 280, 100, 30);

        // Add buttons to the frame's content pane
        getContentPane().add(button1);

        // Set null layout
        getContentPane().setLayout(null);
        
        
        button1.addActionListener(e -> Imprimir(comboBox, dateChooser));

	}
	
	private void Imprimir(JComboBox<String> boton, JDateChooser fecha) {
		/*
		// Obtener la opción seleccionada
        String seleccion = (String) boton.getSelectedItem();
        
        //Fecha
        Date date = fecha.getDate();
        
        String fecha_correcta = formatoCorto.format(date);
        
        // Mostrar un cuadro de diálogo con la opción seleccionada
        JOptionPane.showMessageDialog(boton, "La seleccion es " + seleccion + "\n" + 
        "La fecha seleccionada es " + fecha_correcta);*/
		
		muestra.setVisible(true);
	}


}
