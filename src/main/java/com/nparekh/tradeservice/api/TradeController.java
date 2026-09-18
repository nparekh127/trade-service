package com.nparekh.tradeservice.api;

import java.math.BigDecimal;
import java.util.Map;

import com.nparekh.tradeservice.service.TradeService;
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

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/{tradeId}")
    public Map<String, Object> getTrade(@PathVariable String tradeId) {
        return tradeService.getTrade(tradeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createTrade(@RequestBody CreateTradeRequest request) {
        return tradeService.createTrade(request.symbol(), request.quantity(), request.side());
    }

    public record CreateTradeRequest(String symbol, BigDecimal quantity, String side) {
    }
}
