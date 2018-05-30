package year_2015.day_9

/**
 See {@linktourl http://adventofcode.com/2015/day/9}
 */
class SingleNight {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_9/input.txt').toURI())
        ShortestPath path = new ShortestPath(file.readLines())

        println "Distance of the shortest route: ${path.minRoute}"
        println "Distance of the longest route: ${path.maxRoute}"
    }
}
