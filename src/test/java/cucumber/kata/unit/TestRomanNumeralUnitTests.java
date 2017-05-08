package cucumber.kata.unit;

import cucumber.kata.RomanNumbers;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Shane on 4/25/2017.
 */
public class TestRomanNumeralUnitTests {
    @Test
    public void testSimpleArabicToRoman () {
        assertEquals("1 should be the outcome",1, RomanNumbers.toArabic("I"));
        assertEquals("5 should be the outcome",5, RomanNumbers.toArabic("V"));
    }
    @Test
    public void testComplexArabicToRoman () {
        assertEquals("256 should be the outcome", 256, RomanNumbers.toArabic("CCLVI") );
    }
    @Test
    public void testInvalidRomanNumeralB() {
        try {
            RomanNumbers.toArabic("B");
            fail("Invalid Digit B");
        }
        catch (IllegalArgumentException expectedException)
        {//do nothing
        }
    }
    @Test
    public void testInvalidRomanNumeralComboVC() {
        try {
            RomanNumbers.toArabic("VC");
            fail("Invalid Digit C");
        }
        catch (IllegalArgumentException expectedException)
        {//do nothing
        }
    }
    @Test
    public void testArabicToRoman () {
        assertEquals("I should be the outcome", "I", RomanNumbers.toRoman(1));
        assertEquals("V should be the outcome", "V", RomanNumbers.toRoman(5));
    }
    @Test
    public void testInvalidRomanNumeralOne() {
        try {
            RomanNumbers.toRoman(0);
            fail("Only numbers between 1 and 3999 is supported.");
        }
        catch (IllegalArgumentException expectedException)
        {//do nothing
        }
    }

}
