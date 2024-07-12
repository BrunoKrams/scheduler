package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import static de.brunokrams.schedulebuilder.CommonTestData.*;
import static de.brunokrams.schedulebuilder.CommonTestData.CANTOR;
import static de.brunokrams.schedulebuilder.CommonTestData.GAUSS;
import static de.brunokrams.schedulebuilder.CommonTestData.HILBERT;
import static de.brunokrams.schedulebuilder.CommonTestData.RIEMANN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    void add_fails_whenPairingIsNull() {
        // given
        Round<String> round = new Round<>();
        
        // when/then
        assertThatThrownBy(() -> round.add(null)).isInstanceOf(IllegalArgumentException.class).hasMessage("The pairing must not be null.");
    }
    
    @Test
    void add_fails_whenOneOfTheParticipantsOfThePairingIsAlreadyContainedInAnExistingPairing() {
        // given
        Round<String> round = new Round<>();
        round.add(new Pairing<>(GAUSS, RIEMANN));
        round.add(new Pairing<>(CANTOR, HILBERT));

        // when/then
        assertThatThrownBy(() -> round.add(new Pairing<>(HILBERT, WEIERSTRASS))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HILBERT + " already is in some Pairing in this round.");        // when/then
        assertThatThrownBy(() -> round.add(new Pairing<>(EULER, HILBERT))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HILBERT + " already is in some Pairing in this round.");
    }
    
    @Test
    void add_addsPairing_ifEverythingIsOk() {
        // given
        Round<String> round = new Round<>();
        Pairing<String> pairing = new Pairing<>(GAUSS, EULER);
        
        // when
        round.add(pairing);
        
        // then
        assertThat(round.getPairings()).containsExactly(pairing);
    }
}