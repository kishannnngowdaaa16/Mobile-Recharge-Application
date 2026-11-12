
package com.example.labb;

import java.util.ArrayList;
import java.util.List;

public class MobileRechargeService {

    private List<RechargePlan> plans;

    public MobileRechargeService() {

        plans = new ArrayList<>();

        plans.add(new RechargePlan(1, "Basic Plan", 99, 28));
        plans.add(new RechargePlan(2, "Standard Plan", 199, 56));
        plans.add(new RechargePlan(3, "Premium Plan", 299, 84));
        plans.add(new RechargePlan(4, "Unlimited Plan", 499, 90));
    }

    public boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber != null &&
               mobileNumber.matches("[6-9][0-9]{9}");
    }

    public List<RechargePlan> getAvailablePlans() {
        return new ArrayList<>(plans);
    }

    public RechargePlan selectPlan(int planId) {

        for (RechargePlan plan : plans) {
            if (plan.getPlanId() == planId) {
                return plan;
            }
        }

        return null;
    }

    public String recharge(String mobileNumber, int planId) {

        if (!validateMobileNumber(mobileNumber)) {
            return "Invalid mobile number!";
        }

        RechargePlan selectedPlan = selectPlan(planId);

        if (selectedPlan == null) {
            return "Invalid recharge plan!";
        }

        return "Recharge Successful!\n" +
               "Mobile Number: " + mobileNumber + "\n" +
               "Plan: " + selectedPlan.getDescription() + "\n" +
               "Recharge Amount: Rs." + selectedPlan.getAmount() + "\n" +
               "Validity: " + selectedPlan.getValidity() + " days";
    }
}
