package demos;
import processing.core.*;

import org.joda.time.LocalTime;

public class DisplaySimpleWindow extends PApplet {
	//Warning variable
	private static final long serialVersionUID = 1L;
	
	//String variable of URL of the image
	private String URL = "https://www.oneaero.ru/uploads/pictures/plyazhi/bangkok/hua-hin-beach.jpg";
	
	//Object (maybe) of PImage
	private PImage backgroundImg;
	
	/*
	 * Time SetUp
	 */
	
	
	
	//Setup PApplet
	public void setup() {
		size(200,200);
		backgroundImg = loadImage(URL, "jpg");
	}
	
	//Showing up content in PApplet
	public void draw( ) {
		LocalTime curTime = LocalTime.parse("00:00");
		backgroundImg.resize(0, height);
		image(backgroundImg, 0, 0);
		//Get isBettwen method day time
		int time = isBetween(curTime);
		switch(time) {
			case 1:
				fill(255,244,188);
				break;
			case 2:
				fill(252,212,64);
				break;
			case 3:
				fill(253,94,83);
				break;
			case 4:
				fill(67,67,103);
		}
		ellipse(width/4, height/5, width/5, width/5);
	}
	
	public static int isBetween(LocalTime candidate){
		LocalTime morning = LocalTime.parse("8:00:00"); 
		LocalTime midday = LocalTime.parse("9:00:00");
		LocalTime evening = LocalTime.parse("18:00:00");
		LocalTime night = LocalTime.parse("22:00:00");
		
		//Check if it  morning
		if(!candidate.isBefore(morning) && !candidate.isAfter(midday)) {
			return 1;
		//Check if it midday
		} else if (!candidate.isBefore(midday) && !candidate.isAfter(evening)) {
			return 2;
		//Check if it evening
		} else if (!candidate.isBefore(evening) && !candidate.isAfter(night)) {
			return 3;
		}
		else {
			return 4;
		}
	}
}
