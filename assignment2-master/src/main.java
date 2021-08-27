
import java.util.Scanner;
import java.io.File;

public class main {
    public static void main(String[] args) {

        String movieTitle =null;
        try {
            File file = new File("movie.txt");
            String[] st=new String[100];
            Scanner myFile = new Scanner(file);

            int count = 0;
            while (myFile.hasNextLine()) {
                count++;
                st[count] = myFile.nextLine();
            }
            int b = (int)(Math.random()*(count+1));
            movieTitle=st[b];

        }
        catch (Exception e)
        {
            System.out.println("not found");
        }

        char[] ch=new char[movieTitle.length()];
        for(int i=0;i<movieTitle.length();i++)
        {
            if(movieTitle.charAt(i)==' ')
            {
                ch[i]=movieTitle.charAt(i);
            }
            else
            {
                ch[i]='_';
            }

        }

        Scanner scan=new Scanner(System.in);
        int w=0,right=0, point =10;
        char[] wh=new char[100];
        boolean lose=true;
        for(int i=0;i<movieTitle.length();i++)
        {

            if(movieTitle.charAt(i)==' ')
            {
                right++;
            }
        }



            while (point>0)
        {            //   System.out.println(right+"meow");

            String guess=new String(ch);
            String wrong =new String(wh);
            //System.out.println(right);

            System.out.println("You are gussing:"+guess);
            System.out.print("You have guessed("+w+")wrong letters:");
            if(wrong.length()>=0)
            {
                for(int i=0;i<wrong.length();i++)
                    System.out.print(wrong.charAt(i) + " ");
                System.out.println();
            }
                
            else
            {
                System.out.println();
            }
            System.out.println("Guess a letter:");
            char r= scan.next().charAt(0);
            boolean bool=false;
            for(int i=0;i<movieTitle.length();i++)
            {

                if(movieTitle.charAt(i)==r && ch[i]=='_') {
                  //  System.out.println("right pushedth");

                    point++;
                    right++;
                    ch[i] = r;
                    bool = true;
                    break;
                }

            }
            if(bool==false)
            {
                w++;
                wh[w]=r;

            }

            if (right>=movieTitle.length())
            {
                lose=false;
                System.out.println("Win The Game");
                break;
            }
            String win=new String(ch);

           // System.out.println(right);

        }
        if(lose)
        {
            System.out.println("Lose The Game");
        }


    }


}

