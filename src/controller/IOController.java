package controller;

import model.ConferenceEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class IOController {

    static ArrayList<ConferenceEvent> eventsToSchedule = new ArrayList<>();

    public static ArrayList<ConferenceEvent> readKeyboardInput(){
        System.out.println("Please enter conferences: ");
        Scanner keyboard = new Scanner(System.in);
        String line = null;

        try{
            while(!(line = keyboard.nextLine()).isEmpty()){
                parseLine(line);
            }
        }
        finally {
            keyboard.close();
        }
        return eventsToSchedule;
    }

    public static void parseLine(String line){
        try{
            String[] words = line.split("\\s+");
            String durationString = words[words.length - 1];
            durationString = durationString.replaceAll("[^\\d]", "");
            int length = Integer.parseInt(durationString);

            // create Event and add it to arraylist
            ConferenceEvent event = new ConferenceEvent(line, length);
            eventsToSchedule.add(event);
            System.out.println(event.toString()); //debug
        }catch(Exception e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
