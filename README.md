# Mars-Rover
NASA intends to land robotic rovers on Mars to explore a particularly curious-looking plateau. The rovers must navigate this rectangular plateau in a way so that their on board cameras can get a complete image of the surrounding terrain to send back to Earth.

A simple two-dimensional coordinate grid is mapped to the plateau to aid in rover navigation. Each point on the grid is represented by a pair of numbers X Y which correspond to the number of points East or North, respectively, from the origin. The origin of the grid is represented by 0 0 which corresponds to the southwest corner of the plateau. 0 1 is the point directly north of 0 0, 1 1 is the point immediately east of 0 1, etc. A rover’s current position and heading are represented by a triple X Y Z consisting of its current grid position X Y plus a letter Z corresponding to one of the four cardinal compass points, N E S W. For example, 0 0 N indicates that the rover is in the very southwest corner of the plateau, facing north.

NASA remotely controls rovers via instructions consisting of strings of letters. Possible instruction letters are L, R, and M. L and R instruct the rover to turn 90 degrees left or right, respectively (without moving from its current spot), while M instructs the rover to move forward one grid point along its current heading.

Your task is write an application that takes the test input (instructions from NASA) and provides the expected output (the feedback from the rovers to NASA). Each rover will move in series, i.e. the next rover will not start moving until the one preceding it finishes.

<b>INPUT:</b>
Assume the southwest corner of the grid is 0,0 (the origin). The first line of input establishes the exploration grid by indicating the coordinates corresponding to the northeast corner of the plateau.

Next, each rover is given its instructions in turn. Each rover’s instructions consists of two lines of strings. The first string confirms the rover’s current position and heading. The second string consists of turn / move instructions.

<b>OUTPUT:</b>
Once each rover has received and completely executed its given instructions, it transmits its updated position and heading to NASA.


---



<b>EXPLANATION OF DESIGN:</b>
To implement my solution, I created two classes Mars and Rover. Mars contains the grid size and creates the rover instances. The Mars class also handles the user input and runs the executeCommands() function which makes calls to the Rover class. Inside the Rover class is where the majority of the logic is contained. The Rover checks to make sure each command is both valid and physically possible given the grid size. Upon construction of the Rover instance, the currentDirection of the Rover is converted to an index variable of type Integer, in order to make it easier to cycle through the validDirections[] in correct order. There are methods to handle the rotations as well as the actual movements made by the Rover. I made as many of the variable and methods private as I could, treating this as if it was a serious program actually being used by NASA.

<b>ASSUMPTIONS:</b>

-The Rover will never run out of battery or power

-The Rover can only move forward, not backwards

-The Rover can only rotate at 90 degree angles, and only move 1 unit at a time
