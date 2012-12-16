package com.github.lateralthoughts.rest.utils;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

    private final Server server;

    public WebServer(int port, String resourceBase) {
        this.server = new Server(port);
        registerServletContext(resourceBase);
    }

    private void registerServletContext(String resourceBase) {
        WebAppContext context = new WebAppContext();
        context.setResourceBase(resourceBase);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {context});
        server.setHandler(handlers);
    }

    public void start() {
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
