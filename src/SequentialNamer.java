public class SequentialNamer implements Namer {
    private int index;

    public SequentialNamer() {
        this.index = 1;
    }

    @Override
    public void rename(FileSystemEntry entry) {
        entry.setName(entry.getName() + "_" + this.index);
        this.index++;
    }
}
