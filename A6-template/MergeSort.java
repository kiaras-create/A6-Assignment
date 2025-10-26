import java.util.ArrayDeque;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    while(!unsorted.isEmpty()){
    CardPile single = new CardPile();
    single.addLast(unsorted.removeFirst());
    queue.addLast(single);
    }

   
    while (queue.size()>1){
    CardPile pile1 = queue.removeFirst();
    CardPile pile2 = queue.removeFirst();
    CardPile newPile = new CardPile();
        
    Card card1 = pile1.removeFirst();
    Card card2 = pile2.removeFirst();

    while((!pile2.isEmpty() && !pile1.isEmpty())){
      if (card1.compareTo(card2) > 0){
        //merge(card1, card2)
        newPile.add(card2);
        newPile.add(card1);
        }
          
      else if (card1.compareTo(card2)< 0){
        //merge(card2,card1)
        newPile.add(card1);
        newPile.add(card2);
          }
      else if(card1.compareTo(card2) == 0){
        //merge(card1,card2)
        newPile.add(card2);
        newPile.add(card1);

      }
      queue.addLast(newPile);
    
        }




    }

//     ## MergeSort

// - Begin by placing each element of `unsorted` into its own new singleton `CardPile` and add all those piles to a queue.
// - While more than one list remains on the queue:
//   - Remove the first two lists from the queue and merge them, preserving their sorted order.
//   - Put the result back at the end of the queue.

// _To merge two sorted lists into a single sorted list:_
//   - Look at the first element in each list.
//   - Take the smaller of the two off the front of its old list and put it at the end of a new (merged) list.
//   - Repeat this until both one of the old lists is empty, at which point you can append the remainder of the other original list to the new list.
//   - If the original lists were sorted, and you always take the smallest element available, then the resulting list will also be sorted. (You might want to convince yourself of this fact before continuing.)

// _Note: the **key operation** here is the merging of two sorted lists. Probably you will want to develop a method for this and test it thoroughly before tackling the full program._

    

  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    // return the sorted result here
    return queue.remove();
  }
}
