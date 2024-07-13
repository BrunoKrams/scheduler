package de.brunokrams.schedulebuilder;

import java.util.ArrayList;
import java.util.List;

public class CircularList<T> extends ArrayList<T> {

    public CircularList(List<T> list) {
        super(list);
    }

    public void move() {
        T temp = this.get(this.size() - 1);
        for (int i = this.size() - 1; i > 0; i--) {
            this.set(i, this.get(i - 1));
        }
        this.set(0, temp);
    }

}
