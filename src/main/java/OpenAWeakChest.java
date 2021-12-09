import java.util.Random;

public class OpenAWeakChest {

    static class BadCodeException extends RuntimeException {
    }

    static class WeakChest {
        private boolean isOpen = false;
        private final int code = new Random().nextInt(999);

        public boolean isOpen() {
            return isOpen;
        }

        public void openChest(int inputCode) throws BadCodeException {
            if (inputCode != code) {
                throw new BadCodeException();
            }

            isOpen = true;
        }
    }

    static class Burglar {

        public WeakChest lockpick(WeakChest chest) {
            Random random = new Random();

            do {
                int randomCode = random.nextInt(999);
                System.out.printf("Trying to open chest with code (%d)%n", randomCode);

                try {
                    chest.openChest(randomCode);
                } catch (BadCodeException ignored) {
                }

            } while (!chest.isOpen());

            return chest;
        }
    }

    public static void main(String[] args) {
        WeakChest chest = new WeakChest();
        Burglar burglar = new Burglar();
        chest = burglar.lockpick(chest);

        if (chest.isOpen()) {
            System.out.println("Good job!");
        }
    }
}
