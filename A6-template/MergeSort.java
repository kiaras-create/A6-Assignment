import java.util.ArrayDeque;

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


public static void main(String[] args) {
  SortRecorder recorder = new SortRecorder();

  Card.loadImages(recorder);
  CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

  cards = MergeSort.sort(cards, recorder);

  System.out.println(cards);

  recorder.display("Card Sort Demo: MergeSort");
}
}
