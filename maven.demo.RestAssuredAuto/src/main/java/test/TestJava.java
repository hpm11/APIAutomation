package test;

public class TestJava {
	
	
	public static void main(String[] args) {
		
		//String s = "abcdefg";
		//String k = s.substring(3, 5);
		
	//	System.out.println(k);
		
		String str = "acbdfghybdf";  
        String lrs="";  
        int n = str.length();  
        for(int i = 0; i < n; i++){  
            for(int j = i+1; j < n; j++){  
                //Checks for the largest common factors in every substring  
                String x = lcp(str.substring(i,n),str.substring(j,n));  
                //If the current prefix is greater than previous one  
                //then it takes the current one as longest repeating sequence  
                if(x.length() > lrs.length()) lrs=x;  
            }  
        }  
        System.out.println("Longest repeating sequence: "+lrs);  
    }  
		
		//int n = Math.min(arg0, arg1)
		
	public static String lcp(String s, String t){  
        int n = Math.min(s.length(),t.length());
      //  System.out.println("--n is" +n);
        for(int i = 0; i < n; i++){  
            if(s.charAt(i) != t.charAt(i)){  
                return s.substring(0,i);  
            }  
        }  
      //  System.out.println("---"+s.substring(0,n));
        return s.substring(0,n);  
    }  
	
	
	
	}


