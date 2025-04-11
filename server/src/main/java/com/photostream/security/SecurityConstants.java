package com.photostream.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/auth/**";

    public static final String SECRET = "eDPnAbOlFXRCF4RUaBu7QEV7VUo/Xlu5Md9C763wqIEXv9T/cKZTzNs7tWgHof84Bwc8z1jB/izei3YBLwQIZiAZ+6h+qNuv21QTBsa/rZwRLDacvZvH5DgLU2nmCmnraethCA9O46ZJqmmidsyvVJ2ghp/oEvJcME7/rpkv+iSq%";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000; // 10 minutes
}
