package ie.atu;

import java.util.Set;
import java.util.HashSet;

public class Workshop
{
    private String workShopName;
    private int capacity;
    private Set<String> studentsID = new HashSet<>();

    public Workshop(String workShopName, int capacity, Set<String> studentsID)
    {
        this.workShopName = workShopName;
        this.capacity = capacity;
        this.studentsID = studentsID;
    }

    public void printinfo()
    {
        System.out.println("Workshop name - " + workShopName);
        System.out.println("Capacity - " + capacity);
        System.out.println("Student ID's - " + studentsID);
    }


}
