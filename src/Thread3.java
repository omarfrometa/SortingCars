
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author omarfrometa
 */
public class Thread3 extends Thread {

    private Thread t;
    private Car[] cars;

    Thread3(Car[] _cars) {
        cars = _cars;
    }

    public void run() {
        try {
            //Criteria #3 : Serial Number
            Arrays.sort(cars);
            int i = 1;
            for (Car c : cars) {
                System.out.println("Seq: " + i++ + ", Serial Number: " + c.getSerialNumber() + ", Color: " + c.getColor() + ", Destination " + c.getDestination() + "");
            }
            System.out.println("-----*-----*-----*-----");
        } catch (Exception e) {
            System.out.println("ColorComparator Error");
        }
    }

    public void start() {
        System.out.println("Starting Thread - (Quick Serial Number by Color Field)");
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
