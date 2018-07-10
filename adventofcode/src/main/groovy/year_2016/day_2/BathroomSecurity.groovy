package year_2016.day_2

/**
 See {@linktourl http://adventofcode.com/2016/day/2}
 */
class BathroomSecurity {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_2/input.txt').toURI())
        SecurityCode securityCode = new SecurityCode(file.readLines())

        println "Bathroom code: ${securityCode.code}"
        println "Correct bathroom code: ${securityCode.correctCode}"
    }
}
