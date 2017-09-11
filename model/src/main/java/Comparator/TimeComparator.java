package Comparator;

import com.entities.Classes;

import java.util.Comparator;

public class TimeComparator implements Comparator<Classes>{

    public int compare(Classes c1, Classes c2) {

        return c1.getTime().compareTo(c2.getTime());
    }


}
