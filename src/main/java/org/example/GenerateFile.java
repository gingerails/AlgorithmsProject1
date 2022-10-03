package org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Generated my random inputs file. Only for testing purposes. :)
 */
public class GenerateFile {

    public void generateFile() throws IOException {
        try{
            PrintWriter write = new PrintWriter("input.txt");
            Random rand = new Random();
            final int LIMIT = 10000;

            for(int i = 0; i < LIMIT; i++)
            {
                int isDouble = rand.nextInt(0, 2);
                System.out.println(isDouble);
                if(isDouble == 0)
                {
                    write.println(rand.nextInt(0,100));
                }else{
                    double randomDouble = rand.nextDouble() + rand.nextInt(0, 100);
                    DecimalFormat df = new DecimalFormat("#.##");
                    double p = Double.parseDouble(df.format(randomDouble));
                    write.println(p);
                }
            }
            write.close();
        }
		catch(IOException e)
        {
            System.out.println("An error occured while trying to write to the file");
        }

    }
}
// BufferedReader reader = new BufferedReader(new FileReader("input.txt"));