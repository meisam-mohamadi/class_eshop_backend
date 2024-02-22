package com.api.eshop.service.utilities;

import com.google.gson.Gson;

public class GsonManager
{
 public <T> String getJsonFromObject(T object)
 {
     return new Gson().toJson(object);
 }
}
