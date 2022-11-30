import controller.IOController;
import controller.PlanConferenceController;
import model.ConferenceEvent;
import model.Track;

import java.text.ParseException;
import java.util.ArrayList;

public class ConferenceApplication {
    static ArrayList<ConferenceEvent> eventsToSchedule = new ArrayList<>();
    static ArrayList<Track> tracks = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        eventsToSchedule = IOController.readKeyboardInput();

        tracks = PlanConferenceController.planConference(eventsToSchedule);
        IOController.generateOutputFiles(tracks);
        System.exit(0);

    }
}
