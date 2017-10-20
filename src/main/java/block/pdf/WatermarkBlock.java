package block.pdf;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import model.IBlock;

import java.io.File;

public class WatermarkBlock extends IBlock {

    @Override
    public String getName() {
        return "watermark";
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
        PdfDocument pdfDocument = (PdfDocument) in[0];
        String watermarkText = in[1].toString();

        PdfCanvas over = new PdfCanvas(pdfDocument.getFirstPage());
        over.setFillColor(Color.RED);
        Paragraph p = new Paragraph(watermarkText).setFontSize(32);
        new Canvas(over, pdfDocument, pdfDocument.getDefaultPageSize())
                .showTextAligned(p, 297, 500, 1, TextAlignment.CENTER, VerticalAlignment.TOP, 0);
        over.saveState();
        PdfExtGState gs1 = new PdfExtGState();
        gs1.setFillOpacity(0.5f);
        over.setExtGState(gs1);
        return new Object[]{pdfDocument};
    }
}
