package year_2016.day_1

/**
 See {@linktourl http://adventofcode.com/2016/day/1}
 */
class Taxicab {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_1/input.txt').toURI())
        DirectionsMap map = new DirectionsMap(file.text)
        println "Blocks away: ${map.blocksAway}"
        println "The first location visited twice: ${map.visitedTwiceDistance}"
    }
}
