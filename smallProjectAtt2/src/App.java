import java.util.Scanner;

public class App {
    public static double f(double[] arr,boolean[] avoid, int target, String operator,int count){
      double bax = 999;   
      if(count > 4){return bax;}; 
        for(int i = 0; i< 6; i++){
          for(int j = i; j<6; j++){
              if(i != j && avoid[i] == false && avoid[j] == false){
                double[] arrTemp = arr.clone(); 
                boolean[] avoidTemp = avoid.clone();
                if(operator == "+"){
                      arrTemp[i] = arr[i] + arr[j]; 
                      avoidTemp[j] = true; 
                      double x = target - arrTemp[i];
                      double kx = (x) < 0 ? -(x) : x; 
                      int counter = count + 1;   
                      if(counter>4){
                        if(kx < bax){
                          return kx; 
                        }
                      }; 
                      double a = f(arrTemp,avoidTemp,target,"+",counter); 
                      double b = f(arrTemp,avoidTemp,target,"-",counter); 
                      double c = f(arrTemp,avoidTemp,target,"*",counter);
                      double d = f(arrTemp,avoidTemp,target,"/",counter);       
                      if( ((kx < a)||(kx==a)) && ((kx < b)||(kx==b))
                       && ((kx < c)||(kx==c)) && ((kx < d)||(kx==d))){
                        if (kx < bax){
                          bax = kx;    
                                             
                        }
                      }else if(((a < b)||(a==b)) && ((a < c)||(a==c)) && ((a < d)||(a==d))){
                       if(a < bax){
                        bax = a;     
                                             
                       }
                      }else if(((b < a)||(b==a)) && ((b < c)||(b==c)) && ((b < d)||(b==d))){
                        if(b < bax){
                          bax = b;   
                                                 
                         }
                      }else if(((c < a)||(c==a)) && ((c < b)||(c==d)) && ((c < d)||(c==d))){
                       if(c < bax){
                        bax = c;      
                                     
                       }
                      }else if(((d < a)||(d==a)) && ((d < b)||(d==b)) && ((d < c)||(d==c))){
                         if(d < bax){
                          bax = d;      
                                                
                         }
                      }
                }else if(operator == "-"){
                    arrTemp[i] = arr[i] - arr[j]; 
                    avoidTemp[j] = true; 
                    double x = target - arrTemp[i];
                    double kx = (x) < 0 ? -(x) : x;                
                    int counter = count + 1;   
                    if(counter>4){
                      if(kx < bax){
                        return kx; 
                      }
                    }; 
                    double a = f(arrTemp,avoidTemp,target,"+",counter); 
                    double b = f(arrTemp,avoidTemp,target,"-",counter); 
                    double c = f(arrTemp,avoidTemp,target,"*",counter);
                    double d = f(arrTemp,avoidTemp,target,"/",counter);
                    if( ((kx < a)||(kx==a)) && ((kx < b)||(kx==b))
                    && ((kx < c)||(kx==c)) && ((kx < d)||(kx==d))){
                     if (kx < bax){
                       bax = kx;                    
                     }
                   }else if(((a < b)||(a==b)) && ((a < c)||(a==c)) && ((a < d)||(a==d))){
                    if(a < bax){
                     bax = a;            
                    }
                   }else if(((b < a)||(b==a)) && ((b < c)||(b==c)) && ((b < d)||(b==d))){
                     if(b < bax){
                       bax = b;                       
                      }
                   }else if(((c < a)||(c==a)) && ((c < b)||(c==d)) && ((c < d)||(c==d))){
                    if(c < bax){
                     bax = c;                     
                    }
                   }else if(((d < a)||(d==a)) && ((d < b)||(d==b)) && ((d < c)||(d==c))){
                      if(d < bax){
                       bax = d;                      
                      }
                    }
                    // *********************************se druga*******
                    arrTemp[i] = arr[i] + arr[j];
                    arrTemp[i] = arr[j] - arr[i]; 
                    avoidTemp[j] = true; 
                     x = target - arrTemp[i];
                     kx = (x) < 0 ? -(x) : x;                
                   // int counter = count + 1;   
                    if(counter>4){
                      if(kx < bax){
                        return kx; 
                      }
                    }; 
                    a = f(arrTemp,avoidTemp,target,"+",counter); 
                    b = f(arrTemp,avoidTemp,target,"-",counter); 
                    c = f(arrTemp,avoidTemp,target,"*",counter);
                    d = f(arrTemp,avoidTemp,target,"/",counter);
                    if( ((kx < a)||(kx==a)) && ((kx < b)||(kx==b))
                    && ((kx < c)||(kx==c)) && ((kx < d)||(kx==d))){
                     if (kx < bax){
                       bax = kx;                        
                     }
                   }else if(((a < b)||(a==b)) && ((a < c)||(a==c)) && ((a < d)||(a==d))){
                    if(a < bax){
                     bax = a;                       
                    }
                   }else if(((b < a)||(b==a)) && ((b < c)||(b==c)) && ((b < d)||(b==d))){
                     if(b < bax){
                       bax = b;                       
                      }
                   }else if(((c < a)||(c==a)) && ((c < b)||(c==d)) && ((c < d)||(c==d))){
                    if(c < bax){
                     bax = c;                   
                    }
                   }else if(((d < a)||(d==a)) && ((d < b)||(d==b)) && ((d < c)||(d==c))){
                      if(d < bax){
                       bax = d;                       
                      }
                   }
 //* +++++++++++++++++++++++++++++++++++++++++++++++ */
                }else if(operator=="*"){              
                    arrTemp[i] = arr[i] * arr[j]; 
                    avoidTemp[j] = true; 
                    double x = target - arrTemp[i];
                    double kx = (x) < 0 ? -(x) : x;                     
                      int counter = count + 1;  
                      if(counter>4){
                        if(kx < bax){
                          return kx; 
                        }
                      };  
                      double c = f(arrTemp,avoidTemp,target,"*",counter);
                      double d = f(arrTemp,avoidTemp,target,"/",counter);
                      if(((kx < c)||(kx==c)) && ((kx < d)||(kx==d))){
                       if(kx < bax){
                        bax = kx;  
                        if(count > 4){return bax;}                          
                       }
                      }else if(c < d || c == d){
                       if(c < bax){
                        bax = c;    
                        if(count > 4){return bax;}                       
                       }
                      }else if(d < c || d == c){
                        if(d < bax){
                          bax = d; 
                         }                       
                      }
                }else{
                  arrTemp[i] = arr[i] / arr[j]; 
                  avoidTemp[j] = true; 
                  double x = target - arrTemp[i];
                   double kx = (x) < 0 ? -(x) : x; 

                  int counter = count + 1;   
                  if(counter>4){
                    if(kx < bax){
                      return kx; 
                    }
                  }; 
                  double c = f(arrTemp,avoidTemp,target,"*",counter);
                  double d = f(arrTemp,avoidTemp,target,"/",counter);
                 if( ((kx < c)||(kx==c)) && ((kx < d)||(kx==d)))
                  {
                   if (kx < bax){
                     bax = kx;                      
                   }
                 }else if(((c < d)||(c==d))){
                  if(c < bax){
                   bax = c; 
                  }
                 }else if(((d < c)||(d==c))){
                    if(d < bax){
                     bax = d;                  
                    }
                 }
                 //**************se v drugo smer******* */
                 //****************** */
                 arrTemp[i] = arr[j] * arr[i];
                 arrTemp[i] = arr[j] / arr[i] ; 
                  avoidTemp[j] = true; 
                  x = target - arrTemp[i];
                  kx = (x) < 0 ? -(x) : x; 

                  counter = count + 1;   
                  if(counter>4){
                    if(kx < bax){
                      return kx; 
                    }
                  }; 
                  c = f(arrTemp,avoidTemp,target,"*",counter);
                  d = f(arrTemp,avoidTemp,target,"/",counter);
                 if( ((kx < c)||(kx==c)) && ((kx < d)||(kx==d)))
                  {
                   if (kx < bax){
                     bax = kx;                      
                   }
                 }else if(((c < d)||(c==d))){
                  if(c < bax){
                   bax = c; 
                  }
                 }else if(((d < c)||(d==c))){
                    if(d < bax){
                     bax = d;                  
                    }
                 }
                 
               }
            }
           }
        }
         return bax; 
       }

