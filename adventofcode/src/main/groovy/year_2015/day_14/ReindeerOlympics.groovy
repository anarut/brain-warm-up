package year_2015.day_14

/**
 See {@linktourl http://adventofcode.com/2015/day/14}
 */
class ReindeerOlympics {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_14/input.txt').toURI())
        OlympicsRace race = new OlympicsRace(file.readLines())

        println "Distance the winning reindeer traveled: ${race.maxDistance}"
        println "Points the winning reindeer have: ${race.maxPoints}"
    }
}
