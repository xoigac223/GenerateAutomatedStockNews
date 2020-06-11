package app;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class News {
	
	private List<Tag> listTag;
	private List<Set<String>> listDoanVan;
	
	public News () {
		listTag = new ArrayList<Tag>();
		listDoanVan = new ArrayList<Set<String>>();
	}

	public List<Tag> getListTag() {
		return listTag;
	}
	
	
	public void add(Tag tag) {
		listTag.add(tag);
	}
	
	public int getSize() {
		return listTag.size();
	}
	
	public static Set<String> mergeSet(List<Set<String>> arr) 
    { 
         Set<String> sets = new LinkedHashSet<String>();
         for (int i = 0; i < arr.size(); i++) {
        	 sets.addAll(arr.get(i));
         }
         return sets;
    }
	
	public String sinhBai(List<Boolean> listTagCheck) {
		StringBuffer sb = new StringBuffer();
		Set<String> setDoanVan = new LinkedHashSet<String>();
		for (int i = 0 ; i < listTag.size(); i++) {
			if (listTagCheck.get(i) == true) listDoanVan.add(listTag.get(i).sinhDoanVan());
		}
		setDoanVan = mergeSet(listDoanVan);
		for (String cauVan : setDoanVan) {
			sb.append(cauVan);
		}
		return sb.toString();
	}
	
}
