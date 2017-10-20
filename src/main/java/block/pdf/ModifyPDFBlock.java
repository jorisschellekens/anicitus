package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import model.IBlock;

import java.io.File;
import java.io.IOException;

public class ModifyPDFBlock extends IBlock{

    @Override
    public String getName() {
        return "modify PDF";
    }

    @Override
    public int countInputs() {
        return 2;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        File inputFile = (File) in[0];
        File outputFile = (File) in[1];
        PdfDocument pdfDocument = null;
        try {
            pdfDocument = new PdfDocument(new PdfReader(inputFile), new PdfWriter(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{pdfDocument};
    }

}
