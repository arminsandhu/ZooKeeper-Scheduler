package edu.ucalgary.oop;


import java.io.*;
import java.util.*;


public class TextFileOutput extends ScheduleBuilder{
    /**
    * The `TextFileOutput` class writes the final schedule to a text file named "schedule.txt".
    * It extends the `ScheduleBuilder` class.
    * Has a class variable of type String, filename.
    * Has a class variable of type File, outputFile.
    * Has a class variable of type HashMap<Integer, TreeSet<FinalSchedule>>, hash.
    */

    private String fileName = "schedule.txt";
    private File outputFile = new File(fileName);

    private HashMap<Integer, TreeSet<FinalSchedule>> hash;

    /**
     * Constructs a new `TextFileOutput` object.
     * @param schedule The `ScheduleBuilder` object that contains the final schedule.
     * @throws IOException If there is an I/O error while creating the file or writing to it.
     */
    public TextFileOutput(ScheduleBuilder schedule) throws IOException{  

      this.hash = schedule.getFinalSchedule();

      createFile();
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    
    /**
     * Creates a new text file if it does not already exist.
     * If the file already exists, nothing happens.
     */
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



    /**
     * Writes the final schedule to the text file.
     * @throws IOException If there is an I/O error while writing to the file.
     */
    public void writeToFile() throws IOException{

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println();

            //int row = 0;
            for (HashMap.Entry<Integer, TreeSet<FinalSchedule>> entry : hash.entrySet()) {
                
                Integer hour = entry.getKey();
                TreeSet<FinalSchedule> tasks = entry.getValue();

                printHourLabel(hour, tasks, printWriter);
                
                printHourlyTasks(tasks, printWriter);
                
                printWriter.println();
            }

            printWriter.close();
            
          } 
        catch (FileNotFoundException e) {
            System.out.println("File cannot be found.");
            e.printStackTrace();
          }

    }

    /**
     * Prints the hour label to the file, checks if a backup volunteer is called 
     * within the hour and adds a message to the hour label if there is.
     * @param hour The hour to print.
     * @param tasks The tasks associated with the hour.
     * @param printWriter The `PrintWriter` object used to write to the file.
     */
    public void printHourLabel(Integer hour, TreeSet<FinalSchedule> tasks, PrintWriter printWriter) {
      int totalTime = 0;
      for (FinalSchedule uniqueTask : tasks) {
        totalTime = uniqueTask.getTimeSpent();                  
      }
      if (totalTime > 60) {
        printWriter.println(hour + ":00" + " [+ backup volunteer]");
      }

      else {
        printWriter.println(hour + ":00");
      }
      
    }


    /**
     * Prints the hourly tasks in any given hour to the file.
     * @param tasks The tasks to print.
     * @param printWriter The `PrintWriter` object used to write to the file.
     */
    public void printHourlyTasks(TreeSet<FinalSchedule> tasks, PrintWriter printWriter) {
      for (FinalSchedule uniqueTask : tasks) {
        
        String taskDescription = uniqueTask.getDescription();
        String animalName = String.valueOf(uniqueTask.getNickname()); 
        String toPrint = "* " + taskDescription + " (" + animalName + ")";
        printWriter.println(toPrint);   
    }
  }


}
