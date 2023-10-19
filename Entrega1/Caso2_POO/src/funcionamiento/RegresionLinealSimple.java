package funcionamiento;

import java.util.ArrayList;

public class RegresionLinealSimple {
	private double coeficiente;
    private double intercepto;

    public void ajustarModelo(ArrayList<Integer> atributosPredecir, ArrayList<Integer> valoresMediantes) {
        int numMuestras = atributosPredecir.size();
        double sumaX = 0;
        double sumaY = 0;
        double sumaXY = 0;
        double sumaXcuadrado = 0;

        for (int i = 0; i < numMuestras; i++) {
            sumaX += atributosPredecir.get(i);
            sumaY += valoresMediantes.get(i);
            sumaXY += atributosPredecir.get(i) * valoresMediantes.get(i);
            sumaXcuadrado += atributosPredecir.get(i) * atributosPredecir.get(i);
        }

        coeficiente = (numMuestras * sumaXY - sumaX * sumaY) / (numMuestras * sumaXcuadrado - sumaX * sumaX);
        intercepto = (sumaY - coeficiente * sumaX) / numMuestras;
    }

    public double predecir(double atributo) {
        return (coeficiente * atributo) + intercepto;
    }
}
