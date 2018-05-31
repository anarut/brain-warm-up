package year_2015.day_10

class LookAndSaySequence {

    private static final String MATCHER = /(([0-9])\2*)/

    private String number

    LookAndSaySequence(String number) {
        this.number = number
    }

    String getResult(int times) {
        String result = number
        (1..times).each {
            result = lookAndSay(result)
        }
        result
    }

    private static String lookAndSay(String sequence) {
        StringBuilder encoded = new StringBuilder()
        (sequence =~ MATCHER).each { matcher ->
            encoded.append(((String) matcher[1]).length()).append(matcher[2])
        }
        encoded.toString()
    }
}
