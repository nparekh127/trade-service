# Trade Service

A basic Spring Boot REST API.

## Requirements

- Java 17+
- Maven 3.9+

## Run locally

```bash
mvn spring-boot:run
```

## Endpoints

- `GET /actuator/health` — application health check
- `GET /api/trades/{tradeId}` — returns a sample trade
- `POST /api/trades` — accepts a trade request

Example create request:

```json
{
  "symbol": "AAPL",
  "quantity": 10,
  "side": "BUY"
}
```
