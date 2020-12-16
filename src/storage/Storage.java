package storage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Storage {

	
	@SuppressWarnings("unchecked")
	public List<Folder> folderlist = (List<Folder>) Collections.synchronizedCollection(new ArrayList());
	
	
	
	public Storage() {
		
	}
	
}