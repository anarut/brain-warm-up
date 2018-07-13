package year_2016.day_6

/**
 See {@linktourl http://adventofcode.com/2016/day/6}
 */
class SignalsAndNoise {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_6/input.txt').toURI())
        SymbolCombinator combinator = new SymbolCombinator(file.readLines())

        println "The message(most frequent): ${combinator.mostFrequentMessage}"
        println "The message(least common): ${combinator.leastCommonMessage}"
    }
}
