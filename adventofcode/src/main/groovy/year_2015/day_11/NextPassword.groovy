package year_2015.day_11

class NextPassword {

    private static char A = 'a'
    private static char Z = 'z'

    private String currentPassword

    NextPassword(String currentPassword) {
        this.currentPassword = currentPassword
    }

    String getNewPassword() {
        increment(currentPassword)
    }

    String getNextOne() {
        increment(increment(currentPassword))
    }

    private static String increment(String password) {
        String result = increment(password, password.length() - 1)

        while (!(increasingStraight(result) && confusingLetters(result) && twoDifferentNonOverlappingPairs(result))) {
            result = increment(result, result.length() - 1)
            println result
        }
        return result
    }

    private static String increment(String password, int index) {
        char n = password.charAt(index)
        if (n == Z) {
            increment(replace(password, index, A), index - 1)
        } else {
            replace(password, index, (char)(n + 1))
        }
    }

    private static String replace(String password, int index, char newChar) {
        password.substring(0, index) + newChar + password.substring(index + 1, password.length())
    }

    private static boolean increasingStraight(String s) {
        boolean passed = false
        for (int i = 0; i < s.length() - 2 && !passed; i++) {
            int first = (int) s.charAt(i)
            int second = (int) s.charAt(i + 1)
            int third = (int) s.charAt(i + 2)
            if (first + 1 == second && second + 1 == third)  {
                passed = true
            }
        }
        passed
    }

    private static boolean confusingLetters(String s) {
        !(s.contains('i') && s.contains('o') && s.contains('l'))
    }

    private static boolean twoDifferentNonOverlappingPairs(String s) {
        (s =~ /(.)\1/).collect { m -> m[0] }.unique().size() > 1
    }
}
