import models.Parcel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        boolean programRunning = true;
        ArrayList<Parcel> allParcels = new ArrayList<Parcel>();

        while(programRunning){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to Matt Squared Shipping.");
            try{
                System.out.println("Please select a shipping method: standard or priority");
                String userSpeed = bufferedReader.readLine();
                System.out.println("Would you like to have the package gift wrapped? - yes or no");
                String userWrapOption = bufferedReader.readLine();

                if(userSpeed.equals("standard") || userSpeed.equals("priority")){
                    System.out.println("Please enter package length in inches");
                    int userLength = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please enter package width in inches");
                    int userWidth = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please enter package height in inches");
                    int userHeight = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Please enter package weight in ounces");
                    int userWeight = Integer.parseInt(bufferedReader.readLine());
                    Parcel userParcel = new Parcel(userLength, userWidth, userHeight, userWeight);

                    userParcel.costToShip(userSpeed);
                    userParcel.giftWrap(userWrapOption);
                    allParcels.add(userParcel);


                    System.out.println("That package costs $" + userParcel.cost + " to ship.");
                    System.out.println("___________________________________________");
                    System.out.println("Would you like a receipt? - yes or no");
                    String userReceipt = bufferedReader.readLine();
                    if (userReceipt.equals("yes")) {
                        double total = 0.00;
                        for (Parcel individualParcel : allParcels) {
                            System.out.println("___________________________________________");
                            System.out.println(individualParcel.volume + " cubic inches");
                            System.out.println(individualParcel.weight + " ounces");
                            System.out.println("$" + individualParcel.cost);
                            total+=individualParcel.cost;
                        }
                        System.out.println("___________________________________________");
                        System.out.println("Total: $" + total);
                    }

                    System.out.println("___________________________________________");
                    System.out.println("Would you like to ship another package? - yes or no");
                    String userContinue = bufferedReader.readLine();
                    if (userContinue.equals("no")) {
                        programRunning = false;
                    }
                } else  {
                    System.out.println("Sorry, that's not a valid choice. Please try again.");
                }

            } catch (IOException e){
                e.printStackTrace();

            }
        }
    }
}
