public class File extends DirectoryComponent{
    private String fileName;
    private String extension;
    private int fileSize;

    File( String fileName, String extension, int fileSize){
        this.fileName = fileName;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    /**
     * @return - String representation of file
     */
    public String getInfo(){ return fileName + "." + extension + " | File Size: " + fileSize + " kb"; }
}
