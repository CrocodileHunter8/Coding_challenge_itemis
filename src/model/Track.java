package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Track {
    private ArrayList<ConferenceEvent> preLunchEvents = new ArrayList<>();
    private ArrayList<ConferenceEvent> postLunchEvents = new ArrayList<>();
    private ArrayList<String> outputList = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
    Date time = new Date();

    private int firstSlotMinutes = 0;
    private int secondSlotMinutes = 0;

    public void finalizeTrack() throws ParseException{
        time = dateFormat.parse("09:00 AM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        //-------------add first slot events-------------
        for(int i = 0; i < preLunchEvents.size(); i++){
            //Add minutes to date
            outputList.add(dateFormat.format(time) + " " + preLunchEvents.get(i).getName());

            calendar.add(Calendar.MINUTE, preLunchEvents.get(i).getDuration());
            time = calendar.getTime();
            firstSlotMinutes += preLunchEvents.get(i).getDuration();
        }

        //--------------add lunch event----------------------
        outputList.add("12:00 PM Lunch");
        time = dateFormat.parse("01:00 PM");
        calendar.setTime(time);

        //--------------add second slot events--------------------
        for(int i = 0; i < postLunchEvents.size(); i++){
            //Add minutes to date
            outputList.add(dateFormat.format(time) + " " + postLunchEvents.get(i).getName());

            calendar.add(Calendar.MINUTE, postLunchEvents.get(i).getDuration());
            time = calendar.getTime();
            secondSlotMinutes += postLunchEvents.get(i).getDuration();
        }

        //------------------add networking event------------------
        if(secondSlotMinutes <= 180) { // if events are finished before 04:00 PM, start at 04:00 PM
            outputList.add("04:00 OM Networking Event");

        }else{ //start after last event
            outputList.add(dateFormat.format(time) + " Networking Event");
        }

    }


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

    public void addPostLunchEvent(ConferenceEvent event){this.postLunchEvents.add(event); }
    public void addPreLunchEvent(ConferenceEvent event){this.preLunchEvents.add(event); }

}
