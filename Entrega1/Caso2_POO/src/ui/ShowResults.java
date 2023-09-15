package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
        
        
        
        t_humedad = new JTextArea();
        t_humedad.setLineWrap(false); // Enable line wrapping
        t_humedad.setWrapStyleWord(false); // Wrap at word boundaries
        t_humedad.setEditable(false);
        
        tviento = new JTextArea();
        tviento.setLineWrap(true); // Enable line wrapping
        tviento.setWrapStyleWord(true); // Wrap at word boundaries
        tviento.setEditable(false);
        
        t_atmos = new JTextArea();
        t_atmos.setLineWrap(true); // Enable line wrapping
        t_atmos.setWrapStyleWord(true); // Wrap at word boundaries
        t_atmos.setEditable(false);
        
        tregion = new JTextArea();
        tregion.setLineWrap(true); // Enable line wrapping
        tregion.setWrapStyleWord(true); // Wrap at word boundaries
        tregion.setEditable(false);
        
        t_fecha = new JTextArea();
        t_fecha.setLineWrap(true); // Enable line wrapping
        t_fecha.setWrapStyleWord(true); // Wrap at word boundaries
        t_fecha.setEditable(false);

        lluvia = new JTextArea();
        lluvia.setLineWrap(true); // Enable line wrapping
        lluvia.setWrapStyleWord(true); // Wrap at word boundaries
        lluvia.setEditable(false);

        
        t_humedad.setBounds(510, 120, 50, 15);
        tviento.setBounds(240, 120, 50, 15);
        t_atmos.setBounds(350, 120, 75, 15);
        tregion.setBounds(50, 120, 50, 15);
        t_fecha.setBounds(150, 120, 50, 15);
        lluvia.setBounds(590, 120, 100, 15);
        
        // Add text area to the frame's content pane
        getContentPane().add(t_humedad);   
        getContentPane().add(tviento);
        getContentPane().add(t_atmos);   
        getContentPane().add(tregion);
        getContentPane().add(t_fecha);   
        getContentPane().add(lluvia);

        
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
