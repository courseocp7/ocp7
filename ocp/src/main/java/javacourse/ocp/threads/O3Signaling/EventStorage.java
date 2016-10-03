package javacourse.ocp.threads.O3Signaling;

public interface EventStorage {

	void set(Event e) throws InterruptedException;

	Event get() throws InterruptedException;

}