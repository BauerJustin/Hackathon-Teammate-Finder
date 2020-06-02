package teamMaker;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TeamMakerGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblTeamLevel;
	private JLabel lblGoal;
	private JLabel lblSkills;
	private JLabel lblRatings;
	private JLabel lblFE;
	private JLabel lblBE;
	private JLabel lblDB;
	private JLabel lblHW;
	private JTextField txtName;
	private JTextField txtTeamLevel;
	private JTextField txtGoal;
	private JTextField txtSkills;
	private JTextField txtFE;
	private JTextField txtBE;
	private JTextField txtDB;
	private JTextField txtHW;
	private JButton btnRight;
	private JButton btnLeft;
	private int currentPerson;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network me = new Network();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamMakerGUI frame = new TeamMakerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TeamMakerGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name: ");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 10, 90, 25);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(10, 35, 465, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		lblTeamLevel = new JLabel("Team Level: ");
		lblTeamLevel.setForeground(Color.WHITE);
		lblTeamLevel.setBounds(10, 60, 90, 25);
		contentPane.add(lblTeamLevel);
		
		txtTeamLevel = new JTextField();
		txtTeamLevel.setEditable(false);
		txtTeamLevel.setBounds(10, 85, 465, 25);
		contentPane.add(txtTeamLevel);
		txtTeamLevel.setColumns(10);
		
		lblGoal = new JLabel("Goal: ");
		lblGoal.setForeground(Color.WHITE);
		lblGoal.setBounds(10, 110, 90, 25);
		contentPane.add(lblGoal);
		
		txtGoal = new JTextField();
		txtGoal.setEditable(false);
		txtGoal.setBounds(10, 135, 465, 25);
		contentPane.add(txtGoal);
		txtGoal.setColumns(10);
		
		lblSkills = new JLabel("Skills: ");
		lblSkills.setForeground(Color.WHITE);
		lblSkills.setBounds(10, 160, 90, 25);
		contentPane.add(lblSkills);
		
		txtSkills = new JTextField();
		txtSkills.setEditable(false);
		txtSkills.setBounds(10, 185, 465, 25);
		contentPane.add(txtSkills);
		txtSkills.setColumns(10);
		
		lblRatings = new JLabel("Ratings: ");
		lblRatings.setForeground(Color.WHITE);
		lblRatings.setBounds(10, 210, 90, 25);
		contentPane.add(lblRatings);
		
		lblFE = new JLabel("Front End: ");
		lblFE.setForeground(Color.WHITE);
		lblFE.setBounds(60, 235, 90, 25);
		contentPane.add(lblFE);
		
		txtFE = new JTextField();
		txtFE.setEditable(false);
		txtFE.setBounds(60, 260, 100, 25);
		contentPane.add(txtFE);
		txtFE.setColumns(10);
		
		lblBE = new JLabel("Back End: ");
		lblBE.setForeground(Color.WHITE);
		lblBE.setBounds(60, 285, 90, 25);
		contentPane.add(lblBE);
		
		txtBE = new JTextField();
		txtBE.setEditable(false);
		txtBE.setBounds(60, 310, 100, 25);
		contentPane.add(txtBE);
		txtBE.setColumns(10);
		
		lblDB = new JLabel("Database: ");
		lblDB.setForeground(Color.WHITE);
		lblDB.setBounds(60, 335, 90, 25);
		contentPane.add(lblDB);

		txtDB = new JTextField();
		txtDB.setEditable(false);
		txtDB.setBounds(60, 360, 100, 25);
		contentPane.add(txtDB);
		txtDB.setColumns(10);
		
		lblHW = new JLabel("Hardware: ");
		lblHW.setForeground(Color.WHITE);
		lblHW.setBounds(60, 385, 90, 25);
		contentPane.add(lblHW);

		txtHW = new JTextField();
		txtHW.setEditable(false);
		txtHW.setBounds(60, 410, 100, 25);
		contentPane.add(txtHW);
		txtHW.setColumns(10);
		
		btnRight = new JButton("Decline");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnRight_MouseClicked(arg0);
			}
		});
		btnRight.setBackground(UIManager.getColor("Button.light"));
		btnRight.setBounds(350, 400, 120, 25);
		contentPane.add(btnRight);
		
		btnLeft = new JButton("Approve");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnLeft_MouseClicked(arg0);
			}
		});
		btnLeft.setBackground(UIManager.getColor("Button.light"));
		btnLeft.setBounds(200, 400, 120, 25);
		contentPane.add(btnLeft);
		
		currentPerson = 0;
		
		setControls();
	}
	
	private void setControls() {
		
		PersonClass person = Network.hackerNetwork.get(currentPerson);
		
		this.txtName.setText(person.getName());
		if (person.getPerferability()) {
			this.txtTeamLevel.setText("Same level");
		}else {
			this.txtTeamLevel.setText("Any level");
		}
		if (person.getGoals() == 1) {
			this.txtGoal.setText("Win");
		}else if (person.getGoals() == 2) {
			this.txtGoal.setText("Learn");
		}else {
			this.txtGoal.setText("Have fun");
		}
		String languages = "";
		for (int i = 0; i < person.getScores().length; i++) {
			if (person.scores[i] != 0) {
				if(i == 0) {
					languages += "React, ";
				}else if(i == 1) {
					languages += "CSS, ";
				}else if(i == 2) {
					languages += "HTML, ";
				}else if(i == 3) {
					languages += "Javascript, ";
				}else if(i == 4) {
					languages += "Swift, ";
				}else if(i == 5) {
					languages += "Java, ";
				}else if(i == 6) {
					languages += "C/C++, ";
				}else if(i == 7) {
					languages += "C#, ";
				}else if(i == 8) {
					languages += "Ruby, ";
				}else if(i == 9) {
					languages += "PHP, ";
				}else if(i == 10) {
					languages += ".NET, ";
				}else if(i == 11) {
					languages += "Python, ";
				}else if(i == 12) {
					languages += "SQL, ";
				}else if(i == 13) {
					languages += "MongoDB, ";
				}else if(i == 14) {
					languages += "Firebase, ";
				}else if(i == 15) {
					languages += "Google Cloud, ";
				}else if(i == 16) {
					languages += "Google Azure, ";
				}else if(i == 17) {
					languages += "Android Studio, ";
				}else if(i == 18) {
					languages += "Raspberry PI, ";
				}else {
					languages += "Arduino, ";
				}
			}
		}
		if (languages != "") {
			languages = languages.substring(0, (languages.length()-2));
		}
		this.txtSkills.setText(languages);
		this.txtFE.setText(Double.toString(Math.round(person.getCalculatedScores()[0]*100.0)/100.0));
		this.txtBE.setText(Double.toString(Math.round(person.getCalculatedScores()[1]*100.0)/100.0));
		this.txtDB.setText(Double.toString(Math.round(person.getCalculatedScores()[2]*100.0)/100.0));
		this.txtHW.setText(Double.toString(Math.round(person.getCalculatedScores()[3]*100.0)/100.0));
		
	}
	protected void btnRight_MouseClicked(MouseEvent arg0) {
		
		if (currentPerson != CompareClass.getMatches().size()-1) {
			currentPerson++;
			setControls();
		}
		
		
	}
	protected void btnLeft_MouseClicked(MouseEvent arg0) {
		
		if (currentPerson != CompareClass.getMatches().size()-1) {
			currentPerson++;
			setControls();
		}
	}
}
