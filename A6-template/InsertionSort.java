import java.util.Collections;

public class InsertionSort {
  
  /**
   * Sorts a CardPile by insertion sort
   * @param unsorted card pile
   * @param record the SortRecorder to visualize each step
   * @return sorted card pile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //         record.next();
    //         record.add(sorted);
    //         record.add(unsorted);

    // ***********************************************************

    while (!unsorted.isEmpty()) {

      // Remove the first card from the unsorted pile
      Card current =  unsorted.removeFirst();

      // temporary pile to hold cards while we find the insertion point
      CardPile temp =  new CardPile();

      // Find the correct spot in sorted to insert current
      while (!sorted.isEmpty() && sorted.peekFirst().compareTo(current) < 0) {

        // Move larger cards to temp
        temp.add(sorted.removeFirst());
      }

      // Insert the current card at the correct position
      sorted.addFirst(current);
      
      // Puts the larger cards back on top of the inserted card
      while (!temp.isEmpty()){
        sorted.addFirst(temp.removeFirst());
      }

      
      record.next(); // tell it this is a new step
      record.add(sorted);  // the sorted pile
      record.add(unsorted); // the unsorted pile
    }

    // return the sorted result here
    return sorted;
  }

  public static void main(String args[]) {

    //set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards =  new CardPile(Card.newDeck(true), 2, 2);
    
    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));
    
    // mix up the cards
    Collections.shuffle(cards);
    
    // sort the cards using InsertionSort
    cards = InsertionSort.sort(cards, recorder);
    
    //prints out the (un)sorted result
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Insertion Sort");

  }
}
