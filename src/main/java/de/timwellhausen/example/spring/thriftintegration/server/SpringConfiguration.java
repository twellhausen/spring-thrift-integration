package de.timwellhausen.example.spring.thriftintegration.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServlet;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.timwellhausen.example.spring.thriftintegration.api.PingPongService;
import de.timwellhausen.example.spring.thriftintegration.api.PingPongService.Iface;
import de.timwellhausen.example.spring.thriftintegration.api.PingPongService.Processor;

@Configuration
@ComponentScan(basePackages="de.timwellhausen.example.spring.thriftintegration")
public class SpringConfiguration {

    @Bean
    public TServlet thriftServlet(PingPongService.Iface pingPongService) {

        TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();

        Processor<Iface> pingPongProcessor = new PingPongService.Processor<PingPongService.Iface>(pingPongService);
        multiplexedProcessor.registerProcessor("PingPongService", pingPongProcessor);

        Factory protocolFactory = new TBinaryProtocol.Factory();
        TServlet thriftServlet = new TServlet(multiplexedProcessor, protocolFactory);

        LoggerFactory.getLogger(SpringConfiguration.class).info("Thrift servlet initialized.");

        return thriftServlet;
    }
}
