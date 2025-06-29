package ecommerce;

import java.util.*;

public class SearchDemo {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
                new Product(105, "Shoes", "Footwear"),
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "T-shirt", "Apparel"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Phone", "Electronics")
        };

        System.out.print("Enter product ID to search: ");
        int targetId = sc.nextInt();

        System.out.println("\n🔍 Linear Search:");
        Product foundLinear = linearSearch(products, targetId);
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n🔍 Binary Search:");
        Product foundBinary = binarySearch(products, targetId);
        System.out.println(foundBinary != null ? foundBinary : "Product not found");

        sc.close();
    }
}
