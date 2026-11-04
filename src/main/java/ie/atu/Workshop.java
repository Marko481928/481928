package ie.atu;

import java.util.Set;
import java.util.HashSet;

public class Workshop
{
    private String workShopName;
    private int capacity;
    private Set<String> studentsID = new HashSet<>();

    public Workshop(String workShopName, int capacity)
    {
        this.workShopName = workShopName;
        this.capacity = capacity;

    }


}
