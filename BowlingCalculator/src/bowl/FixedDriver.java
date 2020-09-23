package bowl;

import java.util.ArrayList;
import java.util.Scanner;

public class FixedDriver {

	public static void main(String[] args) {
		System.out.println("Please Enter Bowling scores in format **-**-**-...-***");
		boolean done = false;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			ArrayList<Frame> frames = new ArrayList<Frame>();
			
			String input = scan.nextLine();
			
			if(input.equals("done")) { //gives an exit condition in case the user wants to stop entering data
				done = true;
				break;
			}
			
			String[] brokenUpFrames = input.split("-");
			
			//System.out.println(input);
			
			for(int x = 0; x < brokenUpFrames.length; x++) {
				char[] tempCharArray = brokenUpFrames[x].toCharArray();
				String firstThrowOfFrame = "";
				String secondThrowOfFrame = "";
				String specialThrowOfFrame = "";
				
				firstThrowOfFrame = String.valueOf(tempCharArray[0]);
				
				
				switch (tempCharArray.length) {
					case 2:
						secondThrowOfFrame = String.valueOf(tempCharArray[1]);
						break;
					case 3:
						secondThrowOfFrame = String.valueOf(tempCharArray[1]);
						specialThrowOfFrame = String.valueOf(tempCharArray[2]);
						break;
					default:
						break;
				}
				
				frames.add(new Frame(firstThrowOfFrame, secondThrowOfFrame, specialThrowOfFrame));
			}
			
			Game game = new Game(frames);
			
			//System.out.println(game);
			
			System.out.println(game.findGameScore());
		} while (!done);
		
		scan.close();
		
	}

}
