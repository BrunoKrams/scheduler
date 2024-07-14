package de.brunokrams.schedulebuilder;

import java.lang.reflect.Array;
import java.util.List;

public class Scheduler<T> {
   
    public Schedule<T> create(List<T> participants) {
        if (participants.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of participants must be even.");
        }
        
        
        return null;
    }
    
    private class Table {
        
        
        
    }
    

    public void move(T[][] matrix) {
        int columns = matrix.length;

        T temp = matrix[1][0];
        for (int i = 1; i < columns - 1; i++) {
            matrix[i][0] = matrix[i + 1][0];
        }
        matrix[columns - 1][0] = matrix[columns - 1][1];
        for (int i = columns - 1; i > 0; i--) {
            matrix[i][1] = matrix[i - 1][1];
        }
        matrix[0][1] = temp;
    }
        
}
