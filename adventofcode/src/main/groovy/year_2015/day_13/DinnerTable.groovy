package year_2015.day_13

/**
 See {@linktourl http://adventofcode.com/2015/day/13}
 */
class DinnerTable {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_13/input.txt').toURI())
        SeatingArrangement sa = new SeatingArrangement(file.readLines())

        println "Total change in happiness: ${sa.totalChange}"
        println "Total change in happiness with yourself: ${sa.totalChangePlusNeutral}"
    }
}
