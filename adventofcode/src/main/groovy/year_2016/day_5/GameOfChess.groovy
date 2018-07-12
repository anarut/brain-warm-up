package year_2016.day_5

/**
 See {@linktourl http://adventofcode.com/2016/day/5}
 */
class GameOfChess {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_5/input.txt').toURI())
        MD5HashGenerator generator = new MD5HashGenerator(file.text)

        println "Password(in order): ${generator.password}"
        println "Password(with position): ${generator.password2}"
    }
}
