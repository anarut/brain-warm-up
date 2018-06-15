package year_2015.day_17

class WaterCombinator {

    private static final int AMOUNT = 150

    private List<Integer> bottles

    WaterCombinator(List<String> bottles) {
        this.bottles = bottles.collect { b -> Integer.valueOf(b) }.sort()
    }

    int getAllCombinations() {
        search(0, bottles.size() - 1, AMOUNT).size()
    }

    int getAllCombinationsWithMinBottles() {
        List<Integer> allCombinations = search(0, bottles.size() - 1, AMOUNT)
        int min = allCombinations.min()

        allCombinations.findAll { c -> c == min }.size()
    }

    private List<Integer> search(int index, int lastIndex, int amountLeft, int containersUsed = 0) {
        List<Integer> combinations = []
        (index..lastIndex).each { i ->
            int left = amountLeft - bottles[i]
            int used = containersUsed + 1

            if (left == 0) {
                combinations.add(used)
            } else if (left > 0 && i < lastIndex) {
                combinations.addAll(search(i + 1, lastIndex, left, used))
            }
        }
        combinations
    }
}