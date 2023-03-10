import java.util.Scanner;
import java.util.Arrays;
   public class App{
      public static int fxtion(int v,int[][] box,int c,boolean[] avoid){
        boolean o = false;
        int n = box.length; 
        int d = box[0].length; 
 
        int x = c; 
        x++; 
         
        //mozni kandidati, tisti v katere fitta
        boolean[] ax = new boolean[n];    
           for(int j=0; j<n; j++){
              if(v!=j && avoid[j] != true){
                for(int z=0; z<d;z++){
                  if(box[v][z] > box[j][z] || box[v][z] == box[j][z]){
                    o = true; 
                    break; 
                 }
               }
             if(o == true){
               ax[j] = true; 
               o = false;
             }}
            };  
 //
 
      
     //minimumi posameznih stolpcev, samo do min5 ker je zadostovalo za teste
        int min = 1001; 
        int min2 = 1001; 
        int min3 = 1001; 
        int min4 = 1001; 
        int min5 = 1001; 
        for(int i=0; i<n; i++){
          if(avoid[i] == false && ax[i] == false){
          int max = 0; 
          
             if(box[i][d-1] > max){
              max = box[i][d-1]; 

          }
          if(max < min){
            min = max; 
          }
          
          if(d>2){
            if(box[i][d-2] < min2){
            min2 = box[i][d-2]; 
          }
          if(d>3){
            if(box[i][d-3] < min3){
              min3 = box[i][d-3]; 
            }
          
          if(d>4){
            if(box[i][d-4] < min4){
              min4 = box[i][d-4]; 
            }
            if(d>5){
              if(box[i][d-5] < min5){
                min5 = box[i][d-5]; 
              }
            }
          }
          }}
        }}; 
 
          //sending the calls on the next paths
          boolean[] tw = avoid.clone(); 
          int maxer = c; 
          boolean al = false; 
 
          for(int i=0; i<n; i++){
          if(avoid[i] == false && ax[i] == false && tw[i] == false){
          al = false; 
           
          if(d>5){
            if(box[i][d-1] > min && box[i][d-2] != min2 && box[i][d-3] != min3 &&
            box[i][d-4] != min4 && box[i][d-5] != min5){
           al = true; 
         }
          } else if(d>4){
        if(box[i][d-1] > min && box[i][d-2] != min2 && box[i][d-3] != min3 &&
           box[i][d-4] != min4){
          al = true; 
        }
       }else if(d>3){
            if(box[i][d-1] > min && box[i][d-2] != min2 && box[i][d-3] != min3){
              al = true; 
            }
          }else if(d>2){
            if(box[i][d-1] > min && box[i][d-2] != min2){
              al = true; 
            }
          }else{
            if(box[i][d-1] > min){
              al =true; 
            }
          }
        
 
             if(al ==false){
                tw[i] = true;
                int a = fxtion(i,box,x,tw);
                   if(a>maxer){
                    maxer = a; 
                   }
                  }
                }
              } 
          return maxer; 
        }
          
    
    //**************************************************/
    public static void main(String[] args){
        Scanner inpt = new Scanner(System.in);
        String input = inpt.nextLine();
        String[] numArrString = input.split(" ");
        int n = Integer.parseInt(numArrString[0]);
        int d = Integer.parseInt(numArrString[1]); 
        int[][] box = new int[n][d]; 
 
        for(int i = 0; i<n; i++){
            String ik = inpt.nextLine();
            String[] numArrSt = ik.split(" ");
            for(int j = 0; j<d; j++){
               box[i][j] = Integer.parseInt(numArrSt[j]); 
            }; 
        }; 
        inpt.close();
      
        int[] temp= new int[d];
        for(int i=0; i<n; i++){
            for(int j=0; j<d; j++){
                temp[j] = box[i][j]; 
            }
            Arrays.sort(temp); 
            for(int j=0; j<d; j++){
                box[i][j] = temp[j];
            }
        }
        boolean[] avoid = new boolean[n]; 
         for(int i= 0; i<n; i++){
          for(int j = i+1; j<n; j++){
            if(avoid[i] == false){
              boolean k = false; 
              for(int z = 0; z<d; z++){
                if(box[i][z] > box[j][z] || box[i][z] < box[j][z] ){
                   k = true; 
                   break;
                }
              }
              if(k == false){
                avoid[j] = true; 
              }}
          }
        } 
 
        int mx = 0; 
        int mn = 1001; 
        int mn2 = 1001; 
        for(int i = 0; i<n; i++){
          mx = 0; 
          if(avoid[i] == false){
              if(box[i][d-1] > mx){
                mx = box[i][d-1]; 
              }
            if(mx < mn){
               mn = mx; 
            }
          }
        }
      //*****************************/
      boolean al = false; 
      int max = 0; 
 
       for(int i = 0; i<n; i++){  
        al = false; 
              if(box[i][d-1] > mn){
                al = true; 
              }
 
         if(avoid[i] == false){
          boolean[] k = avoid.clone();
          k[i] = true; 
          if(fxtion(i,box,1,k) > max){  
            max = fxtion(i,box,1,k); 
          }
        
      }
    }
      System.out.println(max);
    }
}