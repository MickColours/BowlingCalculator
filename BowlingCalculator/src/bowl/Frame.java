package bowl;

public class Frame {
	private String firstThrow = "";
	private String secondThrow = "";
	private String specialThrow = "";
	private int numberOfThrows;
	private boolean hasStrike = false;
	private boolean hasSpare = false;
	
	public Frame(String firstThrow, String secondThrow, String specialThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		this.specialThrow = specialThrow;
		
		if((firstThrow + secondThrow + specialThrow).contains("X")) {
			hasStrike = true;
		}
		else if((firstThrow + secondThrow + specialThrow).contains("/")) {
			hasSpare = true;
		}
		
		countThrows();
	}
	
	public Frame(String firstThrow, String secondThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		
		if((firstThrow + secondThrow).contains("X")) {
			hasStrike = true;
		}
		else if((firstThrow + secondThrow).contains("/")) {
			hasSpare = true;
		}
		
		countThrows();
	}
	
	public Frame(String firstThrow) { //only one throw in frame, must be strike
		this.firstThrow = firstThrow;
		
		hasStrike = true;
		
		countThrows();
	}
	
	
	public void countThrows() { //by concatenating all throw strings - those without values will not be counted in the total number of throws for the frame
		numberOfThrows = (firstThrow + secondThrow + specialThrow).length();
	}

	public String getFirstThrow() {
		return firstThrow;
	}

	public String getSecondThrow() {
		return secondThrow;
	}

	public String getSpecialThrow() {
		return specialThrow;
	}

	public int getNumberOfThrows() {
		return numberOfThrows;
	}

	public boolean isHasStrike() {
		return hasStrike;
	}

	public boolean isHasSpare() {
		return hasSpare;
	}
	
	/*public String getFrameScore() {
		if(hasStrike) {
			return "X";
		}
		else if(hasSpare) {
			return "/";
		}
		else {
			int tempFirstThrow = 0;
			int tempSecondThrow = 0;
			int tempSpecialThrow = 0;
			
			try {
				tempFirstThrow = Integer.parseInt(firstThrow);
			}
			catch(Exception e){
				return "NaN";
			}
			
			switch (numberOfThrows) {
				case 2:
					try {
						tempSecondThrow = Integer.parseInt(secondThrow);
					}
					catch(Exception e){
						return "NaN";
					}
				case 3:
					try  {
						tempSpecialThrow = Integer.parseInt(specialThrow);
					}
					catch (Exception e){
						return "NaN";
					}
				default:
					break;
			}
			
			return (tempFirstThrow + tempSecondThrow + tempSpecialThrow) + "";
			
		}
		
	}*/
	
	public String toString() {
		return firstThrow + secondThrow + specialThrow;
	}
	
}
