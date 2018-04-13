package year_2015.day_2

/**
 See {@linktourl http://adventofcode.com/2015/day/2}
 */
class ThereWouldBeNoMath {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_2/input.txt').toURI())
        WrappingPaperCalculator calculator = new WrappingPaperCalculator(file.readLines())

        println "size of of wrapping paper: ${calculator.wrappingPaperSize}"
        println "feet of ribbon: ${calculator.ribbonFeet}"
    }
}
