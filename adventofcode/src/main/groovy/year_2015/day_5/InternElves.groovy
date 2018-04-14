package year_2015.day_5

/**
 See {@linktourl http://adventofcode.com/2015/day/5}
 */
class InternElves {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_5/input.txt').toURI())
        StringParser parser = new StringParser(file.readLines())
        
        println "nice string count 1: ${parser.niceStringsCountAtStart}"
        println "nice string count 2: ${parser.niceStringsCountAtEnd}"
    }
}