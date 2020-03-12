package com.tongfu.ndkbuildsample;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NdkBuildJniUtilTest {
    @Test
    public void testPrintHelloWord() {
        NdkBuildJniUtil.printHelloWorld();
    }
}
