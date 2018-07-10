package year_2016.day_2

class SecurityCode {

    private static final String UP = 'U'
    private static final String DOWN = 'D'
    private static final String LEFT = 'L'
    private static final String RIGHT = 'R'

    private List<String> instructions

    SecurityCode(List<String> instructions) {
        this.instructions = instructions
    }

    String getCode() {
        String result = ''

        Point point = new Point()

        instructions.each { line ->
            line.each { move(point, it) }
            result += 5 + point.x + point.y * 3
        }

        result
    }

    String getCorrectCode() {
        String result = ''

        Point point = new Point(x: -2, y: 0)

        instructions.each { line ->
            line.each { move2(point, it) }
            result+=  getSign(7 + point.x + point.y * (Math.abs(point.y) == 1 ? 4 : 3))
        }

        result
    }


    private String getSign(int sign) {
        switch (sign) {
            case 10:
                return 'A'
            case 11:
                return 'B'
            case 12:
                return 'C'
            case 13:
                return 'D'
            default:
                return sign
        }
    }

    private void move(Point p, String direction) {
        switch (direction) {
            case UP:
                p.y -= p.y == -1 ? 0 : 1
                break
            case DOWN:
                p.y += p.y == 1 ? 0 : 1
                break
            case LEFT:
                p.x -= p.x == -1 ? 0 : 1
                break
            case RIGHT:
                p.x += p.x == 1 ? 0 : 1
                break
            default:
                throw new IllegalArgumentException()
        }
    }

    private void move2(Point p, String direction) {

        switch (direction) {
            case UP:
                p.y -= (Math.abs(p.x) + Math.abs(p.y - 1) > 2) ? 0 : 1
                break
            case DOWN:
                p.y += (Math.abs(p.x) + Math.abs(p.y + 1) > 2) ? 0 : 1
                break
            case LEFT:
                p.x -= (Math.abs(p.x - 1) + Math.abs(p.y) > 2) ? 0 : 1
                break
            case RIGHT:
                p.x += (Math.abs(p.x + 1) + Math.abs(p.y) > 2) ? 0 : 1
                break
            default:
                throw new IllegalArgumentException()
        }
    }

    private class Point {

        private int x = 0
        private int y = 0

        private Point(int x = 0, int y = 0){
            this.x = x
            this.y = y
        }
    }
}
