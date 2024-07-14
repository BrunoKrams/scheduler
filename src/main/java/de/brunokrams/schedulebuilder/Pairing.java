package de.brunokrams.schedulebuilder;

import java.util.Objects;
import java.util.Set;

public class Pairing<T> {

    private final T firstParticipant;
    private final T secondParticipant;

    Pairing(T firstParticipant, T secondParticipant) {
        if (firstParticipant == null || secondParticipant == null) {
            throw new IllegalArgumentException("None of the participants must be null.");
        }
        if (firstParticipant.equals(secondParticipant)) {
            throw new IllegalArgumentException("The participants must not be equal.");
        }
        this.firstParticipant = firstParticipant;
        this.secondParticipant = secondParticipant;
    }

    public boolean contains(T participant) {
        return firstParticipant.equals(participant) || secondParticipant.equals(participant);
    }

    public T getFirstParticipant() {
        return firstParticipant;
    }

    public T getSecondParticipant() {
        return secondParticipant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Pairing<?> pairing = (Pairing<?>) o;
        return Objects.equals(
                Set.of(firstParticipant, secondParticipant),
                Set.of(pairing.firstParticipant, pairing.secondParticipant)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(Set.of(firstParticipant, secondParticipant));
    }
}
