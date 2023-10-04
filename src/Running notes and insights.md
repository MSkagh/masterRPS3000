# Reflection
I started with a rough planning regarding what design-patterns I would like to incorporate. 
Itching to see what I planned wrong, I started to code. I started with building a State-pattern
for the menu-system and a Memento-pattern for storing played games. I immediately decided that I
would also use a state-pattern for handling the behavior for the NPC-opponent. I drew up the class
for the Player and the "Game".

At this point I had a lot of code, but I had not decided how they would interact or 
their dependencies. Nor did I have any tests or any runnable code to verify the validity of 
the code, so I started building out the menu-system. At first I ran everything from the
menu-system. And it worked as I added more functionality and more features, however, that quickly
became a lot of bloated anonymous functions in the menus which hardly fit in with the 
Single-Responsibility-Principle nor was it in line with what the menu-system was designed for.

I fleshed out the Game-class to be the driver for the loops of the game and the logic for how it
acts. It was at once easier to navigate through the code.

At this point everything boiled down to smaller and smaller components and smaller and smaller
functions. By following the Single-Responsibility-Principle I could give descriptive enough
names to said functions as to let other people understand what was happening without actually
reading any of the code. Of course, naming functions on the go is all well and good, but in my case,
it is never final and I spent a fair amount of time renaming functions. For example, a function
that displays results would be named displayResults. A fair name given you know exactly which
results are displayed. The name displayRoundResults would be better given that the results
regard the round. A better way to handle this would be with an Interface now that I reflect on it.
An interface would also be more in line with the Interface-Segregation-Principle. Alas, I did 
not opt for that. I achieved basically the same result by following the 
Single-Responsibility-Principle, but the syntax would have been better with the interface instead.

For some reason or another I felt that I mentally went about this project all wrong. I felt that
I needed to incorporate design-patterns by default instead of actually needing them. I was,
at one point, dead set on not letting classes depend on each other more than necessary
 to the extent that it inhibited the code. The next time around I will try to keep the 
SOLID-principles not as a defining rule but as a measurement of best practices because
refactoring and rewriting code is better than not having any code at all.

I have learned a lot during this project. It's hard to pinpoint one thing or another. Of course,
I have learned more about Java, OOP and SOLID-principles, that is to be expected, but I have also
learned more about my self and how I structure things. I think I would do a much better job planning
this project if I were to start over. I would like to think that I would have an easier time 
puzzling together a UML-diagram. Of course, hindsight 20/20, but nonetheless, I feel like I
leave this project with my brain a little more wired around OOP.
