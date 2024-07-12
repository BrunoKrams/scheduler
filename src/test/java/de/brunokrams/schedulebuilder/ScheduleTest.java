package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import static de.brunokrams.schedulebuilder.CommonTestData.CANTOR;
import static de.brunokrams.schedulebuilder.CommonTestData.EULER;
import static de.brunokrams.schedulebuilder.CommonTestData.GAUSS;
import static de.brunokrams.schedulebuilder.CommonTestData.HILBERT;
import static de.brunokrams.schedulebuilder.CommonTestData.RIEMANN;
import static de.brunokrams.schedulebuilder.CommonTestData.WEIERSTRASS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScheduleTest {

    @Test
    void add_fails_whenRoundIsNull() {
        // given
        Schedule<String> schedule = new Schedule<>();

        // when/then
        assertThatThrownBy(() -> schedule.add(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("The round must not be null.");
    }
    
    @Test
    void add_fails_whenAnyPairingOfTheRoundIsAlreadyContainedInAnExistingRound() {
        // given
        Schedule<String> schedule = new Schedule<>();
        Round<String> firstRound = new Round();
        Pairing<String> pairing = new Pairing(EULER, GAUSS);
        firstRound.add(pairing);
        firstRound.add(new Pairing<>(RIEMANN, WEIERSTRASS));
        schedule.add(firstRound);
        
        // when/then        
        Round<String> secondRound = new Round<>();
        secondRound.add(new Pairing<>(HILBERT, CANTOR));
        secondRound.add(pairing);
        assertThatThrownBy(()->schedule.add(secondRound)).isInstanceOf(IllegalArgumentException.class).hasMessage(pairing + " already is in some Round in this schedule.");
    }

    @Test
    void add_addsRound_ifEverythingIsOk() {
        // given
        Schedule<String> schedule = new Schedule<>();
        
        // when
        Round<String> firstRound = new Round<>();
        firstRound.add(new Pairing<>(GAUSS, EULER));
        schedule.add(firstRound);
        Round<String> secondRound = new Round<>();
        secondRound.add(new Pairing<>(HILBERT, WEIERSTRASS));
        schedule.add(secondRound);

        // then
        assertThat(schedule.getRounds()).containsExactly(firstRound, secondRound);
    }
}