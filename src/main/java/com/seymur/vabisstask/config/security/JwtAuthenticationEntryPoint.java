package com.seymur.vabisstask.config.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        ApiResponse apiResponse = new ApiResponse(false, new ErrorResponse(401, 401, Arrays.asList("Unauthorized")));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), apiResponse);

    }
}
