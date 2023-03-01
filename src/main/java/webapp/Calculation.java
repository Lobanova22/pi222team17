package webapp;

public class Calculation {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final int period;
    private final int power;
    private final String privileges;
    private final String luxury;
    public static int power_100 = 25;
    public static int power_150 = 35;
    public static int power_200 = 50;
    public static int power_250 = 75;
    public static int power_999 = 150;

    public String getSurname() {return surname;}

    public String getName() {return name;}

    public String getPatronymic() {return patronymic;}

    public int getPeriod() {return period;}

    public int getPower() {return power;}

    public String getPrivileges() {return privileges;}

    public String getLuxury() {return luxury;}

    private double L;

    public Calculation(String surname, String name, String patronymic, int period, int power, String privileges, String luxury) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.period = period;
        this.power = power;
        this.privileges = privileges;
        this.luxury = luxury;
    }
    public double Calculate() {
        double p = 1;
        switch (privileges) {
            case "Нет льгот":
                p =1;
                break;
            case "Один из родителей (усыновитель) либо опекун (попечитель) в семье, которая признается многодетной":
            case "Герои Советского Союза, Герои Российской Федерации, герои Социалистического Труда, полные кавалеры ордена Славы, полные кавалеры ордена Трудовой Славы":
            case "Инвалиды всех категорий, ветераны Великой Отечественной войны, ветераны боевых действий на территории СССР, на территории Российский Федерации и территориях других государств, ветераны военной службы, ветераны труда, категории граждан, подвергшихся воздействию радиации вследствие чернобыльской катастрофы":
                if (power<=150) {
                    p = 0;
                } else {
                    p = 1;
                }
                break;
        }

        switch (luxury) {
            case "Без налога на роскошь":
                L=1;
                break;
            case "Автомобиль стоит от 3 до 5млн. руб., возраст не более 3 лет":
                L=1.1;
                break;
            case "Автомобиль стоит от 5 до 10 млн. руб., возраст не более 5 лет":
                L=2;
                break;
            case "Автомобиль стоит от 10 до 15 млн. руб., возраст не более 10 лет":
            case "Автомобиль стоит от 15 млн. Руб., возраст не более 20 лет":
                L=3;
                break;
        }

        double e;
        if (power<=100) {
            e = power_100;}
        else if (power<=150) {
            e = power_150;}
        else if (power<=200) {
            e = power_200;}
        else if (power<=250) {
            e = power_250;}
        else {
            e = power_999;}

        return e * power * (period/12) * L * p;
    }
}