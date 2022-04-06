**Google Cloud Pub/Sub**

What is Pub/Sub?

Google Cloud Pub/Sub is a microservice provided by Google Cloud Platform. 
Pub/Sub allows services to communicate asynchronously, with latencies on the order of 100 milliseconds.

Pub/Sub is used for streaming analytics and data integration pipelines to ingest and distribute data. It is equally effective as a messaging- oriented middleware for service integration or as a queue to parallelize tasks.


How PUB/ SUB works?

As the name suggests, this data streaming procedure is based on mainly three parts: Publisher, topic and subscriber.

Due to the use of publisher and subscriber, this procedure has been considered as durable, reliable and flexible.

Pub/Sub data streaming procedure, mainly decouples the sender from the receiver due to which it has found a secure way to process the data between the applications which are independently created. It has the capability of ingesting a large amount of data which is possible due to scalability of the service.



Pub/Sub enables you to create systems of event producers and consumers, called publishers and subscribers. Publishers communicate with subscribers asynchronously by broadcasting events, rather than by synchronous remote procedure calls (RPCs) / Blocking call.

The key concepts in a Pub/Sub service:

    Topic: To which publisher sends the messages.
    Subscription: In order to get the data published to the topic, we must subscribe to that topic. Subscription represents the streaming message from a unique topic to be delivered to the subscribing application.
    Message: A data which is going to be published and subscribed.
    Publisher(also called a producer): creates messages and sends(publishes) them to the messaging service on a specified topic.
    Subscriber(also called a consumer): receives messages on a specified subscription.

Google Cloud Pub/Sub Data flow

The following diagram is an overview of the components in the Pub/Sub and how messages flow between them:
    A publisher application creates a topic in the pub/sub service and sends a message to the topic. A message contains a payload and optional attributes that describe the payload content.
    The service ensures that published messages are retained on behalf of subscriptions. A published message is retained for a subscription until it is acknowledged by any subscriber consuming messages from that subscription.
    Pub/Sub forwards messages from a topic to all of its subscriptions, individually.
    A subscriber receives messages either by Pub/Sub pushing them to the subscriber’s chosen endpoint or by the subscriber pulling them from the service.
    The subscriber sends an acknowledgment to the Pub/Sub service for each received message.
    The service removes acknowledged messages from the subscription’s message queue.

Publisher Application

Publishers can be any application that can make HTTPS request to pubsub.google.apis.com: an App Engine app, a web service hosted on Google Compute Engine or any other third-party network, an app installed on a desktop or mobile device, or even a browser.

Subscriber Application

When you create a subscriber, you need to have a subscription to receives messages from a topic. The subscription connects the topic to a subscriber application that receives and processes messages. A topic can have multiple subscriptions, but a given subscription belongs to a single topic.

There are two mechanisms for message delivery.

    Pull subscription: In pull delivery, your subscriber application initiates requests to the Pub/Sub server to retrieve messages. The subscribing application explicitly calls the pull method, which requests messages for delivery. The Pub/Sub server responds with the message (or an error if the queue is empty), and an ack ID. The subscriber explicitly calls the acknowledge method, using the returned ack ID to acknowledge receipt.

    Push subscription: In push delivery, Pub/Sub initiates requests to your subscriber application to deliver messages. The Pub/Sub server sends each message as an HTTPS request to the subscriber application at a pre-configured endpoint. The endpoint acknowledges the message by returning an HTTP success status code. A non-success response indicates that the message should be resent.

Use Cases

    Balancing workloads in network clusters — For example, a large queue of tasks can be efficiently distributed among multiple workers, such as Google Compute Engine instances.
    Implementing asynchronous workflows — For example, an order processing application can place an order on a topic, from which it can be processed by one or more workers.
    Distributing event notifications — For example, a service that accepts user signups can send notifications whenever a new user registers, and downstream services can subscribe to receive notifications of the event.
    Refreshing distributed caches — For example, an application can publish invalidation events to update the IDs of objects that have changed.
    Logging to multiple systems — For example, a Google Compute Engine instance can write logs to the monitoring system, to a database for later querying, and so on.
    Data streaming from various processes or devices — For example, a residential sensor can stream data to backend servers hosted in the cloud.
    Reliability improvement — For example, a single-zone Compute Engine service can operate in additional zones by subscribing to a common topic, to recover from failures in a zone or region.