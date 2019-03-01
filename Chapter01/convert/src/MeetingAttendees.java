import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MeetingAttendees {
    private Map<String, MeetingAttendee> nameToAttendees = new HashMap<>();

    void add(MeetingAttendee attendee) {
        nameToAttendees.put(attendee.getName(), attendee);
    }

    MeetingAttendee getAttendee(String name) {
        return nameToAttendees.get(name);
    }

    Collection<MeetingAttendee> getAttendees() {
        return nameToAttendees.values();
    }
}
