package com.example.LinkTracker.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Validator {
    public static boolean validateUrl(final String url) {
        try {
            URI u = new URL(url).toURI();
            return true;
        } catch(MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
