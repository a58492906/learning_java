package io.github.ericmeng.gateway.outbound.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpOutboundHandler {


        // 缓存客户端实例
        public static OkHttpClient client = new OkHttpClient();

        // GET 调用
        public static String getAsString(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }


        public static void main(String[] args) throws Exception {

            String url = "http://localhost:8001";
            String text = OkhttpOutboundHandler.getAsString(url);
            System.out.println("url: " + url + " ; response: \n" + text);

            // 清理资源
            OkhttpOutboundHandler.client = null;
        }

}
