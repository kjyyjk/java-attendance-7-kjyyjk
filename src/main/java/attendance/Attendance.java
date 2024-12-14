package attendance;

import java.time.LocalDateTime;

public class Attendance {
    private Crew crew;
    private LocalDateTime localDateTime;

    public Attendance(final Crew crew, final LocalDateTime localDateTime) {
        this.crew = crew;
        this.localDateTime = localDateTime;
    }
}
