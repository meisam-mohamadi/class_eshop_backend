package com.api.eshop.service.utilities;

public class TokenCreator {

    public  String create(String mobilenumber)
    {
        Md5 md5 = new Md5();
        String result="";
        result = md5.reciveMD5(mobilenumber);
        result = result.replace("1","5").replace("2","5").replace("3","u").replace("4","x");
        result = md5.reciveMD5(md5.reciveMD5(result));
        result = result.replace("1","7").replace("2","5").replace("3","s").replace("4","t").replace("5","u").replace("6","t").replace("7","g").replace("8","7").replace("9","e").replace("0","9");
        return result+"____"+mobilenumber;
    }


}
