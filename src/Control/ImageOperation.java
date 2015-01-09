package Control;

import UI.ImageViewer;

public abstract class ImageOperation implements Operation {

    private final ImageViewer viewer;

    public ImageOperation(ImageViewer viewer) {
        this.viewer = viewer;
    }

    public ImageViewer getViewer() {
        return viewer;
    }
}
