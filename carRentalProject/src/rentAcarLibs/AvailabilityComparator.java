
package rentAcarLibs;

import java.util.Comparator;


public class AvailabilityComparator implements Comparator <Object[]>{
    @Override
    public int compare(Object[] car1, Object[] car2) {
        
        return ((String) car1[5]).compareTo((String) car2[5]);
    }
    
}
