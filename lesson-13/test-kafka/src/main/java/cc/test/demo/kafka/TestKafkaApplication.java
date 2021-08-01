package cc.test.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@SpringBootApplication
public class TestKafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestKafkaApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Override
    public void run(String... args) throws Exception {
        log.info("消息发送：");
        this.template.send("test-msg", "data-test-msg");
    }

    @KafkaListener(id = "webGroup", topics = "test-msg")
    public void listen(String input) {
        log.info("消息接收: {}", input);
    }
}
