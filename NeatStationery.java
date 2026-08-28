public class NeatStationery {

    // METHOD 1 - Calculate subtotal with discount
    static double calculateSubtotal(String name, double price, int qty) {
        double subtotal = price * qty;

        if (name.equals("Pen") && qty >= 10)
            subtotal -= subtotal * 0.10;
        if (name.equals("Ruler") && qty >= 5)
            subtotal -= 200;
        if (name.equals("Maths Set") && qty >= 3)
            subtotal -= subtotal * 0.05;

        return subtotal;
    }

    // METHOD 2 - Print receipt
    static void printReceipt(String[] names, int[] quantities,
                             double[] subtotals, double[] originals) {
        System.out.println("\n==== RECEIPT ====");
        for (int i = 0; i < names.length; i++) {
            String discount = subtotals[i] < originals[i] 
                            ? "discount applied" : "no discount";
            System.out.println(names[i] + " x" + quantities[i]
                + " = UGX " + String.format("%.2f", subtotals[i])
                + " (" + discount + ")");
        }
    }

    public static void main(String[] args) {

        String[] names     = {"Pen", "Textbook", "Ruler", "Maths Set"};
        double[] prices    = {500.00, 8000.00, 300.00, 15000.00};
        int[]    quantities = {9, 2, 4, 3};
        double[] subtotals  = new double[4];
        double[] originals  = new double[4];

        // Price list
        System.out.println("==== NEAT STATIONERY PRICE LIST ====");
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i] + " - UGX " 
                             + String.format("%.2f", prices[i]));

        // Calc
        double total = 0;
        for (int i = 0; i < names.length; i++) {
            originals[i] = prices[i] * quantities[i];
            subtotals[i] = calculateSubtotal(names[i], prices[i], quantities[i]);
            total += subtotals[i];
        }

        
        printReceipt(names, quantities, subtotals, originals);
        System.out.println("----------------------------");
        System.out.println("TOTAL = UGX " + String.format("%.2f", total));
    }
}