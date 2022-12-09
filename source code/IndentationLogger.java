public class IndentationLogger extends LoggerDecorator {
    IndentationLogger(Logger logger){
        super(logger);
    }

    @Override
    public void log(String text) {
        text = indent(text);
        super.log(text);
    }

    /**
     * @param text - String that will be indented
     * @return - String that are indented according to the rules specified in the homework
     */
    private String indent(String text){
        int depth = 0; // the number of '\t' that will be added to the beginning of each row
        int currRowStartIndex = 0; // the index of the first char in the current row
        int currRowEndIndex = 0; // the index of the last char in the current row
        String currRow = ""; // current row

        while(currRowStartIndex < text.length()){
            currRowEndIndex = text.indexOf( '\n',currRowStartIndex+1); // ending index is the index of the nearest '\n'
            if(currRowEndIndex == -1 ) //if there is no '\n' anymore, exit the loop
                break;
            currRow = text.substring(currRowStartIndex, currRowEndIndex); // current row of the string representation of the directory

            if(currRow.contains("-") && !currRow.contains("DIRECTORY END")){ // if current row is beginning of a directory
                text = addDepth(text,currRowStartIndex,depth);
                currRowStartIndex = currRowEndIndex + depth + 1; // mind the chars added in addDepth()
                depth++;
            }
            else if(currRow.contains("DIRECTORY END")){ // if current row is ending of a directory
                depth --;
                text = addDepth(text,currRowStartIndex,depth);
                currRowStartIndex = currRowEndIndex + depth + 1; // mind the chars added in addDepth()
            }
            else { // if current row is a file
                text = addDepth(text,currRowStartIndex,depth);
                currRowStartIndex = currRowEndIndex + depth + 1; // mind the chars added in addDepth()
            }
        }
        return text;
    }

    /**
     * Adds the '\t' to the text
     * @param text - the text in the indent() function
     * @param index - the index of the first char in the current row
     * @param depth - the number of '\t' that will be added to the text
     * @return - the same string with additional '\t'
     */
    private String addDepth(String text, int index, int depth){
        for(int i = 0; i < depth; i++){
            text = new StringBuffer(text).insert(index,"\t").toString();
        }
        return text;
    }
}
