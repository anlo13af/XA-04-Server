package main;
import GUI.GUILogic;

/**
 * Not used
 * @author andersliltorp
 *
 */
public class AdminWorker implements Runnable{
	public void run(){
		GUILogic admin = new GUILogic();
		admin.run();
	}
}
