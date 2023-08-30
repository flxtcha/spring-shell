package com.version1.shell;

import com.version1.shell.requests.Request;
import com.version1.shell.requests.RequestFactory;
import com.version1.shell.requests.RequestType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;


@ShellComponent
public class ApiCommands {

    RequestFactory requestFactory = new RequestFactory();

    @ShellMethod(key = "get", value = "Send a GET request to an API endpoint")
    public void getRequest(@ShellOption(help = "URI for the API Endpoint") String endpoint) throws IOException {
        Request getRequest = requestFactory.createRequest(RequestType.GET);
        getRequest.send(endpoint);
    }

    @ShellMethod(key = "post", value = "Send a POST request to an API endpoint")
    public void postRequest(@ShellOption(help = "URL for endpoint") String endpoint,
                            @ShellOption(help = "Body of the request to send") String body) throws IOException {
        Request postRequest = requestFactory.createRequest(RequestType.POST);
        postRequest.send(endpoint,body);
    }
}

