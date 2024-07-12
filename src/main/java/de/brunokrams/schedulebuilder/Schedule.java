package de.brunokrams.schedulebuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schedule<T> {

    Schedule() {
        this.rounds = new ArrayList<>();
        this.pairings = new HashSet<>();
    }

    private List<Round<T>> rounds;
    private Set<Pairing> pairings;

    List<Round<T>> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    void add(Round<T> round) {
        if (round == null) {
            throw new IllegalArgumentException("The round must not be null.");
        }
        round.getPairings().forEach(this::checkIfPairingAlreadyHasRound);

        rounds.add(round);
        pairings.addAll(round.getPairings());
    }

    private void checkIfPairingAlreadyHasRound(Pairing<T> pairing) {
        if (pairings.contains(pairing)) {
            throw new IllegalArgumentException(pairing + " already is in some Round in this schedule.");
        }
    }
}
