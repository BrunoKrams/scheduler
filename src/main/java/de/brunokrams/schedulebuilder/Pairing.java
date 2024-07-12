package de.brunokrams.schedulebuilder;

public record 
Pairing<T>(T firstParticipant, T secondParticipant) {
       public Pairing {
           if (firstParticipant == null || secondParticipant == null) {
               throw new IllegalArgumentException("None of the participants must be null.");
           }
           if (firstParticipant.equals(secondParticipant)) {
               throw new IllegalArgumentException("The participants must not be equal.");
           }
       } 
}
