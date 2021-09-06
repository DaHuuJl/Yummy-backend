package com.yummy.restful.util;

public class BrowserParse {

    public BrowserParse() {}

    public String parse(String str) {
        String[] data = str.split(" ");
        for (String item : data) {
            if (item.contains("Edg"))
                return item.replace("/", " ").replace("Edg", "Microsoft Edge:");
            else if (item.contains("OPR"))
                return item.replace("/", " ").replace("OPR", "Opera:");
            else if (item.contains("YaBrowser"))
                return item.replace("/", " ").replace("YaBrowser", "Yandex Browser:");
            else if (item.contains("MSIE"))
                return item.replace("/", " ").replace("MSIE", "Internet Explorer:");
            else if (item.contains("Firefox"))
                return item.replace("/", " ").replace("Firefox", "Mozilla Firefox:");
        }

        for (String item : data) {
            if (item.contains("Chrome"))
                return item.replace("/", " ").replace("Chrome", "Google Chrome:");
            else if (item.contains("Safari"))
                return item.replace("/", " ").replace("Safari", "Safari:");
        }
        return "";
    }
}
