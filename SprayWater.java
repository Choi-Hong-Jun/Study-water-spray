import java.util.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SprayWater {
   private static final String VOICENAME = "kevin16";
   private static Voice voice;
   private static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {  
      while (true) {
         if (userIsPresent()) {}
            if (!EyeTime()) {
               System.out.println("Are You Sleeping?");
               speaker();
               timer();
            }
         }
      }  
   }

   public static boolean userIsPresent() {
      return true;
   }

   public static boolean EyeTime() {
      return sc.nextBoolean();
   }

   public static void timer() {
      Timer timer = new Timer();
      TimerTask task = new TimerTask() {
         int cnt = 60;

         @Override
         public void run() {
            System.out.println("Type response (I'm not): ");
            if (sc.hasNext()) {
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
