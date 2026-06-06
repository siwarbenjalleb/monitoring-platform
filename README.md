# DevOps Monitoring Platform

A full-stack observability platform built with Spring Boot, Prometheus, Grafana, PostgreSQL, Docker, Terraform, and Kubernetes.

## Architecture

```
Spring Boot API → Prometheus → Grafana
PostgreSQL → postgres-exporter → Prometheus
Terraform → provisions infrastructure
Ansible → configures monitoring stack
Kubernetes → orchestrates containers
```

## Dashboard

![Monitoring Dashboard](docs/dashboard.png)

## Stack

| Tool | Purpose |
|---|---|
| Spring Boot | REST API with metrics via Micrometer |
| Prometheus | Metrics scraping and storage |
| Grafana | Visualization and dashboards |
| PostgreSQL | Application database |
| Docker Compose | Local development stack |
| Terraform | Infrastructure provisioning |
| Ansible | Configuration management |
| Kubernetes | Container orchestration |

## Running Locally

### Prerequisites
- Docker Desktop
- Java 17+

### Start the stack
```bash
docker-compose up --build
```

### Access services
| Service | URL | Credentials |
|---|---|---|
| Spring Boot API | http://localhost:8080 | - |
| Prometheus | http://localhost:9090 | - |
| Grafana | http://localhost:3000 | admin / admin123 |

## API Endpoints

| Endpoint | Description |
|---|---|
| `GET /api/status` | Application health status |
| `GET /api/metrics/summary` | JVM metrics summary |
| `GET /actuator/prometheus` | Prometheus metrics |
| `GET /actuator/health` | Spring Boot health check |

## Project Structure

```
├── app/                    # Spring Boot application
├── infrastructure/
│   ├── terraform/          # Infrastructure as Code
│   └── ansible/            # Configuration management
├── kubernetes/             # K8s manifests
├── monitoring/
│   ├── prometheus/         # Prometheus config
│   └── grafana/            # Grafana dashboards
└── docs/                   # Screenshots and documentation
```