package ie.atu;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String workshopName;
        int capacity;
        int attempts;
        int count = 0;
        int rejectedAttempts = 0;
        HashSet<String> registrations = new HashSet<>();

        System.out.println("Enter workshops name: ");
        workshopName = scan.next();
        System.out.println("\nEnter capacity: ");
        capacity = scan.nextInt();
        System.out.println("\nEnter number of registration attempts: ");
        attempts = scan.nextInt();

        for(int i = 1; i <= attempts; i++)
        {
            System.out.println("\nEnter Student's ID");
            String ID = scan.nextLine();

            if (registrations.contains(ID))
            {
                System.out.println(ID + " - Already registered.");
                rejectedAttempts++;
            }
            else
            {
                if(ID.isBlank() || ID.isEmpty())
                {
                    System.out.println("ID can't be null");
                    rejectedAttempts++;
                }
                else
                {
                    count++;
                    if(count > capacity)
                    {
                        System.out.println(ID + "- Workshop full\n");
                        rejectedAttempts++;
                        count--;
                    }
                    else
                    {
                        System.out.println(ID + " - Registration successful.");
                        registrations.add(ID);
                    }
                }

            }
        }

        Workshop workshop = new Workshop(workshopName, capacity, registrations);

        workshop.printinfo();
        System.out.println(count + " - accepted attempts");
        System.out.println(rejectedAttempts + " - rejected attempts");
        System.out.println(capacity - count + " - places remaining");
    }
}
