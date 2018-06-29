package year_2015.day_22

class ManaCalculator {

    private Hero hero
    private Hero boss

    int minMpSpent = -1

    ManaCalculator(List<String> bossStats) {
        List<Integer> stats = bossStats.collect { Integer.valueOf(it.split(': ')[1]) }
        boss = new Hero(hp: stats.get(0), dmg: stats.get(1))
        hero = new Hero(hp: 50, mp: 500)
    }

    int getMinMp() {
        minMpSpent = -1
        simulateBattle(hero.new, boss.new)
    }

    int getMinMpHard() {
        minMpSpent = -1
        simulateBattle(hero.new, boss.new,true)
    }
    private int simulateBattle(Hero hero, Hero boss, boolean reduceHp = false, boolean heroTurn = true, int mpSpent = 0, List<Spell> activatedSpells = []) {
        if (minMpSpent > 0 && mpSpent > minMpSpent) {
            return -1
        }

        if (reduceHp) {
            if (boss.hp <= 0) {
                return mpSpent
            }

            if (heroTurn) {
                hero.hp--
                if (hero.hp <= 0) {
                    return -1
                }
            }
        }

        int tempArmor = 0

        activatedSpells.findAll{ it.turns > 0 }.each { spell ->
            hero.mp+= spell.turnMp
            boss.hp-= spell.turnDmg
            tempArmor+=spell.turnArmor
            spell.turns--
        }

        if (boss.hp > 0) {
            if (heroTurn) {
                return allSpells.findAll { s ->
                    hero.mp >= s.cost && activatedSpells.find { it.turns > 0 && it.name == s.name } == null
                }.collect { spell ->
                    Hero newHero = hero.new
                    Hero newBoss = boss.new

                    List<Spell> list = (List<Spell>) activatedSpells.collect { it.new }
                    list.add(spell)

                    newHero.hp+=spell.instantHeal
                    newBoss.hp-=spell.instantDmg
                    newHero.mp-=spell.cost

                    return simulateBattle(newHero, newBoss, reduceHp, !heroTurn, mpSpent + spell.cost, list)
                }.findAll {
                   it > 0
                }.min() ?: -1
            } else {
                hero.hp-= Math.max(1, boss.dmg - tempArmor)
                if (hero.hp > 0) {
                    return simulateBattle(hero.new, boss.new, reduceHp, !heroTurn, mpSpent, activatedSpells)
                } else {
                    return -1
                }

            }
        }

        if (minMpSpent < 0 || minMpSpent > mpSpent) {
            minMpSpent = mpSpent
        }

        mpSpent
    }

    private static List<Spell> getAllSpells() {
        [new Spell(name: 'Magic Missile', cost: 53, instantDmg: 4),
         new Spell(name: 'Drain', cost: 73, instantDmg: 2, instantHeal: 2),
         new Spell(name: 'Shield', cost: 113, turns: 6, turnArmor: 7),
         new Spell(name: 'Poison', cost: 173, turns: 6, turnDmg: 3),
         new Spell(name: 'Recharge', cost: 229, turns: 5, turnMp: 101)
        ]
    }

    private static class Hero {
        int hp = 0
        int mp = 0
        int dmg = 0

        private Hero getNew() {
            new Hero(hp: hp, mp: mp, dmg: dmg)
        }
    }

    private static class Spell {

        private String name
        private int cost = 0
        private int instantDmg = 0
        private int instantHeal = 0
        private int turns = 0
        private int turnArmor = 0
        private int turnDmg = 0
        private int turnMp = 0

        private Spell getNew() {
            new Spell(name: name, cost: cost, instantDmg: instantDmg, instantHeal: instantHeal, turns: turns, turnArmor: turnArmor, turnDmg: turnDmg, turnMp: turnMp)
        }
    }

}
