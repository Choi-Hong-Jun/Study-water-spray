import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;


public class EyeDetector {
    Mat frame = new Mat();
    VideoCapture cap = new VideoCapture(0);
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

    private void cameraShow(){

        

    }

}

