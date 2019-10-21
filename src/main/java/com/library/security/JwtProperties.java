package com.library.security;

public class JwtProperties {
	public static final String SECRET = "SomeSecretForJWTGeneration";
	public static final int EXPIRATION_TIME = 360000;// 6min //864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}