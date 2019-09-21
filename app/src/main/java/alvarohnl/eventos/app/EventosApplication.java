package alvarohnl.eventos.app;

import android.app.Application;

public class EventosApplication extends Application {

    private static EventosApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static EventosApplication getInstance() {
        return instance;
    }

}

