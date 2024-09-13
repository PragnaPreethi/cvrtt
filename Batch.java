
//!csec
import java.util.*; 
public class Batch extends Timetable{
    String a[][]=Timetable.a;;
    
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    boolean add(String x,String y){
        int i,j,k,m,n;
        for(i=0;i<5;i++){
            for(j=0;j<8;j++){
                if( a[i][j].equals(".")){
                    list.add(i*10 + j);
                }
            }
        }
        int count=0;
      //  System.out.println("free"+x+"periods"+list);
        if(list.size()>=5){
            while(count<5){
            for(i=0;i<4;i++){
                k=rand.nextInt(list.size());
                n=list.get(k)%10;
                m=list.get(k)/10;
                if(isSafe(m,n,a,x)){
                this.a[m][n]=x;
                count++;
                }
                
                list.remove(k);
            }
        }
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

    public boolean isSafe(int row,int col,String a[][],String sub){
        //!for sub
        if(col==3)
        return false;      
                 
        for(int i=0;i<a[0].length;i++){  
            if( a[row][i].equals(sub))
            return false;
        } 
        
        //check for col repeat atmost 2
        int count=0;
        for(int i=0;i<row;i++){
            if(a[i][col].equals(sub))
             count++;
          // return false;
        }
        if(count>=1)
        return false;

        return true;
    }
}