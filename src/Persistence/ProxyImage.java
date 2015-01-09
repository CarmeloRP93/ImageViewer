package Persistence;

import Model.Bitmap;
import Model.Image;

public class ProxyImage extends Image {

    private final ImageLoader imageLoader;
    private Image realImage;

    public ProxyImage(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public Bitmap getBitmap() {
        checkImageLoaded();
        return realImage.getBitmap();
    }

    private void checkImageLoaded() {
        if (realImage != null) {
            return;
        }
        realImage = imageLoader.load();
    }
}
