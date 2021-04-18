package kakao;

public class K21_1 {

    // - 45 . 46 _ 95 , 80 ~89 , 97 ~ 122
    public static void main(String[] args) {
        String new_id = 	"z-+.^.";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<new_id.length(); i++){
            char a = new_id.charAt(i);
            if(a >= 65 && a <= 90){
                a = (char) (a+32);
                sb.append(a);
            }else{
                sb.append(a);
            }
        }
        new_id = sb.toString();
        sb.delete(0, sb.length());

        for(int i=0; i<new_id.length(); i++){
            char a = new_id.charAt(i);
            if(a == 45 || a == 46 || a == 95 || (a>=48 && a<=57) || (a>=97 && a<=122)){
                sb.append(a);
            }
        }
        new_id = sb.toString();
        sb.delete(0, sb.length());
        sb.append(new_id.charAt(0));
        for(int i=1; i<new_id.length(); i++){
            char a = new_id.charAt(i);
            char b = new_id.charAt(i-1);
            if (a == 46 && a==b) {
                continue;
            }else {
                sb.append(a);
            }
        }
        new_id = sb.toString();
        sb.delete(0, sb.length());

        if(new_id.charAt(0) == 46){
            if(new_id.length() == 1){
                new_id = "a";
            }else {
                new_id = new_id.substring(1, new_id.length());
            }
        }
        if(new_id.charAt(new_id.length()-1) == 46){
            new_id =  new_id.substring(0, new_id.length()-1);
        }
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) == 46){
            new_id =  new_id.substring(0, new_id.length()-1);
        }
        if(new_id.length()<=2){
            String s = new_id.substring(new_id.length()-1, new_id.length());
            while (new_id.length() <3){
                new_id += s;
            }
        }
        System.out.println(new_id);

    }
}
