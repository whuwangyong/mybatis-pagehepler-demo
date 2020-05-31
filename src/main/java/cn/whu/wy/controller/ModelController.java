package cn.whu.wy.controller;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.service.WeatherService;
import com.github.pagehelper.PageInfo;
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
                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Weather> pageInfo = weatherService.show(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getPageSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("navigatePages", pageInfo.getNavigatePages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return "index";
    }

}
