package com.example.assignment2;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AutomatedUITest {

    private static final String PACKAGE_NAME = "com.example.assignment2";
    private static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice device;

    @Before
    public void startMainActivityFromHomeScreen() throws RemoteException {
        device = UiDevice.getInstance(getInstrumentation());

        if (!device.isScreenOn()) {
            device.wakeUp();
        }

        device.pressHome();

        final String launcherPackage = device.getLauncherPackageName();
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        Context context = getInstrumentation().getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void testStartSecondActivityAndCheckChallenge() {
        UiObject2 button = device.wait(Until.findObject(By.res(PACKAGE_NAME, "button_explicit")), LAUNCH_TIMEOUT);
        button.click();

        device.wait(Until.hasObject(By.res(PACKAGE_NAME, "textViewChallenges")), LAUNCH_TIMEOUT);

        UiObject2 textView = device.findObject(By.res(PACKAGE_NAME, "textViewChallenges"));
        String text = textView.getText();

        assert text.contains("Battery Life Optimization") ||
                text.contains("Screen Size Variability") ||
                text.contains("Security and Privacy") ||
                text.contains("Network Connectivity Issues") ||
                text.contains("Performance Optimization");
    }
}
