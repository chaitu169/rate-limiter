package org.example.ratelimiter.models;

import lombok.Data;

@Data
public class Tier {
    private int tierId;
    private TierEnum tierEnum;
    private double price;
}
