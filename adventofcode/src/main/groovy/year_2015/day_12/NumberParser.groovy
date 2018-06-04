package year_2015.day_12

import groovy.json.JsonSlurper

class NumberParser {

    private static final String MATCHER = /-?\d+/
    private static final String RED = 'red'

    private String json

    NumberParser(String json) {
        this.json = json
    }

    int getSum() {
        calculate(json)
    }

    int getUpdatedSum() {
        Map map = (Map) new JsonSlurper().parseText(json)
        map = ignoreRed(map)
        calculate(map.toString())
    }

    private static int calculate(String string) {
        (string =~ MATCHER).collect { Integer.valueOf(it) }.sum()
    }

    private static Map ignoreRed(Map map) {
        map = map.find { k, v -> RED == v } ? [ : ] : map
        map.findAll{ k, v -> v instanceof Map }.each { k, v -> map.put(k, ignoreRed((Map) v)) }
        map.findAll{ k, v -> v instanceof List }.each { k, v -> findMap(v) }
        map
    }

    private static void findMap(List list) {
        list.findAll { v -> v instanceof Map }.each { Map v ->
            list.remove(v)
            list.add(ignoreRed(v))
        }
        list.findAll { v -> v instanceof List }.each { List v -> findMap(v) }
    }
}
