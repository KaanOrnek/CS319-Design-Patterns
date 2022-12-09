public class SizeBasedStrategy implements MemoryRepresentationStrategy{

    private String text;

    SizeBasedStrategy(){
        text = "";
    }

    /**
     * Prints the memory of the Dictionary according to the rules specified in the homework
     */
    @Override
    public void represent() {
        String representation = "{ "; //the first char
        int currRowStartIndex = 0; // the index of the first char in the current row
        int currRowEndIndex = 0; // the index of the last char in the current row
        String currRow = ""; // current row
        String currFileSize = "";

        while(currRowStartIndex < text.length() ){
            currRowEndIndex = text.indexOf( '\n',currRowStartIndex+1); // ending index is the index of the nearest '\n'
            if(currRowEndIndex == -1 ){ //if there is no '\n' anymore, close the dictionary and exit the loop
                representation += "] ";
                break;
            }
            currRow = text.substring(currRowStartIndex, currRowEndIndex);


            if(currRow.contains("-") && !currRow.contains("DIRECTORY END")){ // if current row is beginning of a directory
                representation += "[ ";
            }

            else if(currRow.contains("DIRECTORY END")){ // if current row is ending of a directory
                representation += "] ";
            }

            else { // if current row is a file
                currFileSize = currRow.substring((currRow.indexOf("File Size:") + 11), (currRowEndIndex-currRowStartIndex - 3));
                representation += "(" + currFileSize + ") ";
            }
            currRowStartIndex = currRowEndIndex + 1;
        }
        representation += "}"; //last char
        System.out.println(representation);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
