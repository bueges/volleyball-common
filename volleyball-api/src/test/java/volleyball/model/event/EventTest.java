package volleyball.model.event;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import volleyball.model.match.Match;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}