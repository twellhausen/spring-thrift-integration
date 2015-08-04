package de.timwellhausen.example.spring.thriftintegration.client;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.LoggerFactory;

import de.timwellhausen.example.spring.thriftintegration.api.Ping;
import de.timwellhausen.example.spring.thriftintegration.api.PingPongService;
import de.timwellhausen.example.spring.thriftintegration.api.Pong;

public class Client {

    public static void main(String[] args) throws Exception {

        THttpClient transport = new THttpClient("http://localhost:8080/api");
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        PingPongService.Client client = new PingPongService.Client(new TMultiplexedProtocol(protocol, "PingPongService"));

        Ping ping = new Ping();
        ping.setMessage("Hello");
        Pong pong = client.knock(ping);

        LoggerFactory.getLogger(Client.class).info("Got answer: "+pong.getAnswer());
    }
}
