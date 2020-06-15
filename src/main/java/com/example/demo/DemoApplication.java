package com.example.demo;

import com.rabbitmq.client.MetricsCollector;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.FrameHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
@EnableBinding({ Rabbit1Sink.class, Rabbit2Sink.class })
public class DemoApplication {

	@Bean
	public ConnectionFactory connectionFactory() {
		com.rabbitmq.client.ConnectionFactory rcf = new CustomRCF();
		CachingConnectionFactory cacheConnFact = new CachingConnectionFactory(rcf) {};
		return cacheConnFact;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


@Slf4j
class CustomRCF extends com.rabbitmq.client.ConnectionFactory {
	@Override
	protected AMQConnection createConnection(ConnectionParams params, FrameHandler frameHandler, MetricsCollector metricsCollector) {
		log.info("creating connection");

		return super.createConnection(params, frameHandler, metricsCollector);
	}
}
