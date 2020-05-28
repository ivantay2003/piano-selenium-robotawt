package keydefine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class keydefination {
	
	List<Map<String, String>> keysChordCoord = new ArrayList<Map<String, String>>();
	Map<Object,ArrayList<Object>> multiMap = new HashMap<Object, ArrayList<Object>>();
	Robot r ;
	

	
	public keydefination () {
		
		setup();
	}
	
	public void setup() {
		
		try {
			r = new Robot();
			keysChordCoord = readChordCoordinatesFile();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map <String, String> getCoord (int keyNum) {
		

		Map coord = new HashMap ();
		coord=keysChordCoord.get(keyNum);

		
		return coord;
		
		
	}
	
	public void KeysPress (int keyNum, int duration) {

			
		Map coord= getCoord (keyNum);
		
		//System.out.println (coord.get("x"));
		int x = (Integer.valueOf(String.valueOf(coord.get("x"))));
		int y = (Integer.valueOf(String.valueOf(coord.get("y"))));
		r.mouseMove(x, y); //9
	  
		r.mousePress(InputEvent.BUTTON2_MASK);
		r.delay(duration);
		r.mouseRelease(InputEvent.BUTTON2_MASK);
	}
	
	public List<Map<String, String>> readChordCoordinatesFile() {
		
		String filename = "keysChord.json";
		List<Map<String, String>> keys = new ArrayList<Map<String, String>>();
		
		try {
			
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(new FileReader(filename));  
            JSONArray jsonArr = (JSONArray)object;
            
            for (int i=0; i<jsonArr.size(); i++) {
            	
            	JSONObject jsonObj = (JSONObject) jsonArr.get(i);
            	Map map = new HashMap();
            	map.put("x", jsonObj.get("x"));
            	map.put("y", jsonObj.get("y"));
            	keys.add(map);
            	
            
            }
            
            
            
       } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return keys;
		
	}
	
	
	public String [] readFile (String filename) {
		
		String [] lineSplit ;
		try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);

		      
		      String line = myReader.nextLine();
		      System.out.println (line);
		      lineSplit = line.split("\\s+");
		      System.out.println (lineSplit);
		      
		     
		      
		      myReader.close();
		      
		      return lineSplit;
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      
		      return null;
		    }
		
		
		 
	}
	
	int getDuration (String dur) {
		
		int duration =0;
		
		dur = dur.toLowerCase();
		
		switch (dur) {
		
		case "a":

			duration = 25;
			break;
		case "b":

			duration = 50;
			break;
		case "c":

			duration = 75;
			break;
		case "d":

			duration = 100;
			break;
		case "e":

			duration = 200;
			break;
		case "f":

			duration = 300;
			break;
		case "g":

			duration = 500;
			break;
		case "h":

			duration = 750;
			break;
		case "i":

			duration = 1000;
			break;
		case "j":

			duration = 2000;
			break;
		default:

			duration = 500;
		}
		
		
		
		
		
		return duration;
	}
	public void Play (String filename) {
		
		String [] keynotes = readFile (filename);
		int duration ;
		
		for (int i=0; i<keynotes.length; i++) {
			
			System.out.println (keynotes[i]);
			String[] part = keynotes[i].split("(?<=\\D)(?=\\d)");
			
			if (part.length==1){
				duration = 500;

				System.out.println ("Key Number : " + part[0] + " , duration : " + duration + " ms ");
				KeysPress (Integer.valueOf (part[0]),duration);
				
				
			}else {
				duration = getDuration(part[0]);
				System.out.println("Key Number : " + part[1] + " , duration : " + duration + " ms ");
				KeysPress (Integer.valueOf(part[1]),duration);
			}
			
			
			

			
		}
	}
	


	
}
