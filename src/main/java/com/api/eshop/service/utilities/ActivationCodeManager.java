package com.api.eshop.service.utilities;

import java.util.Random;

public class ActivationCodeManager {
    public  String getNewCode()
    {
         return String.format("%04d", new Random().nextInt(9999));
    }
}
