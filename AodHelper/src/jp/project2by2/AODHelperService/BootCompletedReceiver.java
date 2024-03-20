//
//  Copyright (C) 2024 The 2by2 Project
//  SPDX-License-Identifier: Apache-2.0
//

package jp.project2by2.AODHelperService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final String TAG = "AODHelperService";

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            context.startService(new Intent(context, DozeCustomService.class));
        }
    }
}
