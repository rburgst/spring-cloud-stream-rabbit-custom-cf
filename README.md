# Spring cloud stream custom binder

This sample intends to connect to 2 different RMQ instances. 

* `Rabbit1` requires a custom `com.rabbitmq.client.ConnectionFactory`
* `Rabbit2` can run with a normal `com.rabbitmq.client.ConnectionFactory`

Currently the configured `com.example.demo.CustomRCF` is ignored and instead
2 default `org.springframework.amqp.rabbit.connection.CachingConnectionFactory` with
the settings from `application.yaml` are created.

To test place a breakpoint into `com.example.demo.CustomRCF.createConnection` and
see if it is being hit.
Currently, the answer is no.
