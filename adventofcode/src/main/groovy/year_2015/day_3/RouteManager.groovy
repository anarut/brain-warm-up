package year_2015.day_3

class RouteManager {

    private String instructions

    RouteManager(String instructions) {
        this.instructions = instructions
    }

    int getUniquePlacesCount() {
        Set set = new HashSet()
        int i = 0
        int j = 0
        
        set.add([i, j])

        instructions.each { String step ->
            switch (step) {
                case '>':
                    i++
                    break
                case '<':
                    i--
                    break
                case '^':
                    j++
                    break
                case 'v':
                    j--
                    break
                default:
                    throw new Exception("incorrect instruction: ${step}")
            }
            set.add([i, j])
        }
        
        set.size()
    }
    
    int getUniquePlacesCountWithRobot() {
        Set set = new HashSet()
        int i1 = 0
        int j1 = 0
        int i2 = 0
        int j2 = 0
        
        boolean reverse = true
        
        set.add([i1, j1])

        instructions.each { String step ->
            switch (step) {
                case '>':
                    reverse ? i1++ : i2++
                    break
                case '<':
                    reverse ? i1-- : i2--
                    break
                case '^':
                    reverse ? j1++ : j2++
                    break
                case 'v':
                    reverse ? j1-- : j2--
                    break
                default:
                    throw new Exception("incorrect instruction: ${step}")
            }

             
            set.add(reverse ? [i1, j1] : [i2, j2])
            
            reverse = !reverse
        }

        set.size()
    }
}
