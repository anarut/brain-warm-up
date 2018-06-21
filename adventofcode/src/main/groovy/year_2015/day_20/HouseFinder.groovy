package year_2015.day_20

class HouseFinder {

    private int numberOfPresents

    HouseFinder(String numberOfPresents) {
        this.numberOfPresents = Integer.valueOf(numberOfPresents)
    }

    int getHouseNumber() {
        getMinHouseNumber(numberOfPresents, 10)

    }

    int getNewHouseNumber() {
        getMinHouseNumber(numberOfPresents, 11, 50)
    }

    private static int getMinHouseNumber(int numberOfPresents, int giftsCount, int maxVisits = numberOfPresents) {
        int result = numberOfPresents
        int max = (int) numberOfPresents / giftsCount

        List<Integer> houses = [].withDefault { 0 }

        (1..max).each { i ->
            int visits = 0
            for (int j = i; j < max && visits < maxVisits; j+=i) {
                if ((houses[j]+=i*giftsCount) >= numberOfPresents && j < result) {
                    result = j
                }
                visits++
            }
        }
        result
    }
}
