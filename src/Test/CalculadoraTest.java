package Test;

import static org.junit.jupiter.api.Assertions.*;

import Principal.Calculadora;
import org.junit.jupiter.api.Test;

class CalculadoraTest {



    @Test
    void CalculadoraCN1() {
        int[] números = new int[]{1, 15, -60, 0, 55, -2};
        assertArrayEquals(new Calculadora("Calcu", números).números, números,"(0010)Error del constructor");
    }

    @Test
    void CalculadoraCN2() {
        int[] números = new int[]{1, 15, -60, 0, 55, -2};
        assertArrayEquals(new Calculadora("", números).números, números,"(0020)Error del constructor");
    }

    @Test
    void CalculadoraCN3() {
        int[] números = new int[]{};
        assertArrayEquals(new Calculadora("Calcu", números).números, números,"(0030)Error del constructor");
    }

    @Test
    void CalculadoraCN4() {
        int[] números = new int[]{};
        assertArrayEquals(new Calculadora("", números).números, números,"(0040)Error del constructor");
    }

    @Test
    void CalculadoraNull1() {
        boolean salta = false;
        try {
            new Calculadora("Calcu", null);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta, "(0050)Error al saltar la excepción.");
    }

    @Test
    void CalculadoraNull2() {
        boolean salta = false;
        int[] números = new int[]{1,2};
        try {
            new Calculadora(null, números);
        } catch (Exception e) {
            salta = true;
        }
        assertFalse(salta, "(0060)Error al saltar la excepción.");
    }

    @Test
    void multiplicarCN1() {
        Calculadora vacio = new Calculadora("Calcu",new int[0]);
        Calculadora vectorNulo = new Calculadora("Calcu",new int[0]);
        vacio.multiplicar(2);
        assertArrayEquals(vacio.números, vectorNulo.números, "(0040)No se han multiplicado correctamente.");
    }


    @Test
    void númeroRepeticionesCN1() throws Exception {
        int[] números = new int[]{1,2, 3, 1,5,1,2};
        Calculadora calculadora = new Calculadora("cal", números);
        assertEquals(3,calculadora.númeroRepeticiones(1), "No se encuentra este número");
    }

    @Test
    void númeroRepeticionesCN2() throws Exception {
        int[] números = new int[]{1,2, 3, 1,5,1,2};
        Calculadora calculadora = new Calculadora("cal", números);
        assertNotEquals(0,calculadora.númeroRepeticiones(4), "No se encuentra este número");
    }

    @Test
    void númeroRepeticionesCN3() throws Exception {
        int[] números = new int[]{};
        Calculadora calculadora = new Calculadora("cal", números);
        assertNotEquals(0,calculadora.númeroRepeticiones(4), "No se encuentra este número");
    }

    @Test
    void equalsCN1() {
        int[] números1 = new int[]{1,2,3};
        Calculadora calculadora1 = new Calculadora("cal", números1);
        Calculadora calculadora2 = new Calculadora("cal", números1);
        assertEquals(calculadora1, calculadora2, "Las calculadoras no so iguales");
    }

    @Test
    void equalsCN2() {
        int[] números1 = new int[]{1,2,3};
        int[] números2 = new int[]{3,5,7};

        Calculadora calculadora1 = new Calculadora("cal", números1);
        Calculadora calculadora2 = new Calculadora("cal", números2);
        assertNotEquals(calculadora1, calculadora2, "Las calculadoras no so iguales");
    }

    @Test
    void equalsCN3() {
        int[] números1 = new int[]{1,2,3};

        Calculadora calculadora1 = new Calculadora("cal", números1);
        Calculadora calculadora2 = new Calculadora("calcu", números1);
        assertNotEquals(calculadora1, calculadora2, "Las calculadoras no so iguales");
    }

}