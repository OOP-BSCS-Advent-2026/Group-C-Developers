public class NeatStationary {

    public static void main(String[] args) {
        String[] names = {"Pen", "Textbook", "Ruler", "Maths Set"};
        double[] prices = {500.00, 8000.00, 300.00, 15000.00};
        int[] quantities = {9, 2, 4, 3};
        double[] subtotals = new double[4];

        String[] discounts = new String[4];
        for (int d = 0; d < discounts.length; d++) {
            discounts[d] = "No discount";
        }

        // Price list
        System.out.println("==== NEAT STATIONERY PRICE LIST ====");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - UGX "
                    + String.format("%.2f", prices[i]));
        }

        // Calculate subtotals, apply discounts, and track grand total
        double grandTotal = 0.0;
        for (int i = 0; i < names.length; i++) {
            subtotals[i] = calculateSubtotal(names[i], prices[i], quantities[i]);

            if (names[i].equals("Pen") && quantities[i] >= 10) {
                discounts[i] = "10% off total";
            } else if (names[i].equals("Ruler") && quantities[i] >= 5) {
                discounts[i] = "UGX 200 off total";
            } else if (names[i].equals("Maths Set") && quantities[i] >= 3) {
                discounts[i] = "5% off total";
            }

            grandTotal += subtotals[i];
        }

        System.out.println("==== GRAND TOTAL ====");
        System.out.println("UGX " + String.format("%.2f", grandTotal));
    }

    static double calculateSubtotal(String name, double price, int qty) {

        double subtotal = price * qty;

        if (name.equals("Pen") && qty >= 10) {
            subtotal -= subtotal * 0.10;
        }
        if (name.equals("Ruler") && qty >= 5) {
            subtotal -= 200;
        }
        if (name.equals("Maths Set") && qty >= 3) {
            subtotal -= subtotal * 0.05;
        }

        return subtotal;
    }
}