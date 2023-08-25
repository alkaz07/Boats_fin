import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //popytka1();
       // popytka2();
        //создать список людей из файла
        ArrayList<Human> group1 = loadPeopleFromFile("input.txt");
        //создали список лодок
        ArrayList<Boat> boats= new ArrayList<>();
        //сортировка списка людей по весу от меньшего к большему
        group1.sort(Comparator.comparing(x->x.weight));
        //сделали инверсию, от большего к меньшему
        Collections.reverse(group1);
        System.out.println(group1);
        //установили счетчик лодок, к-е уплывут с людьми
        int k=1;
        //пока группа людей не пустая, делаем цикл
        while(! group1.isEmpty())
        {
            //самого легкого получаем из последнего элемента списка
            Human lightest = group1.get(group1.size()-1);
            //если сумма веса первого и последнего человека меньше вместимости лодки (150кг)
            if(group1.get(0).weight + lightest.weight <= 150)
            {
                //формируем лодку
                Boat b = new Boat(k, 150);
                //сажаем первого и последнего в лодку
                b.addPassenger(group1.get(0));
                b.addPassenger(lightest);
                //удаляем их из списка
                group1.remove(0);
                group1.remove(lightest);
                //добавляем эту лодку в список лодок
                boats.add(b);
            } //иначе сажаем одного самого тяжелого в лодку
            else {
                Boat b = new Boat(k, 150);
                b.addPassenger(group1.get(0));
                //удаляем его из списка людей
                group1.remove(0);
                //лодку записываем в список лодок
                boats.add(b);
            }
            //увеличиваем счетчик уплывших лодок на 1
            k++;
        }
        //список лодок выводим в консоль
        String listString = boats.stream().map(Object::toString).collect(Collectors.joining("\n"));
        System.out.println(listString);

    }

    private static ArrayList<Human> loadPeopleFromFile(String fname)
    {
        //ручной ввод списка людей
        ArrayList<Human> crowd=new ArrayList<>();
        crowd.add(new Human("А", 80));
        crowd.add(new Human("В", 75));
        crowd.add(new Human("АА", 65));
        crowd.add(new Human("Б", 110));
        crowd.add(new Human("Г", 55));
        return crowd;
    }

    private static void popytka2() {
        Boat boat = new Boat(1, 150);
        Human p = new Human("Pavel", 80);
        Human v = new Human("Victor", 75);
        boat.addPassenger(v);
        boat.addPassenger(p);
        System.out.println(boat);
    }

    private static void popytka1() {
        //попробуем создать людей
        Human v = new Human("Vasya", 111);
        Human p = new Human("Petya", 99);
        Human r = new Human("Roman", 100);
        System.out.println(v + ", "+p);
        //попробуем создать список людей
        ArrayList<Human> crowd = new ArrayList<>();
        crowd.add(p);
        crowd.add(v);
        crowd.add(r);
        System.out.println(crowd);
        //сортировать список людей по весу в обратном порядке
        crowd.sort(Comparator.comparing(x->x.weight));
        Collections.reverse(crowd);
        System.out.println(crowd);
    }
}