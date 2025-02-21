import java.util.*;

class Card {
    private String symbol;
    private String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Symbol: " + symbol + ", Value: " + value;
    }
}

public class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>();
    }

    public void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }

    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        while (true) {
            System.out.println("1. Add Card\n2. Find Cards by Symbol\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter Symbol and Value: ");
                String symbol = sc.next();
                String value = sc.next();
                collection.addCard(symbol, value);
            } else if (choice == 2) {
                System.out.print("Enter Symbol to find: ");
                String symbol = sc.next();
                List<Card> foundCards = collection.findCardsBySymbol(symbol);
                if (foundCards.isEmpty()) {
                    System.out.println("No cards found with this symbol.");
                } else {
                    for (Card card : foundCards) {
                        System.out.println(card);
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}