// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};

    //When you try to get value from array --> month: 0-11, day:0-27, profit_commodities: 0-4
    static public int[][][] dataArray = new int[12][28][5]; //months-days-profit_commodities
    

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
        //When you try to get value from array --> month: 0-11, day:0-27, profit_commodities: 0-4

        for (int monthIndex=0; monthIndex<MONTHS; monthIndex++){ //months loop
            String filePath = "Data_Files/" + months[monthIndex] + ".txt"; //creating file path for each file

            File file = new File(filePath); //created file to read it

            try (Scanner scanner = new Scanner(file);) {

                //Just skipping first useless line
                scanner.nextLine();

                for (int dayIndex = 0; dayIndex<DAYS; dayIndex++) { //day loop
                    for (int commsIndex=0; commsIndex<COMMS; commsIndex++) { //comms loop

                        String line = scanner.nextLine();
                        String[] parts = line.split(",");

                        int profit = Integer.parseInt(parts[2]);

                        dataArray[monthIndex][dayIndex][commsIndex] = profit;

                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException");
            }

        }

    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {

        //Checking for invalid month
        if (!(month>=0 && month <=11)){
            //for testing
            System.out.println("INVALID_MONTH");
            return "INVALID_MONTH";
        }


        int[][] monthArray = dataArray[month];
        //array[28][5] --> 0-27, 0-4

        int[] totalProfitComms = new int[5];

        for (int dayIndex = 0; dayIndex<DAYS; dayIndex++) { //day loop  0-27
            for (int commsIndex=0; commsIndex<COMMS; commsIndex++) { //comms loop  0-4

                totalProfitComms[commsIndex] += dataArray[month][dayIndex][commsIndex];

            }
        }

        int mostProfitableIndex = 0;
        for (int i=0; i<totalProfitComms.length; i++) {
            if (totalProfitComms[mostProfitableIndex] < totalProfitComms[i]) {
                mostProfitableIndex = i;
            }
        }
        //For testing
        System.out.println("mostProfitableIndex: " + mostProfitableIndex);
        System.out.println(totalProfitComms[0]);
        System.out.println(totalProfitComms[1]);
        System.out.println(totalProfitComms[2]);
        System.out.println(totalProfitComms[3]);
        System.out.println(totalProfitComms[4]);

        String returnString = commodities[mostProfitableIndex] + " " + totalProfitComms[mostProfitableIndex];
        System.out.println(returnString);

        return returnString;
    }

    public static int totalProfitOnDay(int month, int day) {
        //when accessing data --> (day-1)

        //checking for invalid day or month
        if (!(month>=0 && month<=11 && day>=1 && day<=28)){
            System.out.println("Invalid day or month"); //for testing
            return -99999;
        }

        int totalProfit = 0;

        for (int i=0;i<COMMS;i++){
            totalProfit += dataArray[month][day-1][i];
        }
        System.out.println(totalProfit);
        return totalProfit;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        return 1234;
    }

    public static int bestDayOfMonth(int month) { 
        return 1234; 
    }
    
    public static String bestMonthForCommodity(String comm) { 
        return "DUMMY"; 
    }

    public static int consecutiveLossDays(String comm) { 
        return 1234; 
    }
    
    public static int daysAboveThreshold(String comm, int threshold) { 
        return 1234; 
    }

    public static int biggestDailySwing(int month) { 
        return 1234; 
    }
    
    public static String compareTwoCommodities(String c1, String c2) { 
        return "DUMMY is better by 1234"; 
    }
    
    public static String bestWeekOfMonth(int month) { 
        return "DUMMY"; 
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
        //mostProfitableCommodityInMonth(9);
        //totalProfitOnDay(1,27);
    }
}