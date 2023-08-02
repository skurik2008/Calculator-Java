public enum ConverterArabToRom {
    _1("I"), _2("II"), _3("III"), _4("IV"), _5("V"), _6("VI"), _7("VII"), _8("VIII"), _9("IX"),
    _10("X"), _20("XX"), _30("XXX"), _40("XL"), _50("L"), _60("LX"), _70("LXX"), _80("LXXX"), _90("XC"), _100("C");
    private String i;
    ConverterArabToRom(String i) {
        this.i = i;
    }
    public String getNumber() {
        return i;
    }
}

