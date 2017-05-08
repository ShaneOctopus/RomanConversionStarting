package cucumber.kata;

/**
 * Created by Shane on 4/25/2017.
 */
public class RomanNumbers {
    private static final int LOWER_NUMERAL_LIMIT = 1;
    private static final int UPPER_NUMERAL_LIMIT = 3999;

    public static long toArabic(String aRomanNumber) throws IllegalArgumentException{
        int arabic = 0;
        String romanName;
        for (RomanNumeral currentRomanNumber : RomanNumeral.values()) { //Iterate through all of the enums
            romanName = currentRomanNumber.getName();
            while (aRomanNumber.startsWith(romanName)) {                //We might have many instances of the same letter(s)
                arabic += currentRomanNumber.getArabic();               //based on finding a match, grab the associated value
                aRomanNumber = aRomanNumber.substring(romanName.length()); //remove the letter(s) we just found
            }
        }
        if (aRomanNumber.length() > 0) {
            throw new IllegalArgumentException("Invalid Digit " + aRomanNumber); //if we have anything left over, that is bad
        }
        return arabic;
    }
    public static String toRoman(int arabic)throws IllegalArgumentException {
        if (arabic < LOWER_NUMERAL_LIMIT || arabic > UPPER_NUMERAL_LIMIT) {
            throw new IllegalArgumentException(String.format("Only numbers between %s and %s is supported.", LOWER_NUMERAL_LIMIT, UPPER_NUMERAL_LIMIT));
        }

        StringBuilder result = new StringBuilder();
        for (RomanNumeral numeral : RomanNumeral.values()) { //Iterate through all of the enums, large to small
            while (arabic >= numeral.getArabic()) {         //starting with the larger values, subtract them out
                arabic -= numeral.getArabic();              //reduce number with matching number
                result.append(numeral.name());              //append found roman value
            }
        }
        return result.toString();
    }


}
