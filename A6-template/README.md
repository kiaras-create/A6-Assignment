# A8 Card Sorting

Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

## General Information
Programming Partner Name (if you'd like to be graded together): Chiashi Yang, Kiara Sunil Singh, Victoria Reyes Borges, Shakila Jafari 

Other Collaborators (and kudos to helpful members of the class):

Any references used besides JavaDoc and course materials: the folkdancing video on quicksort!

## Assignment Reflection

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category?

Victoria Reyes Borges - For the smaller piles, the algorithms seemed to go finished quickly but when there were bigger piles, they got slower. Selection adn insertion sort were slower (O(n^2)), while Quicksort and merge sort were faster (O(n log n)).

Kiara Sunil Singh - I noticed that the system runtime for merge sort was constant and quick regardless of the number of cards that we used. This makes logical sense since merge sorts has a dependable time complexity of O(nlogn). However, when I ran insertion sort and selection sort I noticed that as the number of cards in the cardpile increased its system runtime also increased, this is consistent with its time complexity since selection sort's average case is O(n^2) and insertion sort's average case is O(n^2). Additionallly, I found that quicksort also had one of the quicker system runtimes.

Chiashi Yang - I noticed that the runtime for selection sort and merge sort took longer the more cards I was sorting. However, for merge sort and quick sort, the time was constant despite the differing cards being sorted. I would split merge and quick sort into the "faster" algorithms and insertion and selection sort into "faster" algorithms. 

Shakila Jafari - When I tried sorting bigger decks like 10k, 20k, and 40k cards, I noticed insertion sort got way slower as the number of cards went up. Doubling the cards didn’t just double the time, it made it take even longer! So,for big data we’d never use insertion sort, but for small lists it’s totally fine and it works pretty fast.

Please reflect on your experience with this assignment. What was most challenging? What was most interesting?

Victoria Reyes Borges - I enjoyed this aissgnment, mostlye because I like the concepts of the sorting algorithms and the different ways we can use them. I found challeging visually the algortihms mentally or without any physcial objects, so I had to use some of my personal things to figure out the logic! I found interesting how, in a way, we can "make" storage in coding but when we perform these sorting algortihms that storage is just space "in real life", so definitely tying that back what I was doing with physically visualizing my algorithm into code was interesting!

Kiara Sunil Singh - I really enjoyed this assignment because I liked working with real world algorithms and being able to apply previous knowledge to a well known concept. I found this to be very helpful in understanding more about how queues work and the logical sequence of a queue's features. I also enjoyed looking at the different runtimes of each algorithm because it helped me better understand the efficiency of each algorithm and see firsthand how bigger passed in arguments can affect the runtime. 

Chiashi Yang - I definitely enjoyed completing this assignment. It was intimidating at first because I wasn't sure how to start. However, after writing some code and referencing the notes, I got an idea of how to complete it. I found the initial understanding of the algorithms, specifically quicksort and merge sort, to be challenging because I wasn't sure how to visualize them, especially for quicksort since that class involved recursion. However, attending Halie's office hours cleared up any trouble I had. I found the runtimes to be interesting because they differed drastically across algorithms depending on how big the card pile was.  

Shakila Jafari - The hardest part was getting insertion sort to work with a linked list instead of an array. I had to think in terms of piles and moves like removeFirs() and addFirst(). I ended up using a temporary pile to hold cards while I found the right spot to insert the current one, kind of like how you’d slide a card in your hand when playing poker. Once i got used to it, it made sense. The visualization tool was also super helpful too. And generally, I liked this assignment because the visualized cards made it way easier to understand the logic instead of just imagining how things move in my head, I could actually see it happen!