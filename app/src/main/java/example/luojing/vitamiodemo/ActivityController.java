package example.luojing.vitamiodemo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by outi on 2018/3/24.
 */

public abstract class ActivityController {

    public static List<Activity> ListActivities=new ArrayList<>();

    public static void addActivity(Activity activity){
        ListActivities.add(activity);
    }

    public static void removeActivity(Activity activity){
        ListActivities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:ListActivities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
