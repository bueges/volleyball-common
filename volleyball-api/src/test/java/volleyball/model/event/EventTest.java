package volleyball.model.event;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static volleyball.TestData.COMPETITION_NAME;

@Slf4j
class EventTest {

    // test parameter
    private final Match match = Mockito.mock(Match.class);

    @Test
    @DisplayName("create event with valid match")
    public void createEvent() {
        Event event = new Event(null, match);
        log.info("create event : {}", event);

        assertNotNull(event);
        assertNotNull(event.getMatch());
    }

    @Test
    @DisplayName("check NullPointerException when create event with null match")
    public void testCheckNullPointerExceptionWhenCreateEventWithNULLMatch() {
        assertThrows(NullPointerException.class, () -> new Event(null, null));
    }

    @Test
    @DisplayName("compare events with same ID")
    public void compareEventsWithSameID() {
        Event event1 = new Event(1, match);
        Event event2 = new Event(1, Mockito.mock(Match.class));

        log.info("compare events : ");
        log.info("event 1 : {}", event1);
        log.info("event 2 : {}", event2);

        assertEquals(event1, event2);
    }

    @Test
    @DisplayName("compare events with different ID")
    public void compareEventsWithDifferentID() {
        Event event1 = new Event(1, match);
        Event event2 = new Event(2, match);

        log.info("compare events : ");
        log.info("event 1 : {}", event1);
        log.info("event 2 : {}", event2);

        assertNotEquals(event1, event2);
    }
}