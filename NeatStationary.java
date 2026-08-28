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
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i] + " - UGX " 
                             + String.format("%.2f", prices[i]));

            }
        }static double calculateSubtotal(String name, double price, int qty) {

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
