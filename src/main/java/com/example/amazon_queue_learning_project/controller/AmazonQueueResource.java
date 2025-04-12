package com.example.amazon_queue_learning_project.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.example.amazon_queue_learning_project.model.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.example.amazon_queue_learning_project.constants.AmazonQueueLearningConstants.SEND_MESSAGE_API_PATH;
import static com.example.amazon_queue_learning_project.constants.AmazonQueueLearningConstants.SEND_MESSAGE_TO_EMAIL_API_PATH;

@RestController
@Slf4j
public class AmazonQueueResource {

    @Autowired
    AmazonSNSClient amazonSNSClient;

    private final String SNS_QUEUE_ARN = "arn:aws:sns:us-east-1:317995861961:sns-demo-topic";
    private final String SQS_QUEUE_ARN = "arn:aws:sqs:us-east-1:317995861961:sqs-demo-queue";

    //send message from SNS to SQS
    @GetMapping("/subscribe/sqs")
    public String subscribeToSQS(){
        SubscribeRequest subscribeRequest = new SubscribeRequest(SNS_QUEUE_ARN, "sqs", SQS_QUEUE_ARN);
        amazonSNSClient.subscribe(subscribeRequest);
        return "SQS subscription is successful";
    }
    //send messages to Email

    @PostMapping(path = SEND_MESSAGE_API_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String sendMessage(@RequestBody UserMessage userMessage){
        PublishRequest publishRequest = new PublishRequest(SNS_QUEUE_ARN, userMessage.getMessage(), "SQS Demo");
        amazonSNSClient.publish(publishRequest);
        return "Message Published Successfully";
    }

    @PostMapping(path = SEND_MESSAGE_TO_EMAIL_API_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String sendMessageToEmail(@RequestBody UserMessage userMessage){
        PublishRequest publishRequest = new PublishRequest(SNS_QUEUE_ARN, userMessage.getMessage(), "email Demo");
        amazonSNSClient.publish(publishRequest);
        return "Message Published Successfully To Email";
    }


    @GetMapping("/subscribe/{email}")
    public String subscribeToEmail(@PathVariable(value="email") String email){
        SubscribeRequest subscribeRequest = new SubscribeRequest(SNS_QUEUE_ARN, "email", email);
        amazonSNSClient.subscribe(subscribeRequest);
        return "SQS subscription is successful";
    }

    @GetMapping("/test")
    public String testEndpoint(){
        log.info("Service is up and running");
        return "Success";
    }
}
