package com.example.richard.jobscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyStartServiceReceiver extends BroadcastReceiver {

  @Override public void onReceive(Context context, Intent intent) {
    /*
    Careful, commenting this line out will allow the job to keep scheduling
    itself even after reboot. This can cause a situation where you must use ADB
    to uninstall the app in order to make your device usable again.
     */
    //Util.scheduleJob(context);
  }
}
