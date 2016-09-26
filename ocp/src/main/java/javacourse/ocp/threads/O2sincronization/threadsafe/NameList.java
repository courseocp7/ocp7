package javacourse.ocp.threads.O2sincronization.threadsafe;

import java.util.*;


/**
 * This class is using a Thread-safe member.
 * 
 * @author Jose Blesa
 *
 */
public class NameList {
	private List<String> names = Collections.synchronizedList(new LinkedList<String>());

	public void add(String name) {
		names.add(name);
	}

	public String removeFirst() throws InterruptedException {
		if (names.size() > 0){
			Thread.sleep(10000);
			return names.remove(0);
		}else
			return null;
	}
}
