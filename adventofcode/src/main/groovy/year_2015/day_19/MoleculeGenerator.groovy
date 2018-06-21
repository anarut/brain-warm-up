package year_2015.day_19

class MoleculeGenerator {

    private static final String SEQUENCE = ' => '
    private static final String ELECTRON = 'e'


    private List<Replacement> replacements
    private String baseFormula

    MoleculeGenerator(List<String> instructions) {
        replacements = (0..instructions.size() - 3).collect { i -> new Replacement(instructions.get(i)) }
        baseFormula = instructions.get(instructions.size() - 1)
    }

    int getDistinctMolecules() {
        generateNewMolecules([baseFormula] as Set).size()
    }

    int getNumberOfSteps() {
        int count = 0
        String molecule = baseFormula

        while (molecule != ELECTRON) {
            String current = molecule

            replacements.each { r ->
                int index = molecule.indexOf(r.to)
                if (index >= 0) {
                    molecule = molecule.substring(0, index) + r.from + molecule.substring(index + r.to.length())
                    count++
                }
            }

            if (current == molecule) {
                molecule = baseFormula
                count = 0
                Collections.shuffle(replacements)
            }
        }

        count
    }

    private Set<String> generateNewMolecules(Set<String> baseMolecules, boolean reverse = false) {
        Set<String> newMolecules = []

        baseMolecules.each { baseMolecule ->
            replacements.each { r ->
                String from = reverse ? r.to : r.from
                String to = reverse ? r.from : r.to

                if (baseMolecule == from) {
                    newMolecules.add(to)
                } else {
                    int index = 0
                    def fromLength = from.length()
                    def k = baseMolecule.split(from)

                    k.each { s ->
                        index+= s.length()
                        if (baseMolecule.length() != index ) {
                            newMolecules.add(baseMolecule.substring(0, index) + to + baseMolecule.substring(index + fromLength))
                            index+= fromLength
                        }
                    }
                }
            }
        }

        newMolecules
    }


    private class Replacement {

        private String from
        private String to

        private Replacement(String line) {
            String[] split = line.split(SEQUENCE)
            from = split[0]
            to = split[1]
        }
    }
}
