package Principal;

import java.util.Arrays;

public class Calculadora {
    /**
     * Diseñe el código y las pruebas de caja negra y blanca para una clase Calculadora, que tendrá los
     * siguientes atributos y métodos: ( 6 puntos)
     * - public string nombreCalculadora;
     * - public int[] números;
     *
     * - public Calculadora(string nombre, int[] números): constructor que inicia el nombre y los números
     * que tendrá para los cálculos.
     * - public void multiplicar(int x): cada dato interno lo modifica multiplicándolo por x.
     * - public int númeroRepeticiones(int número): devuelve las veces que aparece el número dentro del
     * vector. Si no aparece, produce una excepción.
     * - Sobreescribir el método equals. Dos calculadoras son iguales si tienen el mismo nombre y los mismos
     * datos.
     */

    public String nombreCalculadora;
    public int[] números;

    public Calculadora(String nombreCalculadora, int[] números) {
        this.nombreCalculadora = nombreCalculadora;
        this.números = números.clone();
    }

    public void multiplicar(int x){
        for (int i = 0; i < números.length; i++) {
            números[i] *= x;
        }
    }

    public int númeroRepeticiones(int número) throws Exception{

        int contador = 0;
        if(números.length==0){
            throw new Exception("El vector no está iniciado");
        }
        for (int i = 0; i < números.length; i++) {
            if (números[i]==número){
                contador++;
            }else{
                throw new Exception("No se encuentra este número");
            }
        }

        /**
         *  for (int i = 0; i < números.length; i++) {
         *     if (números[i]==número){
         *        contador++;
         *     }
         *     if (contador == 0){
         *     throw new Exception("No se encuentra este número")
         *   }
         */
        return contador;
    }

    @Override
    public boolean equals(Object o) {
        return o!=null
                && getClass() == o.getClass()
                && nombreCalculadora == (((Calculadora)o).nombreCalculadora)
                && Arrays.equals(números, (((Calculadora)o).números));
    }
}
