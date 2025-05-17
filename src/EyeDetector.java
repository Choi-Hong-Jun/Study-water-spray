import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class EyeDetector {
    private final Mat frame = new Mat();
    private final VideoCapture cap = new VideoCapture(0);
    @FXML
    private Button button;
    @FXML
    private ImageView currentFrame;


    private void captureOn(){
        if (!cap.isOpened()){
            System.out.println("Webcam closed");
            System.exit(0);
        }
    }

    public void frameCapture(){
        captureOn();
        while (true){
            Boolean ret = cap.read(frame);

        }


    }

    protected void cameraEvent(ActionEvent event){
        Runnable grabber = new Runnable(){
            @Override
            public void run() {

            }
        };
        this.timer = Executors.newSingleThreadScheduledExecutor();
        this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS)



    }

}

