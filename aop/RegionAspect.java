@Aspect
@Component
public class RegionAspect {

    @Pointcut("execution(* com.ctyun.cloud.adapter.iaas.client.yacos.YacosClient.*(..))")
    public void pointcut(){

    }
    @Before(value = "pointcut () ")
    public void before(JoinPoint point){
        Object[] args = point.getArgs();
        if (args == null) {
            return;
        }
        if (args.length != 1) {
            return;
        }
        Object argsObject = args[0];
        if (argsObject instanceof CloudBaseCriteria) {
            RegionUtil.setRegionId(((CloudBaseCriteria) argsObject).getRegionId());
        }
    }
}