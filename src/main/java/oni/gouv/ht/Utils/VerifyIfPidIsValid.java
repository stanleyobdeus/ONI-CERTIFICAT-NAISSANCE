package oni.gouv.ht.Utils;

import oni.gouv.ht.Models.Error;
import oni.gouv.ht.Models.Response;
import org.springframework.stereotype.Component;

@Component
public class VerifyIfPidIsValid {

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }

    public Response isValid(String pid){
        if (!isInteger(pid))
            return new Response(null, new Error("Le PID ne peux pas avoir des Lettres..!", 400));
        if (pid.length() != 10)
            return new Response(null, new Error("Le PID Doit avoir 10 Chiffres..!", 400));
        return null;
    }
}
