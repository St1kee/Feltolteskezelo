import java.util.Arrays;

public class Folder extends FileSystemEntry{
    private FileSystemEntry[] children;

    public Folder(Folder parent, String name) {
        super(parent, name);
        this.children = null;
    }

    public void addChild(FileSystemEntry child) {
        if (this.children == null ) {
            this.children = new FileSystemEntry[] {child};
        } else {
            this.children = Arrays.copyOf(this.children, this.children.length + 1);
            this.children[this.children.length - 1] = child;
        }
    }

    @Override
    public long size() {
        long totalSize = 0;
        if (this.children != null) {
            for (FileSystemEntry child: this.children) {
                totalSize += child.size();
            }
        }
        return totalSize;
    }
}
