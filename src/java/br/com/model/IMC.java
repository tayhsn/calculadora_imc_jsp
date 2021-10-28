
package br.com.model;

/**
 *
 * @author Tayanne
 */
public class IMC {
    private double altura;
    private double peso;

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    public String informarClassificacao(double IMC) {
        String classif;
        if(IMC < 18.5) {
            classif = "Abaixo do peso";
        } else if(IMC > 18.6 && IMC < 24.9) {
            classif = "Saudável";
        } else if(IMC > 25.0 && IMC < 29.9) {
            classif = "Peso em excesso";
        } else if(IMC > 30.0 && IMC < 34.9) {
            classif = "Obesidade Grau 1";
        } else if(IMC > 35.0 && IMC < 39.9) {
            classif = "Obesidade Grau 2 (Severa)";
        } else {
            classif = "Obesidade Grau 3 (Mórbida)";
        }
        return classif;
    }
    
}
