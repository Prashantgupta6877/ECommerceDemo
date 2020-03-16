package com.pguptafeb.ecommercedemo

import android.content.Context
import com.facebook.stetho.Stetho

public class MyClass  {

    fun addLib(context: Context) {
        Stetho.initialize(
            Stetho.newInitializerBuilder(context)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                .build()
        )
    }
}
