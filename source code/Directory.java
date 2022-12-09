import java.util.ArrayList;

public class Directory extends DirectoryComponent{
    private final String directoryName;
    private ArrayList<DirectoryComponent> directoryComponents;
    private  MemoryRepresentationStrategy representationStrategy;

    Directory( String directoryName){
        this.directoryName = directoryName;
        directoryComponents = new ArrayList<>();
    }

    /**
     * Creates a string that represents the DirectoryComponents in the Directory
     * @return - String representation of the directory's content
     */
    public String getInfo(){
        String result;
        result = "- " + directoryName;

        for (DirectoryComponent directoryComponent : directoryComponents) {
            result += "\n" + directoryComponent.getInfo();
        }
        result += "\n- DIRECTORY END | " + directoryName;
        return result;
    }

    /**
     * Adds a DirectoryComponent to the content of the Directory
     * @param newComponent - gets added to the array list
     */
    public void addComponent( DirectoryComponent newComponent){
        directoryComponents.add(newComponent);
    }

    /**
     * Selects the memory representation style
     * @param newStrategy - desired style
     */
    public void adjustMemoryRepresentation(MemoryRepresentationStrategy newStrategy){
        representationStrategy = newStrategy;
        representationStrategy.setText(this.getInfo());
    }

    /**
     * Prints the memory representation that must specified earlier
     */
    public void applyMemoryRepresentation(){
        representationStrategy.represent();
    }
}
