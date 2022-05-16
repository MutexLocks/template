public class Main {
    public static void main(String[] args) {
        DMEFeignClient dmeFeignClient = Feign.builder()
                .client(new ApacheHttpClient(httpClient))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .requestInterceptor(new DMEFeignClientInterceptor(dmeFeignClientConfig))
                .logger(new Slf4jLogger(DMEFeignClient.class))
                .logLevel(feign.Logger.Level.FULL)
                .target(DMEFeignClient.class, dmeFeignClientConfig.getAddress());
    }
}