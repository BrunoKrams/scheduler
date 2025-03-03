package de.brunokrams.schedulebuilder;

import java.util.List;

public class Scheduler<T>  {

    public Schedule<T> create(List<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        if (participants.size() == 2) {
            Schedule<T> schedule = new Schedule<>();
            Round<T> round = new Round<>();
            round.add(new Pairing<>(participants.get(0), participants.get(1)));
            schedule.add(round);
            return schedule;
        }

        Schedule<T> schedule = new Schedule<>();
        Table<T> table = new Table<>(participants);
        for (int i = 0; i < participants.size() - 1; i++) {
            Round<T> round = new Round<>();
            table.getRows().forEach(row -> round.add(new Pairing<>(row.get(0), row.get(1))));
            schedule.add(round);
            table.move();
        }
        return schedule;
    }

}
