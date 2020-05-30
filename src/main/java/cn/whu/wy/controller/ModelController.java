package cn.whu.wy.controller;

import cn.whu.wy.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 10:48
 */
@Controller
@Slf4j
public class ModelController {
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("weathers", weatherService.showAll());
        return "index";
    }

    /**
     * http://127.0.0.1:10086/?pageNum=1&pageSize=10
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        model.addAttribute("weathers", weatherService.show(pageNum, pageSize));
        return "index";
    }

}
