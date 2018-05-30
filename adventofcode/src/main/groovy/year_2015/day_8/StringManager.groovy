package year_2015.day_8

class StringManager {

    private static final String HEX_REGEX = '\\\\x[0-9a-f]{2}'
    private static final String DISPLAYABLE_NON_WORD_CHAR_REGEX = '\\\\\\W'
    private static final String NON_WORD_CHAR_REGEX = '\\W'

    private List<String> strings

    StringManager(List<String> strings) {
        this.strings = strings
    }

    int getDecodeDiff() {
        (int) strings.collect { s -> s.length() - decode(s).length() }.sum()
    }

    private static String decode(String s) {
        s.replaceAll(HEX_REGEX, 'a')
                .replaceAll(DISPLAYABLE_NON_WORD_CHAR_REGEX, 'a')
                .replaceAll(NON_WORD_CHAR_REGEX, '')
    }

    int getEncodeDiff() {
        (int) strings.collect { s -> encode(s).length() - s.length() }.sum()
    }

    private static String encode(String s) {
        "a${s.replaceAll(NON_WORD_CHAR_REGEX, 'aa')}a".toString()
    }

}