# CSCI 205 - Software Engineering and Design
Bucknell University
Lewisburg, PA

### Course Info
Instructor: Prof. Dancy

Semester: SP21
## Team Information: Rule.Baba is us
Anh Tran, Nguyen Nguyen, Christiaan Smith, Yuhan Chen
## Project Information
Final Project: Rule.Baba is you
## Project description:
<br>The original Rule.Baba is You game is a level-based puzzle game, where the game rules are present as blocks you can interact with. By manipulating them, the user can change the game rules in order to find out a way to get to the “win” condition. The game never gives you an answer on how to approach each puzzle, the only rules you follow are those that are shown on the screen by the blocks when pushed together to form sentences for example the three blocks pushed together. For example, forming “BABA” + “IS” + “YOU”, would give the player control to move the BABA object on the screen. If these blocks are disconnected, then their rule no longer applies to the game environment until they are reconnected.
<br>There are three different kinds of blocks to make rules in the game, Ones representing Objects in the level, ones representing actions, and ones used to connect these together. There are many many different rule blocks in the original game, so as to reduce the complexity of the project to a more manageable level, we will be creating smaller grid maps, and use a smaller list of possible rule blocks. We can also reduce the number of levels needed to maybe 4 or 5 to make it simpler to implement.
## Project package structure:
The code contains the following packages: gameboard, gameManager, gameMenu, instructions, levelMenu, mediaPlayer, Rule, and settings

Each package strictly follows the MVC design pattern, with the exception of the Rule package.

- The gameboard package contains the MVC code for the game in approach 1.

- The gameManager contains the code that controls the scene transition between the GUI packages

- The gameMenu contains the MVC code for the game menu
- The instructions contains the MVC code for the instructions of the game
- The levelMenu contains the MVC code for the level selection scene
- The mediaPlayer contains the code for the background music
- The Rule contains the code for the game in the second approach
- The settings contains the MVC code for the settings and customization of the game

## External libraries:
- javafx
    - Version: 14.0.2+1
    - URL: https://openjfx.io/  


