package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import model.IBlock;

import java.io.File;
import java.io.IOException;

public class ReadPDFBlock extends IBlock {
    @Override
    public String getName() {
        return "read PDF";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        File inputFile = (File) in[0];
        PdfDocument pdfDocument = null;
        try {
            pdfDocument = new PdfDocument(new PdfReader(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{pdfDocument};
    }

}
