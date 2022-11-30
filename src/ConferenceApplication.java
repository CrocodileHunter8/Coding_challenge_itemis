import controller.IOController;
import controller.PlanConferenceController;
import model.ConferenceEvent;
import model.Track;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ConferenceApplication {
    static ArrayList<ConferenceEvent> eventsToSchedule = new ArrayList<>();
    static ArrayList<Track> tracks = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {

        //Variant 1 : no files as input, enter data manually
        if (args.length == 0) {
            eventsToSchedule = IOController.readKeyboardInput();
        }
        //Variant 2 : read input files instead of keyboard inputs ----
        // Execute -> java ConferenceApplication .\sampleInput.txt
        if (args.length > 0) {
            eventsToSchedule = IOController.readFilesInput(args);
        }

        tracks = PlanConferenceController.planConference(eventsToSchedule);
        IOController.generateOutputFiles(tracks);
        System.exit(0);

    }
}
