package dam.ed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Suma dos números")
    void testsumar() {
        assertEquals(3, miCalculadora.suma(1, 2));
        assertEquals(4, miCalculadora.suma(2, 2));
        assertEquals(20, miCalculadora.suma(10, 10));
        assertEquals(91, miCalculadora.suma(90, 1));
    }

    @Test
    @DisplayName("Resta dos numeros")
    void testResta() {
        assertEquals(0, miCalculadora.resta(1, 1));
        assertEquals(2, miCalculadora.resta(4, 2));
        assertEquals(4, miCalculadora.resta(5, 1));
        assertEquals(8, miCalculadora.resta(10, 2));

    }


    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(16, miCalculadora.multiplica(4, 4));
        assertEquals(-5, miCalculadora.multiplica(-5, 1));

        assertEquals(1, miCalculadora.multiplica(1, 1));
        assertEquals(4, miCalculadora.multiplica(2, 2));
        assertEquals(9, miCalculadora.multiplica(3, 3));
        assertEquals(16, miCalculadora.multiplica(4, 4));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4, 2));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));

        assertEquals(5, miCalculadora.divide(10, 2));
        assertEquals(5, miCalculadora.divide(15, 3));
        assertEquals(6, miCalculadora.divide(12, 2));
        assertEquals(5, miCalculadora.divide(20, 4));

    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("Raiz y cuadrada")
    void testRaizCuadrada()  throws RuntimeException{
        assertEquals(0, miCalculadora.raizCuadrada(0));
        assertEquals(4, miCalculadora.raizCuadrada(4));
        assertEquals(1, miCalculadora.raizCuadrada(1));
    }

    @Test
    @DisplayName("Raiz y cuadrada negativos")
    void testRaizCuadradaNegativos() throws RuntimeException {
        assertTrue (miCalculadora.raizCuadrada(-5) < 0);


    }


    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Raíz cuadrada de número negativo causa excepción")
    void testRaizCuadradaNegativosy0() {
        Calculadora miCalculadora = new Calculadora();

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            miCalculadora.raizCuadrada(-5);
        });

        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}