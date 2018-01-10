package com.example.richard.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.net.Uri;

public class TestJobService extends JobService {

  @Override public boolean onStartJob(JobParameters params) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cnn.com/"));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);

    Util.scheduleJob(this);

    return false;
  }

  @Override public boolean onStopJob(JobParameters params) {
    return true;
  }
}
