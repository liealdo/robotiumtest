package com.example.aldo.robotiumtest;


import android.test.ActivityInstrumentationTestCase2;


import com.robotium.solo.*;

public class RobotiumTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public RobotiumTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRun(){

    }


}
