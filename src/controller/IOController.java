package controller;

import model.ConferenceEvent;
import model.Track;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class IOController {

    static ArrayList<ConferenceEvent> eventsToSchedule = new ArrayList<>();

    public static void generateOutputFiles(ArrayList<Track> tracks){
        String fileName = new SimpleDateFormat("yyyy-MM-dd  HH-mm'.txt'").format(new Date());
        try{
            FileWriter myWriter = new FileWriter("TRACK-MANAGEMENT_" + fileName);
            for (int i = 0; i < tracks.size(); i++) {
                ArrayList<String> outputList = tracks.get(i).getOutputList();
                myWriter.write("Track " + (i + 1) + ":" + System.lineSeparator());
                System.out.println("");
                System.out.println("Track " + (i + 1) + ":");
                for (String str: outputList) {

                    myWriter.write(str + System.lineSeparator());
                    System.out.println(str);
                }
            }
            myWriter.close();
            
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

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
