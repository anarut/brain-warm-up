package year_2015.day_24

class Balancer {

    List<BigInteger> packages

    Balancer(List<String> packages) {
        this.packages = packages.collect { BigInteger.valueOf(Long.valueOf(it)) }.sort()
    }

    BigInteger getQE(int countOfGroups) {
        (BigInteger) findGroups((BigInteger) (packages.sum() / countOfGroups), packages.size() - 1)
                .collect{ it.inject((BigInteger) 1) { a, b -> a * b } }
                .min()
    }

    private List<List<BigInteger>> findGroups(BigInteger remaining, int index, List<BigInteger> group = []) {
        if (remaining == 0) {
            return [group]
        } else if (remaining < 0) {
            return []
        } else {
            List<List<BigInteger>> groups = []
            for (int i = index; i >= 0; i --) {
                if (packages[i] <= remaining) {
                    List<BigInteger> newGroup = (List<BigInteger>) group.clone()
                    newGroup.add(packages[i])
                    groups.addAll(findGroups(remaining - packages[i], i - 1, newGroup))
                }
            }

            return groups
        }


    }
}
