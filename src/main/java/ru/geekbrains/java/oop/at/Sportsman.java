package ru.geekbrains.java.oop.at;
// Базовый класс для классов Human, Cat, Robot
public abstract class Sportsman {
    protected String info;
    protected int maxdistance;
    protected double maxheight;
    protected String succesfulrunresult;
    protected String badrunresult;
    protected String succesfuljumpresult;
    protected String badjumpresult;
    private boolean condition;
    Sportsman(String name, int maxdistance, double maxheight){
        this.info = "";
        this.maxdistance=maxdistance;
        this.maxheight=maxheight;
        this.succesfulrunresult="";
        this.badrunresult = "";
        this.succesfuljumpresult="";
        this.badjumpresult="";
        this.condition=true;
    }
    // Информация о спортмене вида "Человек по имени Марк" или "Кот по имени Барсик"
    public String getInfo() {
        return info;
    }
    // Бежать дистанцию. Сравнивается длина дорожки и возможность ее пробежать
    public String run(int distance){
        if (distance<maxdistance  && condition){
            return info  +  succesfulrunresult + distance + " м";}
        condition=false;
        return  info + badrunresult;
    }
    // Прыгать через стенку. Сравнивается высота стенки и возможность ее перепрыгнуть
    public String jump(double height){
        if (height<maxheight && condition){
            return info  +  succesfuljumpresult + height + " м";}
        condition=false;
        return  info + badjumpresult;
    }
    // Получает состояние спортсмена. condotion = true - значит дальше участвует
    // или является победителем, если препятствия закончились
    public boolean getCondition(){return condition;}
}
