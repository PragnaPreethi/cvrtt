
//!csec
import java.util.*; 
public class BatchD extends Timetable{

    String a[][]=Timetable.a;
     static  int[] book = Timetable.b;
   // Arrays.fill(book, 0);   
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    boolean add(String x,String y){
        int i,j,k,m,n;
        for(i=0;i<5;i++){
            for(j=0;j<8;j++){
                if(book[i]==-1 || j==3)continue;
               else  if( a[i][j].equals(".") && isFree(a,i,j)){
                    list.add(i*10 + j);
                }
            }
        }
        System.out.println("free "+x+" periods "+list);
        if(list.size()>=1){
           // for(i=0;i<4;i++){
                k=rand.nextInt(list.size());               
                m=list.get(k)/10;//row
                n=list.get(k)%10; //col                
                place(this.a,m,n,x);                
                list.remove(k);
                
           // }

            list.clear();
            return true;
        }
        list.clear();
        return false;
    }

    void print(){
        for(String i[]:a){
            System.out.println(Arrays.toString(i));
        }
    }

    static boolean isFree(String a[][], int row, int col) {
        //checking if in conseq 3 cols if any col==3 and if it reaches array index outof bounds
         if (col + 2 >= a[row].length || (col <= 3 && col + 2 >= 3)) {
            return false;
        }
    
         for (int i = col; i < col + 3; i++) {
            if (!a[row][i].equals(".")) {
                return false;
            }
        }
    
        return true;
    }
    

    static void place(String a[][], int row, int col, String sub) {
        for (int i = col; i < col + 3 && i < a[row].length; i++) {
            a[row][i] = sub;
        }
        book[row]=-1;
    }
    
}