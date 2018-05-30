package year_2015.day_8

/**
 See {@linktourl http://adventofcode.com/2015/day/8}
 */
class Matchsticks {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_8/input.txt').toURI())
        StringManager manager = new StringManager(file.readLines())

        println "Decode diff: ${manager.decodeDiff}"
        println "Encode diff: ${manager.encodeDiff}"
    }
}
