package com.yurkin;

public class WeatherCheck {
    public String day;
    public String temperature;
    public String precipitation;
    public String windy;
    public String humidity;

    public void setWeather(String day, String temperature, String precipitation, String windy, String humidity) {
        this.day = day;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windy = windy;
        this.humidity = humidity;
    }

    public boolean weatherIsGood() {
        if (day != "воскресенье") {
            return false;
        }

        if (temperature != "тепло" && temperature != "жарко") {
            return false;
        }

        if (precipitation != "ясно" && precipitation != "облачно") {
            return false;
        }

        if (windy == "да") {
            return false;
        }

        if (humidity == "высокая") {
            return false;
        }
        
        return true;
    }
}