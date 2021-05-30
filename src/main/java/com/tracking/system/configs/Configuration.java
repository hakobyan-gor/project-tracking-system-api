package com.tracking.system.configs;

@org.springframework.context.annotation.Configuration
public class Configuration {

    public static final String TOKEN_SECRET = "project-tracking-system_12358";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 365 * 24 * 60 * 60;
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    public static final String TOKEN_PREFIX = "Bearer ";

}
