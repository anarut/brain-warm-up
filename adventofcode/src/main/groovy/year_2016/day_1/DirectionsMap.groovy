package year_2016.day_1

class DirectionsMap {

    private static final String SPLITTER = ', '
    private static final String LEFT = 'L'
    private String map
    private Point point = new Point()

    DirectionsMap(String map) {
        this.map = map
        init()
    }

    int getBlocksAway() {
        point.distance
    }

    int getVisitedTwiceDistance() {
        Math.abs(point.visitedTwice[0]) + Math.abs(point.visitedTwice[1])
    }

    private void init() {
        map.split(SPLITTER).each { String turn ->
            point.turn(turn.startsWith(LEFT))
            point.move(Integer.valueOf(turn.substring(1)))
        }
    }

    private class Point {
        private int x = 0
        private int y = 0

        private int direction = 0
        private Set visitedPoints = [[x, y]]
        private List<Integer> visitedTwice = []


        private turn(boolean left) {
            direction += left ? - 1 : 1
        }

        private void move(int steps) {
            int x1 = x
            int y1 = y

            if (direction % 2 == 0) {
                y+= direction % 4 ? steps : - steps
            } else {
                x+= (direction - 1) % 4 ? steps : - steps
            }

            if (visitedTwice.empty) {
                markRoute(x1, y1)
            }
        }

        private void markRoute(int x1, int y1) {
            (x1..x).each { x ->
                (y1..y).each { y ->
                    if (!(x1 == x && y1 == y)) {
                        if (visitedPoints.contains([x, y]) && visitedTwice.empty) {
                            visitedTwice.addAll([x, y])
                        } else {
                            visitedPoints.add([x, y])
                        }
                    }
                }
            }
        }

        private int getDistance() {
            Math.abs(x) + Math.abs(y)
        }
    }
}
