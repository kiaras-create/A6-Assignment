public class SelectionSortTimer {
  /**
   * sorts unsorted pile using selection sort algorithm and keeps track of time
   * @param unsorted card pile
   * @return sorted pile
   */
    public static CardPile sort(CardPile unsorted) {
            
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
          Card smallest = unsorted.pop(); // take a look a the first card in the unsorted pile
          CardPile temp = new CardPile(); // make a temporary list to hold the cards
    
    
          while(!unsorted.isEmpty()){
            Card current = unsorted.pop(); // take a look at the current card we are on 
    
            if(current.compareTo(smallest) < 0){ // if this current card we are on is less than the smallest card aka the beginning card
              temp.add(smallest); // add the smallest (which is the card with bigger value) to the temporary list
              smallest = current; // now the current card we were looking at is the smallest value in our list, so we'll compare the next ones to it
            } else { // if this current card we are on is NOT less than the smallest card aka the beginning card
              temp.add(current); // move the current card into the temporary pile
            }
          } //while the unsorted list is not empty
    
    
          sorted.add(smallest); //add the smallest card into the sorted pile
    
          while(!temp.isEmpty()){ // while the temporary pile is not empty
            unsorted.add(temp.pop()); //take the first card of the temporary pile and add it to the unsorted list so we can compare it to the smallest
          }
    
          
    
        }
   
        // return the sorted result here
        return sorted;
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
