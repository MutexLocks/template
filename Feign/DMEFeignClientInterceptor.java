public class DMEFeignClientInterceptor implements RequestInterceptor {

    private DMEFeignClientConfig dmeFeignClientConfig;
    public DMEFeignClientInterceptor(DMEFeignClientConfig dmeFeignClientConfig) {
        this.dmeFeignClientConfig = dmeFeignClientConfig;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {

        requestTemplate.headers(generateAuthHeader(requestTemplate));
    }

    private Map<String, Collection<String>> generateAuthHeader(RequestTemplate template) {
        Map<String, Collection<String>> headerMap = new HashMap<>();
        DMEFeignClient dmeFeignClient = DMEHelper.getDmeFeignClient(dmeFeignClientConfig);

        AccessSessionRequest accessSessionRequest = new AccessSessionRequest();
        accessSessionRequest.setUserName(dmeFeignClientConfig.getUsername());
        accessSessionRequest.setValue(dmeFeignClientConfig.getPassword());
        accessSessionRequest.setGrantType("password");

        AccessSessionResponse sessionResponse = dmeFeignClient.getAccessSession(accessSessionRequest);

        headerMap.put("X-Auth-Token", Collections.singleton(sessionResponse.getAccessSession()));
        headerMap.put("Content-Type", Collections.singleton("application/json"));
        headerMap.put("charset", Collections.singleton("UTF-8"));

        return headerMap;
    }
}
