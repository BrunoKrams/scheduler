package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static de.brunokrams.schedulebuilder.CommonTestData.EULER;
import static de.brunokrams.schedulebuilder.CommonTestData.GAUSS;
import static de.brunokrams.schedulebuilder.CommonTestData.RIEMANN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableTest {

    @Test
    void constructorFails_whenNumberOfParticipantsIsNotEven() {
        // when/then
        assertThatThrownBy(() -> new Table<>(List.of(GAUSS, RIEMANN, EULER))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of participants must be even.");
    }

    @Test
    void constructor_initsTableCorrectly() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // when
        Table<Integer> table = new Table<>(list);

        // then
        assertThat(table.get(0, 0)).isEqualTo(1);
        assertThat(table.get(0, 1)).isEqualTo(2);
        assertThat(table.get(1, 0)).isEqualTo(3);
        assertThat(table.get(1, 1)).isEqualTo(4);
        assertThat(table.get(2, 0)).isEqualTo(5);
        assertThat(table.get(2, 1)).isEqualTo(6);
        assertThat(table.get(3, 0)).isEqualTo(7);
        assertThat(table.get(3, 1)).isEqualTo(8);
    }

    @Test
    void move_movesAsExpected() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Table<Integer> table = new Table<>(list);

        // when
        table.move();

        // then
        assertThat(table.get(0, 0)).isEqualTo(1);
        assertThat(table.get(0, 1)).isEqualTo(3);
        assertThat(table.get(1, 0)).isEqualTo(5);
        assertThat(table.get(1, 1)).isEqualTo(2);
        assertThat(table.get(2, 0)).isEqualTo(7);
        assertThat(table.get(2, 1)).isEqualTo(4);
        assertThat(table.get(3, 0)).isEqualTo(8);
        assertThat(table.get(3, 1)).isEqualTo(6);

        // when
        table.move();

        // then
        assertThat(table.get(0, 0)).isEqualTo(1);
        assertThat(table.get(0, 1)).isEqualTo(5);
        assertThat(table.get(1, 0)).isEqualTo(7);
        assertThat(table.get(1, 1)).isEqualTo(3);
        assertThat(table.get(2, 0)).isEqualTo(8);
        assertThat(table.get(2, 1)).isEqualTo(2);
        assertThat(table.get(3, 0)).isEqualTo(6);
        assertThat(table.get(3, 1)).isEqualTo(4);
    }

}