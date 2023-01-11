package com.poc.trace.controller;

import com.poc.trace.client.MonitorClient;
import javax.management.monitor.Monitor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class TraceController {

  private final MonitorClient client;

  @GetMapping("trace")
  public String trace() {
    log.info("Bateu no trace");
    client.monitor();
    return "Hello World";
  }

  @GetMapping("trace2")
  public String error() {
    log.info("Bateu no ERRO do trace");
    client.error();
    return "Hello World Error";
  }
}
