package br.edu.lab5.atividade1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TrianguloTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarClassificacaoTriangulo(int a, int b, int c, String resultadoEsperado) {
        String resultado = Triangulo.classificar(a, b, c);
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of(3, 4, 5, "Escaleno"),
                Arguments.of(3, 3, 5, "Isósceles"),
                Arguments.of(3, 5, 3, "Isósceles"),
                Arguments.of(5, 3, 3, "Isósceles"),
                Arguments.of(3, 3, 3, "Equilátero"),

                Arguments.of(0, 1, 1, "Não é um triângulo"),
                Arguments.of(1, 0, 1, "Não é um triângulo"),
                Arguments.of(1, 1, 0, "Não é um triângulo"),
                Arguments.of(-1, 1, 1, "Não é um triângulo"),
                Arguments.of(1, -1, 1, "Não é um triângulo"),
                Arguments.of(1, 1, -1, "Não é um triângulo"),

                Arguments.of(1, 2, 3, "Não é um triângulo"),
                Arguments.of(1, 3, 2, "Não é um triângulo"),
                Arguments.of(3, 1, 2, "Não é um triângulo")
        );
    }
}