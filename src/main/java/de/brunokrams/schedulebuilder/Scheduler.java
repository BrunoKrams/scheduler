package de.brunokrams.schedulebuilder;

import java.util.List;

public interface Scheduler<T> {
    Schedule<T> create(List<T> participants);
}
