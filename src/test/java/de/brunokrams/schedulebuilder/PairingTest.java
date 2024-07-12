package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import static de.brunokrams.schedulebuilder.CommonTestData.CANTOR;
import static de.brunokrams.schedulebuilder.CommonTestData.EULER;
import static de.brunokrams.schedulebuilder.CommonTestData.GAUSS;
import static de.brunokrams.schedulebuilder.CommonTestData.RIEMANN;
import static org.assertj.core.api.Assertions.assertThat;
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
    
    @Test
    void contains_returnsTrue_whenGivenParticipantIsFirstParticipant() {
        // given
        Pairing<String> pairing = new Pairing<>(EULER, CANTOR);
        
        // when
        boolean result = pairing.contains(EULER);
        
        // then
        assertThat(result).isTrue();        
    }
    @Test
    void contains_returnsTrue_whenGivenParticipantIsSecondParticipant() {
        // given
        Pairing<String> pairing = new Pairing<>(EULER, CANTOR);

        // when
        boolean result = pairing.contains(CANTOR);

        // then
        assertThat(result).isTrue();
    }
    
    @Test
    void contains_returnsFalse_whenGivenParticipantIsNeitherFirstNorSecondParticipant() {
        // given
        Pairing<String> pairing = new Pairing<>(EULER, CANTOR);

        // when
        boolean result = pairing.contains(RIEMANN);

        // then
        assertThat(result).isFalse();
    }
    
    @Test
    void equals_returnsTrue_whenFirstParticipantsAndSecondParticipantsAreEqual() {
        // given
        Pairing<String> first = new Pairing<>(EULER, GAUSS);
        Pairing<String> second = new Pairing<>(EULER, GAUSS);
        
        // when
        boolean result = first.equals(second);
        
        // then
        assertThat(result).isTrue();        
    }
    
    @Test
    void equals_returnsTrue_whenFirstParticipantOfFirstPairEqualsSecondParticipantsOfSecondPairAndViceVersa() {
        // given
        Pairing<String> first = new Pairing<>(EULER, GAUSS);
        Pairing<String> second = new Pairing<>(GAUSS, EULER);

        // when
        boolean result = first.equals(second);

        // then
        assertThat(result).isTrue();
    }
    
    @Test
    void equals_returnsFalse_whenAtLeastOnParticipantDiffers() {
        // given
        Pairing<String> first = new Pairing<>(EULER, GAUSS);
        Pairing<String> second = new Pairing<>(EULER, RIEMANN);

        // when
        boolean result = first.equals(second);

        // then
        assertThat(result).isFalse();
    }
    
    @Test
    void equals_returnsFalse_whenBothParticipantsAreDifferent() {
        // given
        Pairing<String> first = new Pairing<>(EULER, GAUSS);
        Pairing<String> second = new Pairing<>(RIEMANN, CANTOR);

        // when
        boolean result = first.equals(second);

        // then
        assertThat(result).isFalse();
    }

}