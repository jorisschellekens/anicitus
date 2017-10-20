package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import model.IBlock;

import java.io.File;
import java.io.IOException;

public class ExtractCreatorBlock extends IBlock {

    @Override
    public String getName() {
        return "extract creator";
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
        PdfDocument pdfDocument = (PdfDocument) in[0];
        return new Object[]{pdfDocument.getDocumentInfo().getCreator()};
    }

    public String toString()
    {
        return getName();
    }

}
