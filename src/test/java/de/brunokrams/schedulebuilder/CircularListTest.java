package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CircularListTest {

    @Test
    void move_shiftsAllElements() {
        // given
        List<Integer> list = List.of(4,1,7,5,5,8,5,9);
        CircularList<Integer> circularList = new CircularList<>(list);
        
        // when
        circularList.move();
        
        // then
        assertThat(circularList).isEqualTo(List.of(9,4, 1,7,5,5,8,5));
    }

}