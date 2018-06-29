package year_2015.day_23

/**
 See {@linktourl http://adventofcode.com/2015/day/23}
 */
class TuringLock {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_23/input.txt').toURI())

        Turing turing = new Turing(file.readLines())

        println "The value in register b (a=0, b=0): ${turing.b}"
        println "The value in register b (a=1, b=0): ${turing.newB}"
    }
}
