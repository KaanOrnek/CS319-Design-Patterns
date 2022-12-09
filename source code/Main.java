public class Main {
    public static void main(String[] args) {

        //PART 1
        System.out.println("*****PART 1*****\n");

        //example 1
        System.out.println("***EXAMPLE 1***");
        File example1 = new File("video","mp4",200);
        System.out.println(example1.getInfo());
        System.out.println();

        //example 2
        System.out.println("***EXAMPLE 2***");
        Directory example2 = new Directory("MyDocuments");
        System.out.println(example2.getInfo());
        System.out.println();

        //example 3
        System.out.println("***EXAMPLE 3***");
        Directory example3 = new Directory("FavoriteMusic");
        example3.addComponent(new File("MetallicaTheUnforgiven", "mp3", 100));
        System.out.println(example3.getInfo());
        System.out.println();

        //example 4
        System.out.println("***EXAMPLE 4***");
        Directory example4 = new Directory("BilkentStuff");
        example4.addComponent(new File("InternshipReport", "pdf", 10));
        example4.addComponent(new File("setup", "exe", 5));
        example4.addComponent(new File("ToDoList", "docx", 15));
        example4.addComponent(example3);
        System.out.println(example4.getInfo());
        System.out.println();

        //example 5
        System.out.println("***EXAMPLE 5***");
        Directory example5 = new Directory("MyPC");
        example5.addComponent(example2);
        example5.addComponent(example4);
        System.out.println(example5.getInfo());
        System.out.println();

        //PART 2
        System.out.println("\n\n*****PART 2*****\n");

        //example 6
        System.out.println("***EXAMPLE 6***");
        Logger indented = new IndentationLogger(new ConsoleLogger());
        indented.log(example5.getInfo());
        System.out.println();

        //example 7
        System.out.println("***EXAMPLE 7***");
        Logger typeIndicated = new TypeIndicationLogger(new ConsoleLogger());
        typeIndicated.log(example5.getInfo());
        System.out.println();

        //example 8
        System.out.println("***EXAMPLE 8***");
        Logger typeIndicatedIndented = new IndentationLogger(new TypeIndicationLogger( new ConsoleLogger()));
        typeIndicatedIndented.log(example5.getInfo());
        System.out.println();

        //part 3
        System.out.println("*****PART 3*****");

        //example 9
        System.out.println("***EXAMPLE 9***");
        MemoryRepresentationStrategy representationStrategy1 = new SizeBasedStrategy();
        example5.adjustMemoryRepresentation(representationStrategy1);
        example5.applyMemoryRepresentation();
        System.out.println();

        //example 10
        System.out.println("***EXAMPLE 10***");
        MemoryRepresentationStrategy representationStrategy2 = new TypeBasedStrategy();
        example5.adjustMemoryRepresentation(representationStrategy2);
        example5.applyMemoryRepresentation();
        System.out.println();
    }
}