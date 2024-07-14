package de.brunokrams.schedulebuilder;

import java.util.List;

public class DfsScheduler<T> implements Scheduler<T> {
    @Override
    public Schedule<T> create(List<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        return null;

//        List<Pairing<T>> allPairings = calculateAllPairings();
    }

//    private List<Pairing<T>> calculateAllPairings() {
//    }
}
