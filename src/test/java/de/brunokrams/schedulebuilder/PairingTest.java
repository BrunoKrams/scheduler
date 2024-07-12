package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairingTest {

    @Test
    void constructor_throwsException_ifEitherArgumentIsNull() {
        // when/then
        assertThatThrownBy(() -> new Pairing<>(null, "ABC")).isInstanceOf(IllegalArgumentException.class).hasMessage("None of the participants must be null.");
        assertThatThrownBy(() -> new Pairing<>("ABC", null)).isInstanceOf(IllegalArgumentException.class).hasMessage("None of the participants must be null.");
    }
    
    @Test
    void constructor_throwsException_ifArgumentsAreEqual() {
        // given
        String participant = "Carl Friedrich";
        
        // when
        assertThatThrownBy(() -> new Pairing<>(participant, participant)).isInstanceOf(IllegalArgumentException.class).hasMessage("The participants must not be equal.");
    }
    

}