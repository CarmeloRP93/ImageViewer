package App;

import Control.NextImageOperation;
import Control.Operation;
import Control.PrevImageOperation;
import Model.Image;
import Persistence.File.FileImageListLoader;
import Persistence.ImageListLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swing.ActionListenerFactory;
import swing.ApplicationFrame;

public class Application {

    public static void main(String[] args) {
        new Application().execute();
    }
    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private Map<String, Operation> map;
    private ApplicationFrame applicationFrame;

    private void execute() {
        ImageListLoader loader = createImageListLoader(PATH);
        List<Image> list = loader.load();
        applicationFrame = new ApplicationFrame(createActionListenerFactory());
        applicationFrame.getImageViewer().setImage(list.get(0));
        map = new HashMap<>();
        map.put("Next", new NextImageOperation(applicationFrame.getImageViewer()));
        map.put("Prev", new PrevImageOperation(applicationFrame.getImageViewer()));
        applicationFrame.setVisible(true);
    }

    private ImageListLoader createImageListLoader(String path) {
        return new FileImageListLoader(path);
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Operation operation = map.get(action);
                        if (operation == null) {
                            return;
                        }
                        operation.execute();
                    }
                };
            }
        };
    }
}
