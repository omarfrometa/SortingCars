
import java.lang.Comparable;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author omarfrometa
 */
public class Car implements Comparable<Car> {

    private int serialNumber;
    private String color;
    private String destination;

    public Car(int serialNumber, String color, String destination) {
        super();
        this.destination = destination;
        this.color = color;
        this.serialNumber = serialNumber;
    }

    /**
     * @return the serialNumber
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int compareTo(Car compareCar) {
        int getSerialNumber = ((Car) compareCar).getSerialNumber();
        return this.serialNumber - getSerialNumber;
    }

    public static Comparator<Car> ColorComparator = new Comparator<Car>() {

        public int compare(Car car1, Car car2) {

            String carColor1 = car1.getColor().toUpperCase();
            String carColor2 = car2.getColor().toUpperCase();

            //ascending order
            return carColor1.compareTo(carColor2);

            //descending order
            //return carColor2.compareTo(carColor1);
        }

    };

    public static Comparator<Car> DestinationComparator = new Comparator<Car>() {

        public int compare(Car car1, Car car2) {

            String carDestination1 = car1.getDestination().toUpperCase();
            String carDestination2 = car2.getDestination().toUpperCase();

            return carDestination1.compareTo(carDestination2);
        }
    };
}
