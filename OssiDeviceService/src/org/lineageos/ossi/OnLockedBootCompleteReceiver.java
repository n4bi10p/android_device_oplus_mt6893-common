//
//  Copyright (C) 2024 The LineageOS Project
//  SPDX-License-Identifier: Apache-2.0
//

package org.lineageos.ossi;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

import android.util.Log;

import org.lineageos.ossi.disablehwoverlays.DisableHWOverlaysService;
import org.lineageos.ossi.aodhelper.DozeCustomService;

public class OnLockedBootCompleteReceiver extends BroadcastReceiver {
    private static final String TAG = "OssiDeviceService";

    Intent sIntent;

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.i(TAG, "onBoot");

        sIntent = new Intent(context, DisableHWOverlaysService.class);
        context.startService(sIntent);

        sIntent = new Intent(context, DozeCustomService.class);
        context.startService(sIntent);
    }
}
