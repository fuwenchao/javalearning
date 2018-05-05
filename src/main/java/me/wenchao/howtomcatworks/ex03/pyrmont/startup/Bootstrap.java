package me.wenchao.howtomcatworks.ex03.pyrmont.startup;


import me.wenchao.howtomcatworks.ex03.pyrmont.connector.http.HttpConnector;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    connector.start();
  }
}