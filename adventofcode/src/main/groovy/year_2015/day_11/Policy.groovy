package year_2015.day_11

/**
 See {@linktourl http://adventofcode.com/2015/day/11}
 */
class Policy {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_11/input.txt').toURI())
        NextPassword function = new NextPassword(file.text)

        println "Next password: ${function.newPassword}"
        println "The next one: ${function.nextOne}"
    }
}
