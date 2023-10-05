package rentAcarLibs;

import java.util.Comparator;

public class BrandComparator implements Comparator<Object[]> {
    @Override
    public int compare(Object[] car1, Object[] car2) {
        return ((String) car1[0]).compareTo((String) car2[0]);
    }
}
