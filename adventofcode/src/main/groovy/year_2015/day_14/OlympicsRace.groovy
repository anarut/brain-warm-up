package year_2015.day_14

class OlympicsRace {

    private static final int DISTANCE = 2503

    private List<String> participants

    OlympicsRace(List<String> participants) {
        this.participants = participants
    }

    int getMaxDistance() {
        getMaxDistanceAt(DISTANCE)
    }

    int getMaxDistanceAt(int seconds) {
        participants.collect { line ->
            new Participant(Integer.valueOf(line.split()[3]), Integer.valueOf(line.split()[6]), Integer.valueOf(line.split()[13]))
        }.collect { Participant p ->
            int remainingTime = seconds
            boolean run = true

            int distance = 0
            while (remainingTime > 0) {
                if (run) {
                    distance += p.speed * Math.min(p.runTime, remainingTime)
                    remainingTime -= p.runTime
                } else {
                    remainingTime -= p.restTime
                }
                run = !run
            }
            distance
        }.max()
    }

    int getMaxPoints() {
        getMaxPointsAt(DISTANCE)
    }

    int getMaxPointsAt(int seconds) {
        List<Tracker> trackerList = participants.collect { line ->
            new Tracker(new Participant(Integer.valueOf(line.split()[3]), Integer.valueOf(line.split()[6]), Integer.valueOf(line.split()[13])))
        }

        (1..seconds).each { int i ->
            trackerList.each { t -> t.runOneSecond() }
            int maxDist = ((List<Integer>) trackerList*.distanceTraveled).max()

            trackerList.findAll { t -> t.distanceTraveled == maxDist }.each { t -> t.points++}
        }

        ((List<Integer>) trackerList*.points).max()
    }

    private class Participant {

        private int speed
        private int runTime
        private int restTime

        Participant(int speed, int runTime, int restTime) {
            this.speed = speed
            this.runTime = runTime
            this.restTime = restTime
        }
    }

    private class Tracker {

        private Participant participant

        private boolean isRunning = true
        private int timeSpentForAction = 0

        private int distanceTraveled = 0
        private int points = 0

        Tracker(Participant participant) {
            this.participant = participant
        }

        void runOneSecond() {
            timeSpentForAction++
            if (isRunning) {
                distanceTraveled += participant.speed

                if (timeSpentForAction == participant.runTime) {
                    timeSpentForAction = 0
                    isRunning = false
                }

            } else {
                if (timeSpentForAction == participant.restTime) {
                    timeSpentForAction = 0
                    isRunning = true
                }
            }
        }
    }
}
