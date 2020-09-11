import java.util.Scanner;

public class HCF {
    int N = 0;
    int K = 0;
    
    
    public int faktorial(int faktor){
        int nilaiFaktor;                                
        if(faktor<=1){                                  
            nilaiFaktor = 1;
        }
        else{                                           
            nilaiFaktor = faktor*faktorial(faktor-1);
        }
        return nilaiFaktor;                             
    }   
    
    public int kombinasi(int N, int K) {
        int nilaiAkhir;                                                         
        if(N==1&&K==1){                                                         
            nilaiAkhir = 1;
        }
        else{                                                                  
            nilaiAkhir = faktorial((N+K)-1)/(faktorial(K)*faktorial(N-1));
        }
        return nilaiAkhir;                                                      
    }

    public int proses(int T){
        int success = 1;                                                        
        hasil[] newhasil = new hasil[T];                                        
        int j = 0;                                                              
        Scanner sc = new Scanner(System.in);                                    
        while(j < T){                                                           
            String str = sc.nextLine();                                         
            int last = 0;                      
            int num = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            if(num <= 9){
                  last = Integer.parseInt(str.substring(2));
            }
            
            if(num <= 99){
                 last = Integer.parseInt(str.substring(3));
            }

            if(num <= 999){
                 last = Integer.parseInt(str.substring(4));
            }            
            N = num;                                        
            K = last;                           
//            System.out.println("num "+num+", last : "+last);
            int  hcf = 0;
            for(int g = 1; g<= N ||g<=K;g++){
                if(N%g == 0  && K%g==0){
                     newhasil[j] = new hasil(g);
                }
            }
//            newhasil[j] = new hasil(kombinasi(N, K));       
            j++;                                            
        }
        System.out.println("\nOutput :");                   
        for (int m = 0; m < newhasil.length; m++){          
            System.out.println(newhasil[m].nilaiSimpanan); 
//            System.out.println("hcf: "+hcf);
        }
        return success;                                     
    }
}


class hasil 
{ 
    public int nilaiSimpanan;                   
    hasil(int nilaiSimpanan)                    
    { 
        this.nilaiSimpanan = nilaiSimpanan;     
    } 
} 
