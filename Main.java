package com.company;

import java.net.SocketOption;

public class Main {

    static int  search (String olgo,String check,int i,int p,int f)
    {
         if (p>=olgo.length() && i>=check.length())
                return f ;
        if (p>=olgo.length() || i>=check.length()) {
            f = 1;
            return f;
        }

            if (olgo.charAt(p)=='*')
            {
                if (p==olgo.length()-1)
                    return f ;
                p++ ;
                while (olgo.charAt(p)!=check.charAt(i) )
                {
                    i++;
                    if (i>=check.length()) {
                        f = 1;
                        return f;
                    }
                }
                f = search(olgo,check,i,p,f);
            }
            else if (olgo.charAt(p)=='!')
            {
                if (check.charAt(i)!=check.charAt(i-1))
                    f = 1 ;
                f = search(olgo,check,i+1,p+1,f);

            }
            else
            {
                if (olgo.charAt(p)==check.charAt(i))
                {
                    f = search(olgo,check,i+1,p+1,f);
                }
                else
                    f =1;
            }
        return f ;
    }
    public static void main(String[] args)
    {
        String olgo = "T*y", check = "TakeItEasy" ;
        int answ =  search(olgo,check,0,0,0);
        if (answ==1)
            System.out.println("false");
        else
            System.out.println("true");


    }
}
