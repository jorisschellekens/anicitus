package block.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import model.IBlock;

import java.io.File;
import java.io.IOException;

public class ExtractTextBlock extends IBlock {

    @Override
    public String getName() {
        return "extract text";
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
        String text = "";
        for(int i=1;i<=pdfDocument.getNumberOfPages();i++) {
            text += PdfTextExtractor.getTextFromPage(pdfDocument.getPage(i)) + "\n";
        }
        return new String[]{text};
    }

}
