package io.github.andresqz.interceptors;

import io.github.andresqz.repository.TraceRequestRepository;
import io.github.andresqz.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import java.time.Instant;

@Component
    public class TraceRequestEndpointInterceptor implements EndpointInterceptor {

       @Autowired
       TraceRequestRepository traceRequestRepository;

        @Override
        public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {;

            TransportContext context = TransportContextHolder.getTransportContext();
            var httpServelet= ((HttpServletConnection ) context.getConnection()).getHttpServletRequest();

            if (endpoint instanceof MethodEndpoint) {
                MethodEndpoint methodEndpoint = (MethodEndpoint)endpoint;
               try {
                   traceRequestRepository.save(RepositoryUtil.createRequestData(httpServelet.getRemoteAddr(), Instant.now(), methodEndpoint.getMethod().getName()));
               } catch (Exception e) {
                   System.out.println(String.format("something went wrong : %s", e.getCause()));
               }
            }
            return true;
        }

        @Override
        public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
            return true;
        }

        @Override
        public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
            return true;
        }

        @Override
        public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        }
    }

