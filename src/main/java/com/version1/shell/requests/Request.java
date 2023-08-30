package com.version1.shell.requests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface Request {

    void send(String url) ;
    void send(String url, String body) ;
}
