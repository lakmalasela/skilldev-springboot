package com.giganerds.skilldev.util;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBlacklistService {

    // Using a ConcurrentHashMap to store blacklisted tokens
    private final ConcurrentHashMap<String, Long> blacklistedTokens = new ConcurrentHashMap<>();

    // Add token to the blacklist with the expiry time (e.g., token expiration time)
    public void blacklistToken(String token, long expirationTime) {
        blacklistedTokens.put(token, expirationTime); // Store token with its expiry time
    }

    // Check if token is blacklisted
    public boolean isTokenBlacklisted(String token) {
        Long expirationTime = blacklistedTokens.get(token);
        if (expirationTime != null && expirationTime > System.currentTimeMillis()) {
            return true; // Token is still valid and blacklisted
        }
        return false; // Token is either not blacklisted or expired
    }

    // Remove expired tokens
    public void removeExpiredTokens() {
        long currentTime = System.currentTimeMillis();
        blacklistedTokens.entrySet().removeIf(entry -> entry.getValue() < currentTime); // Remove expired tokens
    }
}
