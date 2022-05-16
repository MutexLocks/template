public interface DMEFeignClient {
    @PostMapping("/rest/vmmgmt/v1/vms/{id}/clone")
    AsyncTaskResponse createInstances(@PathVariable("id") String id, @RequestBody CreateInstanceRequest createInstanceRequest);
}