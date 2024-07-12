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

    private final List<Round<T>> rounds;
    private final Set<Pairing<T>> pairings;

    public List<Pairing<T>> getPairings(T participant) {
        return rounds.stream().flatMap(round -> round.getPairings().stream()).filter(pairing -> pairing.contains(participant))
                .toList();
    }

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
