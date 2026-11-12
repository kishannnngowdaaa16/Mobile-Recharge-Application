
package com.example.labb;

public class RechargePlan {

    private int planId;
    private String description;
    private double amount;
    private int validity;

    public RechargePlan(int planId, String description,
                         double amount, int validity) {
        this.planId = planId;
        this.description = description;
        this.amount = amount;
        this.validity = validity;
    }

    public int getPlanId() {
        return planId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public int getValidity() {
        return validity;
    }

    @Override
    public String toString() {
        return planId + ". " + description +
                " - Rs." + amount +
                " (" + validity + " days)";
    }
}
