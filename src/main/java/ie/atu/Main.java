package ie.atu;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        String name;
        String capacity_S;
        Set<String> studentsID = new HashSet<>();

        int attempts;

        Scanner scan =  new Scanner(System.in);
        System.out.println("Workshop name:");
        name = scan.nextLine();
        System.out.println("Capacity:");
        capacity_S = scan.nextLine();
        int capacity = Integer.parseInt(capacity_S);

        Workshop shop1 = new Workshop(name, capacity);

        System.out.printf("Number of registrations attempts: ");
        attempts = scan.nextInt();
        for(int i=0; i<attempts; i++)
        {
            System.out.println("Student ID: ");
            studentsID.add(scan.next());

            System.out.println("Registered");

            if(studentsID.containsAll(studentsID))
            {
                System.out.println("Already registered");
            }

            if(studentsID.isEmpty() || studentsID == null)
            {
                System.out.println("Invalid student ID");
            }

            if(attempts > capacity)
            {
                System.out.println("Workshop full");
            }
        }

    }
}