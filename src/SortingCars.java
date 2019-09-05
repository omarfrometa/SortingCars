
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.Comparable ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omarfrometa
 * Test Assignment for Educational Network
 */
public class SortingCars implements SortAlgorithm
{
    public static int totalCars = 100000;
    public static String[] colors = {"Red", "Green", "Blue"};
    public static String[] destinations = {"Los Angeles", "New Orleans", "Miami", "New York"};
    
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }
    
    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }
    
    private static <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) {
        int randomIndex = left + (int)(Math.random()*(right - left + 1));
        SortUtils.swap(array, randomIndex, right);
        return partition(array, left, right);
    }
    
    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (SortUtils.less(array[left], pivot)) {
                ++left;
            }
            while (SortUtils.less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                SortUtils.swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
    { 
        /*  TASK #1
            Randomly create 100000 car objects. The serial number of the first car should be 1, and the serial number of each following 
            car should be +1 of the previous car. As a result, the last car's serial number will be 100000. Color and destination should be 
            randomly selected from the values above.
        */
        
        Car[] cars = new Car[totalCars];
        for(int i = 0; i <= (totalCars - 1); i++)
        {
            Car _car = new Car(i, getColor(),getDestination()); 
            cars[i]= _car;
        }
        
        /*  TASK #2 & TASK #3
            Implement the quicksort algorithm to sort  all the cars. Here are the 3 criteria:
            Criteria #1 : Destination (Order: Los Angeles, New Orleans, Miami, New York)
            Criteria #2 : Color (Order: Red, Green, Blue)
            Criteria #3 : Serial number.
            While doing the sorting, measure also the time that the computer needs for it, and display it on the screen.
         */
        
        //Criteria #1 - Destination
        System.out.println("(Quick Sort by Destination Field)");
        Arrays.sort(cars, Car.DestinationComparator);
        int i=1;
        for(Car c: cars)
        {
           System.out.println("Seq: " + i++ +", Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
        }
        
         System.out.println("-----");
         System.out.println("Quick Sort by Color Field");
        
        //Criteria #2 - Colors
        Arrays.sort(cars, Car.ColorComparator);
        i=1;
        for(Car c: cars)
        {
           System.out.println("Seq: " + i++ +", Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
        }
        
        System.out.println("-----");
        System.out.println("Quick Sort by Serial Numnber Field");
        
        //Criteria #3 - Serial Number
        Arrays.sort(cars);
        i=1;
        for(Car c: cars)
        {
           System.out.println("Seq: " + i++ +", Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
        }
        
        /*  TASK #4 - Create two files:
            - cars.txt: Write the list of all the cars into this file, in the sequence they have been generated (unsorted). Each row should include the following information: Serial number, color, destination.
            - sorted_colors.txt: Write the list of sorted cars.
        */
        
        //Calculate Elapsed Time
        DateTimeUtils obj = new DateTimeUtils();
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date; 
        
        PrintWriter writer;
        //Writing Text Cars File
        date = new Date(); 
        writer = new PrintWriter("cars.txt", "UTF-8");
        writer.println("Proccess Started: " + dateFormat.format(date));
        writer.println("");
        for (Car c : cars) 
        {
            writer.println("Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
        }
        date = new Date(); 
        writer.println("");
        writer.println("Proccess Finished: " + dateFormat.format(date));
        writer.close();
        
        //Writing Sorted Cars by Color
        date = new Date(); 
        writer = new PrintWriter("sorted_colors.txt", "UTF-8");
        writer.println("Proccess Started: " + dateFormat.format(date));
        writer.println("");

        Arrays.sort(cars, Car.ColorComparator); //Sorting by Color
        for (Car c : cars) 
        {
            writer.println("Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
        }
        date = new Date(); 
        writer.println("");
        writer.println("Proccess Finished: " + dateFormat.format(date));
        writer.close();
        
        //Clear Objects in Memory
        System.gc();
    }

    private static String getColor() 
    {
        Random randomGenerator = new Random(); 
        int randomNumber = randomGenerator.nextInt(colors.length);

        return colors[randomNumber];
    }
    
    private static String getDestination() 
    {
        Random randomGenerator = new Random(); 
        int randomNumber = randomGenerator.nextInt(destinations.length);

        return destinations[randomNumber];
    }
}
