package com.api.eshop.security;


public class SecurityConstants {
    public static final String SIGNUP_AND_SIGNIN_URL = "/users/**";
    public static final String PUBLIC_ACCESS = "/public/**";
    public static final String PRODUCTS = "/products/**";
    public static final String FILES = "/Files/**";
    public static final String SWAGGER_URI = "/v3/api-docs/**";
    public static final String SWAGGER_UI = "/swagger-ui.html";
    public static final String SWAGGER_UI2 = "/swagger-ui/*";
    public static final String STATIC_CONTENTS = "/download/**";
    public static final String SECRET_KEY = "asdasd@#@!Masda%$^%tU^&*$#@!@&2$%!!@xdvxcvW123rCV,b$%^YTg$%@vsw4523rF4AS23rsgggHY^AFW#@%WEF*&^yu&?&!#$RFV8)(*&^%$#";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 480*60*1000;
}