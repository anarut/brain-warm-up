package year_2015.day_6

/**
 See {@linktourl http://adventofcode.com/2015/day/6}
 */
class FireHazard {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_6/input.txt').toURI())
        Matrix matrix = new Matrix(file.readLines())

        println "lit lights count: ${matrix.litLightsCount}"
        println "total brightness: ${matrix.totalBrightness}"
    }
}
