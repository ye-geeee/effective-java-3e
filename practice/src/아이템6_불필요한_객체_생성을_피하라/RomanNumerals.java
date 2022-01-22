package src.아이템6_불필요한_객체_생성을_피하라;

import java.util.regex.Pattern;

public class RomanNumerals {
    // bad example
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$");
    }

    // good example
    private static final Pattern ROMAN = Pattern.compile("^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$");

    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
