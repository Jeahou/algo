package kakao;

public class K21_5 {
    public static void main(String[] args) {
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        //System.out.println(calTime(play_time));
        //System.out.println(calTime("99:59:59"));
        int[] adList = new int[360000];
        for(String s : logs){
            String[] l = s.split("-");
            int fir = calTime(l[0]);
            int sec = calTime(l[1]);
            for(int i=fir; i<=sec; i++){
                adList[i] = adList[i]+1;
            }
        }
        int adTime = calTime(adv_time);

        long[] sum = new long[360000];
        sum[0] = adList[0];
        for(int i=1; i<adList.length; i++){
            sum[i] = adList[i] + sum[i-1];
        }

        long answer = 0;
        int idx = 0;
        for(int i=0; i<adList.length-adTime; i++){
            if(i == 0) {
                answer = sum[adTime-1];
            }else {
                long t = sum[i+adTime-1] - sum[i-1];
                if(t>answer){
                    answer = t;
                    idx = i;
                }
            }
        }
        //System.out.println(answer);
        //System.out.println(idx);
        System.out.println(returnTime(idx));

    }
    static int calTime(String time){
        String[] timeList = time.split(":");
        int f = Integer.parseInt(timeList[0]);
        int s = Integer.parseInt(timeList[1]);
        return (f*3600) + (s*60) + Integer.parseInt(timeList[2]);
    }

    static String returnTime(int i){
        int f = i/3600;
        i = i-(3600*f);
        int s = i/60;
        i = i - (60*s);
        StringBuffer sb = new StringBuffer();
        if(f < 10){
            sb.append(0).append(f).append(":");
        }else{
            sb.append(f).append(":");
        }
        if(s < 10){
            sb.append(0).append(s).append(":");
        }else {
            sb.append(s).append(":");
        }
        if(i < 10){
            sb.append(0).append(i);
        }else {
            sb.append(i);
        }
        return sb.toString();
    }
}
