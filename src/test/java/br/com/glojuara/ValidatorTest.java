package br.com.glojuara;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "860.082.270-00",
            "679.161.030-10",
            "224.275.040-25",
            "235.423.450-32",
            "944.997.140-44",
            "002.985.200-52",
            "429.546.230-63",
            "511.272.170-70",
            "364.205.810-87",
            "880.595.790-96",
    })
    public void testValidCPF(String cpf) {
        Assertions.assertTrue(Validator.isValidCpf(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "51127217070",
            "511.272.170.70",
            "511.272.170#70",
            "511#272.170-70",
            "511.272#170-70",
            "511.272.170-7",
    })
    public void testInvalidFormat(String cpf) {
        Assertions.assertFalse(Validator.isValidCpf(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "511.272.170-00",
            "511.272.170-10",
            "511.272.170-20",
            "511.272.170-30",
            "511.272.170-40",
            "511.272.170-50",
            "511.272.170-60",
            "511.272.170-80",
            "511.272.170-90",
    })
    public void testInvalidFirstDigit(String cpf) {
        Assertions.assertFalse(Validator.isValidCpf(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "511.272.170-71",
            "511.272.170-72",
            "511.272.170-73",
            "511.272.170-74",
            "511.272.170-75",
            "511.272.170-76",
            "511.272.170-77",
            "511.272.170-78",
            "511.272.170-79",
    })
    public void testInvalidSecondDigit(String cpf) {
        Assertions.assertFalse(Validator.isValidCpf(cpf));
    }

}
