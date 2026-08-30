public class NeatStationery {

    // METHOD 1 - Calculate subtotal with discount
    static double calculateSubtotal(String itemName, double itemPrice, int quantity) {
        double subtotal = itemPrice * quantity;

        if (itemName.equals("Pen") && quantity >= 10)
            subtotal -= subtotal * 0.10;
        if (itemName.equals("Ruler") && quantity >= 5)
            subtotal -= 200;
        if (itemName.equals("Maths Set") && quantity >= 3)
            subtotal -= subtotal * 0.05;

        return subtotal;
    }

    // METHOD 2 - Print receipt
    static void printReceipt(String[] itemNames, int[] itemQuantities,
                             double[] subtotals, double[] originalTotals) {
        System.out.println("\n==== RECEIPT ====");
        for (int i = 0; i < itemNames.length; i++) {
            String discountMessage = subtotals[i] < originalTotals[i] 
                            ? "discount applied" : "no discount";
            System.out.println(itemNames[i] + " x" + itemQuantities[i]
                + " = UGX " + String.format("%.2f", subtotals[i])
                + " (" + discountMessage + ")");
        }
    }

    public static void main(String[] args) {

        String[] itemNames     = {"Pen", "Textbook", "Ruler", "Maths Set"};
        double[] itemPrices    = {500.00, 8000.00, 300.00, 15000.00};
        int[]    itemQuantities = {9, 2, 4, 3};
        double[] subtotals  = new double[4];
        double[] originalTotals  = new double[4];

        // Price list
        System.out.println("==== NEAT STATIONERY PRICE LIST ====");
        for (int i = 0; i < itemNames.length; i++)
            System.out.println(itemNames[i] + " - UGX " 
                             + String.format("%.2f", itemPrices[i]));

        // Calc
        double total = 0;
        for (int i = 0; i < itemNames.length; i++) {
            originalTotals[i] = itemPrices[i] * itemQuantities[i];
            subtotals[i] = calculateSubtotal(itemNames[i], itemPrices[i], itemQuantities[i]);
            total += subtotals[i];
        }

        
        printReceipt(itemNames, itemQuantities, subtotals, originalTotals);
        System.out.println("----------------------------");
        System.out.println("TOTAL = UGX " + String.format("%.2f", total));
    }
}