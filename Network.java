package teamMaker;

import java.util.ArrayList;

public class Network {
	
	static ArrayList<PersonClass> hackerNetwork = new ArrayList<PersonClass>();
	int numOfHackers = 50;
	String[] names = {"Kevin Mitnick", "Anonymous", "Adrian Lamo", "Albert Gonzalez", "Matthew Bevan" , "Richard Pryce", "Jeanson James Ancheta", "Michael Calce", "Kevin Poulsen", "Jonathan James"
			,"Mark Abene", "Mitch Altman", "Jacob Appelbaum", "Trishneet Arora", "Loyd Blankenship", "Max Butler", "Brad Carter", "Cyber Anakin", "Jean-Bernard Condat", "Kim Dotcom", 
			"John Draper", "Mohamed Elnouby", "Eric S. Raymond", "Alexandra Elbakyan", "Bruce Fancher", "Joe Grand", "Richard Greenblatt", "Jeremy Hammond", "Susan Headley", "Billy Hoffman"
			, "The Jester", "Karl Koch", "Adrian Lamo", "Gordon Lyon", "Gary Mckinnon", "Jess Moss", "Katie Moussouris", "Craig Neidorf", "Beto O'Rourke", "Justin Tanner Peterson", 
			"Christien Rioux", "Alisa Shevchenko", "Matt Suiche", "Peter Samson", "Justine Tunner", "Kimberley Vanvaeck", "Steve Wozniak", "Peiter Zatko", "Cris Thomas", "Aaron Swartz"};
	
	public Network() {
		
		createNetwork();
		
		int[] scores = {0,0,0,0,0,3,2,0,0,0,0,2,2,0,0,0,0,0,0,0};
		PersonClass user = new PersonClass("John Smith", scores, true, 1);
		
		CompareClass userComparison = new CompareClass(user, hackerNetwork);
		userComparison.compare();
		
		hackerNetwork = CompareClass.getMatches();

	}

	private void createNetwork() {

		for (int i = 0; i < numOfHackers; i++) {
			int[] scores = new int[20];
			for (int j = 0; j < 20; j++) {
				if (Math.random() > 0.75) {
					scores[j] = (int) (5*Math.random());
				}else {
					scores[j] = 0;
				}
			}
			boolean preferance;
			if (Math.random() > 0.5) {
				preferance = true;
			}else {
				preferance = false;
			}
			int goals;
			if (Math.random() > 0.66) {
				goals = 1;
			}else if (Math.random() > 0.33) {
				goals = 2;
			}else {
				goals = 3;
			}
			
			hackerNetwork.add(new PersonClass(names[i], scores, preferance, goals));
		}
	}
}
