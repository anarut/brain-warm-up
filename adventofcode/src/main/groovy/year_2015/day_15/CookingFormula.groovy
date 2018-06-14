package year_2015.day_15

class CookingFormula {

    private static final int COUNT = 100
    private static final int CALORIE_TOTAL = 500

    private List<Ingredient> ingredients

    CookingFormula(List<String> ingredients) {
        this.ingredients = ingredients.collect { i ->
            String[] split = i.replace(',', '').split()
            new Ingredient(
                    Integer.valueOf(split[2]),
                    Integer.valueOf(split[4]),
                    Integer.valueOf(split[6]),
                    Integer.valueOf(split[8]),
                    Integer.valueOf(split[10]))
        }
    }

    int getBestResult() {
        findBestResult()
    }

    int getBestResultWithCalorie() {
        findBestResult(true)
    }

    private int findBestResult(boolean includeCalorie = false) {
        FormulaIterator iterator = new FormulaIterator(ingredients.size(), COUNT)

        List<Integer> currentFormula = iterator.formula

        int bestResult = calculate(ingredients, currentFormula, includeCalorie)

        while (iterator.next()) {
            currentFormula = iterator.formula
            int result = calculate(ingredients, currentFormula, includeCalorie)
            if (bestResult < result) {
                bestResult = result
            }
        }

        bestResult
    }


    private static int calculate(List<Ingredient> ingredients, List<Integer> formula, boolean includeCalorie) {
        int capacity = 0
        int durability = 0
        int flavor = 0
        int texture = 0
        int calories = 0

        (0..(ingredients.size() - 1)).each { i ->
            capacity += ingredients[i].capacity * formula[i]
            durability += ingredients[i].durability * formula[i]
            flavor += ingredients[i].flavor * formula[i]
            texture += ingredients[i].texture * formula[i]
            calories += ingredients[i].calories * formula[i]
        }

        List<Integer> s = [capacity, durability, flavor, texture]

        ((includeCalorie && calories != CALORIE_TOTAL) || s.min() <= 0) ? 0 : (int) s.inject(1) { a, b -> a * b }
    }

    private class FormulaIterator {

        private int uniqueItems
        private int count

        List<Integer> formula = []

        private FormulaIterator(int uniqueItems, int count) {
            this.uniqueItems = uniqueItems
            this.count = count
            this.init()
        }

        private void init() {
            (2..uniqueItems).each {
                formula.add(0)
            }
            formula.add(count)
        }

        private boolean next() {
            if (formula[0] == count) {
                return false
            }

            for(int i = uniqueItems - 1; i > 0; i--) {
                if (formula[i] > 0) {
                    formula[i - 1]++
                    formula[i]--
                    if (i != uniqueItems - 1) {
                        formula[uniqueItems - 1] = formula[i]
                        formula[i] = 0
                    }

                    break
                }
            }
            true
        }
    }

    private class Ingredient {

        private int capacity
        private int durability
        private int flavor
        private int texture
        private int calories

        private Ingredient(int capacity, int durability, int flavor, int texture, int calories) {
            this.capacity = capacity
            this.durability = durability
            this.flavor = flavor
            this.texture = texture
            this.calories = calories
        }
    }
}
