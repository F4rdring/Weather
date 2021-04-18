package NewLesson6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.Request;

import java.io.IOException;


public class Client {

        private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {


        Request request = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true")
                .addHeader("X-Yandex-API-Key", "d567f2b9-f12d-44a6-b582-a2b59c5321f5")
                .build();
        Response response = okHttpClient.newCall(request).execute();

        System.out.println("Код ответа:" + response.code());
        String responseBody = response.body().string();
        //System.out.println(responseBody);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode weather = objectMapper.readTree(responseBody);

        String temp = weather.get("fact").get("temp").asText();
        //String city = weather.get("info").get("tzinfo").get("name").asText();  //Москва
        String city = weather.get("geo_object").get("locality").get("name").asText();

        //String temp = objectMapper.readTree(String.valueOf(weather)).at("/fact/temp").asText();

        //System.out.println("test: " + temper);
        //System.out.println(weather.get("fact").get("temp").asText());

        System.out.println("Температура: " + temp);
        System.out.println("Город: " + city);
        

    }


}
