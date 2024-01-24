package com.tui.proof.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerCustom {
    @ExceptionHandler(value = AccessDeniedException.class)
    public void handleConflict(HttpServletResponse response) throws IOException {
        String text = "You don´t have access. Contact the administrator!";

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);
    }
}
