package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ShowResults extends JFrame{
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton button2;
	private int ancho = 90;
	private int alto = 20;
	
	public ShowResults() {
		setTitle("MUESTRA DE LA INFORMACION / INFO. A MOSTRAR");
        setSize(1200, 600); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        
        JLabel label_titulo = new JLabel("Muestra de datos del clima");
        JLabel humedad = new JLabel("Humedad");
        JLabel vientos = new JLabel("Vientos");
        JLabel p_atmos = new JLabel("Presión atmosférica");
        JLabel region = new JLabel("Region");
        JLabel fecha = new JLabel("Fecha");
        JLabel datos_lluvia = new JLabel("Datos de la lluvia");
        
        humedad.setBounds(510, 100, 200, 15);
        vientos.setBounds(240, 100, 200, 15);
        p_atmos.setBounds(350, 100, 200, 15);
        region.setBounds(50, 100, 200, 15);
        fecha.setBounds(150, 100, 200, 15);
        datos_lluvia.setBounds(590, 100, 200, 15);

        // Add label to the frame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(label_titulo);
        getContentPane().add(humedad);
        getContentPane().add(vientos);
        getContentPane().add(p_atmos);
        getContentPane().add(region);
        getContentPane().add(fecha);
        getContentPane().add(datos_lluvia);
        
        
        
        /*textArea1 = new JTextArea();
        textArea1.setLineWrap(true); // Enable line wrapping
        textArea1.setWrapStyleWord(true); // Wrap at word boundaries
        
        textArea2 = new JTextArea();
        textArea2.setLineWrap(true); // Enable line wrapping
        textArea2.setWrapStyleWord(true); // Wrap at word boundaries

        Rectangle textAreaBounds = new Rectangle(120, 70, 180, 200);
        textAreaBounds.setSize(ancho, alto);
        
        Rectangle textAreaBounds2 = new Rectangle(120, 100, 180, 200);
        textAreaBounds2.setSize(ancho, alto);
        textArea1.setBounds(textAreaBounds);
        textArea2.setBounds(textAreaBounds2);
        
        // Add text area to the frame's content pane
        getContentPane().add(textArea1);   
        getContentPane().add(textArea2);*/
        
        JButton button1 = new JButton("Cancelar");

        // Define positions for the buttons
        button1.setBounds(40, 280, 100, 30);

        // Add buttons to the frame's content pane
        getContentPane().add(button1);

        // Set null layout
        getContentPane().setLayout(null);
        
        //button1.addActionListener(e -> Imprimir());

	}
}
