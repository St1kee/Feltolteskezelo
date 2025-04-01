public class Manager {
    private Namer namer;
    private Folder imagesFolder;
    private Folder etcFolder;

    public Manager(Namer namer, Folder rootFolder) {
        this.imagesFolder = new Folder(rootFolder, "images");
        this.etcFolder = new Folder(rootFolder, "etc");
        this.namer = namer;
    }

    public File upload(String fileName, long size) {
        File newFile;
        if (fileName.matches(".*\\.(jpg|png|gif)$")) {
            newFile = new File(imagesFolder, fileName, size);
        } else {
            newFile = new File(etcFolder, fileName, size);
        }
        namer.rename(newFile);
        System.out.printf("Stored %s at %s\n", fileName, newFile.fullPath());
        System.out.printf("Images size: %d bytes\n", imagesFolder.size());
        System.out.printf("Etc size: %d bytes\n", etcFolder.size());
        return newFile;
    }

}
