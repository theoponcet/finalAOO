package main;

import java.util.Observable;
import java.util.Observer;

public class Log implements Observer {

	private Job jobUpdate;
	
	public Log(Job jobUpdate) {
		this.jobUpdate = jobUpdate;
	}

	@Override
	public void update(Observable observable, Object job) {
		jobUpdate = (Job) job;
        System.out.println("Document : " + jobUpdate.getDocument() +". Etat : " + jobUpdate.getState() + ". Imprimante : " + jobUpdate.getPrinter());
	}

}
