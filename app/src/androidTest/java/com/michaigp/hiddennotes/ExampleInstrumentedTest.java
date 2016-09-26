package com.michaigp.hiddennotes;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.michaigp.hiddennotes", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testButton() {
        onView(withId(R.id.button)).perform(click());
        onView(withText("Clicked!")).check(matches(isDisplayed()));
        onView(withId(R.id.textView2)).check(matches(withText("The button was clicked")));
    }

    @Test
    public void testFab() {
        onView(withId(R.id.fab)).perform(click());
        onView(withText("Replace with your own action")).check(matches(isDisplayed()));
    }

    @Test
    public void testEditText() {
        onView(withId(R.id.editText)).perform(typeText("Hello"), click());
        onView(withId(R.id.editText)).check(matches(withText("Hello")));
    }


    @Test
    public void testTextView() {
        onView(withText("textview")).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonText() {
        onView(withText("buttton")).check(matches(isDisplayed()));
    }

    @Test
    public void testNavigationDrawer() {
        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.LEFT)));
        DrawerActions.openDrawer(R.id.drawer_layout, Gravity.START);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen(Gravity.LEFT)));
        onView(withText("Import")).check(matches(isDisplayed()));
        onView(withText("Gallery")).check(matches(isDisplayed()));
        onView(withText("Slideshow")).check(matches(isDisplayed()));
        onView(withText("Tools")).check(matches(isDisplayed()));
    }
}
