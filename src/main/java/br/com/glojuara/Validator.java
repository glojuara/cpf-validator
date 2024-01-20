package br.com.glojuara;

import org.openjdk.jmh.annotations.*;

public class Validator {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.All)
    public void init() {
        isValidCpf("860.082.270-00");
    }

    public static boolean isValidCpf(String cpf) {
        return isValidFormat(cpf) && isValidDigit(cpf, 1) && isValidDigit(cpf, 2);
    }

    private static boolean isValidFormat(String cpf) {
        int cpfSize = 14;
        if (cpf == null || cpf.length() != cpfSize) {
            return false;
        }
        return cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-';
    }

    private static boolean isValidDigit(String cpf, int digit) {
        int sum = 0;
        int multiplier = 9 + digit;
        int limit = digit == 1 ? 10 : 12;
        for (int index = 0; index <= limit; index++) {
            if(index == 3 || index == 7 || index == 11) continue;
            sum += Character.getNumericValue(cpf.charAt(index)) * multiplier--;
        }
        int rest = sum % 11;
        int digitIndex = 11 + digit;
        if (rest < 2) {
            return Character.getNumericValue(cpf.charAt(digitIndex)) == 0;
        }
        return Character.getNumericValue(cpf.charAt(digitIndex)) == 11 - rest;
    }

}
