package cucumber.kata;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Shane on 4/25/2017.
 */
public class TestRomanNumeralFeatureSteps {
    private ConversionEntry aRomanConversion;
    private ConversionEntry aComplexConversion;
    private ConversionEntry anErrorConversion;
    private ConversionEntry anArabicConversion;

    @When("^I ask for a translation of a \"([^\"]*)\"$")
    public void iAskForATranslationOfA(String romanNumeral) throws Throwable {
        aRomanConversion = new ConversionEntry();
        aRomanConversion.romanNumeral = romanNumeral;
        //no test done, this is setup for the next step
    }

    @Then("^I get the correct \"([^\"]*)\"$")
    public void iGetTheCorrect(Integer anArabicNumber) throws Throwable {
        assertEquals(Long.valueOf(anArabicNumber), Long.valueOf(RomanNumbers.toArabic(aRomanConversion.romanNumeral)));
    }

    @When("^I ask for a translation of a combination \"([^\"]*)\"$")
    public void iAskForATranslationOfACombination(String romanNumeral) throws Throwable {
        aComplexConversion = new ConversionEntry();
        aComplexConversion.setRomanNumeral(romanNumeral);
//no test done, this is setup for the next step

    }

    @Then("^I get the correct combination translation \"([^\"]*)\"$")
    public void iGetTheCorrectCombinationTranslation(Integer anArabicNumber) throws Throwable {
        assertEquals(Long.valueOf(anArabicNumber), Long.valueOf(RomanNumbers.toArabic(aComplexConversion.romanNumeral)));
    }

    @When("^I ask for a translation of an invalid \"([^\"]*)\"$")
    public void iAskForATranslationOfAnInvalid(String romanNumeral) throws Throwable {
        anErrorConversion = new ConversionEntry();
        anErrorConversion.setRomanNumeral(romanNumeral);
        //no test done, this is setup for the next step

    }

    @Then("^I get the invalid numeral error$")
    public void iGetTheInvalidNumeralError() throws Throwable {
        try {
            RomanNumbers.toArabic(anErrorConversion.romanNumeral);
            fail("Invalid RomanNumeral, no exception thrown.");
        }
        catch (IllegalArgumentException e) {
            //do nothing here as the exception was expected
        }

    }

    @When("^I ask for a Roman translation of a \"([^\"]*)\"$")
    public void iAskForARomanTranslationOfA(Integer anArabicNumber) throws Throwable {
        anArabicConversion = new ConversionEntry();
        anArabicConversion.setArabicNumber(anArabicNumber);
        //no test done, this is setup for the next step
    }

    @Then("^I get the correct Roman Numeral \"([^\"]*)\"$")
    public void iGetTheCorrectRomanNumeral(String aRomanNumber) throws Throwable {
        assertEquals(aRomanNumber, RomanNumbers.toRoman(anArabicConversion.getArabicNumber()));
    }
    @When("^I ask for a Roman translation of a invalid \"([^\"]*)\"$")
    public void iAskForARomanTranslationOfAInvalid(Integer anArabicNumber) throws Throwable {
        anArabicConversion = new ConversionEntry();
        anArabicConversion.setArabicNumber(anArabicNumber);
        //no test done, this is setup for the next step
    }

    @Then("^I get the invalid Arabic error$")
    public void iGetTheInvalidArabicError() throws Throwable {
        try {
            RomanNumbers.toRoman(anArabicConversion.getArabicNumber());
            fail("Invalid Arabic Numeral, no exception raised.");
        }
        catch (IllegalArgumentException e) {
            //do nothing here as the exception was expected
        }
    }

    //helper class
    public class ConversionEntry {
        String romanNumeral;
        Integer arabicNumber;

        public void setRomanNumeral(String romanNumeral) {
            this.romanNumeral = romanNumeral;
        }

        public void setArabicNumber(int anArabicNumber) {
            this.arabicNumber = anArabicNumber;
        }

        public String getRomanNumeral() {
            return romanNumeral;
        }

        public int getArabicNumber() {
            return arabicNumber;
        }
    }

}
