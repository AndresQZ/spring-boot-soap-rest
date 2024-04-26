package io.github.andresqz.components;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {

    String getClientIp(HttpServletRequest request);

}
