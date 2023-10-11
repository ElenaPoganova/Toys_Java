package Toys.Files;

import static Toys.Files.Vars.myFileName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Toys.Toy.Toy;

public class MyFileWriter {


    public static void writeToy(Toy winnerToy) {
        String result_string =
                winnerToy.getId() + System.lineSeparator() +
                        winnerToy.getName() + System.lineSeparator() +
                        winnerToy.getCount() + System.lineSeparator() +
                        winnerToy.getWeight() + System.lineSeparator();


        try {
            File myTxt = new File(myFileName);
            FileWriter fr = new FileWriter(myTxt);
            BufferedWriter br = new BufferedWriter(fr);

            br.write(result_string);
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}