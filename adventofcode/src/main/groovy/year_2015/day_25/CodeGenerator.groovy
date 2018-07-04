package year_2015.day_25

class CodeGenerator {

    private int row
    private int column
    private BigInteger initialValue = 20151125

    BigInteger multiplier = 252533
    BigInteger divider = 33554393

    CodeGenerator(String line) {
        row = Integer.valueOf(line.substring(line.indexOf('row') + 4).split(',')[0])
        column = Integer.valueOf(line.substring(line.indexOf('column') + 7).split('\\.')[0])
    }

    BigInteger getCode() {
        def offset = (row + column - 1) * (row + column) / 2 - (row - 1)

        BigInteger currentValue = initialValue

        (2..offset).each {
            currentValue = currentValue * multiplier % divider
        }

        currentValue
    }
}