    public static void main(String[] args){
        Scanner inpt = new Scanner(System.in);
        String input = inpt.nextLine();
        String[] numArrString = input.split(" ");
        int[] numArr = new int[6];
        for(int i = 0; i<6; i++){
            numArr[i] = Integer.parseInt(numArrString[i]);
        }
        int t = Integer.parseInt(inpt.nextLine());
        inpt.close();
        boolean[] avoid = new boolean[6]; 
        double[] arr =  new double[6];
        for(int i = 0; i<6; i++){
            arr[i] = numArr[i]; 
        }
        double a = f(arr,avoid,t,"+",0);
        double b = f(arr,avoid,t,"-",0);
        double c = f(arr,avoid,t,"*",0);
        double d = f(arr,avoid,t,"/",0);
        if(t == arr[0] || t == arr[1] || t == arr[2] || t==arr[3] || t==arr[4] || t==arr[5]){
           System.out.print(0);
        }else if( ((a < b)||(a==b)) && ((a < c)||(a==c)) && ((a < d)||(a==d))){
            System.out.print(a);
        }else if(((b < a)||(b==a)) && ((b < c)||(b==c)) && ((b < d)||(b==d))){
            System.out.print(b);
        }else if(((c < a)||(c==a)) && ((c < b)||(c==d)) && ((c < d)||(c==d))){
            System.out.print(c);
        }else{
            System.out.print(d);
        }
    }
   
}
