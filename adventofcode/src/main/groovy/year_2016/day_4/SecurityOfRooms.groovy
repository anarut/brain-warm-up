package year_2016.day_4

/**
 See {@linktourl http://adventofcode.com/2016/day/4}
 */
class SecurityOfRooms {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_4/input.txt').toURI())
        RoomValidator validator = new RoomValidator(file.readLines())

        println "Sum of the sector IDs: ${validator.sumOfIds}"
        println "Sector ID of storage: ${validator.realSectorId}"
    }
}
