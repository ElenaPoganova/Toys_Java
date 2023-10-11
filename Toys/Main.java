package Toys;
import static Toys.Files.Vars.allToys;
import static Toys.Files.Vars.winsToys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Toys.Files.MyFileWriter;
import Toys.Toy.Toy;

public class Main {
    public static void main(String[] args) {
        //создаем произвольные игрушки
        Toy doll = new Toy(1, "Кукла", 10, 15);
        Toy car = new Toy(2, "Машинка", 3, 30);
        Toy cat = new Toy(3, "Кошка", 4, 20);
        Toy elephant = new Toy(4, "Слон", 10, 100);
        Toy bunny = new Toy(5, "Зайчик", 6, 40);
        Toy ball = new Toy(6, "Мяч", 5, 8);

        //список с новым весом
        addToListWithNewWeight(doll, 5);
        addToListWithNewWeight(car, 10);
        addToListWithNewWeight(cat, 21);
        addToListWithNewWeight(elephant, 7);
        addToListWithNewWeight(bunny, 45);
        addToListWithNewWeight(ball, 67);

        //общий список игрушек
        System.out.println("Имеющиеся игрушки: ");
        showNewList(allToys);

        //список призовых игрушек (с весом от 20)
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 20);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("Призовые игрушки: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка случайным образом
        Toy givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("Победитель получает: " + givedWinner.info());

        //пишем инфо в текстовый файл
        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("Игрушка [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}
