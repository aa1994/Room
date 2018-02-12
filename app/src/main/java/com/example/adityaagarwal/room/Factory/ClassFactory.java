package com.example.adityaagarwal.room.Factory;

import com.example.adityaagarwal.room.Activity.ItemDetailsActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by adityaagarwal on 08/02/18.
 */

public class ClassFactory {

    private Map<String, Class> classMap = new HashMap<>();

    public ClassFactory() {
        classMap.put("Book", ItemDetailsActivity.class);
        classMap.put("Movie", ItemDetailsActivity.class);
        classMap.put("Places", ItemDetailsActivity.class);
        classMap.put("Restaurant", ItemDetailsActivity.class);
        classMap.put("Songs", ItemDetailsActivity.class);
        classMap.put("Stuff to Buy", ItemDetailsActivity.class);
        classMap.put("TV", ItemDetailsActivity.class);
    }

    public Class getActivity(String category) {
        return classMap.get(category);
    }

    public Set<String> getKeys() {
        return classMap.keySet();
    }
}
