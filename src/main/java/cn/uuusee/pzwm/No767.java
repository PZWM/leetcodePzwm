package cn.uuusee.pzwm;

public class No767 {

    public String reorganizeString(String S) {



        char[] ss = S.toCharArray();
        int index = 0, max = ss.length, curr = 0;
        char last = '~';
        for (int i = 0; i < ss.length; i++) {
            //当上一个不一样的话就不用交换
            if (last != ss[i]) {
                last=ss[i];
                continue;
            }
            curr=max-1;
            while (curr>=0){
                if(ss[curr]!=last){
                    if(curr>i) {
                        swap(ss, i, curr);
                        break;
                    }else{
                        if(curr-1>=0&&ss[i]==ss[curr-1]){
                            curr--;
                            continue;}
                        if(curr+1<max-1&&ss[i]==ss[curr+1]) {
                            curr--;
                            continue;
                        }
                        swap(ss,i,curr);
                        break;
                    }
                }
                curr--;
            }
            if(curr<0)
                return "";
            last=ss[i];
        }
        return new String(ss);
    }

    public void swap(char[] ss, int a, int b) {
        char temp = ss[a];
        ss[a] = ss[b];
        ss[b] = temp;
    }


}
