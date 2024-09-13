
import java.util.*;
 class combined1 {
 
    // static  String a[][]=new String[5][5];
     //Arrays.fill(a,".");     this is for 1d array only 
     private boolean isInitialized = false;
     //! to avoid everytime filling with ".",for every call, boolean is used to check that its intinalised only once
     private String[][] a;
     private int[] book;
 
     public combined1() {
         if (!isInitialized) {
             a = new String[5][8];
             book = new int[5];
             initializeArray();
             isInitialized = true;
           
         }
     }
 
     private void initializeArray() {
         for (int i = 0; i < a.length; i++) {
             Arrays.fill(a[i], ".");
         }
         Arrays.fill(book, 0); // Initialize book array with 0s (free)
     }
 
 
 
     public void print(){
            for(int i=0;i<a.length;i++)        
         System.out.println(Arrays.toString(a[i]));


     }


    public void add(String s[]){
       if(subject(0,a,s,0)){
           print();
       }
       else
       System.out.println("Invalid");       
    }
    static int res=0;
    static String sub="";
    
    public boolean subject(int row,String a[][],String s[],int index){       
         
        if (index >= s.length) {
            return true;  // All subjects and labs have been placed
        }
        if (row >= a.length) {         
            // If we are done with the rows, but not with the subjects/labs
            return subject(0, a, s, index + 1);
        }
          sub=s[index];
         if(sub.length()>3 && sub.substring(sub.length()-3).equals("lab"))
         res=1;
         else
         res=0;         
         
       int ro=0;
        
       

         if(res==0){    
            while(ro<a.length){
            for(int col=0;col<a[0].length;col++){
        if(isSafe(row,col,a,sub,res) && a[row][col].equals(".")){
           
            a[row][col]=sub;
            if(subject(ro+1,a,s,index))
            return true;
            a[row][col]=".";
        }
    }
    }
    return subject(0, a, s, index+1);
        }

        else if(res==1){
            
          for (int r = 0; r < a.length; r++) {
           if(book[r]==-1  )continue;
          // System.out.println(Arrays.toString(book));
            for(int col=0;col<a[0].length;col++){ 
      // System.out.println("row= "+row+" col="+col+"  index="+index+"  res="+res+" lab= "+sub);
         
            if( col+2<a[0].length && isSafe(r,col,a,sub,res) && a[r][col].equals(".") ){
                for(int i=col;i<col+3;i++){
                a[r][i]=sub;               
                }
                 book[r]=-1;
               //print();
                if(index>=s.length-1 || subject(0,a,s,index+1))
                return true;

                //backtrack
                for(int i=col;i<col+3;i++){
                a[r][i]=".";               
                }
                 book[r]=0;  
                       
                
        }
    }          
        }   
        }
        
        return false;
    }
    
    public boolean isSafe(int row,int col,String a[][],String sub,int res){
        //!for sub
        if(col==3)
        return false; 
       // System.out.println("res= "+res);
        if(res==0){  
                 
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
    //!for lab
    else if(res==1){
         //!check if row is empty
         if(book[row]==-1)
         return false;
 
         //i==4 ||
        //!check  consecutive 3 col are free
         for(int i=col;i<col+3;i++){
             if( i==3||i==a[0].length)
             return false;
             if(!a[row][i].equals("."))
             return false;
         }
         return true;
    }
    return true;
    }
    
    
}


class Sample {
    public static void main(String[] args) {
        combined1  obj=new combined1();  
//String sub[]={"s1","s2","s3","s4","adalab","dslab","oslab","cnlab","pslab"};  
 String sub[]={ "dslab","wtlab", "s2","s3","s4","cnlab","oslab","s1","pelab"}; 
     obj.add(sub);
    // String sub1[]={"s2"};
    //  obj.add(sub1);
    }
}