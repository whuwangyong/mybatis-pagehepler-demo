package cn.whu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {
    @Autowired
    MyService myService;

    @Autowired
    Log log;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);


    @GetMapping("/hello")
    public String sayHello() {
        log.info("sync start");
        myService.doSomething();
        log.info("sync end");

        return "success";
    }

    @GetMapping("/hello-async")
    public DeferredResult<String> sayHelloAsync() {
        log.info("async start");
        DeferredResult<String> result = new DeferredResult<>();
        executorService.execute(()->{
            myService.doSomething();
            result.setResult("ok");
        });


        log.info("async end");

        return result;
    }




}
