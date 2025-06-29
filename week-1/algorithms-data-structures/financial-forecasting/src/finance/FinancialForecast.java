package finance;

import java.util.Scanner;

public class FinancialForecast {

    public static double forecastFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + growthRate) * forecastFutureValue(presentValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Present Value (₹): ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (e.g., 0.10 for 10%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double futureValue = forecastFutureValue(presentValue, growthRate, years);
        System.out.printf("📈 Future Value after %d years: ₹%.2f\n", years, futureValue);

        sc.close();
    }
}

