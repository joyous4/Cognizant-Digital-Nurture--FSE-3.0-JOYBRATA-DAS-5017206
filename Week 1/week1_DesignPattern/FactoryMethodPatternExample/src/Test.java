public class Test {
    public static void main(String[] args){
        WordDocumentFactory word=new WordDocumentFactory();
        WordDocument wordDocument =  (WordDocument) word.createDocument();
        wordDocument.open();
        wordDocument.close();
        PdfDocumentFactory pdf=new PdfDocumentFactory();
        PdfDocument pdfDocument = (PdfDocument) pdf.createDocument();
        pdfDocument.open();
        pdfDocument.close();
        ExcelDocumentFactory excl = new ExcelDocumentFactory();
        ExcelDocument excelDocument=(ExcelDocument) excl.createDocument();
        excelDocument.open();
        excelDocument.close();
    }
}
