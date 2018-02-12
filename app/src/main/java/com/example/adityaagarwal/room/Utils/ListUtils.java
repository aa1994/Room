package com.example.adityaagarwal.room.Utils;

/**
 * Created by adityaagarwal on 12/02/18.
 */

public class ListUtils {

    public static <T> T nullCheck(T t1, T t2) {
        return t1 != null ? t1 : t2;
    }
}
