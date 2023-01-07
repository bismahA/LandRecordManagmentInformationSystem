package com.example.demo;
//package com.lynden.gmapsexampleapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


//public class WebMap extends Application {
//
//    @Override
//    public void start(Stage stage) {
//        // create web engine and view
//        final WebEngine webEngine = new WebEngine(getClass().getResource("map.html").toString());
//        final WebView webView = new WebView(webEngine);
//        // create scene
//        // stage.setTitle("Web Map");
//        Scene scene = new Scene(webView, 1000, 700, Color.web("#666970"));
//        stage.setScene(scene);
//        // show stage
//        stage.setVisible(true);
//    }
//
//    static { // use system proxy settings when standalone application
//        System.setProperty("java.net.useSystemProxies", "true");
//    }
//}