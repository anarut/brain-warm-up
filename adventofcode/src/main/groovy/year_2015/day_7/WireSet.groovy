package year_2015.day_7

class WireSet {

    private static final String EX = ' -> '

    private List<String> instructions
    private Map<String, Integer> tempMap = [:]

    WireSet(List<String> instructions) {
        this.instructions = instructions
    }

    int getSignalForWireA() {
        return getSignalFor('a')
    }

    int getSignalForWireAwithOverridenB() {
        int a = getSignalFor('a')
        tempMap = ['b' : a]
        return getSignalFor('a')
    }

    private int getSignalFor(String name) {
        if (name.isInteger()) {
            return Integer.valueOf(name)
        } else if (tempMap.get(name)) {
            return tempMap.get(name)
        } else {
            String[] args = instructions.find  { l -> l.endsWith("${EX}${name}") }.split(EX)[0].split()

            int value

            switch (args.size()) {
                case 1:
                    value = getSignalFor(args[0])
                    break
                case 2:
                    value = apply(args[0], getSignalFor(args[1]))
                    break
                case 3:
                    value = apply(args[1], getSignalFor(args[0]), getSignalFor(args[2]))
                    break
                default:
                    throw new IllegalArgumentException()
            }

            tempMap.put(name, value)
            return value
        }
    }

    private static int apply(String operator, int... args) {
        switch (operator) {
            case 'AND':
                return args[0] & args[1]
            case 'OR' :
                return args[0] | args[1]
            case 'LSHIFT':
                return args[0] << args[1]
            case 'RSHIFT':
                return args[0] >> args[1]
            case 'NOT':
                return ~args[0]
        }
    }
}