package block;

import block.io.*;
import block.math.AddBlockFactory;
import block.math.DivideByBlockFactory;
import block.math.MultiplyBlockFactory;
import block.math.PowerBlockFactory;
import block.math.RemainderBlockFactory;
import block.math.RoundBlockFactory;
import block.math.SubtractBlockFactory;
import block.meta.DuplicateInputBlockFactory;
import block.logic.IfBlockFactory;
import block.nlp.DetermineLanguageBlockFactory;
import block.logic.AndBlockFactory;
import block.logic.EqualsBlockFactory;
import block.logic.GreaterThanBlockFactory;
import block.logic.NotBlockFactory;
import block.pdf.ClosePDFBlockFactory;
import block.pdf.MergeDocumentsBlockFactory;
import block.pdf.ModifyPDFBlockFactory;
import block.pdf.ReadPDFBlockFactory;
import block.pdf.WatermarkBlockFactory;
import block.primitive.DateBlockFactory;
import block.primitive.NumberBlockFactory;
import block.logic.OrBlockFactory;
import block.logic.SmallerThanBlockFactory;
import block.pdf.CountPagesBlockFactory;
import block.pdf.ExtractAuthorBlockFactory;
import block.pdf.ExtractCreatorBlockFactory;
import block.pdf.ExtractProducerBlockFactory;
import block.pdf.ExtractTextBlockFactory;
import block.primitive.RandomNumberBlockFactory;
import block.primitive.ToNumberBlockFactory;
import block.string.*;
import block.primitive.StringBlockFactory;
import model.IBlock;
import model.IBlockFactory;

public class IBlockFactoryEnum {

    public static IBlockFactory[] getAvailableFactories()
    {
        return new IBlockFactory[]{
                // IO
                new AlertBlockFactory(),
                new AppendToFileBlockFactory(),
                new BeepBlockFactory(),
                new ConsoleOutBlockFactory(),
                new FileInputBlockFactory(),
                new FileOutputBlockFactory(),
                new FileSelectBlockFactory(),
                new MailTextBlockFactory(),
                new ReadBytesBlockFactory(),
                new WGetBlockFactory(),
                // LOGIC
                new AndBlockFactory(),
                new EqualsBlockFactory(),
                new GreaterThanBlockFactory(),
                new IfBlockFactory(),
                new NotBlockFactory(),
                new OrBlockFactory(),
                new SmallerThanBlockFactory(),
                // MATH
                new AddBlockFactory(),
                new DivideByBlockFactory(),
                new MultiplyBlockFactory(),
                new PowerBlockFactory(),
                new RemainderBlockFactory(),
                new RoundBlockFactory(),
                new SubtractBlockFactory(),
                // META
                new DuplicateInputBlockFactory(),
                // NLP
                new DetermineLanguageBlockFactory(),
                // PDF
                new ClosePDFBlockFactory(),
                new CountPagesBlockFactory(),
                new ExtractAuthorBlockFactory(),
                new ExtractCreatorBlockFactory(),
                new ExtractProducerBlockFactory(),
                new ExtractTextBlockFactory(),
                new MergeDocumentsBlockFactory(),
                new ModifyPDFBlockFactory(),
                new ReadPDFBlockFactory(),
                new WatermarkBlockFactory(),
                // PRIMITVE
                new DateBlockFactory(),
                new NumberBlockFactory(),
                new RandomNumberBlockFactory(),
                new StringBlockFactory(),
                new ToNumberBlockFactory(),
                // STRING
                new ConcatenateBlockFactory(),
                new ContainsBlockFactory(),
                new LengthBlockFactory(),
                new ReplaceBlockFactory(),
                new SubstringBlockFactory(),
                new ToLowerBlockFactory(),
                new ToUpperBlockFactory()
        };
    }

    public static IBlockFactory lookupFactory(IBlock block)
    {
        String blockClassName = block.getClass().getName();
        for(IBlockFactory factory : getAvailableFactories())
        {
            String factoryClassName = factory.getClass().getName();
            if(factoryClassName.startsWith(blockClassName))
                return factory;
        }
        return null;
    }

    public static IBlockFactory lookupFactory(String iBlockName)
    {
        for(IBlockFactory f : IBlockFactoryEnum.getAvailableFactories())
        {
            if(f.getClass().getSimpleName().startsWith(iBlockName))
            {
                return f;
            }
        }
        return null;
    }
}
