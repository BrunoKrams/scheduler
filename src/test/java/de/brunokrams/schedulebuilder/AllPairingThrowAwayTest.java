package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.brunokrams.schedulebuilder.CommonTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class AllPairingThrowAwayTest {

    @Test
    void allPairings() {
        // when
        List<Pairing<String>> pairings = calculateAllPairings(PARTICIPANTS);

        // then
        assertThat(pairings).containsExactlyInAnyOrder(
                new Pairing<>(GAUSS, RIEMANN),
                new Pairing<>(GAUSS, EULER),
                new Pairing<>(GAUSS, CANTOR),
                new Pairing<>(GAUSS, HILBERT),
                new Pairing<>(GAUSS, WEIERSTRASS),
                new Pairing<>(RIEMANN, EULER),
                new Pairing<>(RIEMANN, CANTOR),
                new Pairing<>(RIEMANN, HILBERT),
                new Pairing<>(RIEMANN, WEIERSTRASS),
                new Pairing<>(EULER, CANTOR),
                new Pairing<>(EULER, HILBERT),
                new Pairing<>(EULER, WEIERSTRASS),
                new Pairing<>(CANTOR, HILBERT),
                new Pairing<>(CANTOR, WEIERSTRASS),
                new Pairing<>(HILBERT, WEIERSTRASS)
        );
    }


    private List<Pairing<String>> calculateAllPairings(List<String> participants) {
        List<Pairing<String>> result = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            for (int j = i + 1; j < participants.size(); j++) {
                result.add(new Pairing<>(participants.get(i), participants.get(j)));
            }
        }
        return result;
    }

}
