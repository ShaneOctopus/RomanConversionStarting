package cucumber.kata;

/**
 * Created by Shane on 4/25/2017.
 */
public enum RomanNumeral {
    // sequence is important here
    M(1000, "M"),
    CM(900, "CM"),
    D(500,"D"),
    CD(400,"CD"),
    C(100, "C"),
    XC(90,"XC"),
    L(50,"L"),
    XL(40,"XL"),
    X(10,"X"),
    IX(9,"IX"),
    V(5,"V"),
    IV(4,"IV"),
    I(1,"I");

    private int arabic;
    private String name;
    private RomanNumeral(int arabic, String name){
        this.arabic = arabic;
        this.name = name;
    }
    public int getArabic() {
        return arabic;
    }
    public String getName() {
        return name;
    }
}

