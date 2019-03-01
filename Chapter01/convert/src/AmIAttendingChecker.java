public class AmIAttendingChecker {
    public static void main(String [] args) {
        MeetingAttendees attendees = new MeetingAttendees();
        attendees.add(new MeetingAttendee("Sam"));
        attendees.add(new MeetingAttendee("Joe"));

        MeetingAttendee sam = attendees.getAttendee("Sam");
        System.out.println("Sam is attending: " + sam.getName());
    }
}

// java code to paste into this file after converted to Kotlin
//        for (MeetingAttendee attendee : attendees.getAttendees()) {
//                System.out.println(attendee.getName() + " is attending");
//        }
