import java.util.ArrayDeque;

public class MergeSortTimer {

  /**
   * sorts unsorted card pile using merge sort algorithm and keeps track of time
   * @param unsorted card pile
   * @return sorted card pile
   */
  public static CardPile sort(CardPile unsorted) {
    
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
    queue.addLast(newPile);


    }
    return queue.remove();
  }

  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
  }
}

