import java.util.*;
import com.sun.speech.freetts.*;
import org.opencv.core.*;
import org.opencv.videoio.*;
import org.opencv.objdetect.*;

public class SprayWater {
   public static String VOICENAME = "kevin16";
   public static Voice voice;
   public static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {  
      while (true) {
         if (userIsPresent()) {
            if (!EyeTime()) {
               System.out.println("Are You Sleeping?");
               speaker();
               timer();
            }
         }
      }  
   }

   public static boolean userIsPresent() {
      if (user is present) { // explanation
         return true;
      }
      return false;
   }

   public static boolean EyeTime() {
      int time = 0;
      while (time < 10) {
         if (eyes are open) {  //explanation
            return true;
         }
         time++;
      }
      return false;
   }

   public static void timer() {
      Timer timer = new Timer();
      TimerTask task = new TimerTask() {
         int cnt = 60;

         @Override
         public void run() {
            System.out.println("Type response (I'm not): ");
            if (sc.hasNextLine()) {
               String answer = sc.nextLine();
               if (answer.equalsIgnoreCase("I'm not")) {
                  timer.cancel();
                  return;
               }
            }

            cnt--;
            if (cnt <= 0) {
               timer.cancel();
               spray();
            }
         }
      };
      timer.scheduleAtFixedRate(task, 0, 1000);
   }

   public static void spray() {
      System.out.println("Spray! 💦");
   }

   private static void speaker() {
      if (voice == null) {
         VoiceManager vm = VoiceManager.getInstance();
         voice = vm.getVoice(VOICENAME);
         if (voice != null) {
            voice.allocate();
         } else {
            return;
         }
      }
      voice.speak("Are you sleeping?");
   }
}
