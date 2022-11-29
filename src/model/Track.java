package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Track {
    private ArrayList<ConferenceEvent> preLunchEvents = new ArrayList<>();
    private ArrayList<ConferenceEvent> postLunchEvents = new ArrayList<>();
    private ArrayList<String> outputList = new ArrayList<>();
    DateFormat fateFormat = new SimpleDateFormat("hh:mm a");
    Date time = new Date();

    private int firstSlotMinutes = 0;
    private int secondSlotMinutes = 0;


    public ArrayList<ConferenceEvent> getPreLunchEvents()
    {
        return preLunchEvents;
    }
    public ArrayList<ConferenceEvent> getPostLunchEvents()
    {
        return postLunchEvents;
    }
    public ArrayList<String> getOutputList()
    {
        return outputList;
    }

}
