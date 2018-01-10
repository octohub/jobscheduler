package com.example.richard.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import java.util.concurrent.TimeUnit;

public class Util {

  public static void scheduleJob(Context context) {
    ComponentName serviceComponent = new ComponentName(context, TestJobService.class);
    JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);

    builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
    builder.setPeriodic(TimeUnit.DAYS.toMillis(1) / 2);
    builder.setBackoffCriteria(TimeUnit.MINUTES.toMillis(1), JobInfo.BACKOFF_POLICY_EXPONENTIAL);
    builder.setPersisted(true);

    JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
    if (jobScheduler != null) {
      jobScheduler.schedule(builder.build());
    }
  }
}
