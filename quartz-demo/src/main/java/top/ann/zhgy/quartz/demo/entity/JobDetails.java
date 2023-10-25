package top.ann.zhgy.quartz.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ann-zhgy
 * @version JobDetails.class 2023-09-15 17:54
 * @since 2023-09
 */
@Data
public class JobDetails {
    private String cronExpression;
    private String jobClassName;
    private String triggerGroupName;
    private String triggerName;
    private String jobGroupName;
    private String jobName;
    private Date nextFireTime;
    private Date previousFireTime;
    private Date startTime;
    private String timeZone;
    private String status;
}
