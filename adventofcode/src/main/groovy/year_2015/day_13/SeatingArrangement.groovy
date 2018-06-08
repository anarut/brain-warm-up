package year_2015.day_13

class SeatingArrangement {

    private static final String POS = 'gain'

    private List<String> settings

    private Map<String, Map<String, Integer>> keyMap = [:]
    private List<List<String>> allCases = []

    SeatingArrangement(List<String> settings) {
        this.settings = settings
        parse()
    }

    int getTotalChange() {
        allCases.clear()
        findAllCases([keyMap.keySet()[0]])
        allCases.collect { list ->
            int sum = 0
            for (int i = 0; i < list.size(); i++) {
                Map<String, Integer> map = keyMap.get(list[i])
                sum += map.get(list[i - 1 < 0 ? list.size() - 1 : i - 1]) + map.get(list[i + 1 > list.size() - 1 ? 0 : i + 1])
            }
            sum
        }.max()
    }

    int getTotalChangePlusNeutral() {
        allCases.clear()
        findAllCases()
        allCases.collect { list ->
            int sum = 0
            for (int i = 0; i < list.size(); i++) {
                Map<String, Integer> map = keyMap.get(list[i])

                if (i > 0) {
                    sum += map.get(list[i - 1])
                }

                if (i < list.size() - 1) {
                    sum += map.get(list[ i + 1])
                }
            }
            sum
        }.max()
    }

    private void parse() {
        settings.each { line->
            String[] split = line.replace('.', '').split()

            String who = split[0]
            String toPerson = split[10]
            Integer diff = Integer.valueOf(split[3]) * (split[2] == POS ? 1 : -1)

            if (keyMap.get(who) == null) {
                keyMap.put(who, [:])
            }

            keyMap.get(who).put(toPerson, diff)
        }
    }

    private void findAllCases(List<String> alreadyUsed = []) {
        keyMap.keySet().findAll { l -> !alreadyUsed.contains(l)}.each { l ->
            List<String> used = (List<String>) alreadyUsed.clone()
            used.add(l)
            if (keyMap.keySet().size() == used.size()) {
                allCases.add(used)
            }

            findAllCases(used)
        }
    }
}
