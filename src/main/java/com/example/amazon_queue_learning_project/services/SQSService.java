package com.example.amazon_queue_learning_project.services;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SQSService {

    //@SqsListener(value="sqs-demo-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    @SqsListener(value = "${sqs.url}")
    public void receiveMessage(String message){
        log.info("Message Received : {}", message);
        //AmazonSQSAsync a
    }
}
