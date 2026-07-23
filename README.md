# Event Ingestion Service

A Spring Boot service that accepts event batches, persists raw events in
MongoDB, and publishes them to Kafka for downstream processing.

## Place in the pipeline

```text
Android SDK → POST /ingest → MongoDB + Kafka → processing layer
```

## Stack

- Java 17 and Spring Boot
- Spring Web
- Spring Kafka
- Spring Data MongoDB
- Actuator

## Endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| `POST` | `/ingest` | Receive an event payload |
| `GET` | `/health` | Health check |

The request contract is defined in `Events_Ingestion_DTO.java`; an example
payload is available in `payload.json`.

## Run locally

1. Start Kafka and MongoDB.
2. Review `src/main/resources/application.yaml`.
3. Start the service:

```bash
./mvnw spring-boot:run
```

Test it with:

```bash
./mvnw test
```

## Related services

- [Processing layer](https://github.com/CHAITANYA2605/tracking_processing_layer)
- [Kafka-to-ClickHouse receiver](https://github.com/CHAITANYA2605/tracker_kafka_receiver)
- [Complete monorepo](https://github.com/CHAITANYA2605/eventandpush)
