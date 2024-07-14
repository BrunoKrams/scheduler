package de.brunokrams.schedulebuilder;

import java.util.ArrayList;
import java.util.List;

public class DfsScheduler<T> implements Scheduler<T> {
    @Override
    public Schedule<T> create(List<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        List<Pairing<T>> allPairings = calculateAllPairings(participants);
        return null;
    }


    private List<Pairing<T>> calculateAllPairings(List<T> participants) {
        List<Pairing<T>> result = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            for (int j = i + 1; j < participants.size(); j++) {
                result.add(new Pairing<>(participants.get(i), participants.get(j)));
            }
        }
        return result;
    }

}
