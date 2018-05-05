package me.wenchao.howtomcatworks.ex03.pyrmont;

import me.wenchao.howtomcatworks.ex03.pyrmont.connector.http.HttpRequest;
import me.wenchao.howtomcatworks.ex03.pyrmont.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
