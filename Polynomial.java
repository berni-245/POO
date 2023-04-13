public class Polynomial {
    private double[] coeficientes;
    private int size;
    private int dim;

    public Polynomial(int maxExponenteInicial){
        if(maxExponenteInicial < 0)
            throw new InvalidGradeException();
        coeficientes = new double[maxExponenteInicial + 1];
        size = maxExponenteInicial + 1;
    }

    public void set(int exponente, double coeficiente){
        if(exponente < 0)
            throw new InvalidGradeException();
        if(exponente >= size)
            reSize(exponente);

        this.coeficientes[exponente] = coeficiente;
    }

    private void reSize(int newMaxExponente){
        size = newMaxExponente + 1;
        double[] arrayAux = new double[size];
        System.arraycopy(coeficientes, 0, arrayAux, 0, coeficientes.length);
        coeficientes = arrayAux;
    }

    public double eval(double x){
        int i;
        double resultado = 0;
        for(i = 0; i < this.size; i++){
            resultado += coeficientes[i]*Math.pow(x, i);
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Polinomio: ");
        int i;
        for(i=0;i<size;i++){
            if(Double.compare(coeficientes[i],0) != 0)
                str.append("(%.1f) * x^%d + ".formatted(coeficientes[i], i));
        }
        str.setLength(str.length() - 3);

        return str.toString();
    }
}
