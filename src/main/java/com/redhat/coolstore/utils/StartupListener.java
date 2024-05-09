package com.redhat.coolstore.utils;

import jakarta.inject.Inject;
import java.util.logging.Logger;

import weblogic.application.ApplicationLifecycleEvent;
import weblogic.application.ApplicationLifecycleListener;

public class StartupListener extends ApplicationLifecycleListener {

    @Inject
    Logger log;

    @Override
    public void postStart(ApplicationLifecycleEvent evt) {
        log.info("AppListener(postStart)");
    }

    @Override
    public void preStop(ApplicationLifecycleEvent evt) {
        log.info("AppListener(preStop)");
    }

}
