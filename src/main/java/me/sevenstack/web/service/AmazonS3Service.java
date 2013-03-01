package me.sevenstack.web.service;

import com.google.inject.ImplementedBy;

public interface AmazonS3Service {

    public void upload() throws Exception;
}
