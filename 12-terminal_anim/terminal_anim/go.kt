//Eric Wong
//APCS2 pd8
//HW12
//2018-03-02

Q0: The two classes means that the java file treats them as two different objects.
Q1: the command line arguments are processed by inputting 2 numbers after &java Demo. ie. java Demo 12 200 - would result in a 12X12 board with a delay of 200ms.
Q2: if no command line arguments are given, then the program uses the default delay (500 ms) a8nd default board size (8X8)
Q3: recursion gives the program a limitation - it tells the program how long to run. It is not necessary for the animation itself, however.
Q4:I expect random spots on the board to be filled with numbers that increase by 1 but not necessarily all the spots will be filled.
Q5: I expect it to run for (sideLength*sideLength) - sideLength times.
Q6: ANSI stands for American National Standards Institute. By creating a uniform standard, ANSI codes can be used across different systems and platforms.

Q7: My observations was pretty consistent with my expectations. I observed that the numbers start at sideLength, which I had not take note of prior my running of the program. Just as I had expected, the numbers increment and are placed at random places, and can be placed over existed numbers.
Q8: this framework can be used to animate knights tour, expect in knights tour, the places a number could be placed cannot be random. They should only be able to move in an 'L' shape and should end up filling all the spaces. This is a good foundation to work from, however.

knight algo
1. Place a knight at any space on the board

2. Moving in an 'L' formation (2 down or up and 1 the other direction), find another possible spot
  a.if that spot is open, place knight there
    repeat step 2 with new position of knight(recursion)
  b.if that spot is not open, try another spot
    repeat step 2
  if there are no open spots,
    remove knight
    repeat step 2 (with the knight before this)

