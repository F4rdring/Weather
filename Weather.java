package NewLesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Weather {
    private static final String PROTOKOL = "http";
    private static final String API_KEY = "d567f2b9-f12d-44a6-b582-a2b59c5321f5";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "forecast";
    private static final String API_V1 = "v2";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private void getWeather(Period period, String selectedCity) throws IOException {
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(CITIES_ENDPOINT)
                    .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                    .build();
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();

        }
    }

    public static void detectCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .build();
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responceString = response.body().string();
        System.out.println(response.body().string());

    }

    public static void main(String[] args) throws IOException {
            detectCityKey("New");


    }
}
