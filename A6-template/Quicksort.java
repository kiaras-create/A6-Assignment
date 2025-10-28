import java.util.Collections;
import java.util.ListIterator;

public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    record.add(unsorted);

    // stop condition
    // if list has 0 or 1 elements, return list as it's already sorted
    if (unsorted.size() == 0 || unsorted.size() == 1) {
      return unsorted;
    }
    
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    record.add(smaller);
    record.add(bigger);

  
    // pivot will be the first element of the list
    Card pivot = unsorted.getFirst();
    // will keep track of current position in list
    ListIterator<Card> iter = unsorted.listIterator();
    // move iterator to go past the pivot
    Card curr = iter.next();

    // iterates over card pile until no more cards to iterate
    while (iter.hasNext()) {
      curr = iter.next();
      if (curr.compareTo(pivot) >= 0) {
        // debugging purposes
        // System.out.println("current card is bigger! moving it to the bigger cardpile");
        bigger.add(curr);
        iter.remove();
      } else if (curr.compareTo(pivot) < 0 ) {
          // System.out.println("current card is smaller! moving it to smaller cardpile");
          smaller.add(curr);
          iter.remove();
      } else {
        // System.out.println("current card is of equal value! moving it to the bigger cardpile, it'll still be sorted for final result");
        bigger.add(curr);
        iter.remove();
      }
    } 


    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();


    // This will hold the assembled result
    CardPile result = new CardPile();


    // recursive call to sort smaller and bigger piles
    sort(smaller, record);
    record.add(smaller);

    sort(bigger, record);
    record.add(bigger);
    
    // add smaller pile to assembled result first 
    // then pivot
    // then bigger pile 
    result.addAll(smaller);
    result.add(pivot);
    result.addAll(bigger);


    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }

    public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    //cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);
   
    // if you want to sort in array form, use:
    // Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Quick Sort");
  }

}
