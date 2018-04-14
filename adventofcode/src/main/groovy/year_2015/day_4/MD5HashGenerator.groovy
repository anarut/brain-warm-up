package year_2015.day_4

import java.security.MessageDigest

class MD5HashGenerator {

    private static final String ALGORITHM = 'MD5'
    
    private static final String PREFIX_5_ZERO = '00000'
    private static final String PREFIX_6_ZERO = '000000'
    
    private String key
    
    MD5HashGenerator(String key) {
        this.key = key
    }

    String getAnswerWith5Zero() {
        getAnswer(PREFIX_5_ZERO)
    }

    String getAnswerWith6Zero() {
        getAnswer(PREFIX_6_ZERO)
    }
    
    private String getAnswer(String prefix) {
        boolean resultFound = false
        int i = 0
        
        while (!resultFound) {
            i++
            String hash = generateMD5("${key}${i}")
            if (hash.startsWith(prefix)) {
                resultFound = true
            }
        }
        
        i
    }

    private static String generateMD5(String s) {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM)
        digest.update(s.bytes)
        new BigInteger(1, digest.digest()).toString(16).padLeft(32, '0')
    }
}