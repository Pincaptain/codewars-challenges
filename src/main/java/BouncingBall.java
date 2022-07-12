public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || (bounce <= 0 || bounce >= 1) || window >= h) {
            return -1;
        }

        int seen = 1;
        double currentHeight = h;
        while (true) {
            currentHeight *= bounce;
            System.out.println(currentHeight);
            if (currentHeight > window) {
                seen += 2;
            } else {
                break;
            }
        }

        return seen;
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall(2.0, 0.5, 1.0));
    }
}
