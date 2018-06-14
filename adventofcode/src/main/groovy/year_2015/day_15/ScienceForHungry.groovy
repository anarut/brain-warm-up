package year_2015.day_15

/**
 See {@linktourl http://adventofcode.com/2015/day/15}
 */
class ScienceForHungry {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_15/input.txt').toURI())
        CookingFormula formula = new CookingFormula(file.readLines())

        println "Highest total score: ${formula.bestResult}"
        println "Highest total score with 500 calorie: ${formula.bestResultWithCalorie}"
    }
}
