package year_2015.day_5

class StringParser {

    private static final String VOWELS = 'aeiou'
            
    private List<String> strings
    
    StringParser(List<String> strings) {
        this.strings = strings
    }
    
    int getNiceStringsCountAtStart() {
        strings.findAll { verifyAtStart(it) }.size()
    }
    
    private static boolean verifyAtStart(String string) {
        boolean result = false
        for (int i = 1; i < string.length() && !result; i++) {
            if (string.charAt(i - 1) == string.charAt(i)) {
                result = true
            }
        }
        
        result && string.findAll { VOWELS.contains(it) }.size() >= 3 && !['ab', 'cd', 'pq', 'xy'].findAll { string.contains(it) }
    }

    int getNiceStringsCountAtEnd() {
        strings.findAll { verifyAtEnd(it) }.size()
    }

    private static boolean verifyAtEnd(String string) {
        boolean rule1 = false
        boolean rule2 = false
        for (int i = 2; i < string.length() && !(rule1 && rule2); i++) {
            for(int j = i + 1; j < string.length() && !rule1; j++) {
                if (string.substring(i - 2, i) == string.substring(j - 1, j + 1)) {
                    rule1 = true
                }
            }
            
            if (string.charAt(i - 2) == string.charAt(i)) {
                rule2 = true
            }
        }
        
        rule1 && rule2
    }
}