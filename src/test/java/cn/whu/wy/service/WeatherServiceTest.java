package cn.whu.wy.service;

import cn.whu.wy.entity.Weather;
import cn.whu.wy.mapper.IWeatherMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @Author WangYong
 * @Date 2020/05/28
 * @Time 11:41
 */
//@RunWith(MockitoJUnitRunner.class) mock不会真正写数据到数据库
@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherServiceTest {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private IWeatherMapper weatherMapper;


    private String[] cities = {"北京", "深圳", "长沙", "重庆"};
    private String[] weathers = {"晴", "雨", "雪", "多云"};
    private int[] tempertatures = {-1, 5, 22, 24, 30, 28};

    private Random rand;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        rand = new Random();
//        clear();
    }

    private void clear() {
        for (Weather weather : weatherMapper.selectAll()) {
            weatherMapper.delete(weather);
        }
        assertEquals(0, weatherMapper.selectAll().size());
    }

    //    @Test
    public void add() {
        LocalDate from = LocalDate.of(2020, 1, 1);
        Weather weather = new Weather();

        for (String city : cities) {
            weather.setCity(city);
            for (int i = 0; i < 30; i++) {
                weather.setDate(from.plusDays(i));
                weather.setWeather(weathers[rand.nextInt(4)]);
                weather.setTemperature(tempertatures[rand.nextInt(6)]);
                weather.setId(null);
                weatherService.add(weather);
            }
        }

        assertEquals(120, weatherMapper.selectAll().size());
    }

    @Test
    public void testExample() {
        List<Weather> weathers = weatherMapper.select(null, null, null);
        assertEquals(120, weathers.size());
    }
}