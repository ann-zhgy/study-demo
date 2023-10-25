package top.ann.zhgy.quartz.demo.job;

import top.ann.zhgy.quartz.demo.utils.SpringUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author ann-zhgy
 * @version HelloJob.class 2023-09-15 17:58
 * @since 2023-09
 */
@Slf4j
public class NewJob extends QuartzJobBean {
    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // get parameters
        context.getJobDetail().getJobDataMap().forEach(
                (k, v) -> log.info("param, key:{}, value:{}", k, v)
        );
        // your logics
        log.info("{} 执行时间: {}, 端口：{}", context.getJobDetail().getKey(), new Date(), SpringUtil.getServerPort());
    }
}
