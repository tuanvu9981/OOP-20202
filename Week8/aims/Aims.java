package Week8.aims;

import Week8.aims.media.*;
import Week8.aims.order.Order;

import java.util.Scanner;

import static Week7.hust.soict.hedspi.aims.order.Order.MAX_LIMITED_ORDERED;
import static Week7.hust.soict.hedspi.aims.order.Order.getNbOrder;

public class Aims {
    public static void main(String[] args) {
        int choice, id;
        Scanner scn = new Scanner(System.in);
        String space = "";
        Order myorder = createNewOrder();
        //nbOrder from -1 become 0.

        while(true) {
            showMenu();
            choice = scn.nextInt();
            space = scn.nextLine();
            //can't createNewOrder() here --> unknown loops.

            switch (choice) {
                case 1:
                    System.out.println("1. Create new order");
                    myorder = createNewOrder();
                    if(myorder == null) System.out.println("Cannot create another order");
                    else {
                        //myorder.setDateOrdered(13,4,2021);
                        System.out.println("Created order successfully!");
                    }
                    break;

                case 2:
                    System.out.println("2. Add item to the order\n");
                    Media new_mdf = showMenuCreation();
                    if(new_mdf != null) {
                        System.out.println(myorder.addMedia(new_mdf));
                    }
                    break;

                case 3:
                    System.out.println("3. Delete item by id");
                    System.out.print("Input id of item you wanna delete: ");
                    id = scn.nextInt();
                    space = scn.nextLine();
                    System.out.println(myorder.removeMedia(id));
                    break;

                case 4:
                    System.out.println("4. Display item list of order");
                    myorder.printOrder();
                    break;

                case 0:
                    System.out.println("0. Exit");
                    break;

                default:
                    System.out.println("Entered number doesn't exit.");
                    break;
            }
            if(choice == 0) break;
        }
    }

    public static void showMenu(){
        System.out.println("\nOrder Management Application ");
        System.out.println("_____________________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display item list of order");
        System.out.println("0. Exit");
        System.out.println("_____________________________");
        System.out.println("Choose a number: 0-1-2-3-4");
        System.out.print("Your choice: ");
    }

    public static Order createNewOrder(){
        if(getNbOrder() > MAX_LIMITED_ORDERED){
            System.out.println("Number of Order surpassed MAXIMUM");
            return null;
        }
        else {
            Order oror = new Order();
            return oror;
        }
    }

    public static Media showMenuCreation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t1. Create DigitalVideoDisc (DVD)");
        System.out.println("\t2. Create Compact Disc (CD)");
        System.out.println("\t3. Create Book");
        //System.out.println("\t4. Create Intelligent Pen");

        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("1. Create DigitalVideoDisc (DVD)");
                return createItemFromConsole(new DVDFactory());

            case 2:
                System.out.println("2. Create Compact Disc (CD)");
                return createItemFromConsole(new CDFactory());

            case 3:
                System.out.println("3. Create Book");
                return createItemFromConsole(new BookFactory());

            default:
                System.out.println("Entered number doesn't exist.");
                return null;
        }
    }

    public static Media createItemFromConsole(AbstractItemFactory factory){
        // parameter: factory (an interface = abstract class)
        // return a method createMediaItemFromConsole() (return a Media)
        return factory.createMediaItemFromConsole();
    }
    //24 pattern ??? --> composit ??
}