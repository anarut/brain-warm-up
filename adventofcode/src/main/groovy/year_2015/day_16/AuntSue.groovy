package year_2015.day_16

/**
 See {@linktourl http://adventofcode.com/2015/day/16}
 */
class AuntSue {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_16/input.txt').toURI())
        CSAM csam = new CSAM(file.readLines())

        println "Number of the Sue that got you the gift: ${csam.numberOfAuntSue}"
        println "Number of the real Aunt Sue: ${csam.realNumberOfAuntSue}"
    }
}
