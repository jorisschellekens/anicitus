package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import model.IBlock;

public class ClosePDFBlock extends IBlock {
    @Override
    public String getName() {
        return "close PDF";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 0;
    }

    @Override
    public Object[] process(Object[] in) {
        PdfDocument pdfDocument = (PdfDocument) in[0];
        pdfDocument.close();
        return new Object[0];
    }
}
