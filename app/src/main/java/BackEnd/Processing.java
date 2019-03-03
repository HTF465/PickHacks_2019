package BackEnd;

import android.os.Build;
import android.support.annotation.RequiresApi;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Processing {


    private static final String[] OUT = {"invalid", "invalid"};


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void go(Person pIn) {
        JSONObject send = new JSONObject();
        try {
            send.accumulate("person", pIn.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(send.toString());

        whenAsynchronousPut("https://pickhacks-spring2019-htf465.c9users.io:8080/search", send);


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String goGo(Person pIn) {
        JSONObject send = new JSONObject();
        JSONObject kill = new JSONObject();
        int count = 0;
        try {
            send.accumulate("UID", pIn.getID());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (OUT[1].equals("invalid") && count < 10) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            whenAsynchronousPut("https://pickhacks-spring2019-htf465.c9users.io:8080/notifications", send);
            count++;
        }
        String maybe = OUT[1];
        System.out.println("THIS: " + OUT[1]);
        if (!OUT[1].equals("no notifications")) {
            try {

                kill.accumulate("guy", OUT[1]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            count = 0;
            while (!OUT[1].equals("Noice") && count < 10) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                whenAsynchronousKill("https://pickhacks-spring2019-htf465.c9users.io:8080/kill", kill);
                count++;
            }
        }
        System.out.println(maybe);
        return maybe;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getID() {
        int count = 0;
        Processing pro = new Processing();
        pro.whenAsynchronousGetRequest_thenCorrect();
        System.out.println(OUT[0]);
        while (OUT[0].equals("invalid")) {

            System.out.println(OUT[0]);
            if (count >= 10) {
                return "-001";
            }
            pro.whenAsynchronousGetRequest_thenCorrect();

            count++;
        }

        return OUT[0];


    }

    public void killer(Person pIn)
    {
        int count = 0;
        Processing pro = new Processing();
    }


    public void whenAsynchronousGetRequest_thenCorrect() {

        Request request = new Request.Builder()
                .url("https://pickhacks-spring2019-htf465.c9users.io:8080/idMake")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                //System.out.println("SDIIFJLSIDKHGILSDHFKIDSHFDSKUHG");
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                //System.out.println(response.body().string());
                System.out.println(OUT[0] = response.body().string());
                System.out.println(OUT[0]);

            }

            public void onFailure(Call call, IOException e) {
                //mine = new Holder("-1");
                e.printStackTrace();
            }
        });
    }

    public void whenAsynchronousPut(String url, JSONObject json) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        okhttp3.RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                //System.out.println("SDIIFJLSIDKHGILSDHFKIDSHFDSKUHG");
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                //System.out.println(response.body().string());
                String hld = response.body().string();
                if(!hld.equals("")) {
                    OUT[1] = hld;
                }
                System.out.println(OUT[1]);

            }

            public void onFailure(Call call, IOException e) {
                //mine = new Holder("-1");
                e.printStackTrace();
            }
        });
    }

    public void whenAsynchronousKill(String url, JSONObject json) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        okhttp3.RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                //System.out.println("SDIIFJLSIDKHGILSDHFKIDSHFDSKUHG");
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                //System.out.println(response.body().string());
                OUT[1] = response.body().string();
                System.out.println(OUT[1]);

            }

            public void onFailure(Call call, IOException e) {
                //mine = new Holder("-1");
                e.printStackTrace();
            }
        });
    }
}
