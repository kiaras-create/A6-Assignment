public class SelectionSort {
  
  /**
   * @param unsorted
   * @param record
   * @return sorted
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

    while(!unsorted.isEmpty()){ //while the unsorted list is not empty
      Card smallest = unsorted.peek(); // take a look a the first card in the unsorted pile
      CardPile temp = new CardPile(); // make a temporary list to hold the cards


      while(!unsorted.isEmpty()){ //while the unsorted list is not empty
        Card current = unsorted.peek(); // take a look at the current card we are on 

        if(current.compareTo(smallest) < 0){ // if this current card we are on is less than the smallest card aka the beginning card
          temp.add(smallest); // add the smallest (which is the card with bigger value) to the temporary list
          smallest = current; // now the current card we were looking at is the smallest value in our list, so we'll compare the next ones to it
        } else { // if this current card we are on is NOT less than the smallest card aka the beginning card
          temp.add(current); // move the current card into the temporary pile
        }
      }

      while(!temp.isEmpty()){ // while the temporary pile is not empty
        unsorted.add(temp.pop()); //take the first card of the temporary pile and add it to the unsorted list so we can compare it to the smallest
      }

      sorted.add(smallest); //add the smallest card into the sorted pile

    }

    record.next();        // tell it this is a new step
    record.add(sorted);   // the sorted pile
    record.add(unsorted); // the unsorted pile
    
    // return the sorted result here
    return sorted;
  }
}
