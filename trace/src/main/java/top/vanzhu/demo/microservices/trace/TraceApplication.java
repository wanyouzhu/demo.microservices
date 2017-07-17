package top.vanzhu.demo.microservices.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class TraceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TraceApplication.class, args);
	}
}
