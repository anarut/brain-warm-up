package year_2015.day_3

/**
 See {@linktourl http://adventofcode.com/2015/day/3}
 */
class SphericalHouses {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_3/input.txt').toURI())
        RouteManager manager = new RouteManager(file.text)
        
        println "unique places count: ${manager.uniquePlacesCount}"
        println "unique places count with robot: ${manager.uniquePlacesCountWithRobot}"
    }
}
