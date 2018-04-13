package year_2015.day_1

/**
 See {@linktourl http://adventofcode.com/2015/day/1}
 */
class NotQuiteLisp {
    
    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_1/input.txt').toURI())
        DirectionsDecoder decoder = new DirectionsDecoder(file.text)
        println "Floor: ${decoder.floor}"
        println "1st (-1) position: ${decoder.position}"
    }
}