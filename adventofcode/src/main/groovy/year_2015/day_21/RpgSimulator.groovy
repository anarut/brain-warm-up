package year_2015.day_21

/**
 See {@linktourl http://adventofcode.com/2015/day/21}
 */
class RpgSimulator {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_21/input.txt').toURI())

        StatsCalculator calculator = new StatsCalculator(file.readLines())

        println "The least amount of gold to win: ${calculator.minCost}"
        println "The most amount of gold to lose: ${calculator.maxCost}"
    }
}
