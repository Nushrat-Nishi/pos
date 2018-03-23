package com.chumbok.pos.service;

import com.chumbok.pos.entity.Product;

import java.awt.*;
import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    Image getImage (long imageId);
    Image createImage(Image image);
    void updateImage(Image image);
    void deleteImage(long ImageId);
}
