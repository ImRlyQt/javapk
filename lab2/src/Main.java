public class Main {
    public static void main(String[] args) {
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0, 128);

        System.out.println("Color 1: " + color1);
        System.out.println("Color 1 - Red: " + color1.red() + ", Green: " + color1.green() + ", Blue: " + color1.blue() + ", Alpha: " + color1.alpha());
        System.out.println("Color 2: " + color2);
        System.out.println("Color 2 - Red: " + color2.red() + ", Green: " + color2.green() + ", Blue: " + color2.blue() + ", Alpha: " + color2.alpha());
    }
}