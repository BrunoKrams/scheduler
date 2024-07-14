package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static de.brunokrams.schedulebuilder.CommonTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SchedulerTest {

    @Test
    void create_fails_whenNumberOfParticipantsIsNotEven() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // given
        Scheduler<String> scheduler = new Scheduler<>();

        // when/then
        assertThatThrownBy(() -> scheduler.create(List.of(GAUSS, RIEMANN, EULER))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of participants must be even.");
    }

    @Test
    void eachParticipant_playsEachOtherExactlyOnce() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // given
        Scheduler<String> scheduler = new Scheduler<>();

        // when
        Schedule<String> schedule = scheduler.create(PARTICIPANTS);

        // then
        for (String participant : PARTICIPANTS) {
            Set<String> expected = new HashSet<>(PARTICIPANTS);
            expected.remove(participant);
            assertThat(getOpponents(schedule, participant)).containsExactlyInAnyOrderElementsOf(expected);
        }
    }

    private List<String> getOpponents(Schedule<String> schedule, String participant) {
        List<String> result = new ArrayList<>();
        for (Pairing<String> pairing : schedule.getPairings(participant)) {
            if (pairing.getFirstParticipant().equals(participant)) {
                result.add(pairing.getSecondParticipant());
            } else {
                result.add(pairing.getFirstParticipant());
            }
        }
        return result;
    }

}
