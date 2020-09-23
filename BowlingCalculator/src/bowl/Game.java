package bowl;

import java.util.ArrayList;



public class Game {
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	
	
	public Game() {
		
	}
	
	public Game(ArrayList<Frame> frames) {
		this.frames = frames;
	}
	
	public void addFrame(Frame frameToAdd) {
		frames.add(frameToAdd);
	}
	
	public int findGameScore() {
		int gameScore = 0;
		
		for(int x = 0; x < frames.size(); x++) {
			
			Frame currentFrame = frames.get(x);
			
			
			if(frames.get(frames.size() - 1) != currentFrame) { //all frames that are not the last frame
				Frame nextFrame = frames.get(x + 1);
				
				if(frames.get(frames.size() - 1) != nextFrame) { //all frames that are not the last or second to last frame
					if(currentFrame.isHasStrike()) { //Strike on this Frame
						gameScore += 10;
						
						if(nextFrame.isHasStrike()) { //next throw is also a strike
							gameScore += 10;
							
							if(frames.get(x + 2).isHasStrike()) { // third throw is also a strike
								gameScore += 10;
							}
							else {
								gameScore += Integer.parseInt(frames.get(x + 2).getFirstThrow());
							}
						}
						else if(nextFrame.isHasSpare()){ //the next two throws will result in a spare, equaling 10 points collectively
							gameScore += 10;
						}
						else {
							gameScore += Integer.parseInt(nextFrame.getFirstThrow());
							gameScore += Integer.parseInt(nextFrame.getSecondThrow());
						}
					}
					else if(currentFrame.isHasSpare()){ //Spare on this Frame
						gameScore += 10;
						
						if(nextFrame.isHasStrike()) { //next throw is a strike
							gameScore += 10;
						}
						else {
							gameScore += Integer.parseInt(nextFrame.getFirstThrow());
						}
					}
					
					else {
						gameScore += Integer.parseInt(currentFrame.getFirstThrow());
						gameScore += Integer.parseInt(currentFrame.getSecondThrow());
						
					}
				}
				else { //the second to last frame
					if(currentFrame.isHasStrike()) {
						gameScore += 10;
						
						//gameScore += StringUtils.countOccurencesOf(nextFrame.toString(), "X");
						if(nextFrame.getSpecialThrow().equals("X")) { //the next throw could be a strike
							gameScore += (10 * ((nextFrame.getFirstThrow() + nextFrame.getSecondThrow()).chars().filter(X -> X == 'X').count())); //converting first two throws of final frame to string and counting X(strikes)'s
						}
						else { //no strike, so normal calculation adding on to the next two throws
							gameScore += (Integer.parseInt(nextFrame.getFirstThrow()) + Integer.parseInt(nextFrame.getSecondThrow()));
						}
					}
					else if(currentFrame.isHasSpare()) {
						gameScore += 10;
						gameScore += nextFrame.getFirstThrow().equals("X") ? 10 : Integer.parseInt(nextFrame.getFirstThrow());
						
					}
					else {
						gameScore += (Integer.parseInt(currentFrame.getFirstThrow()) + Integer.parseInt(currentFrame.getSecondThrow()));
					}
					
				}
			}
			else { //you're in the last frame
				if(currentFrame.getFirstThrow().equals("X")) { //first throw is a strike
					gameScore += (10 * ((currentFrame.getFirstThrow() + currentFrame.getSecondThrow() + currentFrame.getSpecialThrow()).chars().filter(X -> X == 'X').count()));
				}
				else if(currentFrame.isHasSpare()) {
					if(currentFrame.getSpecialThrow().equals("X")) {
						gameScore += 20;
					}
					else {
						gameScore += (10  + Integer.parseInt(currentFrame.getSpecialThrow()));
					}
				}
				else {
					gameScore += (Integer.parseInt(currentFrame.getFirstThrow()) + Integer.parseInt(currentFrame.getSecondThrow()));
				}
			}
		}
		
		return gameScore;
	}
	
	public String toString() {
		String returnString = "";
		
		for(Frame frame : frames) {
			returnString += frame.toString() + "\t";
		}
		
		return returnString;
	}
}
