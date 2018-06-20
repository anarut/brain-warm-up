package year_2015.day_18

class LightToggleManager {

    private static final String ON = '#'

    private int size
    private int[][] lightMap

    LightToggleManager(List<String> lines) {
        size = lines.size()
        lightMap = new int[size][size]

        (0..size - 1).each { i ->
            (0..size - 1).each { j ->
                lightMap[i][j] = lines.get(i)[j] == ON ? 1 : 0
            }
        }
    }

    int lightsOnAfter(int steps, boolean cornersAlwaysOn = false) {
        int[][] result = lightMap
        (1..steps).each { i ->
            result = toggle(result, size, cornersAlwaysOn)
        }

        (int) result.collect { m -> m.findAll().size() }.sum()
    }

    private static int[][] toggle(int[][] map, int size, boolean cornersAlwaysOn) {
        int[][] result = new int[size][size]
        (0..size - 1).each { i ->
            (0..size - 1).each { j ->
                result[i][j] = (cornersAlwaysOn && isCorner(i, j, size - 1)) ? 1 : get(map, i, j, size - 1)
            }
        }
        return result
    }

    private static boolean isCorner(int i, int j, int range) {
        ((i == 0) || (i == range)) && ((j == 0) || (j == range))
    }


    private static int get(int[][] map, int i, int j, int range) {
        int lightsCount = 0

        if (i - 1 >= 0 && j - 1 >= 0) {
            lightsCount+= map[i - 1][j - 1]
        }
        if (i - 1 >= 0) {
            lightsCount+= map[i - 1][j]
        }
        if (i - 1 >= 0 && j + 1 <= range) {
            lightsCount+= map[i - 1][j + 1]
        }
        if (j + 1 <= range) {
            lightsCount+= map[i][j + 1]
        }
        if (i + 1 <= range && j + 1 <= range) {
            lightsCount+= map[i + 1][j + 1]
        }
        if (i + 1 <= range) {
            lightsCount+= map[i + 1][j]
        }
        if (i + 1 <= range && j - 1 >= 0) {
            lightsCount+= map[i + 1][j - 1]
        }
        if (j - 1 >= 0) {
            lightsCount+= map[i][j - 1]
        }

        ((lightsCount == 3) || (map[i][j] == 1 && lightsCount == 2)) ? 1 : 0
    }
}
