output "server_ip" {
  description = "Public IP of the monitoring server"
  value       = aws_instance.monitoring.public_ip
}

output "grafana_url" {
  description = "Grafana dashboard URL"
  value       = "http://${aws_instance.monitoring.public_ip}:3000"
}

output "prometheus_url" {
  description = "Prometheus URL"
  value       = "http://${aws_instance.monitoring.public_ip}:9090"
}

output "api_url" {
  description = "Spring Boot API URL"
  value       = "http://${aws_instance.monitoring.public_ip}:8080"
}