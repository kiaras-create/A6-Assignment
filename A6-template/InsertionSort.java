import java.util.Collections;

public class InsertionSort {
  
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

    // ***********************************************************

    while (!unsorted.isEmpty()) {
      Card current =  unsorted.removeFirst();

      CardPile temp =  new CardPile();
      while (!sorted.isEmpty() && sorted.peekFirst().compareTo(current) < 0) {
        temp.add(sorted.removeFirst());
      }

      sorted.addFirst(current);

      while (!temp.isEmpty()){
        sorted.addFirst(temp.removeFirst());
      }

      record.next();
      record.add(sorted);
      record.add(unsorted);
    }

    // return the sorted result here
    return sorted;
  }

  public static void main(String args[]) {
    SortRecorder recorder = new SortRecorder();

    Card.loadImages(recorder);
    CardPile cards =  new CardPile(Card.newDeck(true), 2, 2);

    Collections.shuffle(cards);

    cards = InsertionSort.sort(cards, recorder);
    
    System.out.println(cards);

    recorder.display("Card Sort Demo: Insertion Sort");

  }
}
