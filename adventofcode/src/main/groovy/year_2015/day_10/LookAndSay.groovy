package year_2015.day_10

/**
 See {@linktourl http://adventofcode.com/2015/day/10}
 */
class LookAndSay {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_10/input.txt').toURI())
        LookAndSaySequence function = new LookAndSaySequence(file.text)

        println "The length of the result (40): ${function.getResult(40).length()}"
        println "The length of the result (50): ${function.getResult(50).length()}"
    }
}
