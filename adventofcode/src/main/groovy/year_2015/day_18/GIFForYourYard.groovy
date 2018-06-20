package year_2015.day_18

/**
 See {@linktourl http://adventofcode.com/2015/day/18}
 */
class GIFForYourYard {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_18/input.txt').toURI())

        LightToggleManager manager = new LightToggleManager(file.readLines())

        println "Lights are on after 100 steps: ${manager.lightsOnAfter(100)}"
        println "Lights are on after 100 steps with ON corners: ${manager.lightsOnAfter(100, true)}"
    }
}
