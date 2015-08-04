namespace java de.timwellhausen.example.spring.thriftintegration.api

struct Ping {
    1: string message;
}

struct Pong {
    1: string answer;
}

service PingPongService {
    Pong knock(1: Ping ping);
}
