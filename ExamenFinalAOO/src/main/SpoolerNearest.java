package main;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SpoolerNearest extends Spooler{
	
	private ArrayList<Integer> distances;
	
	public SpoolerNearest() {}
	
	@Override
	public void findBestPrinter(User aUser,Job aJob) {
		for (Printer printer : printers) {
			distances.add(Localisation.distance(aUser,printer));
		}
		schedule(aUser, aJob, printers.get(distances.indexOf(Collections.min(distances))) );
		
		return;
		
	}

}
