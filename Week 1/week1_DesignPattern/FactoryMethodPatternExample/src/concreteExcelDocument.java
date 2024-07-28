public class concreteExcelDocument implements ExcelDocument {

    @Override
    public void open() {
        System.out.println("Opening excel document");
    }

    @Override
    public void close() {
        System.out.println("Closing excel document");
    }

}
