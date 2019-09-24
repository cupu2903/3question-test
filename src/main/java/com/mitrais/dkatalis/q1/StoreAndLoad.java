package com.mitrais.dkatalis.q1;

import java.util.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 17/09/2019
 */
public class StoreAndLoad {

    static HashMap<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) {
        String text = "key1=value1;key2=value2\nkeyA=valueA\n";
        HashMap<String, String>[] a = load(text);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].toString());
        }
        String textStore = store(a);
        System.out.println(textStore);

    }

    public static String store(HashMap<String, String>[] a) {
        if(a.length>0){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<a.length;++i){
                HashMap<String,String> map = a[i];
                Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<String,String> entry =  iterator.next();
                    String key = entry.getKey();
                    String value = entry.getValue();
                    sb.append(key).append("=").append(value).append(";");
                }
                sb.deleteCharAt(sb.lastIndexOf(";"));
                if(i!=a.length-1){ // if it is not the last index of array, print "\n
                    sb.append("\n");
                }
            }

            return sb.toString();
        }
        return null;

    }

    public static HashMap<String, String>[] load(String text) {
        String[] items = text.split("\n");
        if (items.length > 0) {
            HashMap<String, String>[] maps = new HashMap[items.length];
            for (int i = 0; i < items.length; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                String[] semicolon = items[i].split(";");
                if (semicolon.length > 0) {
                    for (int j = 0; j < semicolon.length; j++) {
                        String[] keyValue = semicolon[j].split("=");
                        map.put(keyValue[0], keyValue[1]);
                    }
                }else{
                    String[] keyValue = items[i].split("=");
                    map.put(keyValue[0], keyValue[1]);
                }
                maps[i] = map;
            }
            return maps;
        }
        return null;
    }

    private static void putValue(String keyValues) {
        String[] keyValue = keyValues.split("=");
    }
}
