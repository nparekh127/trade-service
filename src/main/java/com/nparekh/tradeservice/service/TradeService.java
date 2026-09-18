package com.nparekh.tradeservice.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TradeService {

    public Map<String, Object> getTrade(String tradeId) {
        return Map.of(
                "id", tradeId,
                "symbol", "AAPL",
                "quantity", new BigDecimal("10"),
                "status", "OPEN");
    }

    public Map<String, Object> createTrade(String symbol, BigDecimal quantity, String side) {
        return Map.of(
                "id", "trade-" + Instant.now().toEpochMilli(),
                "symbol", symbol,
                "quantity", quantity,
                "side", side,
                "status", "ACCEPTED");
    }
}
