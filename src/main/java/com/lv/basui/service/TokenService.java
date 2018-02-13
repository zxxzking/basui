package com.lv.basui.service;

public interface TokenService {
    String createToken(Long userId);

    boolean checkToken(String token) throws Exception;
}
