
//!csec
import java.util.*; 
public class combined extends Timetable{

    String a[][]=Timetable.a;
     static  int[] book = Timetable.b;
     
   // Arrays.fill(book, 0);   
    static Random rand = new Random(); 
    static ArrayList<Integer> list = new ArrayList<Integer>();
    boolean add(String x,String y) {
        int count = 0;
        boolean isLab = x.endsWith("Lab");
        int i, j, k, m, n;
    
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 8; j++) {
                if (j == 3) continue;
                if (isLab) {
                    if (book[i] == -1) continue;
                    else if (a[i][j].equals(".") && isFree(a, i, j)) {
                        list.add(i * 10 + j);
                    }
                } else {
                    if (a[i][j].equals(".")) {
                        list.add(i * 10 + j);
                    }
                }
            }
        }
    
        if (isLab) {
            while (count < 1 && !list.isEmpty()) {
                if (list.size() >= 1) {
                    Random rand = new Random(); 
                    k = rand.nextInt(list.size());
                    m = list.get(k) / 10; // row
                    n = list.get(k) % 10; // col  
    
                    if (isFree(a, m, n)) {         
                        place(this.a, m, n, x); 
                        count++;
                    }               
                    list.remove(k);
                }
            }
            list.clear();
            return count == 1;
        } else {
            if (list.size() >= 5) {
                while (count < 5 && !list.isEmpty()) {
                    for (i = 0; i < 4; i++) {
                        Random rand = new Random();
                        if (list.size() > 0) { // Check if list is not empty
 
                        k = rand.nextInt(list.size());
                        n = list.get(k) % 10;
                        m = list.get(k) / 10;
                        if (isSafe(m, n, a, x)) {
                            this.a[m][n] = x;
                            count++;
                        }
                        list.remove(k);
                    }
                }
                }
                list.clear();
                return count == 5;
            }
            list.clear();
            return false;
        }
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


// //!csec
// import java.util.*; 
// public class combined extends Timetable{

//     String a[][]=Timetable.a;
//      static  int[] book = Timetable.b;
     
//    // Arrays.fill(book, 0);   
//     static Random rand = new Random(); 
//     static ArrayList<Integer> list = new ArrayList<Integer>();
//     boolean add(String x,String y) {
//         int count = 0;
//         boolean isLab = x.endsWith("Lab");
//         int i, j, k, m, n;
    
//         for (i = 0; i < 5; i++) {
//             for (j = 0; j < 8; j++) {
//                 if (j == 3) continue;
//                 if (isLab) {
//                     if (book[i] == -1) continue;
//                     else if (a[i][j].equals(".") && isFree(a, i, j)) {
//                         list.add(i * 10 + j);
//                     }
//                 } else {
//                     if (a[i][j].equals(".")) {
//                         list.add(i * 10 + j);
//                     }
//                 }
//             }
//         }
    
//         if (isLab) {
//             while (count < 1 && !list.isEmpty()) {
//                 if (list.size() >= 1) {
//                     k = rand.nextInt(list.size());
//                     m = list.get(k) / 10; // row
//                     n = list.get(k) % 10; // col  
    
//                     if (isFree(a, m, n)) {         
//                         place(this.a, m, n, x); 
//                         count++;
//                     }               
//                     list.remove(k);
//                 }
//             }
//             list.clear();
//             return count == 1;
//         } else {
//             if (list.size() >= 5) {
//                 while (count < 5 && !list.isEmpty()) {
//                     for (i = 0; i < 4; i++) {
//                         k = rand.nextInt(list.size());
//                         n = list.get(k) % 10;
//                         m = list.get(k) / 10;
//                         if (isSafe(m, n, a, x)) {
//                             this.a[m][n] = x;
//                             count++;
//                         }
//                         list.remove(k);
//                     }
//                 }
//                 list.clear();
//                 return count == 5;
//             }
//             list.clear();
//             return false;
//         }
//     }
    


// //     void print(){
// //         for(String i[]:a){
// //             System.out.println(Arrays.toString(i));
// //         }
// //     }

// //     static boolean isFree(String a[][], int row, int col) {
// //         //checking if in conseq 3 cols if any col==3 and if it reaches array index outof bounds
// //          if (col + 2 >= a[row].length || (col <= 3 && col + 2 >= 3)) {
// //             return false;
// //         }
    
// //          for (int i = col; i < col + 3; i++) {
// //             if (!a[row][i].equals(".")) {
// //                 return false;
// //             }
// //         }
    
// //         return true;
// //     }
    

// //     static void place(String a[][], int row, int col, String sub) {
// //         for (int i = col; i < col + 3 && i < a[row].length; i++) {
// //             a[row][i] = sub;
// //         }
// //         book[row]=-1;
// //     }

// //     public boolean isSafe(int row,int col,String a[][],String sub){
// //         //!for sub
// //         if(col==3)
// //         return false;      
                 
// //         for(int i=0;i<a[0].length;i++){  
// //             if( a[row][i].equals(sub))
// //             return false;
// //         } 
        
// //         //check for col repeat atmost 2
// //         int count=0;
// //         for(int i=0;i<row;i++){
// //             if(a[i][col].equals(sub))
// //              count++;
// //           // return false;
// //         }
// //         if(count>=1)
// //         return false;

// //         return true;
// //     }
    
// // }