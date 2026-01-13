package org.example.ratelimiter.models;

import lombok.Data;

@Data
public class ModelTier {
    private int modelId;
    private int tierId;
    private boolean isSupported;
    private int requestLimitPerHour;
    private int requestLimitPerDay;
}
