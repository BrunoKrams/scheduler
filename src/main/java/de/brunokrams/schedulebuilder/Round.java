package de.brunokrams.schedulebuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Round<T> {

    Round() {
        this.pairings = new ArrayList<>();
        this.participants = new HashSet<>();
    }

    private List<Pairing<T>> pairings;
    private Set<T> participants;

    void add(Pairing<T> pairing) {
        if (pairing == null) {
            throw new IllegalArgumentException("The pairing must not be null.");
        }
        checkIfParticipantAlreadyHasPairing(pairing.firstParticipant());
        checkIfParticipantAlreadyHasPairing(pairing.secondParticipant());
        
        pairings.add(pairing);
        participants.add(pairing.firstParticipant());
        participants.add(pairing.secondParticipant());
    }

    private void checkIfParticipantAlreadyHasPairing(T participant) {
        if (participants.contains(participant)) {
            throw new IllegalArgumentException(participant + " already is in some Pairing in this round.");
        }
    }

    List<Pairing<T>> getPairings() {
        return Collections.unmodifiableList(pairings);
    }
}
