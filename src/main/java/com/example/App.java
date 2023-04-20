package com.example;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.io.PrintWriter;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectClass(ByteBuddyTests.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        // TestPlan testPlan = launcher.discover(request);

        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        PrintWriter writer = new PrintWriter(System.out);
        summary.printTo(writer);
        summary.printFailuresTo(writer);
    }

}
