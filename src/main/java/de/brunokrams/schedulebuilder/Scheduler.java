package de.brunokrams.schedulebuilder;

import java.util.Set;

public class Scheduler<T> {
    
    public Schedule<T> create(Set<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        return null;
    }
}
