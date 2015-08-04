package de.timwellhausen.example.spring.thriftintegration.server;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.timwellhausen.example.spring.thriftintegration.api.Ping;
import de.timwellhausen.example.spring.thriftintegration.api.PingPongService;
import de.timwellhausen.example.spring.thriftintegration.api.Pong;

@Service
public class PingPongServiceBean implements PingPongService.Iface {

    @Override
    public Pong knock(Ping ping) throws TException {

        String message = ping.getMessage();
        String answer = StringUtils.reverse(message);

        Pong pong = new Pong();
        pong.setAnswer(answer);
        LoggerFactory.getLogger(PingPongServiceBean.class).info("Got message {} and sent answer {}", message, answer);

        return pong;
    }
}
