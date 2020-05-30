package cn.whu.wy.controller;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author WangYong
 * @Date 2020/05/29
 * @Time 11:09
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Request: http://127.0.0.1:10086/api/query?city=重庆
     * Response: json
     *
     * @param city
     * @return
     */
    @GetMapping("/query")
    public Object query(@RequestParam String city) {
        return weatherService.query(city);
    }

    @PostMapping("/add")
    public void add(@RequestBody Weather weather) {
        weatherService.add(weather);
    }

    @PostMapping("/edit")
    public void edit(@RequestBody Weather weather) {
        weatherService.edit(weather);
    }
}
