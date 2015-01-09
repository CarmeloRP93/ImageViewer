package Control;

import UI.ImageViewer;

public class NextImageOperation extends ImageOperation {

    public NextImageOperation(ImageViewer viewer) {
        super(viewer);
    }

    @Override
    public void execute() {
        this.getViewer().displayNextImage();

    }
}
