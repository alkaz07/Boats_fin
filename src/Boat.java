public class Boat {
    int number;
    int gruz;
    Human passenger1, passenger2;

    public Boat(int number, int gruz) {
        this.number = number;
        this.gruz = gruz;
    }

    public void addPassenger(Human chel)
    {
        if(passenger1 == null)
            passenger1 = chel;
        else
            if(passenger2 == null)
                passenger2=chel;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "number=" + number +
                ", gruz=" + gruz +
                ", passanger1=" + passenger1 +
                ", passenger2=" + passenger2 +
                '}';
    }
}
