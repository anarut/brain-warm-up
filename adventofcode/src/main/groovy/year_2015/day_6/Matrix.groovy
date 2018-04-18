package year_2015.day_6

import java.util.function.Function

class Matrix {

    private static final int MAX_SIZE = 1000
    
    private List<String> instructions

    Matrix(List<String> instructions) {
        this.instructions = instructions
    }
    
    int getLitLightsCount() {
        boolean[][] matrix = new boolean[MAX_SIZE][MAX_SIZE]
        
        instructions.each { String instruction ->
            String[] parts = instruction.split(' ')
            String ruleName = parts.size() == 4 ? parts[0] : "${parts[0]} ${parts[1]}"
            
            String[] begin = (parts.size() == 4 ? parts[1] : parts[2]).split(',')
            String[] end = (parts.size() == 4 ? parts[3] : parts[4]).split(',')

            Integer rowStart = Integer.valueOf(begin[0])
            Integer columnStart = Integer.valueOf(begin[1])
            Integer rowEnd = Integer.valueOf(end[0])
            Integer columnEnd = Integer.valueOf(end[1])
            
            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    matrix[i][j] = getLitRule(ruleName).apply(matrix[i][j])
                }
            }
        }
        
        int count = 0
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (matrix[i][j]) {
                    count++
                }
            }
        }
        
        count
    }
    
    private Function<Boolean, Boolean> getLitRule(String ruleName) {
        switch (ruleName) {
            case 'turn on':
                return { Boolean value ->  true }
            case 'turn off':
                return { Boolean value ->  false }
            case 'toggle':
                return { Boolean value ->  !value }
            default: 
                 throw new Exception("incorrect instructions: ${ruleName}")
        }
    }

    int getTotalBrightness() {
        int [][] matrix = new int[MAX_SIZE][MAX_SIZE]

        instructions.each { String instruction ->
            String[] parts = instruction.split(' ')
            String ruleName = parts.size() == 4 ? parts[0] : "${parts[0]} ${parts[1]}"

            String[] begin = (parts.size() == 4 ? parts[1] : parts[2]).split(',')
            String[] end = (parts.size() == 4 ? parts[3] : parts[4]).split(',')

            Integer rowStart = Integer.valueOf(begin[0])
            Integer columnStart = Integer.valueOf(begin[1])
            Integer rowEnd = Integer.valueOf(end[0])
            Integer columnEnd = Integer.valueOf(end[1])

            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    matrix[i][j] = getBrightnessRule(ruleName).apply(matrix[i][j])
                }
            }
        }

        int totalBrightness = 0
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                totalBrightness+=matrix[i][j]
            }
        }

        totalBrightness
    }

    private Function<Integer, Integer> getBrightnessRule(String ruleName) {
        switch (ruleName) {
            case 'turn on':
                return { int value ->  value + 1 }
            case 'turn off':
                return { int value ->  value == 0 ? 0 : value - 1 }
            case 'toggle':
                return { int value ->  value + 2 }
            default:
                throw new Exception("incorrect instructions: ${ruleName}")
        }
    }
}
