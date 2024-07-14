package de.brunokrams.schedulebuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Table<T> {

    private final List<List<T>> tableImpl;
    private final int nrOfColumns;

    Table(List<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        tableImpl = new ArrayList<>();
        for (int i = 0; i < participants.size() / 2; i++) {
            ArrayList<T> row = new ArrayList<>();
            row.add(participants.get(2 * i));
            row.add(participants.get(2 * i + 1));
            tableImpl.add(row);
        }
        nrOfColumns = tableImpl.size();
    }

    void move() {
        T temp = get(1, 0);
        for (int i = 1; i < nrOfColumns - 1; i++) {
            set(i, 0, get(i + 1, 0));
        }
        set(nrOfColumns - 1, 0, get(nrOfColumns - 1, 1));
        for (int i = nrOfColumns - 1; i > 0; i--) {
            set(i, 1, get(i - 1, 1));
        }
        set(0, 1, temp);
    }

    List<List<T>> getRows() {
        return Collections.unmodifiableList(tableImpl);
    }

    T get(int row, int column) {
        return tableImpl.get(row).get(column);
    }

    private void set(int row, int column, T value) {
        tableImpl.get(row).set(column, value);
    }
}
