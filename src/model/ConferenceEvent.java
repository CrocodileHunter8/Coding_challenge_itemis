package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConferenceEvent implements Comparable<ConferenceEvent> {
    Date start = new Date();
    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
    private String name;
    private int duration;

    public ConferenceEvent(final String name, final int duration) {
        this.name = name;
        this.duration = duration;
    }

    public ConferenceEvent(final String name, final int duration, String date) {
        this.name = name;
        this.duration = duration;
        parseDate(date);
    }

    private void parseDate(String date) {
        try {
            this.start = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getStart() {
        return this.start;
    }

    public void setStart(final String start) {
        parseDate(start);
    }

    public void setduration(final int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("%60s\t%5s", this.name, this.duration);
    }

    @Override
    public int compareTo(final ConferenceEvent conferenceEvent) {
        return Integer.compare(this.getDuration(), conferenceEvent.getDuration());
    }

}
