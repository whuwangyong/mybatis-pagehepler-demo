package cn.whu.wy.controller;

import cn.whu.wy.entity.BankPositionReqMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/bank-position")
    public String get(BankPositionReqMsg reqMsg) {
        log.info(reqMsg.toString());


        return LocalDateTime.now().toString();
    }


}
