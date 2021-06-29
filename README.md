# AndroidNavigation
Android Navigation to explain issue with LiveData


To replicate the issue
- Press on Start
- Countdown will start
- And then using Top help button open up Help screen
- once countdown finishes MainFragment tries to navigate to Alert fragment
- but crashes with Exception

```
E/AndroidRuntime: FATAL EXCEPTION: main
    Process: au.com.soan.androidnavigation, PID: 5170
    java.lang.IllegalArgumentException: Navigation action/destination au.com.soan.androidnavigation:id/action_mainFragment_to_alertFragment cannot be found from the current destination Destination(au.com.soan.androidnavigation:id/helpFragment) label=help_fragment
        at androidx.navigation.NavController.navigate(NavController.java:940)
        at androidx.navigation.NavController.navigate(NavController.java:877)
        at androidx.navigation.NavController.navigate(NavController.java:863)
        at androidx.navigation.NavController.navigate(NavController.java:1159)
        at au.com.soan.androidnavigation.ui.main.MainFragment.navigateTo(MainFragment.kt:62)
        at au.com.soan.androidnavigation.ui.main.MainFragment.onViewCreated$lambda-1(MainFragment.kt:51)
        at au.com.soan.androidnavigation.ui.main.MainFragment.lambda$Xgp1DQZSZLEsDQECO9II4cxT3S8(Unknown Source:0)
        at au.com.soan.androidnavigation.ui.main.-$$Lambda$MainFragment$Xgp1DQZSZLEsDQECO9II4cxT3S8.onChanged(Unknown Source:4)
        at androidx.lifecycle.LiveData.considerNotify(LiveData.java:133)
        at androidx.lifecycle.LiveData.dispatchingValue(LiveData.java:151)
        at androidx.lifecycle.LiveData.setValue(LiveData.java:309)
        at androidx.lifecycle.MutableLiveData.setValue(MutableLiveData.java:50)
        at au.com.soan.androidnavigation.ui.main.MainViewModel$createCountdownTimer$1.onFinish(MainViewModel.kt:26)
        at android.os.CountDownTimer$1.handleMessage(CountDownTimer.java:127)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:223)
        at android.app.ActivityThread.main(ActivityThread.java:7664)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
 ```
