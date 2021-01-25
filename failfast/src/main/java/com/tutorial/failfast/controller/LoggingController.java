package com.tutorial.failfast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static net.logstash.logback.argument.StructuredArguments.kv;

public class LoggingController {
    private static final Logger log = LoggerFactory.getLogger("LoggingTest");

    @RequestMapping(value="/testLogging", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> testLogging(){
        String orderId = "123";
        String status = "ISSUED";
        log.info("Order saved", kv("orderId", orderId), kv("status", status));
        return ResponseEntity.ok("done");
    }

    @RequestMapping(value="/testLoggingMDC", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> testLoggingMDC(){
        String orderId = "123";
        MDC.put("orderId", orderId);
        log.info("Order MDC saved");
        MDC.remove("orderId");
        return ResponseEntity.ok("done");
    }
    @RequestMapping(value="/testLoggingObject", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> testLoggingObject(){
        Order order = new Order("123", "NEW", null);
        log.info("Order saved", kv("order", order));
        return ResponseEntity.ok("done");
    }

    static class Order {
        String orderId;
        String status;
        String canceled;

        Order(String orderId, String status, String canceled) {
            this.orderId = orderId;
            this.status = status;
            this.canceled = canceled;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getStatus() {
            return status;
        }

        public String getCanceled() {
            return canceled;
        }
    }
}
