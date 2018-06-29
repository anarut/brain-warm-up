package year_2015.day_22

/**
 See {@linktourl http://adventofcode.com/2015/day/22}
 */
class WizardSimulator {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_22/input.txt').toURI())

        ManaCalculator calculator = new ManaCalculator(file.readLines())

        println "The least amount of mana: ${calculator.minMp}"
        println "The least amount of mana (hard): ${calculator.minMpHard}"
    }
}
