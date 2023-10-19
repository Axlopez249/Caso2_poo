package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ShowResults extends JFrame{
	private JTextArea t_humedad;
	private JTextArea tviento;
	private JTextArea t_atmos;
	private JTextArea tregion;
	private JTextArea t_fecha;
	private JTextArea lluvia;

	private JButton button2;
	private int ancho = 90;
	private int alto = 20;
	
	//Tabla
	private ArrayList<ArrayList<Object>> data = new ArrayList<>();
	private JTable j = new JTable();
	private String[] columnNames = { "Fecha", "Region", "Velocidad de viento", "Temperatura", "Datos Lluvia", "Provincia" };
	private JScrollPane sp;
	
	public ShowResults() {
		setTitle("MUESTRA DE LA INFORMACION / INFO. A MOSTRAR");
        setSize(1200, 400); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 60);
        
        JLabel label_titulo = new JLabel("Pronostico de una region del clima en específico según el tiempo necesitado");
        label_titulo.setFont(new Font("Arial", Font.BOLD, 25)); // Set font and size
        label_titulo.setForeground(Color.black); // Set text color
        label_titulo.setBounds(40, 15, 900, 30);
        
        


        // Initializing the JTable
        j = new JTable(new MyTableModel(data, columnNames));
        j.setBounds(30, 110, 600, 300);
        
 
        // adding it to JScrollPane
        sp = new JScrollPane(j);
        //getContentPane().add(j);
        sp.setBounds(40, 110, 600, 200);
        getContentPane().add(sp);
            
        
           
        JButton button1 = new JButton("Aceptar");

        // Define positions for the buttons
        button1.setBounds(40, 50, 100, 30);

        // Add buttons to the frame's content pane
        getContentPane().add(button1);
        
        getContentPane().add(label_titulo);

        // Set null layout
        getContentPane().setLayout(null);
        
        button1.addActionListener(e -> cancelar());
	}
	
	public void cancelar() {
		dispose();
	}
	//parametros de la funcion
	//Date fecha, String region, String velViento, String temp, String lluvia, String pronvincia
	public void llenarTable(Date fecha, String region, String velViento, String temp, String lluvia, String pronvincia) {
		ArrayList<Object> dia = new ArrayList<>(); 
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

        // Formatear la fecha usando el formato definido
        String fechaFormateada = formato.format(fecha);
		dia.add(fechaFormateada);
		dia.add(region);
		dia.add(velViento);
		dia.add(lluvia);
		dia.add(temp);
		dia.add(pronvincia);
		data.add(dia);
	}

}
