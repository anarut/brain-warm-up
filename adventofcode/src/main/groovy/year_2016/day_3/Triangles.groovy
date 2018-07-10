package year_2016.day_3

/**
 See {@linktourl http://adventofcode.com/2016/day/3}
 */
class Triangles {

    static void main(String[] args) {
        File file = new File(getClass().getResource('/year_2016/day_3/input.txt').toURI())
        TriangleCheck triangleCheck = new TriangleCheck(file.readLines())

        println "Triangles: ${triangleCheck.validTriangles}"
        println "Groups of triangles: ${triangleCheck.validGroupTriangles}"
    }
}
