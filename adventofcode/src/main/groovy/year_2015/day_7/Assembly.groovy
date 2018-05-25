package year_2015.day_7

/**
 See {@linktourl http://adventofcode.com/2015/day/7}
 */
class Assembly {
    
    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_7/input.txt').toURI())
        WireSet set = new WireSet(file.readLines())

        println "signal for wire 'a': ${set.signalForWireA}"
        println "signal for wire 'a' with overriden signal 'b': ${set.signalForWireAwithOverridenB}"
    }
}
