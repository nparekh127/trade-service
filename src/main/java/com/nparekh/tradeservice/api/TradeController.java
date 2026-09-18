package com.nparekh.tradeservice.api;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @GetMapping("/{tradeId}")
    public Map<String, Object> getTrade(@PathVariable String tradeId) {
        return Map.of(
                "id", tradeId,
                "symbol", "AAPL",
                "quantity", new BigDecimal("10"),
                "status", "OPEN");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createTrade(@RequestBody CreateTradeRequest request) {
        return Map.of(
                "id", "trade-" + Instant.now().toEpochMilli(),
                "symbol", request.symbol(),
                "quantity", request.quantity(),
                "side", request.side(),
                "status", "ACCEPTED");
    }

    public record CreateTradeRequest(String symbol, BigDecimal quantity, String side) {
    }
}
