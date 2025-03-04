package zad1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private String country;
    private final String weatherApiKey = "";
    private final String  apiKey = "";

    public Service(String country) {
        this.country = country;
    }

    public String getWeather(String city) {
        String countryCode = getCountryCode();
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s&units=metric",
                city,
                countryCode,
                weatherApiKey);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new URI(url).toURL().openConnection().getInputStream()))) {

            String json = reader.lines().collect(Collectors.joining());
            Optional<Weather> weather = Optional.ofNullable(new Gson().fromJson(json, Weather.class));


            return weather.map(Weather::toString).orElse(null);
        }catch (IOException| URISyntaxException e) {
            return null;
        }
    }

    public double getRateFor(String currency) {
        String countryCode = getCountryCode();
        if (countryCode != null) {
            Locale locale = new Locale("", countryCode);

            String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, currency);
            String countryCurrency = Currency.getInstance(locale).getCurrencyCode();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new URI(url).toURL().openConnection().getInputStream()))) {

                String json = reader.lines().collect(Collectors.joining());
                ExchangeRate exchangeRate = new Gson().fromJson(json, ExchangeRate.class);

                if (exchangeRate != null) {
                    return exchangeRate.getRates().get(countryCurrency);
                } else {
                    return 0;
                }
            } catch (IOException | URISyntaxException e) {
                return 0;
            }
        }
        return 0;
    }

    public double getNBPRate() {
        String countryCode = getCountryCode();
        if (countryCode != null) {
            Locale locale = new Locale("", countryCode);
            String[] tables = {"A", "B", "C"};
            String url, json;
            String format = "?format=json";
            String countryCurrency = Currency.getInstance(locale).getCurrencyCode();

            if (countryCurrency.equals("PLN")) {
                return 1;
            }

            for (String table : tables) {
                url = String.format("http://api.nbp.pl/api/exchangerates/tables/%s/%s", table, format);

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new URI(url).toURL().openConnection().getInputStream()))) {

                    json = reader.lines().collect(Collectors.joining());
                    List<RatesArray> ratesArrays = new Gson().fromJson(json, new TypeToken<List<RatesArray>>() {
                    }.getType());

                    for (RatesArray array : ratesArrays) {
                        for (Rate rate : array.rates) {
                            if (rate.code.equals(countryCurrency)) {
                                return rate.mid;
                            }
                        }
                    }

                } catch (IOException | URISyntaxException e) {
                    return 0;
                }
            }
        }
        return 0;
    }

    public String getCountryCode() {
        Map<String, String> codes = new HashMap<>();
        for (String c : Locale.getISOCountries()){
            Locale l = new Locale("", c);
            codes.put(l.getDisplayCountry(Locale.ENGLISH), c);
        }
        return codes.get(country);
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class Weather {
    private Coord coord;
    private WeatherDetails[] weather;
    private String base;
    private WeatherMain main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    @Override
    public String toString() {
        return main.getTemp();
    }
}

class WeatherDetails {
    private int id;
    private String main;
    private String description;
    private String icon;
}

class Wind {
    private double speed;
    private int deg;
}

class Clouds {
    private int all;
}

class Sys {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}

class WeatherMain {
    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;

    public String getTemp() {
        return temp;
    }
}

class Coord {
    private double lon;
    private double lat;

}

class ExchangeRate {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getRates() {
        return conversion_rates;
    }

}

class RatesArray{
    List<Rate> rates;
}

class Rate{
    String code;
    double mid;
}
