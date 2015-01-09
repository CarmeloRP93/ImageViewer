package swing;

import UI.ImageViewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private ImageViewer imageViewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Viewer");
        this.factory = factory;
        this.setSize(1040, 725);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.createComponents();
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createImagePanel());
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.create(label));
        return button;
    }

    private JPanel createImagePanel() {
        ImageViewerPanel panel = new ImageViewerPanel();
        imageViewer = panel;
        return panel;
    }
}
