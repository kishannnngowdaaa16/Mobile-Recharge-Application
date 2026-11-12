
package com.example.labb;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MobileRechargeService service =
                new MobileRechargeService();

        System.out.println("================================");
        System.out.println("   MOBILE RECHARGE APPLICATION");
        System.out.println("================================");

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        if (!service.validateMobileNumber(mobileNumber)) {
            System.out.println("Invalid Mobile Number!");
            sc.close();
            return;
        }

        System.out.println("\nAvailable Recharge Plans:");

        List<RechargePlan> plans =
                service.getAvailablePlans();

        for (RechargePlan plan : plans) {
            System.out.println(plan);
        }

        System.out.print("\nSelect Plan ID: ");

        int planId;

        try {
            planId = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid plan selection!");
            sc.close();
            return;
        }

        String result = service.recharge(mobileNumber, planId);

        System.out.println("\n========== TRANSACTION RESULT ==========");
        System.out.println(result);
        System.out.println("========================================");

        sc.close();
    }
}
