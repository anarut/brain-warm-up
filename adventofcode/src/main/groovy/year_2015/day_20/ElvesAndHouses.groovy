package year_2015.day_20

/**
 See {@linktourl http://adventofcode.com/2015/day/20}
 */
class ElvesAndHouses {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_20/input.txt').toURI())

        HouseFinder finder = new HouseFinder(file.text)

        println "The lowest house number: ${finder.houseNumber}"
        println "New lowest house number: ${finder.newHouseNumber}"
    }
}
