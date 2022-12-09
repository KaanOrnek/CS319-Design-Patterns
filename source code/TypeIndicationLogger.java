public class TypeIndicationLogger extends LoggerDecorator {
    TypeIndicationLogger(Logger logger){
        super(logger);
    }

    @Override
    public void log(String text) {
        text = addTypeIndication(text);
        super.log(text);
    }

    private String addTypeIndication(String text){
        int depth = 0;
        int currRowStartIndex = 0;
        int currRowEndIndex = 0;
        String currRow = "";
        while(currRowStartIndex < text.length()){
            currRowEndIndex = text.indexOf( '\n',currRowStartIndex+1);
            if(currRowEndIndex == -1 ){
                text = text.substring(0,currRowStartIndex) + "(!) " + text.substring(currRowStartIndex) ;
                break;
            }
            currRow = text.substring(currRowStartIndex, currRowEndIndex);

            if(currRow.contains("-") && !currRow.contains("DIRECTORY END")){
                text = text.substring(0,currRowStartIndex) + "(d) " + text.substring(currRowStartIndex) ;
            }
            else if(currRow.contains("DIRECTORY END")){
                text = text.substring(0,currRowStartIndex) + "(!) " + text.substring(currRowStartIndex) ;
            }
            else {
                text = text.substring(0,currRowStartIndex) + "(f) " + text.substring(currRowStartIndex) ;
            }
            currRowStartIndex = currRowEndIndex + 5;
        }
        return text;
    }
}
