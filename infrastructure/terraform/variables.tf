variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "eu-west-1"
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
  default     = "t3.micro"
}

variable "ami_id" {
  description = "Ubuntu 22.04 AMI for eu-west-1"
  type        = string
  default     = "ami-0694d931cee176e7d"
}

variable "key_name" {
  description = "Name of your EC2 key pair"
  type        = string
}