package Principal;

public class Main {

    public static void main(String[] args) {

        int[] numeros=new int[]{1,2,3,4};
        Calculadora cal = new Calculadora("cal", numeros);

        cal.multiplicar(2);
    }
}
