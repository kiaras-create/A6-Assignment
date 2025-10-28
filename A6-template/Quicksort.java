import java.util.ListIterator;

public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // stop condition
    // if list has 0 or 1 elements, return list as it's already sorted
    if (unsorted.size() == 0 || unsorted.size() == 1) {
      return unsorted;
    }
    
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************

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
        System.out.println("current card is bigger! moving it to the bigger cardpile");
        bigger.add(curr);
        unsorted.remove(curr);
      } else if (curr.compareTo(pivot) < 0 ) {
          System.out.println("current card is smaller! moving it to smaller cardpile");
          smaller.add(curr);
          unsorted.remove(curr);
      } else {
        System.out.println("current card is of equal value! moving it to the bigger cardpile, it'll still be sorted for final result");
        bigger.add(curr);
        unsorted.remove(curr);
      }
    } 


    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    // recursive call to sort smaller and bigger piles
    sort(smaller, record);
    sort(bigger, record);
    
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
}
