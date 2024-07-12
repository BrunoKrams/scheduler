package de.brunokrams.schedulebuilder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static de.brunokrams.schedulebuilder.CommonTestData.PARTICIPANTS;
import static org.assertj.core.api.Assertions.assertThat;

class SchedulerTest {

    @Test
    void eachParticipant_playsEachOtherExactlyOnce() {
        // given
        Scheduler<String> scheduler = new Scheduler<>();
    
        // when
        Schedule<String> schedule = scheduler.create(PARTICIPANTS);
        
        // then
        for (String participant : PARTICIPANTS) {
            Set<String> expected = new HashSet<>(PARTICIPANTS);
            expected.remove(participant);
            assertThat(getOpponents(schedule, participant)).containsExactlyInAnyOrderElementsOf(expected);
        }
    }   
    
    private List<String> getOpponents(Schedule<String> schedule, String participant) {
        List<String> result = new ArrayList<>();
        for (Pairing<String> pairing : schedule.getPairings(participant)) {
            if (pairing.getFirstParticipant().equals(participant)) {
                result.add(pairing.getSecondParticipant());
            } else{
                result.add(pairing.getFirstParticipant());
            }
        }
        return result;        
    }
    
}
