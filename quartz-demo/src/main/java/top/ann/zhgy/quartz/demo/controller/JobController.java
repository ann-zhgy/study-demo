package top.ann.zhgy.quartz.demo.controller;

import com.github.pagehelper.PageInfo;
import top.ann.zhgy.quartz.demo.entity.JobDetails;
import top.ann.zhgy.quartz.demo.job.HelloJob;
import top.ann.zhgy.quartz.demo.job.NewJob;
import top.ann.zhgy.quartz.demo.service.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ann-zhgy
 * @version JobController.class 2023-09-15 17:57
 * @since 2023-09
 */
@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private QuartzManager qtzManager;

    @SuppressWarnings("unchecked")
    private static Class<? extends QuartzJobBean> getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (Class<? extends QuartzJobBean>) class1;
    }

    /**
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @throws Exception
     */
    @PostMapping(value = "/addjob")
    public void addjob(@RequestParam(value = "jobClassName") String jobClassName,
                       @RequestParam(value = "jobGroupName") String jobGroupName,
                       @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        Class<? extends QuartzJobBean> jobClass;
        if (jobClassName.startsWith("hello")) {
            jobClass = HelloJob.class;
        } else if (jobClassName.startsWith("new")) {
            jobClass = NewJob.class;
        } else {
            throw new RuntimeException("invalid jobClassName");
        }
        qtzManager.addOrUpdateJob(jobClass, jobClassName, jobGroupName, cronExpression);
    }

    /**
     * @param jobClassName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value = "/pausejob")
    public void pausejob(@RequestParam(value = "jobClassName") String jobClassName,
                         @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        qtzManager.pauseJob(jobClassName, jobGroupName);
    }

    /**
     * @param jobClassName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value = "/resumejob")
    public void resumejob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        qtzManager.resumeJob(jobClassName, jobGroupName);
    }

    /**
     * @param jobClassName
     * @param jobGroupName
     * @param cronExpression
     * @throws Exception
     */
    @PostMapping(value = "/reschedulejob")
    public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
                              @RequestParam(value = "jobGroupName") String jobGroupName,
                              @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        qtzManager.addOrUpdateJob(getClass(jobClassName), jobClassName, jobGroupName, cronExpression);
    }

    /**
     * @param jobClassName
     * @param jobGroupName
     * @throws Exception
     */
    @PostMapping(value = "/deletejob")
    public void deletejob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        qtzManager.deleteJob(jobClassName, jobGroupName);
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/queryjob")
    public Map<String, Object> queryjob(@RequestParam(value = "pageNum") Integer pageNum,
                                        @RequestParam(value = "pageSize") Integer pageSize) {
        PageInfo<JobDetails> jobAndTrigger = qtzManager.queryAllJobBean(pageNum, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("JobAndTrigger", jobAndTrigger);
        map.put("number", jobAndTrigger.getTotal());
        return map;
    }
}
