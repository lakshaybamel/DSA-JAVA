
import java.util.HashMap;

public class FindItineraryForTickets {

    // Find starting city of the journey
    public static String getStart(HashMap<String, String> tickets) {

        // Reverse map: destination -> source
        HashMap<String, String> revMap = new HashMap<>();

        for (String src : tickets.keySet()) {
            revMap.put(tickets.get(src), src);
        }

        // Start city is the one which is never a destination
        for (String src : tickets.keySet()) {
            if (!revMap.containsKey(src)) {
                return src;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Cheenai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Cheenai");
        tickets.put("Delhi", "Goa");

        // Find starting point
        String start = getStart(tickets);

        // Print itinerary
        System.out.print(start);
        while (tickets.containsKey(start)) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
