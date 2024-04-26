package io.github.andresqz.utils;

import io.github.andresqz.model.TraceRequest;

import java.time.Instant;

public class RepositoryUtil {
    public static TraceRequest createRequestData (String ipAddress, Instant requestDate, String method) {
      return new TraceRequest(ipAddress, requestDate, method);
    }
}
