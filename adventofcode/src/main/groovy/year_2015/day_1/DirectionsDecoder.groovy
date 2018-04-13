package year_2015.day_1

class DirectionsDecoder {
    
    private String instructions

    DirectionsDecoder(String instructions) {
        this.instructions = instructions
    }
    
    int getFloor() {
        int result = 0

        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions[i]) {
                case '(':
                    result++
                    break
                case ')':
                    result--
                    break
                default:
                    throw new Exception("incorrect instructions: ${instructions[i]}")
            }
        }
        result
    }

    int getPosition() {
        int position = 0
        int result = -1
        
        for (int i = 0; i < instructions.length() && result == -1 ; i++) {
            switch (instructions[i]) {
                case '(':
                    position++
                    break
                case ')':
                    position--
                    break
                default:
                    throw new Exception("incorrect instructions: ${instructions[i]}")
            }
            if (position == -1) {
                result = i + 1
            }
        }
        result
    }
}
