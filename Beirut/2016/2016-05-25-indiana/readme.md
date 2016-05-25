###Date: 2016/05/25
###Source: Codingame 
###Problem Description: Indiana - Level 1

Description:
Your objective is to write a program capable of predicting the route Indy will take on his way down a tunnel. Indy is not in danger of getting trapped in this first mission.
Rules
The tunnel consists of a patchwork of square rooms of different types.The rooms can be accessed and activated by computer using an ancient RS232 serial port (because Mayans aren't very technologically advanced, as is to be expected...).

There is a total of 14 room types (6 base shapes extended to 14 through rotations).

Upon entering a room, depending on the type of the room and Indy's entrance point (TOP,LEFT, or RIGHT) he will either exit the room through a specific exit point, suffer a lethal collision or lose momentum and get stuck.

Indy is perpetually drawn downwards: he cannot leave a room through the top.

At the start of the game, you are given the map of the tunnel in the form of a rectangular grid of rooms. Each room is represented by its type.

For this first mission, you will familiarize yourself with the tunnel system, the rooms have all been arranged in such a way that Indy will have a safe continuous route between his starting point (top of the temple) and the exit area (bottom of the temple).

Each game turn:
You receive Indy's current position
Then you specify what Indy's position will be next turn.
Indy will then move from the current room to the next according to the shape of the current room.
 
Victory Conditions
Indy reaches the exit
 
Lose Conditions
You assert an incorrect position for Indy

#Retrospective	 
1. Easy and it was nice to solve it using modular code 
2. We learned more about code design
3. The challenge was to solve the code while maintaining a reusable design
4. I like the idea of seeing the output of the algorithm we write in action
5. It was fun 