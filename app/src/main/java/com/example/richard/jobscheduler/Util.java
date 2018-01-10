package com.example.richard.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class Util {

  public static void scheduleJob(Context context) {
    ComponentName serviceComponent = new ComponentName(context, TestJobService.class);
    JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);

    builder.setMinimumLatency(0); // wait at least
    builder.setOverrideDeadline(0); // maximum delay

    JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
    if (jobScheduler != null) {
      jobScheduler.schedule(builder.build());
    }
  }
}
