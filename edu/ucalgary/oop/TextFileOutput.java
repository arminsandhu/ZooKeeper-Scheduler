package edu.ucalgary.oop;


import java.io.*;
import java.util.*;


public class TextFileOutput extends ScheduleBuilder{

    private String fileName = "schedule.txt";
    private File outputFile = new File(fileName);

    private HashMap<Integer, TreeSet<FinalSchedule>> hash;


    public TextFileOutput(ScheduleBuilder schedule) throws IOException{  

      this.hash = schedule.getFinalSchedule();
      // System.out.println(hash);
      createFile();
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    

    public void createFile() {
        try {
            
            if (outputFile.createNewFile()) {
              System.out.println("File created: " + outputFile.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void writeToFile() throws IOException{

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            // buildTreeSets();
            // buildHash();
            //System.out.println(hash);
            
            printWriter.println();

            int row = 0;
            for (HashMap.Entry<Integer, TreeSet<FinalSchedule>> entry : hash.entrySet()) {
                
                Integer hour = entry.getKey();
                TreeSet<FinalSchedule> tasks = entry.getValue();

                printWriter.println(hour + ":00");

                for (FinalSchedule uniqueTask : tasks) {
                    //for real data, gain access to all these using getter hopefully
                    String taskDescription = uniqueTask.getDescription();
                    String animalName = String.valueOf(uniqueTask.getUniqueId());

                    
                    String toPrint = "* " + taskDescription + " (" + animalName + ")";
                    printWriter.println(toPrint);

                    row+=1;
                }
                
                printWriter.println();
            }

            printWriter.close();
            
          } 
        catch (FileNotFoundException e) {
            System.out.println("File cannot be found.");
            e.printStackTrace();
          }

    }


}
