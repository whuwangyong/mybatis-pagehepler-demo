package cn.whu.wy.controller;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 10:48
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("weathers", weatherService.showAll());
        return "index";
    }


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
