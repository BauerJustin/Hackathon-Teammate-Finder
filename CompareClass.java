package teamMaker;

import java.util.ArrayList;

public class CompareClass {
	
	PersonClass user;
	ArrayList<PersonClass> hackerNetwork;
	static ArrayList<PersonClass> matches;

	public CompareClass(PersonClass user, ArrayList<PersonClass> hackerNetwork) {
		
		this.user = user;
		this.hackerNetwork = hackerNetwork;
	}

	public void compare() {
		
		matches = new ArrayList<PersonClass>();
		for (int i = 0; i < this.hackerNetwork.size(); i++) {
			double score = 0;
			if (this.user.getPerferability() == this.hackerNetwork.get(i).getPerferability()) {
				score++;
			}
			if (this.user.getGoals() == this.hackerNetwork.get(i).getGoals()) {
				score++;
			}
			if (this.user.perferability == true) {
				for (int j = 0; j < 4; j++) {
					if (this.user.getScores()[j] == 0 && this.hackerNetwork.get(i).getScores()[j] == 0) {
						score += 1;
					}
					else if (this.user.getScores()[j]*100.0 / (this.hackerNetwork.get(i).getScores()[j]) >= 80 && this.user.getScores()[j]*100.0 / (this.hackerNetwork.get(i).getScores()[j]) <= 120) {
						score += 4.1;
					}
				}
			}else {
				for (int j = 0; j < 4; j++) {
					if (this.user.getScores()[j] > 0 && this.hackerNetwork.get(i).getScores()[j] > 0) {
						score += 4.1;
					}
				}
			}
			
			
			this.hackerNetwork.get(i).setRanking(score);
			
			if (matches.size() == 0) {
				matches.add(this.hackerNetwork.get(i));
			}else {
				boolean loopComplete = false;
				for (int j = 0; j < matches.size(); j++){
					if (this.hackerNetwork.get(i).getRanking() > this.matches.get(j).getRanking()) {
						matches.add(j, this.hackerNetwork.get(i));
						loopComplete = true;
						break;
					}
				}if (!loopComplete) {
					matches.add(this.hackerNetwork.get(i));
				}
			}
		}
	}

	public static ArrayList<PersonClass> getMatches() {
		
		return matches;
	
	}

}
