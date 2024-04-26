package io.github.andresqz.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "traceRequest")

public class TraceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "requestDate")
    private Instant requestDate;

    @Column(name = "method")
    private String method;



    public TraceRequest(String ipAddress, Instant requestDate, String method) {
        this.ipAddress = ipAddress;
        this.requestDate = requestDate;
        this.method = method;
    }

    public long getId() {
        return id;
    }

}
