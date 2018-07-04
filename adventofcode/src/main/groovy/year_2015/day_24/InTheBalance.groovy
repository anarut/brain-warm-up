package year_2015.day_24

/**
 See {@linktourl http://adventofcode.com/2015/day/24}
 */
class InTheBalance {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_24/input.txt').toURI())

        Balancer balancer = new Balancer(file.readLines())

        println "Quantum entanglement (3 groups): ${balancer.getQE(3)}"
        println "Quantum entanglement (4 groups): ${balancer.getQE(4)}"
    }
}
