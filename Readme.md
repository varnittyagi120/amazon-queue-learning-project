# Amazon SNS Publisher Project

This project demonstrates how to **publish messages to an Amazon SNS (Simple Notification Service) topic**, with two types of subscribers:
- An **Amazon SQS queue**
- An **email address**

The application is built using **Spring Boot** with **Spring Cloud AWS** for easy integration with AWS services.

---

## What is Amazon SNS?

**Amazon Simple Notification Service (Amazon SNS)** is a fully managed messaging service used to send messages from applications to subscribers via multiple protocols, including **HTTP/S**, **email**, **SMS**, **mobile push**, and **Amazon SQS**. It supports **pub/sub (publish-subscribe)** messaging patterns for building loosely coupled and scalable microservices.

## 🔧 Project Functionalities

### ✅ SNS to SQS Integration
- Creates an **SNS topic**
- Publishes messages to that topic
- **SQS queue** is subscribed to the topic and consumes published messages

### ✅ SNS to Email Integration
- Subscribes an **email address** to the SNS topic
- Sends a **confirmation email**
- Publishes messages to the topic, which are delivered to the email subscriber

### ✅ Programmatic Access
- Configures an **IAM user** with programmatic access (Access Key + Secret Key)
- Uses Spring Cloud AWS to interact with SNS and SQS programmatically

---

## 💻 Technologies Used

- Java 17+
- Spring Boot
- Spring Cloud AWS
- Amazon SNS & Amazon SQS
- IAM (for access control)

---

## ⚙️ Configuration

Update the following properties in your `application.properties` or `application.yml` file:

```properties
aws.access.key=YOUR_AWS_ACCESS_KEY
aws.secret.key=YOUR_AWS_SECRET_KEY
sqs.url=YOUR_SQS_QUEUE_URL
```

> ⚠️ **Important:** Never share your actual AWS credentials (access key and secret key) in public repositories.

---

## 🚀 How to Run

1. Clone the project.
2. Set up AWS credentials as mentioned above.
3. Run the Spring Boot application.
4. Watch as messages are sent to your email and/or SQS queue.

---

## 📩 Notes

- For email subscriptions, ensure you **confirm the subscription** via the email link sent by AWS SNS.
- Make sure your IAM user has the necessary permissions: `sns:Publish`, `sns:Subscribe`, `sqs:SendMessage`, etc.
