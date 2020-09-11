
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FAIZAL
 */
public class ConvexPolygon {
    int N = 0;
    int K = 0;
    
    public static void main(String[] args) {
        System.out.println("Input :");          
        Scanner BT = new Scanner(System.in);   
        int T = Integer.parseInt(BT.next());    
        new ConvexPolygon().proses(T);                   
    }
    
    public static int getSmallest(int[] a, int total){  
    int temp;  
    for (int i = 0; i < total; i++)   
            {  
                for (int j = i + 1; j < total; j++)   
                {  
                    if (a[i] > a[j])   
                    {  
                        temp = a[i];  
                        a[i] = a[j];  
                        a[j] = temp;  
                    }  
                }  
            }  
           return a[0];  
    }      
    
    public int proses(int T){
        int success = 1;                                                        
        int j = 0;
        int counterSV = 0;
        int m = 0;
        int[] res = {};
        storeVar[] newSV = new storeVar[T];    
        Scanner sc = new Scanner(System.in);                                    
        while(j < T){                                                           
            String str = sc.nextLine();                                         
            int last = 0;                      
            int num = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            if(num <= 9){
                  last = Integer.parseInt(str.substring(2));
            }
            
            else if(num <= 99){
                 last = Integer.parseInt(str.substring(3));
            }

            else if(num <= 999){
                 last = Integer.parseInt(str.substring(4));
            }            
            N = num;                                        
            K = last;
            int SV_res = 0;
            SV_res = N + K;
            newSV[j] = new storeVar(N, K, SV_res);
            res = push(res,SV_res);
            j++;
        }
        int smallest = getSmallest(res,T);
        for(int looperSV = 0; looperSV < newSV.length; looperSV++){
            if(newSV[looperSV].SV_result != smallest){
                counterSV++;
            }
        }
        System.out.println("\nOutput :");                   
        System.out.println(counterSV);
        if(counterSV != 0){
            System.out.println("\nOutput Detail:");          
            System.out.print("The largest convex polygon is the pentagon ");
            for (m = 0; m < newSV.length; m++){
                if(newSV[m].SV_result != smallest){
                    System.out.print("("+newSV[m].SV_X+","+newSV[m].SV_Y+")");
                    if(counterSV > 1){
                        if(m == counterSV-1){
                            System.out.print("\n");
                        }
                        else if(m < counterSV-1){
                            System.out.print(", ");
                        }
                    }
                } 
            }        
        }
        return success;                                     
    }
    
    private static int[] push(int[] array, int push) {
        int[] longer = new int[array.length + 1];
        for (int i = 0; i < array.length; i++)
            longer[i] = array[i];
        longer[array.length] = push;
        return longer;
    }
}

class storeVar 
{ 
    public int SV_result;                   
    public int SV_X;                   
    public int SV_Y;                   
    storeVar(int SV_X, int SV_Y, int SV_result)                    
    { 
        this.SV_X = SV_X;     
        this.SV_Y = SV_Y;     
        this.SV_result = SV_result;     
    } 
}