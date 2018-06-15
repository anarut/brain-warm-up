package year_2015.day_17

/**
 See {@linktourl http://adventofcode.com/2015/day/17}
 */
class SuchThing {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_17/input.txt').toURI())
        WaterCombinator combinator = new WaterCombinator(file.readLines())

        println "Combinations count: ${combinator.allCombinations}"
        println "Combinations count with minimum containers: ${combinator.allCombinationsWithMinBottles}"
    }
}
