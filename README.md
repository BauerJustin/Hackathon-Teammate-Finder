# Hackathon-Teammate-Finder
Hack the Valley 4 submission (February 2020).

## Run Instructions
Download the [HackathonTeammateFinder.jar](https://github.com/justinbauer-1/Hackathon-Teammate-Finder/blob/master/HackathonTeammateFinder.jar) file to see the program in action with a pre-set profile. On the other hand, you can download all the files and run the HackathonTeammateFinderGUI.java file to start the program. 

To customize your profile (cannot be done using the jar file, must be done locally), open the Network.java file and modify:

`int[] scores = {0,0,0,0,0,3,2,0,0,0,0,2,2,0,0,0,0,0,0,0};`

`PersonClass user = new PersonClass("John Smith", scores, true, 1);`

* Replace first parameter "John Smith" with a string of your name
* Rank your technical ability for each index in the scores array from 0-5
  * Respectively indexes are React, CSS, HTML, JavaScript, Swift, Java, C/C++, C#, Ruby, PHP, .NET, Python, SQL, MongoDB, Firebase, Google Cloud, Google Azure, Android Studio, Raspberry PI and Arduino.
* Set third parameter to:
  * true if you want to work with people at the same level (same ability  as you)
  * false if you don't care what level the people are compared to you
* Set forth parameter to which one is more important:
  * 1 - Winning
  * 2 - Learning
  * 3 - Having fun

## Background
Java GUI program where the user can go through a list of fellow (random) hackers to try and find matching teammates to attend a hackathon with. The program acts like tinder where users can approve or decline other hackers and if users match they can attend the hackathon together. Myself and three other students came up with this idea at Hack the Valley 4. For most of us it was our first hackathon and none of use knew each other ahead of time. Instead of the stress of trying to message people in Facebook groups ahead of time or trying to find people at the hackathon we thought having a teammate finder would solve that problem.

In this repository, it is only my portion of the project which is the tinder GUI portion. Before that the user would conduct a survey on a website which would then take that information and import it into the GUI. However, I do not have access to this portion of the project.

## Project components
HackathonTeammateFinderGUI.java: 

This is the main program which creates the GUI and presents the information to the user. The user can interact with this GUI by approving or declining the hacker presented. The GUI updates with the hackers in the order of predicted preference for the user.

PersonClass.java:

Class which contains all the hacker attributes such as their languages and preferences. This program calculates scores on front end, back end, data base and hardware knowledge which will be used to compare hackers. 

CompareClass.java:

This program compares hackers with the user and sorts the hackers into a list based on their calculated scores. The list goes from best match to worst match. 

Network.java:

The network program contains the user's information as well as a list of hackers. The network creates the network at random to have a test database of random hackers. Then the user is compared with the network using the CompareClass. The output is then presented in the GUI for the user to see.
