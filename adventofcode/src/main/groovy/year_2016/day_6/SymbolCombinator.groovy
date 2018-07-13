package year_2016.day_6

class SymbolCombinator {

    private List<String> lines

    SymbolCombinator(List<String> lines) {
        this.lines = lines
    }

    String getMostFrequentMessage() {
        getMessage()
    }

    String getLeastCommonMessage(){
        getMessage(false)
    }

    private String getMessage(boolean mostFrequent = true) {
        Map<Integer, Map<String, Integer>> map = [:]

        lines.each { line ->
            (1..line.length()).each { Integer i ->
                if (!map.containsKey(i)) {
                    map.put(i, [:])
                }
                map.get(i).put(line[i - 1], ++(map.get(i).get(line[i - 1]) ?: 0))
            }
        }

        map.collect { k, v -> v.sort { e -> mostFrequent ? -e.value : e.value }.keySet()[0]}.join()
    }
}
