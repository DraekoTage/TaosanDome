import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] a = {1,2,3,45,6,1,4,64,7};
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length-1; i++) {
            for(int j=0;j<a.length-1-i;j++){
                if (a[j]<a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
