package year_2015.day_4

/**
 See {@linktourl http://adventofcode.com/2015/day/4}
 */
class StockingStuffer {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_4/input.txt').toURI())
        MD5HashGenerator generator = new MD5HashGenerator(file.text)
        
        println "answer with 5 zero: ${generator.answerWith5Zero}"
        println "answer with 6 zero: ${generator.answerWith6Zero}"
    }
}