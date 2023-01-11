package com.poc.trace.client;

import feign.FeignException;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "monitor-client",
    url = "${monitor.url}",
    configuration = MonitorClient.FeignConfiguration.class)
public interface MonitorClient {

  @GetMapping(
      value = "monitor",
      produces = MediaType.APPLICATION_JSON_VALUE)
  String monitor();

  @GetMapping(
      value = "error",
      produces = MediaType.APPLICATION_JSON_VALUE)
  String error();

  class FeignConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
      return FeignException::errorStatus;
    }
  }

}
