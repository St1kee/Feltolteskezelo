public abstract class FileSystemEntry {
    private String name;
    private Folder parent;

    public FileSystemEntry(Folder parent, String name){
        this.parent = parent;
        this.name = name;
        if (this.parent != null){
            this.parent.addChild(this);
        }
    }

    public abstract long size();

    public String fullPath() {
        return this.parent == null ? this.name : this.parent.fullPath() + "/" + this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }
}
