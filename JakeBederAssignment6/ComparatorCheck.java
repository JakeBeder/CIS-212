import java.util.Comparator;
import java.util.Map;
public class ComparatorCheck implements Comparator<Map.Entry>  {

	public int compare(Map.Entry a, Map.Entry b) {
		// TODO Auto-generated method stub
		int x = (Integer)a.getValue() - (Integer)b.getValue();
		return x;
	}

}
