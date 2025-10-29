# A8 Card Sorting

Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

## General Information
Programming Partner Name (if you'd like to be graded together):

Other Collaborators (and kudos to helpful members of the class):

Any references used besides JavaDoc and course materials:

## Assignment Reflection

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category?

Victoria Reyes Borges - For the smaller piles, the algorithms seemed to finish quickly but when there were bigger piles, they got slower. Selection and insertion sort were slower (O(n^2)) when the piles got bigger, but they went quickly with small piles. While Quicksort and merge sort were faster (O(n log n)) with small and big piles.

Shakila Jafari - When I tried sorting bigger decks like 10k, 20k, and 40k cards, I noticed insertion sort got way slower as the number of cards went up. Doubling the cards didn’t just double the time, it made it take even longer! So,for big data we’d never use insertion sort, but for small lists it’s totally fine and it works pretty fast. 

Please reflect on your experience with this assignment. What was most challenging? What was most interesting?

Victoria Reyes Borges - I enjoyed this aissgnment, mostlye because I like the concepts of the sorting algorithms and the different ways we can use them. I found challeging visually the algortihms mentally or without any physcial objects, so I had to use some of my personal things to figure out the logic! I found interesting how, in a way, we can "make" storage in coding but when we perform these sorting algortihms that storage is just space "in real life", so definitely tying that back what I was doing with physically visualizing my algorithm into code was interesting!

Shakila Jafari - The hardest part was getting insertion sort to work with a linked list instead of an array. I had to think in terms of piles and moves like removeFirs() and addFirst(). I ended up using a temporary pile to hold cards while I found the right spot to insert the current one, kind of like how you’d slide a card in your hand when playing poker. Once i got used to it, it made sense. The visualization tool was also super helpful too. And generally, I liked this assignment because the visualized cards made it way easier to understand the logic instead of just imagining how things move in my head, I could actually see it happen!

