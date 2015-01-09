package Control;

import UI.ImageViewer;

public class PrevImageOperation extends ImageOperation {

    public PrevImageOperation(ImageViewer viewer) {
        super(viewer);
    }

    @Override
    public void execute() {
        this.getViewer().displayPrevImage();
    }
}
