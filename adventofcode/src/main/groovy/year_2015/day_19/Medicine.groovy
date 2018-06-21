package year_2015.day_19

/**
 See {@linktourl http://adventofcode.com/2015/day/19}
 */
class Medicine {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2015/day_19/input.txt').toURI())

        MoleculeGenerator generator = new MoleculeGenerator(file.readLines())

        println "Distinct molecules: ${generator.distinctMolecules}"
        println "Fewest number of steps: ${generator.numberOfSteps}"
    }
}
