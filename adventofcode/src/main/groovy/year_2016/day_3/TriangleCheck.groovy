package year_2016.day_3

class TriangleCheck {

    private List<String> triangles

    TriangleCheck(List<String> triangles) {
        this.triangles = triangles
    }

    int getValidTriangles() {
        triangles.collect { line ->
            List<Integer> sides = line.split().collect { Integer.valueOf(it) }.sort()
            new Triangle(sides[0], sides[1], sides[2])
        }.findAll { it.a + it.b > it.c }.size()
    }

    int getValidGroupTriangles() {
        int result = 0
        (1..triangles.size() / 3).each { i ->
            int index = i * 3 - 3
            (0..2).each { j ->
                List<Integer> sides = [triangles[index].split()[j], triangles[index + 1].split()[j], triangles[index + 2].split()[j]]
                        .collect { String s -> Integer.valueOf(s) }
                        .sort()

                if (sides[0] + sides[1] > sides[2]) {
                    result++
                }
            }
        }
        result
    }

    private class Triangle {
        int a
        int b
        int c

        private Triangle(int a, int b, int c) {
            this.a = a
            this.b = b
            this.c = c
        }
    }
}
