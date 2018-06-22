package year_2015.day_21

class StatsCalculator {

    private static final List<Item> WEAPONS = [
            new Item(8, 4, 0),
            new Item(10, 5, 0),
            new Item(25, 6, 0),
            new Item(40, 7, 0),
            new Item(74, 8, 0)
    ]

    private static final List<Item> ARMOR = [
            new Item(0, 0, 0),
            new Item(13, 0, 1),
            new Item(31, 0, 2),
            new Item(53, 0, 3),
            new Item(75, 0, 4),
            new Item(102, 0, 5)
    ]

    private static final List<Item> RINGS = [
            new Item(0, 0, 0),
            new Item(0, 0, 0),
            new Item(20, 0, 1),
            new Item(25, 1, 0),
            new Item(40, 0, 2),
            new Item(50, 2, 0),
            new Item(80, 0, 3),
            new Item(100, 3, 0)
    ]

    private Hero boss

    private List<Hero> allCases

    StatsCalculator(List<String> bossStats) {
        List<Integer> stats = bossStats.collect { Integer.valueOf(it.split(': ')[1]) }
        boss = new Hero(stats.get(0), stats.get(1), stats.get(2))
    }

    int getMinCost() {
        allCases = allCases ?: getAllCases().sort { Hero h -> h.cost }

        for (int i = 0; i < allCases.size(); i++) {
            if (simulate(allCases.get(i), boss)) {
                return allCases.get(i).cost
            }
        }

        -1
    }

    int getMaxCost() {
        allCases = allCases ?: getAllCases()

        int maxCost = 0
        allCases.each { Hero hero ->
            if (!simulate(hero, boss) && hero.cost > maxCost) {
                maxCost = hero.cost
            }
        }

        maxCost
    }


    private List<Hero> getAllCases() {
        List<List<Item>> allItemCases = []
        WEAPONS.each { w ->
            ARMOR.each { d ->
                (0..RINGS.size() - 2).each { i1 ->
                    (i1 + 1..RINGS.size() - 1).each { i2 ->
                        allItemCases.add([w, d, RINGS.get(i1), RINGS.get(i2)])
                    }
                }
            }
        }

        allItemCases.collect { List<Item> items ->
            int cost = (int) items.collect { Item it -> it.cost }.sum()
            int damage = (int) items.collect { Item it -> it.damage }.sum()
            int armor = (int) items.collect { Item it -> it.armor }.sum()
            new Item(cost, damage, armor)
        }.collect { Item it ->
            new Hero(100, it.damage, it.armor, it.cost)
        }
    }


    private static boolean simulate(Hero hero, Hero boss) {
        int bossHit = Math.max(boss.damage - hero.armor, 1)
        int heroHit = Math.max(hero.damage - boss.armor, 1)

        int roundsBossFall = (int) boss.health / heroHit + (boss.health % heroHit == 0 ? 0 : 1) - 1
        int roundsHeroFall = (int) hero.health / bossHit + (hero.health % bossHit == 0 ? 0 : 1)

        roundsBossFall < roundsHeroFall
    }

    private class Hero {

        int health
        int damage
        int armor
        int cost

        Hero(int health = 0, int damage = 0, int armor = 0, int cost = 0) {
            this.health = health
            this.damage = damage
            this.armor = armor
            this.cost = cost
        }
    }

    private static class Item {

        final int cost
        final int damage
        final int armor

        Item(int cost, int damage, int armor) {
            this.cost = cost
            this.damage = damage
            this.armor = armor
        }
    }
}
