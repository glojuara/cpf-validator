package br.com.glojuara;

public class Validator {

    public static boolean isValidCpf(String cpf) {
        char[] chars = cpf.toCharArray();
        return isValidFormat(chars) && isValidDigit(chars, 1) && isValidDigit(chars, 2);
    }

    private static boolean isValidFormat(char[] cpf) {
        int cpfSize = 14;
        if (cpf == null || cpf.length != cpfSize) {
            return false;
        }
        return cpf[3] == '.' && cpf[7] == '.' && cpf[11] == '-';
    }

    private static boolean isValidDigit(char[] cpf, int digit) {
        int sum = 0;
        int multiplier = 9 + digit;
        int limit = digit == 1 ? 10 : 12;
        for (int index = 0; index <= limit; index++) {
            if(index == 3 || index == 7 || index == 11) continue;
            sum += Character.getNumericValue(cpf[index]) * multiplier--;
        }
        int rest = sum % 11;
        int digitIndex = 11 + digit;
        if (rest < 2) {
            return Character.getNumericValue(cpf[digitIndex]) == 0;
        }
        return Character.getNumericValue(cpf[digitIndex]) == 11 - rest;
    }

}
