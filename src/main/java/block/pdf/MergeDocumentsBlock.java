package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import model.IBlock;

import java.io.File;
import java.io.FileNotFoundException;

public class MergeDocumentsBlock extends IBlock {

    @Override
    public String getName() {
        return "merge";
    }

    @Override
    public int countInputs() {
        return 3;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        PdfDocument pdfDocumentA = (PdfDocument) in[0];
        PdfDocument pdfDocumentB = (PdfDocument) in[1];

        File destination = (File) in[2];
        try {
            PdfDocument pdfDocumentC = new PdfDocument(new PdfWriter(destination));
            pdfDocumentA.copyPagesTo(1, pdfDocumentA.getNumberOfPages(), pdfDocumentC);
            pdfDocumentB.copyPagesTo(1, pdfDocumentB.getNumberOfPages(), pdfDocumentC);
            pdfDocumentC.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Object[]{destination};
    }

}
