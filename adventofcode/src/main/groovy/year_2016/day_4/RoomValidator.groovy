package year_2016.day_4

class RoomValidator {

    private static final int LETTERS_COUNT = 26
    private static final String STORAGE_NAME = 'northpole object storage'

    private List<Room> rooms

    RoomValidator(List<String> data) {
        this.rooms = data.collect { new Room(it) }
    }

    int getSumOfIds() {
        (int) rooms.findAll { it.validate() }.collect { it.sectorID }.sum()
    }

    int getRealSectorId() {
        rooms.findAll { it.validate() }.find { r ->
            (r.encryptedName as List).collect { it ->
                if (it == '-' ) {
                    ' '
                } else {
                    int index = (int) it
                    int shift = r.sectorID % LETTERS_COUNT
                    (index + shift > (int) 'z' ? index + shift - LETTERS_COUNT : index + shift) as char
                }
            }.join() == STORAGE_NAME
        }.sectorID
    }

    private class Room {

        private String encryptedName
        private int sectorID
        private String checksum

        private Room(String line) {
            this.encryptedName = line.replaceAll(/-\d.+/, '')
            this.sectorID = Integer.valueOf(line.replaceAll(/\D/, ''))
            this.checksum = line.replaceAll(/.+\[(\w+)]/, '$1')
        }

        private boolean validate() {
            Map<String, Integer> map = (encryptedName.replaceAll(/-/, '') as List).groupBy { it -> (it) }.collectEntries { k, v -> [k, v.size()] }.sort { e -> -e.value }
            map.collect { it.value }.join().substring(0, 5) == (checksum as List).collect{ it -> map.get(it) ?:0 }.join()
        }
    }
}

