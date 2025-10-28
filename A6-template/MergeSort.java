import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    record.add(unsorted);

    while(!unsorted.isEmpty()){
    CardPile single = new CardPile();
    single.addLast(unsorted.removeFirst());
    queue.addLast(single);
    }

   
    while (queue.size()>1){
    CardPile pile1 = queue.removeFirst();
    CardPile pile2 = queue.removeFirst();
    CardPile newPile = new CardPile();
        

      while((!pile2.isEmpty() && !pile1.isEmpty())){
        Card card1 = pile1.peekFirst();
        Card card2 = pile2.peekFirst();
        if (card1.compareTo(card2) > 0){
          //merge(card1, card2)
          newPile.add(pile2.removeFirst());
          }
            
        else if (card1.compareTo(card2)< 0){
          //merge(card2,card1)
          newPile.add(pile1.removeFirst());
            }
        else if(card1.compareTo(card2) == 0){
          //merge(card1,card2)
          newPile.add(pile1.removeFirst());

        }
    
        }

    if (!pile1.isEmpty()){
      while (!pile1.isEmpty()){
        newPile.add(pile1.removeFirst());
      }
               
    }
    if (!pile2.isEmpty()){
      while (!pile2.isEmpty()){
        newPile.add(pile2.removeFirst());
      }


    }
    record.next(); // tell it this is a new step
    record.add(newPile); // the allegedly sorted pile
    queue.addLast(newPile);
    



    }
    return queue.remove();
  }


// public static void main(String[] args) {
//   SortRecorder recorder = new SortRecorder();

//   Card.loadImages(recorder);
//   CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

//   cards = MergeSort.sort(cards, recorder);

//   System.out.println(cards);

//   recorder.display("Card Sort Demo: MergeSort");

  
// }
  public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    cards = cards.split(cards.get(52));

    // mix up the cards
    Collections.shuffle(cards);
   
    // if you want to sort in array form, use:
    // Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: Merge Sort");
  }

}
