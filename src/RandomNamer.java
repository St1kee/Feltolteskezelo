public class RandomNamer implements Namer {

    private int length;
    private java.util.Random rnd;
    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    public RandomNamer(java.util.Random rnd, int length) {
        this.rnd = rnd;
        this.length = length;
    }

    @Override
    public void rename(FileSystemEntry entry) {
        String newName = "";
        for (int i = 0; i < this.length; i++) {
            newName += ALPHABET.toCharArray()[rnd.nextInt(ALPHABET.length())];
        }

        entry.setName(newName);
    }
}
