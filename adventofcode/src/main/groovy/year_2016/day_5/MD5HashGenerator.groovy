package year_2016.day_5

import java.security.MessageDigest

class MD5HashGenerator {

    private static final String ALGORITHM = 'MD5'

    private static final int PASSWORD_SIZE = 8
    private static final String PREFIX_5_ZERO = '00000'

    private String key

    MD5HashGenerator(String key) {
        this.key = key
    }

    String getPassword() {
        String password = ''
        int i = 0

        while (password.size() < PASSWORD_SIZE) {
            i++
            String hash = generateMD5("${key}${i}")
            if (hash.startsWith(PREFIX_5_ZERO)) {
                password += hash[PREFIX_5_ZERO.length()]
            }
        }

        password
    }


    String getPassword2() {
        Map<String, String> password = (0..PASSWORD_SIZE - 1).collectEntries { k -> [k.toString(), null] }

        int i = 0
        while (password.values().findAll().size() < PASSWORD_SIZE) {
            i++
            String hash = generateMD5("${key}${i}")
            String index = hash[PREFIX_5_ZERO.length()]
            if (hash.startsWith(PREFIX_5_ZERO) && password.containsKey(index) && !password.get(index)) {
                password.put(index, hash[PREFIX_5_ZERO.length() + 1])
            }
        }

        password.values().join()
    }

    private static String generateMD5(String s) {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM)
        digest.update(s.bytes)
        new BigInteger(1, digest.digest()).toString(16).padLeft(32, '0')
    }
}
