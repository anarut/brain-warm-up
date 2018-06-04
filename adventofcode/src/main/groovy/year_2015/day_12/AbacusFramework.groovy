package year_2015.day_12

/**
 See {@linktourl http://adventofcode.com/2015/day/12}
 */
class AbacusFramework {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_12/input.txt').toURI())
        NumberParser parser = new NumberParser(file.text)

        println "Sum of all numbers: ${parser.sum}"
        println "Sum of all numbers without red: ${parser.updatedSum}"
    }
}
