public class InsertionSortTimer {

    /**
     * Sorts a CardPile by insertion sort
     * @param unsorted card pile
     * @return sorted card pile
     */

    //sorts a CardPile using insertion sort without any recording
    public static CardPile sort(CardPile unsorted){

        CardPile sorted = new CardPile();

        while (!unsorted.isEmpty()) {
            Card current = unsorted.removeFirst();
            CardPile temp = new CardPile();

            // Find insertion point in sorted list
            while (!sorted.isEmpty() && sorted.peekFirst().compareTo(current) < 0) {
                temp.add(sorted.removeFirst());
            }

              sorted.addFirst(current);

            while (!temp.isEmpty()) {
                sorted.addFirst(temp.removeFirst());
            }
        }
        return sorted;
    }

    //Starts the program running
    public static void main(String[] args){

        if (args.length >1){
            System.err.println("Please specify how many cards to sort!");
        } else {
            Card[] deck = Card.newDeck(true);
            CardPile cards = new CardPile();
            
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                cards.add(deck[(int)(52 * Math.random())]);
            }
            sort(cards);
        }
    }
}
