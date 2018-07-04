package year_2015.day_25

/**
 See {@linktourl http://adventofcode.com/2015/day/25}
 */
class LetItSnow {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_25/input.txt').toURI())

        CodeGenerator generator = new CodeGenerator(file.text)

        println "The code is: ${generator.code}"
    }
}
