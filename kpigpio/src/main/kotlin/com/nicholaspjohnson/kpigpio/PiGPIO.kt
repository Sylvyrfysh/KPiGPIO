package com.nicholaspjohnson.kpigpio

object PiGPIO{
    init {
        val javaLibraryPath = System.getProperty("java.library.path")
        if(!javaLibraryPath.contains("/usr/lib")) {
            System.setProperty("java.library.path", "$javaLibraryPath:/usr/lib")
        }
        System.loadLibrary("KPiGPIOC")
    }

    external fun gpioInitialize()
    external fun gpioTerminate()
}