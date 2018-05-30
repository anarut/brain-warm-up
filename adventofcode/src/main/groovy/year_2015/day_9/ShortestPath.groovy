package year_2015.day_9

class ShortestPath {

    private List<String> instructions

    private Set<String> locations = []
    private Map<String, Map<String, Integer>> distanceMap = [:]

    private List<List<String>> allRoutes = []
    private List<Integer> allDistances = []

    ShortestPath(List<String> instructions) {
        this.instructions = instructions

        init()
        findAllRoutes()
        calculateDistance()
    }

    int getMinRoute() {
        allDistances.min()
    }

    int getMaxRoute() {
        allDistances.max()
    }


    private void init() {
        instructions.each { line ->
            int dist = Integer.valueOf(line.split(' = ')[1])
            String[] locs = line.split(' = ')[0].split(' to ')
            locations.addAll(locs)

            locs.each { location ->
                if (!distanceMap.get(location)) {
                    distanceMap.put(location, [:])
                }
            }

            distanceMap.get(locs[0]).put(locs[1], dist)
            distanceMap.get(locs[1]).put(locs[0], dist)
        }
    }

    private void findAllRoutes(List<String> visitedLocations = []) {
        locations.findAll { l -> !visitedLocations.contains(l)}.each { l ->
            List<String> visited = visitedLocations.clone()
            visited.add(l)
            if (locations.size() == visited.size()) {
                allRoutes.add(visited)
            }

            findAllRoutes(visited)
        }
    }

    private void calculateDistance() {
        allDistances = allRoutes.collect { List<String> route ->
            int ditance = 0
            for (int i = 0; i < locations.size() - 1; i++) {
                ditance+= distanceMap.get(route[i]).get(route[i + 1])
            }
            ditance
        }
    }
}
