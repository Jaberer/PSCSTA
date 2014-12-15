package pscsta;

import java.io.*;
import java.util.*;


public class PSCSTA
{
    public static Scanner scn;
    public static File f;
    public static int size;
    public static String[] dataArray = new String[size];

    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = "gamereviews";
        //f = new File("F:\\JudgesData\\" + fileName + ".dat");
        f = new File(fileName + ".dat");
        scn = new Scanner(f);
        scn.nextInt(); // repeats
        scn.nextLine();
        ArrayList<String> game = new ArrayList<String>();
        ArrayList<String> gamename = new ArrayList<String>();
        while (scn.hasNextLine())
        {
            String line = scn.nextLine();
            String name = "";
            Scanner lin = new Scanner(line);
            lin.next();
            while (!lin.hasNextInt()){
                name = name + lin.next() + " ";
            }
            name = name.replace(",", "");
            if (!gamename.contains(name)){
                gamename.add(name);
            }
            game.add(name + "*");
            int x = lin.nextInt();
            for (int i = 0; i < x; i++){
                game.add(name);
            }
        }
        for (int i = 0; i < gamename.size(); i++){
            String name = gamename.get(i);
            int count = 0;
            int num = 0;
            for (int j = 0; j < game.size(); j++){
                if (game.get(i).equals(name)){
                    count++;
                } else if (game.get(i).equals(name+"*")){
                    count++;
                    num++;
                }
            }
            System.out.println(name + " gets " + (double) (count / num) + " stars");

        }


    }


    public static void gorf()
    {
        size = scn.nextInt(); // size
        scn.nextLine();
        while(scn.hasNextLine())
        {
            String set = scn.nextLine(); // set

            double[] inputABC = new double[size]; //
            Scanner t = new Scanner(set); // read line 1
            int i = 0;
            while(t.hasNextDouble())
            {
                inputABC[i] = t.nextDouble();
                i++;
            }
            gorfQuad(inputABC); // prints first distance
        }
    }

    public static void gorfQuad(double[] _input)
    {
        double a = _input[0];
        double b = _input[1];
        double c = _input[2];

        double det = b*b-4*a*c;
        double x1 = ((-1)*b + (Math.pow(det, 0.5))) / (2*a);
        double x2 = ((-1)*b - (Math.pow(det, 0.5))) / (2*a);


        double distance = roundToTenth(x2-x1);
        System.out.println(distance);
    }

    public static double roundToTenth(double a)
    {
        double large = a*10;
        double largeRound = Math.round(large);
        double smallRound = largeRound / 10;
        //System.out.print(smallRound);
        return smallRound;
    }

    public static void Clock()
    {
        size = scn.nextInt(); // size
        scn.nextLine();
        while(scn.hasNextLine())
        {
            String set = scn.nextLine(); // set

            int[] stats = new int[3]; //
            Scanner t = new Scanner(set); // read line 1
            int i = 0;
            while(t.hasNextInt())
            {
                stats[i] = t.nextInt();
                i++;
            }
            //System.out.println(Arrays.toString(stats));
            clockHelp(stats);
        }
    }

    public static void clockHelp(int[] _input)
    {
        int count1 = 0;
        int count0 = 0;
        for(int a : _input)
        {
            if(a == 1)
            {
                count1++;
            }
            else if(a == 0)
            {
                count0++;
            }
            //System.out.print(a);
        }

        if(count1 > count0)
        {
            System.out.println("Player 1");
        }
        else
        {
            System.out.println("Player 2");
        }
    }
}
