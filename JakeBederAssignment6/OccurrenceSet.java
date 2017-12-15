import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T> {
HashMap<T, Integer> hasher = new HashMap<>();
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return hasher.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (hasher.isEmpty()){
			return true;
		}else {
		return false;
	}
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (hasher.get(o) != null){
			return true;
		} else {
		return false;
	}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		ArrayList<Map.Entry> itList = new ArrayList<>();
		Set entrySet = hasher.entrySet();
		Iterator it = entrySet.iterator();
		while (it.hasNext()) {
			itList.add((Map.Entry) it.next());
		}
		ComparatorCheck cCheck = new ComparatorCheck();
		Collections.sort(itList,cCheck);
		ArrayList<T> itListCopy = new ArrayList<>();
		for (int i = 0; i < itList.size(); i++) {
			Map.Entry e = itList.get(i);
			itListCopy.add((T) e.getKey());
		}
		
		
		return itListCopy.iterator();
	}

	@Override
	public Object[] toArray() {
		
		// TODO Auto-generated method stub
		ArrayList<T> arrList = new ArrayList<>();
		Iterator<T> iterator = iterator();
		while(iterator.hasNext()){
			arrList.add(iterator.next());
		}
		return arrList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		// TODO Auto-generated method stub
		ArrayList<T> arrList = new ArrayList<>();
		Iterator<T> iterator = (Iterator<T>) iterator();
		while(iterator.hasNext()){
			arrList.add(iterator.next());
		}
		return arrList.toArray(a);
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if (hasher.containsKey(e)) {
			int x = hasher.get(e);
			x = x+1;
			hasher.put(e,x);
			return true;
		} else {
			hasher.put(e, 1);
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(hasher.containsKey(o)) {
			hasher.remove(o);
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		for (Object i:c) {
			if (hasher.containsKey(i) == false) {
			return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		for(T i : c) {
			this.add(i);
			return true;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		
		for (Object i : c) {
			if (c.contains(i)) {
				return true;
			}
		 else {
			this.remove(i);
		
		 }
		}return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		for (Object i : c) {
			this.remove(i);
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		hasher.clear();
		
	}
	
	public String toString() {
		return Arrays.toString(toArray());
	}
}
