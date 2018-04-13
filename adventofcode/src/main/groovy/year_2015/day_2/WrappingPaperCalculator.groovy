package year_2015.day_2

class WrappingPaperCalculator {
    
    private List<String> boxDimensionsList
    
    WrappingPaperCalculator(List<String> boxDimensionsList) {
        this.boxDimensionsList = boxDimensionsList
    }
    
    int getWrappingPaperSize() {
        int result = 0
        boxDimensionsList.each { dimensions ->
            List<Integer> size = dimensions.split('x').collect { Integer.valueOf(it) }.sort()
            result += 2 * (size[0] * size[1] + size[1] * size[2] + size[0] * size[2]) + size[0] * size[1]
        }
        
        result
    }
    
    int getRibbonFeet() {
        int result = 0
        boxDimensionsList.each { dimensions ->
            List<Integer> size = dimensions.split('x').collect { Integer.valueOf(it) }.sort()
            result += 2 * (size[0] + size[1]) + size[0] * size[1] * size[2]
        }
        result
    }
    
}
