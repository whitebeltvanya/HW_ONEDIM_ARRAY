import java.util.Scanner;

public class GroceryBasketPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа",};
        int[] prices = {50, 14, 80};
        int[] basket = new int[products.length];

        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s %d руб/шт\n", i + 1, products[i], prices[i]);
        }

        int sumProducts = 0;
        while (true) {
            System.out.println("Выберите товар и количество или введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] product = input.split(" ");
            int productNumber = Integer.parseInt(product[0]) - 1;
            int productCount = Integer.parseInt(product[1]);

            if (productCount > 0 && productNumber>=0 && productNumber <products.length) {
                basket[productNumber] = basket[productNumber] + productCount;
                sumProducts += prices[productNumber] * productCount;
            }
        }

        System.out.println("Ваша корзина:");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] > 0) {
                System.out.printf("%s - %d шт, %d руб/шт, %d руб в сумме\n",
                        products[i], basket[i], prices[i], basket[i] * prices[i]);
            }
        }
        System.out.println("Итого: " + sumProducts + " руб");
    }
}
