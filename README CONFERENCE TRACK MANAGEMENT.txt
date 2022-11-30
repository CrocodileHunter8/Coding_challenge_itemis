I chose task 2, the Conference Track Management Problem. The biggest hurdle of this task is figuring out
how to balance the different conferences divided over the day. The basic idea is to implement the knapsack
algorithm. Everything in the program is self-implemented except for the knapsack algorithm, which i got from
the internet (the link is in the programming code as a comment)

There are two ways to run this programm


1. You run the program from an IDE Console. You need to write the conferences into the IDE Console.
It must be entered in the same format as the example of the task:

Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
etc.

You need to press the enter-button two times to accepting the input. The conferences get created in a text file.


2. You run the programm from the operating system console. You go to the src folder of the project and type 

"java ConferenceApplication .\sampleInput.txt" 

The conferences must be in the sampleInput.txt, in the same format as the example of the task:

Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
etc.