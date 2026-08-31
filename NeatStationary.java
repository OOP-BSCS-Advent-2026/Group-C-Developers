public class NeatStationary {

    public static void main(String[] args) {
        String[] itemNames = {"Pen", "Textbook", "Ruler", "Maths Set"};
        double[] itemPrices = {500.00, 8000.00, 300.00, 15000.00};
        int[] itemQuantities = {9, 2, 4, 3};
        double[] subtotals = new double[4];

        String[] discounts = new String[4];
        for (int d = 0; d < discounts.length; d++) {
            discounts[d] = "No discount";
        }
         // Price list
        System.out.println("==== NEAT STATIONERY PRICE LIST ====");
        for (int i = 0; i < itemNames.length; i++)
            System.out.println(itemNames[i] + " - UGX " 
                            + String.format("%.2f", itemPrices[i]));

        double total = 0.0;
        for (int i = 0; i < itemNames.length; i++) {
            //caluculate subtotal using this method
            subtotals[i] = calculateSubtotal(itemPrices[i],itemQuantities[i]);
            
            if (itemNames[i].equals("Pen") && itemQuantities[i] >= 10) {
                subtotals[i] *= 0.90;
                discounts[i] = "10% off total";
            } else if (itemNames[i].equals("Ruler") && itemQuantities[i] >= 5) {
                subtotals[i] -= 200.00;
                discounts[i] = "UGX 200 off total";
            } else if (itemNames[i].equals("Maths Set") && itemQuantities[i] >= 3) {
                subtotals[i] *= 0.95;
                discounts[i] = "5% off total";
            }
            total += subtotals[i];
        }
        printReceipt(itemNames, itemQuantities, discounts, subtotals);
         System.out.println("==== GRAND TOTAL ====");
        System.out.println("UGX " + String.format("%.2f", total));
    }
    // Method 1
   public static double calculateSubtotal(double itemPrices,int itemQuantities){
            
    return itemPrices *itemQuantities;
   }

     //Method 2
        public static void printReceipt(String[] itemNames,int []itemQuantities,String[] discounts,double[] subtotals) {
    System.out.println("==== RECEIPT ====");
        System.out.println("Item - Quantity - Discount - Subtotal");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.println(itemNames[i] + " x " + itemQuantities[i]
                    + " - " + discounts[i]
                    + " - UGX " + String.format("%.2f", subtotals[i]));
        }
       
    }
}