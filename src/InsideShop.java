import java.util.Scanner;

public class InsideShop {
    public void startShopping() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко", "Яйца", "Конфеты"};
        int[] prices = {250, 130, 180, 5, 200};

        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "." + " " + products[i] + " " + prices[i] + " руб/шт");
        }

        int sumProducts = 0;
        String[] basket = new String[products.length]; //корзина
        boolean[] isFilled = new boolean[products.length];
        int countProduct = 0; //счетчик кол-ва товаров в корзине
        int[] boughtCount = new int[products.length];
        int[] boughtPrice = new int[products.length];  //массив с суммой за уже купленные товары

        while (true) {
            System.out.println("Выберите номер товара и количество / введите `end` для совершения покупки / введите 'look' для просмотра корзины");
            String input = scanner.nextLine();
            if (input.equals("end") || input.equals("end ")) {
                outPut(basket, sumProducts);
                break;
            }
            if (input.equals("look") || input.equals("look ")) {
                outPut(basket, sumProducts);
            } else {
                String[] bought = input.split(" ");
                int productNumber = Integer.parseInt(bought[0]) - 1; //переменная номера товара, введенная пользователем
                int productCount = Integer.parseInt(bought[1]); //переменная кол-ва товара, кот. приобретает полльзователь


                if (boughtCount[productNumber] == 0) {
                    boughtCount[productNumber] = productCount;
                    boughtPrice[productNumber] = prices[productNumber];
                    basket[countProduct] = products[productNumber]
                            + " " + productCount + " шт  по " + prices[productNumber]
                            + " руб за шт " + (boughtPrice[productNumber] * productCount) + " руб. в сумме";
                    isFilled[countProduct] = true;
                    countProduct++;
                } else {
                    boughtCount[productNumber] += productCount;
                    boughtPrice[productNumber] += (productCount * prices[productNumber]);
                    basket[countProduct] = products[productNumber] + " " + boughtCount[productNumber]
                            + " шт" + prices[productNumber] + " руб/шт " + boughtPrice[productNumber] + " руб. в сумме";
                    countProduct++;
                }
                for (int sum : boughtPrice) {
                    sumProducts += sum;
                }
            }
            System.out.println();
        }
    }

    static void outPut(String[] basket, int sumProducts) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                System.out.println(basket[i]);
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
    }
}
