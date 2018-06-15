package year_2015.day_16

/**
 * Crime Scene Analysis Machine
 */
class CSAM {

    private static final Map<String, Integer> TICKER_TAP = [
            children: 3,
            cats: 7,
            samoyeds: 2,
            pomeranians: 3,
            akitas: 0,
            vizslas: 0,
            goldfish: 5,
            trees: 3,
            cars: 2,
            perfumes: 1
    ]

    private static final int PROP_COUNT = 3

    private Map<Integer, Map<String, Integer>> auntList = [:]

    CSAM(List<String> list) {
        list.each { line ->
            String[] split = line
                    .replace(':', '')
                    .replace(',', '')
                    .split()
            Integer number = Integer.valueOf(split[1])

            auntList.put(number, parse(split))
        }
    }

    private static Map<String, Integer> parse(String[] line) {
        Map<String, Integer> prop = [:]
        prop.put(line[2], Integer.valueOf(line[3]))
        prop.put(line[4], Integer.valueOf(line[5]))
        prop.put(line[6], Integer.valueOf(line[7]))
        prop
    }

    int getNumberOfAuntSue() {
        findAunt()
    }

    int getRealNumberOfAuntSue() {
        findAunt(true)
    }

    private int findAunt(boolean useAdditionalConditions = false) {
        auntList.findAll { k, v ->
            v.keySet().findAll { key ->
                if (useAdditionalConditions) {
                    switch (key) {
                        case 'cats':
                        case 'trees':
                            return v.get(key) > TICKER_TAP.get(key)
                        case 'goldfish':
                        case 'pomeranians':
                            return v.get(key) < TICKER_TAP.get(key)
                        default:
                            v.get(key) == TICKER_TAP.get(key)
                    }
                } else {
                    v.get(key) == TICKER_TAP.get(key)
                }
            }.size() == PROP_COUNT
        }.keySet()[0]
    }
}



