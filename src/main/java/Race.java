import static java.lang.Character.isDigit;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    ArrayList<automobile> MembersRace = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Ввод имени
    public String InputName() {

        while (true) {
            System.out.println("— Введите название машины №" + (MembersRace.size() + 1));
            String input = scanner.nextLine();

            if ((!(input == null)) & (!input.isEmpty())) {
                return input;
            } else {
                System.out.println("— Неправильная наименование  ");
            }
        }
    }

    //Ввод скорости
    public int InputSpeed() {
        while (true) {
            System.out.println("— Введите скорость машины №" + (MembersRace.size() + 1));
            String input = (scanner.nextLine());

            boolean isDigit=!(input.isEmpty());
            for (int i=0;i<input.length();i++){
                isDigit=isDigit & isDigit(input.charAt(i));
            }
            if (!isDigit) {
                ;
            }
            else if ((Integer.parseInt(input) <= 250) & (Integer.parseInt(input) > 0)) {
                return Integer.parseInt(input);
            }
            System.out.println("— Неправильная скорость  ");

        }
    }


//Запуск приложения
    public void start() {
        for (int i = 0; i < 3; i++) {
            MembersRace.add(new automobile(InputName(), InputSpeed()));
        }
        LeaderCalculation (MembersRace);
    }

    // Вычисление лидера
    public void LeaderCalculation(ArrayList<automobile> MembersRace) {
        automobile leader = new automobile("", 0);
        for (automobile car : MembersRace) {
            if (leader.Speed < car.Speed) {
                leader = car;
            }
        }
        System.out.println("Самая быстрая машина: " + leader.Name);

    }
}
