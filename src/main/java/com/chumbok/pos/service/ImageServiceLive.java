package com.chumbok.pos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Transactional
@Service
public class ImageServiceLive implements ImageService{
    @Override
    public List<Image> getAllImages() {
        return null;
    }

    @Override
    public Image getImage(long imageId) {
        return null;
    }

    @Override
    public Image createImage(Image image) {
        return null;
    }

    @Override
    public void updateImage(Image image) {

    }

    @Override
    public void deleteImage(long ImageId) {

    }
}
