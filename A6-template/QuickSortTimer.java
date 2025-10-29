import java.util.ListIterator;


public class QuickSortTimer {

 /**
  * sorts unsorted card pile into algorithm
  * @param unsorted card pile
  * @return a sorted pile
  */
 public static CardPile sort(CardPile unsorted) {
  
  // stop condition
  // if list has 0 or 1 elements, return list as it's already sorted
  if (unsorted.size() == 0 || unsorted.size() == 1) {
    return unsorted;
  }
  
  // Here are the two partitions you will be creating
  CardPile smaller = new CardPile();
  CardPile bigger = new CardPile();


  // pivot will be the first element of the list
  Card pivot = unsorted.getFirst();
  // will keep track of current position in list
  ListIterator<Card> iter = unsorted.listIterator();
  // move iterator to go past the pivot
  Card curr = iter.next();


  // iterates over card pile until no more cards to iterate
  while (iter.hasNext()) {
    curr = iter.next();
    if (curr.compareTo(pivot) > 0) {
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


  // This will hold the assembled result
  CardPile result = new CardPile();


  // recursive call to sort smaller and bigger piles
  sort(smaller);
  sort(bigger);


  // add smaller pile to assembled result first
  // then pivot
  // then bigger pile
  result.addAll(smaller);
  result.add(pivot);
  result.addAll(bigger);



  // return the sorted result here
  return result;
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


