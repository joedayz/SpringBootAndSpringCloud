package pe.joedayz.demoservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceDiscoveryApplication.class, args);
	}
}
