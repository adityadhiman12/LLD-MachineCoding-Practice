package org.aditya;

import org.aditya.helper.RateLimitHelper;
import org.aditya.model.RateLimit;

public class RateLimitService {
    public static void main(String[] args) {
        RateLimitService rateLimitService = new RateLimitService();
        int limit=5;
        RateLimit rateLimit = new RateLimit(limit);
        new RateLimitHelper("user A", rateLimit).start();
        new RateLimitHelper("user B", rateLimit).start();
    }
}