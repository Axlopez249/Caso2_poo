package ui;

public class ControllerUISalida {
	private int velViento;
	private int lluvia;
	private int temp;
	private String region;
	private String provincia;
	
	public ControllerUISalida(int pvelViento, int plluvia, int ptemp, String pregion, String pprovincia, ShowResults resultado) {
		velViento = pvelViento;
		lluvia = plluvia;
		temp = ptemp;
		region = pregion;
		provincia = pprovincia;
		
		conectarUI(resultado);
	}
	
	public void conectarUI(ShowResults presultado) {
		presultado.setVisible(true);
		//Aqui se van acomodando los datos que se van mostrando
		//se debe de tener cuidado porque los datos se van tirando para abajo
		//se puede seguir el ejemplo de patio
	}
}
