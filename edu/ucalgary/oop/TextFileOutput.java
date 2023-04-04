package edu.ucalgary.oop;


import java.io.*;
import java.util.*;


public class TextFileOutput extends ScheduleBuilder{

    private String fileName = "schedule.txt";
    private File outputFile = new File(fileName);

    // private Set<String> ts1 = new TreeSet<>();
    // private Set<String> ts2 = new TreeSet<>();
    // private Set<String> ts3 = new TreeSet<>();
    // private Set<String> ts4 = new TreeSet<>();
    // private Set<String> ts5 = new TreeSet<>();

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
                    String taskDescription = "UniqueTask->" + uniqueTask;
                    String animalName = "Name->" + uniqueTask;

                    
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

    // public void buildHash() {
    //     hash.put("1", ts1);
    //     hash.put("2", ts2);
    //     hash.put("3", ts3);
    //     hash.put("4", ts4);
    //     hash.put("5", ts5);

    // }

    // public void buildTreeSets() {
    //     //hash key 1
    //     ts1.add("A");
    //     ts1.add("B");
    //     ts1.add("C");

    //     //hash key 2
    //     ts2.add("D");
    //     ts2.add("E");
    //     ts2.add("F");

    //     //hash key 3
    //     ts3.add("G");
    //     ts3.add("H");
    //     ts3.add("I");

    //     //hash key 4
    //     ts4.add("J");
    //     ts4.add("K");
    //     ts4.add("L");

    //     //hash key 5
    //     ts5.add("M");
    //     ts5.add("N");
    //     ts5.add("O");


    // };

//     public static void main(String[] args) throws IOException{
//         new TextFileOutput();
//       }

}
