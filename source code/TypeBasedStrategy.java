public class TypeBasedStrategy implements MemoryRepresentationStrategy{
    private String text;

    TypeBasedStrategy(){
        text = "";
    }

    @Override
    public void represent() {
        String representation = "{ "; //the first char
        int depth = 0; // the num. of '\t' to be added
        int currRowStartIndex = 0; // the index of the first char in the current row
        int currRowEndIndex = 0;  // the index of the last char in the current row
        String currRow = ""; // current row

        while(currRowStartIndex < text.length()){
            currRowEndIndex = text.indexOf( '\n',currRowStartIndex+1); // ending index is the index of the nearest '\n'
            if(currRowEndIndex == -1 ) { //if there is no '\n' anymore, exit the loop
                break;
            }
            currRow = text.substring(currRowStartIndex, currRowEndIndex);

            if(currRow.contains("-") && !currRow.contains("DIRECTORY END")){ // if current row is beginning of a directory
                representation += "[D" + depth +" ";
                depth++;
            }
            else if(currRow.contains("DIRECTORY END")){ // if current row is ending of a directory
                depth --;
                representation += "EOD" + depth + "] ";
            }
            else { // if current row is a file
                representation += "(F) ";
            }
            currRowStartIndex = currRowEndIndex + 1;
        }
        representation += "EOD0] }"; //ending of any dictionary
        System.out.println(representation);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
